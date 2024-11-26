package br.sp.senac.controller;

import br.sp.senac.dao.ProdutoDAO;
import br.sp.senac.model.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.sp.senac.service.ProdutoService;

@WebServlet("/listarProdutos")
public class ListarProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoService produtoService = null;
        List<Produto> produtos = null;
        
        try {
            produtoService = new ProdutoService();
            produtos = produtoService.listarProduto();  // Busca os produtos do banco
            
            // Passando a lista de produtos para o request
            request.setAttribute("produtos", produtos);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao buscar produtos: " + e.getMessage());
        }
        
        // Encaminha para a página JSP
        request.getRequestDispatcher("/listProdutos.jsp").forward(request, response);
    }
}
