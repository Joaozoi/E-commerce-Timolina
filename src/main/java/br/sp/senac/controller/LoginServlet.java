package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.sp.senac.service.*;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		try {
			
			LoginService loginService = new LoginService();
            String userType = loginService.authenticate(email, senha);

            if ("admin".equals(userType)) {
                request.getSession().setAttribute("mensagem", "Login de Admin realizado com sucesso!");
                response.sendRedirect(request.getContextPath() + "/views/novasPaginas/menuFuncionario.jsp");
            } else if ("cliente".equals(userType)) {
                request.getSession().setAttribute("mensagem", "Login de Cliente realizado com sucesso!");
                response.sendRedirect(request.getContextPath() + "/views/novasPaginas/menuCliente.jsp");
            } else {
                throw new IllegalArgumentException("Usuário ou senha inválidos.");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("erro", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/views/novasPaginas/login.jsp");
        }
    }
}
