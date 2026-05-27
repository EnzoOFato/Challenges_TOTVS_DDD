package br.com.fiap.challenge.ouro.service;

public class Senhas {
    public static String esconde(String senha) {
        StringBuilder senhaOculta = new StringBuilder();
        for (int i = 0; i < senha.length(); i++) senhaOculta.append("*");
        return senhaOculta.toString();
    }
}
