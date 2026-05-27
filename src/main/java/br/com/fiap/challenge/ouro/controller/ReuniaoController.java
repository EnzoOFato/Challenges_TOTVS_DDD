package br.com.fiap.challenge.ouro.controller;

import br.com.fiap.challenge.ouro.dto.ReuniaoDTO;
import br.com.fiap.challenge.ouro.dto.ReuniaoDTOSaida;
import br.com.fiap.challenge.ouro.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {

    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarReuniao(@RequestBody ReuniaoDTO reuniaoDTO) {
        return reuniaoService.cadastraReuniao(reuniaoDTO);
    }

    @GetMapping("/listar")
    public List<ReuniaoDTOSaida> todasReunioes() {
        return reuniaoService.todasReunioes();
    }
}
