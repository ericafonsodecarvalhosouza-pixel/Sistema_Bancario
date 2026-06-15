package com.example.sistema_bancario.domínios.contas;

import com.example.sistema_bancario.domínios.cliente.Cliente;

public class ContaPoupanca extends Conta{

    private double rendimentoJuros;

    public ContaPoupanca(Cliente cliente, double rendimentoJuros) {
        super(cliente);
        this.rendimentoJuros = rendimentoJuros;
    }

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.rendimentoJuros = 1.15;
    }

    public double getRendimentoJuros() {
        return rendimentoJuros;
    }

    public void setRendimentoJuros(double rendimentoJuros) {
        this.rendimentoJuros = rendimentoJuros;
    }

    public void rendimento(){
        setSaldo(getSaldo() * rendimentoJuros);
    }
}
