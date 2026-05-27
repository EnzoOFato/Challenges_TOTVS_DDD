package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ListaFuncionario {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public Optional<Funcionario> getFuncionarioCod(String cod) {
        return funcionarios.stream().filter(f -> f.getCodRegistro().equals(cod)).findFirst();
    }
}
