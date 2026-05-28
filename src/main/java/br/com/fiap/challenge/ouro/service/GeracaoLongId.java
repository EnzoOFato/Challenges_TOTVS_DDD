package br.com.fiap.challenge.ouro.service;

public class GeracaoLongId {
    private Long id_sequencia = 1L;

    public Long proxId() {
        return id_sequencia++;
    }
}
