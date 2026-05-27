package br.com.fiap.challenge.ouro.model;

import br.com.fiap.challenge.ouro.service.GeracaoLongId;

import java.time.LocalDate;
import java.util.List;

public class Reuniao {
    private Long id;
    private LocalDate data;
    private String transcricao;
    private List<Usuario> participantes;
    private static final GeracaoLongId geracaoId = new GeracaoLongId();

    public Reuniao(){}

    public Reuniao(LocalDate data, String transcricao, List<Usuario> participantes) {
        this.id = geracaoId.proxId();
        this.data = data;
        this.transcricao = transcricao;
        this.participantes = participantes;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }
}
