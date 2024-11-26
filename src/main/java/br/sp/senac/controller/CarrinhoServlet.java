package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.sp.senac.service.CarrinhoService;
import br.sp.senac.model.Carrinho;

/**
 * Servlet implementation class CarrinhoServlet
 */
@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CarrinhoService carrinhoService;
	
    @Override
    public void init() throws ServletException{
    	try {
			this.carrinhoService = new CarrinhoService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public CarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
        List<Carrinho> itens = carrinhoService.listarItens(usuarioId);

        for (Carrinho item : itens) {
            response.getWriter().write(item.toString() + "\n");
        }
	}
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       int produtoId = Integer.parseInt(request.getParameter("produtoId"));
	       int quantidade = Integer.parseInt(request.getParameter("quantidade"));
	       int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

	        String mensagem = carrinhoService.adicionarItem(produtoId, quantidade, usuarioId);
	        response.getWriter().write(mensagem);
	    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        String mensagem = carrinhoService.atualizarQuantidade(itemId, quantidade);
        response.getWriter().write(mensagem);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        String mensagem = carrinhoService.removerItem(itemId);
        response.getWriter().write(mensagem);
    }
}
