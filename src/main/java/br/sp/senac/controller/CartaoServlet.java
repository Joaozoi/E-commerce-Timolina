package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.sp.senac.dao.CartaoDAO;
import br.sp.senac.model.Cartao;
import java.io.*;
import java.util.List;


/**
 * Servlet implementation class CartaoServlet
 */
@WebServlet("/CartaoServlet")
public class CartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//   
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        cartaoDAO = new CartaoDAO();
//    }

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
	}

}
