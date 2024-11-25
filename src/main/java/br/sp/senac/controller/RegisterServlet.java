package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.sp.senac.service.*;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ClienteService clienteService;
    
    public RegisterServlet() throws SQLException, ClassNotFoundException {
        super();
        clienteService = new ClienteService(); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        
       
        if (email == null || senha == null || nome == null || endereco == null ||
            email.isEmpty() || senha.isEmpty() || nome.isEmpty() || endereco.isEmpty()) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("/views/register.jsp").forward(request, response);
            return;
        }
        
        String resultado = clienteService.registrarCliente(email, senha, nome, endereco);
        
        if (resultado.equals("Conta criada com sucesso!")) {
            request.setAttribute("sucesso", resultado);
            response.sendRedirect(request.getContextPath() + "/views/novasPaginas/login.jsp");
        } else {
            request.setAttribute("erro", resultado);
            request.getRequestDispatcher("/views/novasPaginas/register.jsp").forward(request, response);
        }

        System.out.println("Novo cliente registrado: " + nome + " (" + email + ")");
    }
}
