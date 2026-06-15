package com.example.sistema_bancario.domínios.contas;

import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.enums.TipoMovimentacao;
import com.example.sistema_bancario.exceptions.SaldoInsuficienteException;
import com.example.sistema_bancario.exceptions.ValorInvalidoException;

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

        if(valor <= 0){
            throw new ValorInvalidoException("o saque deve ser maior que zero!");
        }
        double saldoDisponivel = getSaldo() + limiteChequeEspecial;

        if (valor > saldoDisponivel){
            throw new SaldoInsuficienteException("Valor do saque maior que seu saldo disponivel");
        }

        setSaldo(getSaldo() - valor);

        criarAMovimentacao(TipoMovimentacao.SAQUE, valor, "Saque Realizado");
    }


}
