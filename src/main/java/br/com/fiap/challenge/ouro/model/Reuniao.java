package br.com.fiap.challenge.ouro.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Reuniao {
    private String id;
    private LocalDate data;
    private String transcricao;
    private List<Usuario> participantes;

    public Reuniao(LocalDate data, String transcricao, List<Usuario> participantes) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
        this.transcricao = transcricao;
        this.participantes = participantes;
    }

    public String getId() {
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
