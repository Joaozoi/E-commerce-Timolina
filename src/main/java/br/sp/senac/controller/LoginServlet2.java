package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, String> clientes = new HashMap<>();

    private final String adminEmail = "admin@gmail.com";
    private final String adminSenha = "admin123";

    public LoginServlet2() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();

        if (isAdmin(email, senha)) {
            session.setAttribute("mensagem", "Login de Admin realizado com sucesso!");
            response.sendRedirect(request.getContextPath() + "/views/MenuFuncionario.jsp");
        } else if (isCliente(email, senha)) {
            session.setAttribute("mensagem", "Login de Cliente realizado com sucesso!");
            request.getRequestDispatcher("/views/MenuCliente.jsp").forward(request, response);
        } else {
            session.setAttribute("erro", "Usuário ou senha inválidos.");
            response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        }
    }

    private boolean isAdmin(String email, String senha) {
        return adminEmail.equals(email) && adminSenha.equals(senha);
    }

    private boolean isCliente(String email, String senha) {
        return clientes.containsKey(email) && clientes.get(email).equals(senha);
    }

    public static void registrarCliente(String email, String senha) {
        clientes.put(email, senha);
    }
}
