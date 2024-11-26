package br.sp.senac.dao;

import br.sp.senac.model.Produto;
import br.sp.senac.util.DBConnection;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection connection;

   
    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection(); 
    }

    
    private Connection getConnection() throws SQLException {
        return this.connection;
    }

   
    public boolean salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, descricao, preco, categoria, marca, estoque) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());        
            stmt.setString(2, produto.getDescricao());   
            stmt.setDouble(3, produto.getPreco());       
            stmt.setString(4, produto.getCategoria());   
            stmt.setString(5, produto.getMarca());       
            stmt.setInt(6, produto.getEstoque());        

            int rowsAffected = stmt.executeUpdate(); 
            return rowsAffected > 0;
        }
    }

  
    public List<Produto> listarTodos() throws SQLException {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setMarca(rs.getString("marca"));
                produto.setEstoque(rs.getInt("estoque"));
                produtos.add(produto);
            }
        }
        return produtos;
    }

   
    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setMarca(rs.getString("marca"));
                produto.setEstoque(rs.getInt("estoque"));
            }
        }
        return produto;
    }
}
