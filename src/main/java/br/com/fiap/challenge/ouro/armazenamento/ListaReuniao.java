package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Reuniao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ListaReuniao {
    private final List<Reuniao> listaReuniao = new ArrayList<>();

    public void adicionarReuniao(Reuniao reuniao) {
        listaReuniao.add(reuniao);
    }

    public List<Reuniao> getListaReuniao() {
        return this.listaReuniao;
    }

    public Optional<Reuniao> getReuniaoPorId(Long id) {
       return listaReuniao.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
