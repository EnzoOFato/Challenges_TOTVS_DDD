package br.com.fiap.challenge.ouro.exception;

public class ParticipantesException extends RuntimeException {

    private String message;

    public ParticipantesException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
