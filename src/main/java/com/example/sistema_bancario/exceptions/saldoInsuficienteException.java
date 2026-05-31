package com.example.sistema_bancario.exceptions;

public class saldoInsuficienteException extends RuntimeException {
    public saldoInsuficienteException(String message) {
        super(message);
    }
}
