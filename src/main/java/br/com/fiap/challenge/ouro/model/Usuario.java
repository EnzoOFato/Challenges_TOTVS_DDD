package br.com.fiap.challenge.ouro.model;

public abstract class Usuario {
    private String nome;
    private String senha;
    private Integer idade;

    public Usuario() {
    }

    public Usuario(String nome, String senha, Integer idade) {
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
