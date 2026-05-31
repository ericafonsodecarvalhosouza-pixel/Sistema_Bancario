package com.example.sistema_bancario.exceptions;

public class clienteInvalidoException extends RuntimeException {
    public clienteInvalidoException(String message) {
        super(message);
    }
}
