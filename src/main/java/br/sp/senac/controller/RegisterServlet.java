package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import br.sp.senac.model.Cliente;
import br.sp.senac.service.*;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ClienteService clienteService;
    
    public RegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        
        String resultado = clienteService.registrarCliente(email, senha, nome, endereco);
        
        if (resultado.equals("Conta criada com sucesso!")) {
        	request.setAttribute("sucesso", resultado);
        	response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        } else {
        	request.setAttribute("erro", resultado);
        	request.getRequestDispatcher("/views/register.jsp").forward(request, response);
        }
        	
            
            System.out.println("Novo cliente registrado: " + nome + " (" + email + ")");
            
           
        }
    }
