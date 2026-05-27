package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.armazenamento.ListaFuncionario;
import br.com.fiap.challenge.ouro.dto.FuncionarioDTO;
import br.com.fiap.challenge.ouro.exception.CodFuncionarioException;
import br.com.fiap.challenge.ouro.exception.UsuarioNuloException;
import br.com.fiap.challenge.ouro.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private ListaFuncionario listaFuncionario;

    public ResponseEntity<String> adicionaFuncionario(FuncionarioDTO funcionarioDTO){
        try {
            verificaCod(funcionarioDTO);
            verificaNull(funcionarioDTO);
            Funcionario funcionario = converteDTO(funcionarioDTO);
            listaFuncionario.adicionarFuncionario(funcionario);
            return ResponseEntity.ok("Funcionário cadastrado com sucesso");
        } catch (UsuarioNuloException | CodFuncionarioException e) {
            System.out.println("ERRO: " + e.getMessage());
            return ResponseEntity.badRequest().body("Erro ao cadastrar cliente: " + e.getMessage());
        }
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

    public void verificaNull(FuncionarioDTO func) {
        boolean condicao = func.nome() != null && func.senha() != null &&
                func.idade() != null && func.cargo() != null && func.codRegistro() != null;
        if (!condicao) {
            throw new UsuarioNuloException("Dados incompletos do funcionário");
        }
    }

    public void verificaCod(FuncionarioDTO funcionarioDTO) {
        String codVerificacao = funcionarioDTO.codRegistro();
        for (Funcionario funcionario : listaFuncionario.getFuncionarios()) {
            if (funcionario.getCodRegistro().equals(codVerificacao)) {
                throw new CodFuncionarioException("Código de registro já existente");
            }
        }
    }
}
