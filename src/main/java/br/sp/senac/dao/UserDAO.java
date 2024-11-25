package br.sp.senac.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.sp.senac.util.DBConnection;
import br.sp.senac.util.PasswordUtil;
import java.sql.Connection;

public class UserDAO {

    public boolean validateCliente(String email, String senha) throws Exception {
        String query = "SELECT senha FROM clientes WHERE email = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("senha");
                    return PasswordUtil.verificarSenha(senha, hashedPassword); // Comparação com hash
                }
            }
        }
        return false;
    }
}
