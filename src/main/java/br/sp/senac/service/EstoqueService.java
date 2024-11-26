package br.sp.senac.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import br.sp.senac.dao.EstoqueDAO;

public class EstoqueService {
    
    private EstoqueDAO estoqueDAO;

    public EstoqueService() throws ClassNotFoundException, SQLException {
        this.estoqueDAO = new EstoqueDAO();
    }

    
    public boolean verificarDisponibilidade(int produtoId, int quantidadeDesejada) {
        int quantidadeEmEstoque = estoqueDAO.buscarQuantidade(produtoId);
        return quantidadeEmEstoque >= quantidadeDesejada;
    }

   
    public void atualizarEstoque(int produtoId, int quantidade) {
        int quantidadeAtual = estoqueDAO.buscarQuantidade(produtoId);
        estoqueDAO.atualizarQuantidade(produtoId, quantidadeAtual - quantidade);
    }

  
    public BigDecimal buscarPrecoProduto(int produtoId) {
        return estoqueDAO.buscarPrecoProduto(produtoId); 
    }
}
