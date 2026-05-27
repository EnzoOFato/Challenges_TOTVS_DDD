package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Reuniao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaReuniao {
    private final List<Reuniao> listaReuniao = new ArrayList<>();

    public void adicionarReuniao(Reuniao reuniao) {
        listaReuniao.add(reuniao);
    }

    public List<Reuniao> getListaReuniao() {
        return this.listaReuniao;
    }
}
