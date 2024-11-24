package br.sp.senac.model;

public class Produto {
    private int id;              
    private String nome;         
    private String descricao;    
    private double preco;       
    private String categoria;    
    private String marca;        
    private int estoque;         
    private String imagemUrl;   

    
    public Produto() {
    }

  
    public Produto(int id, String nome, String descricao, double preco, String categoria, String marca, int estoque, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.marca = marca;
        this.estoque = estoque;
        this.imagemUrl = imagemUrl;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    
    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria 
                + ", marca=" + marca + ", estoque=" + estoque + ", imagemUrl=" + imagemUrl + "]";
    }
}
