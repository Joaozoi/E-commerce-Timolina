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
import java.util.List;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProdutoServlet() {
        super();
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
            ProdutoDAO produtoDAO = new ProdutoDAO();
            boolean sucesso = produtoDAO.salvar(produto);

            if (sucesso) {
                response.sendRedirect(request.getContextPath() + "/views/listProdutos.jsp");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar o produto.");
                request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao conectar com o banco de dados.");
            request.getRequestDispatcher("views/cadastrarProduto.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.listarTodos(); 
            if (produtos.isEmpty()) {
                request.setAttribute("mensagem", "Nenhum produto encontrado.");
            } else {
                request.setAttribute("produtos", produtos); 
            }

            
            request.getRequestDispatcher("/views/produtos.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao recuperar os produtos do banco.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}
    

