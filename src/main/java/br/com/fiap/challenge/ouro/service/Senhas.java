package br.com.fiap.challenge.ouro.service;

import br.com.fiap.challenge.ouro.model.Cliente;
import br.com.fiap.challenge.ouro.model.Funcionario;
import br.com.fiap.challenge.ouro.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Senhas {
    public static String esconde(String senha) {
        StringBuilder senhaOculta = new StringBuilder();
        for (int i = 0; i < senha.length(); i++) senhaOculta.append("*");
        return senhaOculta.toString();
    }

    public static List<Usuario> escondeVarias(List<Usuario> listaPre) {
        List<Usuario> retorno = new ArrayList<>();

        for (Usuario usuario : listaPre) {
            if (usuario instanceof Funcionario f) {
                retorno.add(new Funcionario(f.getNome(), esconde(f.getSenha()), f.getIdade(), f.getCargo(), f.getCodRegistro()));
            }
            else if (usuario instanceof Cliente c) {
                retorno.add(new Cliente(c.getNome(), esconde(c.getSenha()),
                        c.getIdade(), c.getId(), c.getCNPJ()));
            }
        }

        return retorno;
    }
}
