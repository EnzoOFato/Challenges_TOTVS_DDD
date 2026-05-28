package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.armazenamento.ListaInsight;
import br.com.fiap.challenge.ouro.armazenamento.ListaReuniao;
import br.com.fiap.challenge.ouro.dto.InsightDTO;
import br.com.fiap.challenge.ouro.exception.ReuniaoInvalidaException;
import br.com.fiap.challenge.ouro.model.Insight;
import br.com.fiap.challenge.ouro.model.Reuniao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsightService {
    @Autowired
    private ListaReuniao listaReuniao;

    @Autowired
    private ListaInsight listaInsight;

    @Autowired
    private ConsultaIA consulta;

    public ResponseEntity<String> geraResumoSimples(Long id) {
        try {
            Optional<Reuniao> reuniaoOptional = listaReuniao.getReuniaoPorId(id);
            if (reuniaoOptional.isPresent()){

                Reuniao reuniao = reuniaoOptional.get();

                Insight insight = new Insight(reuniao, consulta.consultaComTexto(reuniao.getTranscricao()));

                listaInsight.addInsight(insight);

                return ResponseEntity.ok(insight.getRelatorioSimples());
            }
            else {
                throw new ReuniaoInvalidaException("Reunião não encontrada");
            }
        } catch (ReuniaoInvalidaException e) {
            return ResponseEntity.badRequest().body("ERRO: " + e.getMessage());
        }
    }

    public List<InsightDTO> getTodos() {
        return listaInsight.getListaInsight().stream().map(
                i -> new InsightDTO(i.getReuniao(), i.getRelatorioSimples())
        ).collect(Collectors.toList());
    }
}
