package br.sp.senac.model;

public class Cliente {
    private String email;
    private String senha;
    private String nome;
    private String endereco;

    // Construtor
    public Cliente(String email, String senha, String nome, String endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   
    @Override
    public String toString() {
        return "Cliente: " +
                "email = '" + email + '\'' +
                ", nome = '" + nome + '\'' +
                ", endereco = '" + endereco + '\'';
    }
}
