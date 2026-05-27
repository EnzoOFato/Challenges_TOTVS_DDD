package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.armazenamento.ListaFuncionario;
import br.com.fiap.challenge.ouro.dto.FuncionarioDTO;
import br.com.fiap.challenge.ouro.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private ListaFuncionario listaFuncionario;

    public void adicionaFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = converteDTO(funcionarioDTO);
        listaFuncionario.adicionarFuncionario(funcionario);
    }

    private Funcionario converteDTO(FuncionarioDTO funcionarioDTO) {
        return new Funcionario(funcionarioDTO.nome(), funcionarioDTO.senha(), funcionarioDTO.idade(),
                funcionarioDTO.cargo(), funcionarioDTO.codRegistro());
    }

    public List<FuncionarioDTO> todosFuncionarios() {
        return listaFuncionario.getFuncionarios().stream().map(
                funcionario -> new FuncionarioDTO(funcionario.getNome(), funcionario.getSenha(), funcionario.getIdade(),
                        funcionario.getCargo(), funcionario.getCodRegistro())
        ).collect(Collectors.toList());
    }
}
