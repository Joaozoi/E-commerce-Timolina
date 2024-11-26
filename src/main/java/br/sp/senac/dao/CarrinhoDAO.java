package br.sp.senac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.sp.senac.util.*;
import br.sp.senac.model.Carrinho;


public class CarrinhoDAO {
	
	private Connection conexao;
	
	public CarrinhoDAO() throws ClassNotFoundException, SQLException {
		this.conexao = DBConnection.getConnection();
	}
	
	 public boolean adicionarItem(Carrinho item) {
	        String sql = "INSERT INTO carrinho (usuario_id, produto_id, quantidade, subtotal) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, item.getUsuarioId());
	            stmt.setInt(2, item.getProdutoId());
	            stmt.setInt(3, item.getQuantidade());
	            stmt.setDouble(4, item.getSubtotal());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean atualizarQuantidade(int id, int quantidade) {
	        String sql = "UPDATE carrinho SET quantidade = ? WHERE id = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, quantidade);
	            stmt.setInt(2, id);
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean removerItem(int id) {
	        String sql = "DELETE FROM carrinho WHERE id = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public List<Carrinho> listarItens(int usuarioId) {
	        String sql = "SELECT * FROM carrinho WHERE usuario_id = ?";
	        List<Carrinho> itens = new ArrayList<>();
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, usuarioId);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Carrinho item = new Carrinho();
	                item.setId(rs.getInt("id"));
	                item.setUsuarioId(rs.getInt("usuario_id"));
	                item.setProdutoId(rs.getInt("produto_id"));
	                item.setQuantidade(rs.getInt("quantidade"));
	                item.setSubtotal(rs.getDouble("subtotal"));
	                itens.add(item);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return itens;
	    }
	}