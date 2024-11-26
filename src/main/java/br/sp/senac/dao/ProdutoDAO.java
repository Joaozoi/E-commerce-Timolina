package br.sp.senac.dao;

import br.sp.senac.model.Produto;
import br.sp.senac.util.DBConnection;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection connection;

    // Construtor que inicializa a conexão com o banco
    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
    }

    // Método para obter a conexão
    private Connection getConnection() {
        return this.connection;
    }

    // Método para salvar um novo produto no banco de dados
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
            return rowsAffected > 0;  // Se alguma linha foi afetada, significa que o produto foi inserido com sucesso
        }
    }

    // Método para listar todos os produtos
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto"; 
        
        // Usando a conexão do construtor já inicializada
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

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

    // Método para buscar um produto por ID
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
        return produto;  // Retorna o produto encontrado ou null caso não exista
    }
}
