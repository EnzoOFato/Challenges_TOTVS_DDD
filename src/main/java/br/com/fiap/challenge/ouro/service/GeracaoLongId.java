package br.com.fiap.challenge.ouro.service;

public class GeracaoLongId {
    private static Long id_sequencia = 1L;

    public Long proxId() {
        return id_sequencia++;
    }
}
