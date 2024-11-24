package br.sp.senac.test;

import java.sql.Connection;
import br.sp.senac.util.*;

public class TestDBConnection {
	public static void main(String[] args) {
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão com o banco de dados bem-sucedida!");
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}