package br.com.fiap.challenge.ouro.model;

import br.com.fiap.challenge.ouro.service.GeracaoLongId;

public class Cliente extends Usuario{
    private Long id;
    private String CNPJ;

    public Cliente() {

    }

    public Cliente(String nome, String senha, Integer idade, String CNPJ) {
        super(nome, senha, idade);
        this.id = GeracaoLongId.proxId();
        this.CNPJ = CNPJ;
    }

    public Long getId() {
        return id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
