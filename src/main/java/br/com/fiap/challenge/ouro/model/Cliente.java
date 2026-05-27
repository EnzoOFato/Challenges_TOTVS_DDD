package br.com.fiap.challenge.ouro.model;

public class Cliente extends Usuario{
    private String CNPJ;

    public Cliente() {

    }

    public Cliente(String nome, String senha, Integer idade, String CNPJ) {
        super(nome, senha, idade);
        this.CNPJ = CNPJ;
    }
}
