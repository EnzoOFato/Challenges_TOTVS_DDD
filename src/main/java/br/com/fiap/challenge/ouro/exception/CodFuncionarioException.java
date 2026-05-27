package br.com.fiap.challenge.ouro.exception;

public class CodFuncionarioException extends RuntimeException {

    private String message;

    public CodFuncionarioException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
