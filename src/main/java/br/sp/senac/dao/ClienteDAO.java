package br.sp.senac.dao;

import br.sp.senac.model.Cliente;
import br.sp.senac.util.DBConnection;
import java.sql.*;
import br.sp.senac.util.*;


public class ClienteDAO {
	
	private Connection connection;
	
	  public ClienteDAO() throws SQLException, ClassNotFoundException {
	        this.connection = DBConnection.getConnection();
	    }
	  
	  public Cliente buscarPorEmail(String email) {
		    String query = "SELECT * FROM usuario WHERE email = ?";
		    try (PreparedStatement stmt = connection.prepareStatement(query)) {
		        stmt.setString(1, email);
		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		                return new Cliente(
		                        rs.getString("email"),
		                        rs.getString("senha"),
		                        rs.getString("nome"),
		                        rs.getString("endereco")
		                );
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		}

	  
	  public boolean salvar(Cliente cliente) {
		    String senhaCriptografada = PasswordUtil.criptografarSenha(cliente.getSenha());
		    String query = "INSERT INTO usuario (email, senha, nome, endereco) VALUES (?, ?, ?, ?)";
		    try (PreparedStatement stmt = connection.prepareStatement(query)) {
		        stmt.setString(1, cliente.getEmail());
		        stmt.setString(2, senhaCriptografada);
		        stmt.setString(3, cliente.getNome());
		        stmt.setString(4, cliente.getEndereco());
		        return stmt.executeUpdate() > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}

	  
	  public boolean verificarEmailExistente(String email) {
		    String query = "SELECT * FROM usuario WHERE email = ?";
		    try (PreparedStatement stmt = connection.prepareStatement(query)) {
		        stmt.setString(1, email);
		        try (ResultSet rs = stmt.executeQuery()) {
		            return rs.next();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}

}
