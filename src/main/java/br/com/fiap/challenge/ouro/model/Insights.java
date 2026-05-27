package br.com.fiap.challenge.ouro.model;

public class Insights {
    private Reuniao reuniao;
    private String relatorioSimples;

    public Insights(Reuniao reuniao, String relatorioSimples) {
        this.reuniao = reuniao;
        this.relatorioSimples = relatorioSimples;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    public String getRelatorioSimples() {
        return relatorioSimples;
    }

    public void setRelatorioSimples(String relatorioSimples) {
        this.relatorioSimples = relatorioSimples;
    }
}
