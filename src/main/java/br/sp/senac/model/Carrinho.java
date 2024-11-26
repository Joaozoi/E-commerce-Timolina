package br.sp.senac.model;

public class Carrinho {
	private int id;
	private int usuarioId;
	private int produtoId;
	private int quantidade;
	private double subtotal;
	
	public Carrinho() {}

	public Carrinho(int id, int usuarioId, int produtoId, int quantidade, double subtotal) {
		this.id = id;
		this.usuarioId = usuarioId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                ", subtotal=" + subtotal +
                '}';
    }
	
	
	

}
