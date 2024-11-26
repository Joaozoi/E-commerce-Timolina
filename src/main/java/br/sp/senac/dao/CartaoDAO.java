package br.sp.senac.dao;

import br.sp.senac.model.Cartao;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import br.sp.senac.util.DBConnection;


public class CartaoDAO {
	private Connection connection;
	
	 public CartaoDAO() throws ClassNotFoundException, SQLException {
	        this.connection = DBConnection.getConnection(); 
	    }

	  public void adicionarCartao(Cartao cartao) {
	       
	        try {
	            LocalDate validade = LocalDate.parse(cartao.getValidade()); 
	            LocalDate hoje = LocalDate.now(); 

	            if (validade.isBefore(hoje)) {
	                throw new IllegalArgumentException("A data de validade não pode ser anterior à data atual.");
	            }
	        } catch (DateTimeParseException e) {
	           
	            throw new IllegalArgumentException("Data de validade inválida. O formato esperado é 'yyyy-MM-dd'.");
	        }

	        
	        String sql = "INSERT INTO cartoes (numero, nome_titular, validade, cvv, limite, saldo) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, cartao.getNumero());
	            stmt.setString(2, cartao.getNomeTitular());
	            stmt.setString(3, cartao.getValidade());
	            stmt.setString(4, cartao.getCvv());
	            stmt.setDouble(5, cartao.getLimite());
	            stmt.setDouble(6, cartao.getSaldo());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public List<Cartao> listarCartoes() {
	        List<Cartao> cartoes = new ArrayList<>();
	        String sql = "SELECT * FROM cartoes";
	        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Cartao cartao = new Cartao();
	                cartao.setId(rs.getInt("id"));
	                cartao.setNumero(rs.getString("numero"));
	                cartao.setNomeTitular(rs.getString("nome_titular"));
	                cartao.setValidade(rs.getString("validade"));
	                cartao.setCvv(rs.getString("cvv"));
	                cartao.setLimite(rs.getDouble("limite"));
	                cartao.setSaldo(rs.getDouble("saldo"));
	                cartoes.add(cartao);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cartoes;
	    }
	}