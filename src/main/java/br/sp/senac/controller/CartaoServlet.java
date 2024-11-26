package br.sp.senac.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.sp.senac.dao.CartaoDAO;
import br.sp.senac.model.Cartao;

import java.util.List;


/**
 * Servlet implementation class CartaoServlet
 */
@WebServlet("/CartaoServlet")
public class CartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartaoDAO cartaoDAO;
	
	@Override
    public void init() throws ServletException {
        super.init();
        try {
			cartaoDAO = new CartaoDAO();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			       List<Cartao> cartoes = cartaoDAO.listarCartoes();
	        request.setAttribute("cartoes", cartoes);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cartoes.jsp");
	        dispatcher.forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				 String numero = request.getParameter("numero");
	        String nomeTitular = request.getParameter("nomeTitular");
	        String validade = request.getParameter("validade");
	        String cvv = request.getParameter("cvv");
	        double limite = Double.parseDouble(request.getParameter("limite"));
	        double saldo = Double.parseDouble(request.getParameter("saldo"));

	        Cartao cartao = new Cartao();
	        cartao.setNumero(numero);
	        cartao.setNomeTitular(nomeTitular);
	        cartao.setValidade(validade);
	        cartao.setCvv(cvv);
	        cartao.setLimite(limite);
	        cartao.setSaldo(saldo);

	        cartaoDAO.adicionarCartao(cartao);
	        response.sendRedirect("cartao");  
	    }
	}