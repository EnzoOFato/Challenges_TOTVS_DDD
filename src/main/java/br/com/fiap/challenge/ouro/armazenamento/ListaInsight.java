package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Insight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaInsight {
    private static final List<Insight> listaInsight = new ArrayList<>();

    public void addInsight(Insight insight) {
        listaInsight.add(insight);
    }

    public List<Insight> getListaInsight() {
        return listaInsight;
    }
}
