package com.example.sistema_bancario.domínios.Contas;

import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.enums.TipoMovimentacao;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {

        double saldoDisponivel = getSaldo() + limiteChequeEspecial;

        if (valor > saldoDisponivel){
            throw new saldoInsuficienteException("Valor de saque maior que o seu saldo disponível.");
        }

        setSaldo(saldoDisponivel - valor);

        criarAMovimentacao(TipoMovimentacao.SAQUE, valor, "Saque Realizado");
    }


}
