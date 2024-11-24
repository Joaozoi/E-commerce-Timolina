package br.sp.senac.service;

import br.sp.senac.dao.ProdutoDAO;
import br.sp.senac.model.Produto;

import java.sql.SQLException;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO;

    public ProdutoService() throws SQLException {
        produtoDAO = new ProdutoDAO();
    }

    public boolean adicionarProduto(Produto produto) {
        if (produto == null || produto.getNome() == null || produto.getPreco() <= 0) {
            return false;
        }
        try {
            return produtoDAO.salvar(produto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Produto> listarProduto() {
        List<Produto> produtos = produtoDAO.listarTodos();
        return produtos != null ? produtos : List.of();
    }
}