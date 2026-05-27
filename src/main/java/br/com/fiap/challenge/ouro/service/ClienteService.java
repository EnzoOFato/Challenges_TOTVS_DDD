package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.armazenamento.ListaCliente;
import br.com.fiap.challenge.ouro.dto.ClienteDTO;
import br.com.fiap.challenge.ouro.exception.CNPJInvalidoException;
import br.com.fiap.challenge.ouro.exception.UsuarioNuloException;
import br.com.fiap.challenge.ouro.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ListaCliente listaCliente;

    private Pattern cnpjPattern = Pattern.compile("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$");

    public ResponseEntity<String> adicionaCliente(ClienteDTO clienteDTO) {
        try {
            verificaNull(clienteDTO);
            verificaCNPJ(clienteDTO.CNPJ());
            listaCliente.adicionarCliente(converteDTO(clienteDTO));
            return ResponseEntity.ok("Cliente criado com sucesso");
        } catch (CNPJInvalidoException | UsuarioNuloException e) {
            System.out.println("ERRO: " + e.getMessage());
            return ResponseEntity.badRequest().body("CNPJ fora do padrão: XX.XXX.XXX/YYYY-ZZ");
        }
    }

    private Cliente converteDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.nome(), clienteDTO.senha(), clienteDTO.idade(), clienteDTO.CNPJ());
    }

    private void verificaCNPJ(String cnpj) {
        Matcher matcher = cnpjPattern.matcher(cnpj);
        if (!matcher.find()) {
            throw new CNPJInvalidoException("CNPJ fora do padrão de formatação");
        }
    }

    public List<ClienteDTO> todosClientes() {
        return listaCliente.getListaCliente().stream().map(
                cliente -> new ClienteDTO(cliente.getId(), cliente.getNome(),
                        Senhas.esconde(cliente.getSenha()), cliente.getIdade(), cliente.getCNPJ())
        ).collect(Collectors.toList());
    }

    public void verificaNull(ClienteDTO clienteDTO) {
        boolean condicao = clienteDTO.nome() != null && clienteDTO.senha() != null &&
                clienteDTO.idade() != null && clienteDTO.CNPJ() != null;
        if (!condicao) {
            throw new UsuarioNuloException("Dados incompletos do funcionário");
        }
    }
}
