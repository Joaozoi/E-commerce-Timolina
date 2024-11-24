package br.sp.senac.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/timolina";
	private static final String USER = "root";
	private static final String PASSWORD = "Lunaapto74@1";
	
	public static Connection getConnection() throws SQLException{
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		}catch (SQLException e ) {
			throw new SQLException("Erro ao conectar ao banco de dados ", e);
			
		}
	}

}
