package br.com.fiap.challenge.ouro.controller;

import br.com.fiap.challenge.ouro.dto.ClienteDTO;
import br.com.fiap.challenge.ouro.dto.FuncionarioDTO;
import br.com.fiap.challenge.ouro.service.ClienteService;
import br.com.fiap.challenge.ouro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/criar/funcionario")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.adicionaFuncionario(funcionarioDTO);
    }

    @GetMapping("/listar/funcionario")
    public List<FuncionarioDTO> getFuncionarios(){
        return funcionarioService.todosFuncionarios();
    }

    @PostMapping("/criar/cliente")
    public ResponseEntity<String> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.adicionaCliente(clienteDTO);
    }

    @GetMapping("/listar/cliente")
    public List<ClienteDTO> getClientes() {
        return clienteService.todosClientes();
    }
}
