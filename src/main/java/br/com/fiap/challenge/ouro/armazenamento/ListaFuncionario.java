package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaFuncionario {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

}
