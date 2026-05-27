package br.com.fiap.challenge.ouro.model;

import java.util.UUID;

public abstract class Usuario {
    private String id;
    private String nome;
    private String senha;
    private Integer idade;

    public Usuario() {
    }

    public Usuario(String nome, String senha, Integer idade) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
    }

    public String getId() {
        return id;
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
