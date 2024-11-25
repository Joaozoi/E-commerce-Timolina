package br.sp.senac.service;

import br.sp.senac.dao.*;

public class LoginService {
	private final UserDAO userDAO = new UserDAO();
	
	public String authenticate(String email, String senha) throws Exception {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha são obrigatórios.");
        }

        if (isAdmin(email, senha)) {
            return "admin";
        }

        if (userDAO.validateCliente(email, senha)) {
            return "cliente";
        }

        throw new IllegalArgumentException("Usuário ou senha inválidos.");
    }

    private boolean isAdmin(String email, String senha) {
        final String ADMIN_EMAIL = "admin@gmail.com";
        final String ADMIN_SENHA = "admin123";
        return ADMIN_EMAIL.equals(email) && ADMIN_SENHA.equals(senha);
    }
}
