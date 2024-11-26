package br.sp.senac.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import br.sp.senac.dao.CarrinhoDAO;
import br.sp.senac.model.Carrinho;




public class CarrinhoService {

    private CarrinhoDAO carrinhoDAO;
    private EstoqueService estoqueService; 

    public CarrinhoService() throws ClassNotFoundException, SQLException {
        this.carrinhoDAO = new CarrinhoDAO();
        this.estoqueService = new EstoqueService();
    }

    public String adicionarItem(int produtoId, int quantidade, int usuarioId) {
        if (!estoqueService.verificarDisponibilidade(produtoId, quantidade)) {
            return "Estoque insuficiente para o produto.";
        }

        Carrinho item = new Carrinho();
        item.setProdutoId(produtoId);
        item.setQuantidade(quantidade);
        item.setUsuarioId(usuarioId);
        item.setSubtotal(calcularSubtotal(produtoId, quantidade));

        if (carrinhoDAO.adicionarItem(item)) {
            return "Item adicionado ao carrinho com sucesso.";
        } else {
            return "Erro ao adicionar item ao carrinho.";
        }
    }

    public String atualizarQuantidade(int itemId, int quantidade) {
        if (carrinhoDAO.atualizarQuantidade(itemId, quantidade)) {
            return "Quantidade atualizada com sucesso.";
        } else {
            return "Erro ao atualizar quantidade.";
        }
    }

    public String removerItem(int itemId) {
        if (carrinhoDAO.removerItem(itemId)) {
            return "Item removido do carrinho com sucesso.";
        } else {
            return "Erro ao remover item do carrinho.";
        }
    }

    public List<Carrinho> listarItens(int usuarioId) {
        return carrinhoDAO.listarItens(usuarioId);
    }

    private double calcularSubtotal(int produtoId, int quantidade) {
        BigDecimal precoUnitario = estoqueService.buscarPrecoProduto(produtoId);
        BigDecimal subtotal = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
        return subtotal.doubleValue();
    }

}

