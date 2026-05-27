package br.com.fiap.challenge.ouro.dto;

import br.com.fiap.challenge.ouro.model.Usuario;

import java.util.List;

public record ReuniaoDTOSaida(Long id, String data, String transcricao, List<Usuario> participantes) {
}
