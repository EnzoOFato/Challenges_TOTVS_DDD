package br.com.fiap.challenge.ouro.exception;

public class ReuniaoInvalidaException extends RuntimeException {

    private String message;

    public ReuniaoInvalidaException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
