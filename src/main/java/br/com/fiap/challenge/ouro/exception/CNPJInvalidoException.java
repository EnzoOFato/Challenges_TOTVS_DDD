package br.com.fiap.challenge.ouro.exception;

public class CNPJInvalidoException extends RuntimeException {

    private String message;

    public CNPJInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
