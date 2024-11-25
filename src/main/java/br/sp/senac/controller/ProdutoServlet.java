package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.sp.senac.dao.ProdutoDAO;
import br.sp.senac.model.Produto;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProdutoServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String nome = request.getParameter("nome");
        String valor = request.getParameter("preco");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");

      
        if (nome == null || nome.isEmpty() || valor == null || valor.isEmpty() || categoria == null || categoria.isEmpty() || marca == null || marca.isEmpty()) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            return;
        }

        
        double valorProduto;
        try {
            valorProduto = Double.parseDouble(valor);
            if (valorProduto <= 0) {
                request.setAttribute("erro", "O valor do produto deve ser maior que zero.");
                request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
                return;
            }

            
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "O valor do produto deve ser um número válido e maior que zero.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            return;
        }

       
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(valorProduto);
        produto.setCategoria(categoria);
        produto.setMarca(marca);

        
        
        try {
        ProdutoDAO produtoDAO = new ProdutoDAO();
       
        boolean sucesso = produtoDAO.salvar(produto);
        

        
        if (sucesso) {
            request.setAttribute("sucesso", "Produto cadastrado com sucesso!");
            response.sendRedirect(request.getContextPath() + "/views/listarProdutos.jsp");
        } else {
            request.setAttribute("erro", "Erro ao cadastrar o produto.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
        }
        
    }catch (SQLException e) {
    	e.printStackTrace();
    	System.out.println("Erro ao salvar o produto: " + e.getMessage());
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
