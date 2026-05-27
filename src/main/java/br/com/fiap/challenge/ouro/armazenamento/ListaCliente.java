package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaCliente {
    private final List<Cliente> listaCliente = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public List<Cliente> getListaCliente() {
        return this.listaCliente;
    }
}
