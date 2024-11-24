package br.sp.senac.dao;

import java.sql.*;
import br.sp.senac.util.DBConnection;
import br.sp.senac.model.Produto;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
	private Connection connection;
	
	public ProdutoDAO() {
		
	}
	
	private Connection getConnection() throws SQLException {
		return DBConnection.getConnection();
	}
	
	public boolean salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (nome, valor, categoria, marca) VALUES (?, ?, ?, ?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setString(3, produto.getCategoria());
			stmt.setString(4, produto.getMarca());	
			
			int uptade = stmt.executeUpdate();
			return uptade > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
			
	}
	
	public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto"; 
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("categoria"),
                    rs.getString("marca"),
                    rs.getInt("estoque"),
                    rs.getString("imagemUrl")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }


	public Produto buscarPorId(int id) {
		String sql = "SELECT * FROM produto WHERE id = ?";
		Produto produto = null;
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			
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
			    produto.setImagemUrl(rs.getString("imagemUrl"));
			}

		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		return produto;
		
	}
	

}
