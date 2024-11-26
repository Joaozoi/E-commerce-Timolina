package br.sp.senac.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.sp.senac.util.DBConnection;

public class EstoqueDAO {

    private Connection conexao;

    public EstoqueDAO() throws SQLException, ClassNotFoundException {
        this.conexao = DBConnection.getConnection();
    }

 
    public int buscarQuantidade(int produtoId) {
        String sql = "SELECT quantidade FROM estoque WHERE produto_id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantidade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

  
    public void atualizarQuantidade(int produtoId, int novaQuantidade) {
        String sql = "UPDATE estoque SET quantidade = ? WHERE produto_id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public BigDecimal buscarPrecoProduto(int produtoId) {
        String sql = "SELECT preco FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBigDecimal("preco");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO; 
    }

}
