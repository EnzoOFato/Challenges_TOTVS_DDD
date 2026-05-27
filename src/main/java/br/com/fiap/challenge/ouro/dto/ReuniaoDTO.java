package br.com.fiap.challenge.ouro.dto;

import java.util.List;

public record ReuniaoDTO (Long id, String data, String transcricao, List<Object> participantes){
}
