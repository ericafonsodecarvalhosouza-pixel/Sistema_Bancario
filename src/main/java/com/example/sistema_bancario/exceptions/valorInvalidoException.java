package com.example.sistema_bancario.exceptions;

public class valorInvalidoException extends RuntimeException {
    public valorInvalidoException(String message) {
        super(message);
    }
}
