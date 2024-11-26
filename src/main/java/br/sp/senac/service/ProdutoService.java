package br.sp.senac.service;

import br.sp.senac.dao.ProdutoDAO;
import br.sp.senac.model.Produto;

import java.sql.SQLException;
import java.util.List;


public class ProdutoService {

    private ProdutoDAO produtoDAO;

    public ProdutoService() throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO();  
    }

    public boolean adicionarProduto(Produto produto) throws ClassNotFoundException, SQLException {
        if (produto == null || produto.getNome() == null || produto.getPreco() <= 0) {
            return false;
        }
        try {
            return produtoDAO.salvar(produto);  
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao adicionar produto", e);  
        }
    }

    public List<Produto> listarProduto() throws SQLException, ClassNotFoundException {
    	
    	    List<Produto> listaProdutos = produtoDAO.listarTodos();
    	    System.out.println("Produtos encontrados: " + listaProdutos.size());
    	    return listaProdutos;
    
 
    	 
    }
}
