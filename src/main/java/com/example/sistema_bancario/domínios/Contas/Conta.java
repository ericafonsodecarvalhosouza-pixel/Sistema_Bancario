package com.example.sistema_bancario.domínios.Contas;

import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.movimentacao.Movimentacao;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.enums.TipoMovimentacao;
import com.example.sistema_bancario.exceptions.clienteInvalidoException;
import com.example.sistema_bancario.exceptions.destinoInvalidoException;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conta {

    private Cliente cliente;
    private double saldo;
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        if (Objects.isNull(cliente)){
            throw new clienteInvalidoException("Cadastro de cliente está sem informações.");
        }
        this.cliente = cliente;
        this.saldo = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){

        if(valor <= 0){
            throw new valorInvalidoException("O valor do depósito deve ser maior que zero!");
        }
        saldo += valor;

        criarAMovimentacao(TipoMovimentacao.DEPOSITO, valor, "Deposito realizado.");
    }

    public void sacar(double valor){
        if (valor <= 0) {
            throw new valorInvalidoException(
                    "O valor do saque deve ser maior que zero.");
        }

        if(valor > saldo){
            throw new saldoInsuficienteException("valor maior que o saldo da conta");
        }

        saldo -= valor;

        criarAMovimentacao(TipoMovimentacao.SAQUE, valor, "Saque realizado.");
    }

    public void criarAMovimentacao(TipoMovimentacao tipo, double valor, String descricao){
        movimentacoes.add(new Movimentacao(tipo, valor, descricao));
    }

    public void transferir(String cpfDestino, double valor){

        if (valor <= 0){
            throw new saldoInsuficienteException("Valor inválido.");
        }

        if (this.saldo < valor){
            throw new saldoInsuficienteException("Saldo insuficiente para transferência.");
        }

        Conta destino = Banco.buscarCPF(cpfDestino);

        if (Objects.isNull(destino)){
            throw new destinoInvalidoException("Não existe o destino solicitado.");
        }

        this.sacar(valor);
        destino.depositar(valor);

        criarAMovimentacao(TipoMovimentacao.TRANSFERENCIA_ENVIADA, valor, "Transferência realizada.");
        destino.criarAMovimentacao(TipoMovimentacao.TRANSFERENCIA_RECEBIDA, valor, "Transferência recebida.");

    }



}
