package br.com.fiap.challenge.ouro.exception;

public class UsuarioNuloException extends RuntimeException {

    private String messsage;

    public UsuarioNuloException(String message) {
        this.messsage = message;
    }

    @Override
    public String getMessage() {
        return this.messsage;
    }
}
