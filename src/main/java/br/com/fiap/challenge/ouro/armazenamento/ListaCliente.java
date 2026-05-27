package br.com.fiap.challenge.ouro.armazenamento;

import br.com.fiap.challenge.ouro.dto.ClienteDTO;
import br.com.fiap.challenge.ouro.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ListaCliente {
    private final List<Cliente> listaCliente = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public List<Cliente> getListaCliente() {
        return this.listaCliente;
    }

    public Optional<Cliente> getClienteId(Long idBusca) {
        return listaCliente.stream().filter(c -> Objects.equals(c.getId(), idBusca)).findFirst();
    }
}
