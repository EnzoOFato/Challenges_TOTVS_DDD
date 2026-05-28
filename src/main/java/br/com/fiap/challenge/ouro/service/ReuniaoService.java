package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.armazenamento.ListaCliente;
import br.com.fiap.challenge.ouro.armazenamento.ListaFuncionario;
import br.com.fiap.challenge.ouro.armazenamento.ListaReuniao;
import br.com.fiap.challenge.ouro.dto.ReuniaoDTO;
import br.com.fiap.challenge.ouro.dto.ReuniaoDTOSaida;
import br.com.fiap.challenge.ouro.exception.ParticipantesException;
import br.com.fiap.challenge.ouro.exception.ReuniaoInvalidaException;
import br.com.fiap.challenge.ouro.model.Cliente;
import br.com.fiap.challenge.ouro.model.Funcionario;
import br.com.fiap.challenge.ouro.model.Reuniao;
import br.com.fiap.challenge.ouro.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReuniaoService {

    @Autowired
    private ListaReuniao listaReuniao;

    @Autowired
    private ListaFuncionario listaFuncionario;

    @Autowired
    private ListaCliente listaCliente;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ResponseEntity<String> cadastraReuniao(ReuniaoDTO reuniaoDTO) {
        try {
            verificaValidadeReuniao(reuniaoDTO);
            listaReuniao.adicionarReuniao(converteDTO(reuniaoDTO));
            return ResponseEntity.ok("Reunião adicionada com sucesso");
        } catch (ReuniaoInvalidaException | ParticipantesException e) {
            return ResponseEntity.badRequest().body("ERRO no formato da reunião: " + e.getMessage());
        }
    }

    public Reuniao converteDTO(ReuniaoDTO reuniaoDTO) {
        return new Reuniao(LocalDate.parse(reuniaoDTO.data(), formatter), reuniaoDTO.transcricao(),
                criaLista(reuniaoDTO.participantes()));
    }

    public void verificaValidadeReuniao(ReuniaoDTO reuniaoDTO) {
        if (reuniaoDTO.data() == null || reuniaoDTO.transcricao() == null || reuniaoDTO.participantes() == null) {
            throw new ReuniaoInvalidaException("Reunião com informações insuficientes");
        }
        LocalDate.parse(reuniaoDTO.data(), formatter);
    }

    public List<Usuario> criaLista(List<Object> idParticipantes) {
        List<Usuario> listaRetorno = new ArrayList<>();
        for (Object o : idParticipantes) {
            if (o instanceof String) {
                Optional<Funcionario> funcionarioOptional = listaFuncionario.getFuncionarioCod(o.toString());
                if (funcionarioOptional.isPresent()) {
                    listaRetorno.add(funcionarioOptional.get());
                }
                else throw new ParticipantesException("ID não encontrado");
            }
            else if (o instanceof Integer) {
                Optional<Cliente> funcionarioOptional = listaCliente.getClienteId(((Integer) o).longValue());
                if (funcionarioOptional.isPresent()) {
                    listaRetorno.add(funcionarioOptional.get());
                }
                else throw new ParticipantesException("ID não encontrado");
            }
            else throw new ParticipantesException("ID não respeita tipos inteiros ou alfanuméricos");
        }
        return listaRetorno;
    }

    public List<ReuniaoDTOSaida> todasReunioes() {
        return listaReuniao.getListaReuniao().stream().map(
                r -> new ReuniaoDTOSaida(r.getId(), formatter.format(r.getData()),
                        r.getTranscricao(),
                        Senhas.escondeVarias(r.getParticipantes()))
        ).collect(Collectors.toList());
    }
}
