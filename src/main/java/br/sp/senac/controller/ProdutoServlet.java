package br.sp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.sp.senac.dao.ProdutoDAO;
import br.sp.senac.model.Produto;
import br.sp.senac.service.ProdutoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProdutoService produtoService;
    private ProdutoDAO produtoDAO;

    @Override
    public void init() throws ServletException {
        try {
            produtoService = new ProdutoService();
            produtoDAO = new ProdutoDAO();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao inicializar o serviço de produtos", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Produto> produtos = produtoService.listarProduto();
            request.setAttribute("produtos", produtos);
            request.getRequestDispatcher("views/listProdutos.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar produtos.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String precoStr = request.getParameter("preco");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");
        String estoqueStr = request.getParameter("estoque");

        if (nome == null || nome.isEmpty() || precoStr == null || precoStr.isEmpty()) {
            request.setAttribute("erro", "Nome e Preço são obrigatórios.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            return;
        }

        double preco = 0;
        int estoque = 0;

        try {
            preco = Double.parseDouble(precoStr);
            estoque = Integer.parseInt(estoqueStr);
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "Preço e Estoque devem ser números válidos.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            return;
        }

        Produto produto = new Produto(nome, descricao, preco, categoria, marca, estoque);

        try {
            boolean sucesso = produtoDAO.salvar(produto);

            if (sucesso) {
                
                response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar o produto.");
                request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao conectar com o banco de dados.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
        }
    }
}
