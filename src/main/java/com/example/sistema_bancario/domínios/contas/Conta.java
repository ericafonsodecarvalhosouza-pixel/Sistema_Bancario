package com.example.sistema_bancario.domínios.contas;

import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.movimentacao.Movimentacao;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.enums.TipoMovimentacao;
import com.example.sistema_bancario.exceptions.ClienteInvalidoException;
import com.example.sistema_bancario.exceptions.DestinoInvalidoException;
import com.example.sistema_bancario.exceptions.SaldoInsuficienteException;
import com.example.sistema_bancario.exceptions.ValorInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conta {

    private Cliente cliente;
    private double saldo;
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        if (Objects.isNull(cliente)){
            throw new ClienteInvalidoException("Cadastro de cliente está sem informações.");
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
            throw new ValorInvalidoException("O valor do depósito deve ser maior que zero!");
        }
        saldo += valor;

        criarAMovimentacao(TipoMovimentacao.DEPOSITO, valor, "Deposito realizado.");
    }

    public void sacar(double valor){
        if (valor <= 0) {
            throw new ValorInvalidoException(
                    "O valor do saque deve ser maior que zero.");
        }

        if(valor > saldo){
            throw new SaldoInsuficienteException("valor maior que o saldo da conta");
        }

        saldo -= valor;

        criarAMovimentacao(TipoMovimentacao.SAQUE, valor, "Saque realizado.");
    }

    public void criarAMovimentacao(TipoMovimentacao tipo, double valor, String descricao){
        movimentacoes.add(new Movimentacao(tipo, valor, descricao));
    }

    public void transferir(String cpfDestino, double valor){

        if (valor <= 0){
            throw new SaldoInsuficienteException("Valor inválido.");
        }

        if (this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }

        Conta destino = Banco.buscarCPF(cpfDestino);

        if (Objects.isNull(destino)){
            throw new DestinoInvalidoException("Não existe o destino solicitado.");
        }

        this.saldo -= valor;
        destino.setSaldo(destino.getSaldo() + valor);

        criarAMovimentacao(TipoMovimentacao.TRANSFERENCIA_ENVIADA, valor, "Transferência realizada.");
        destino.criarAMovimentacao(TipoMovimentacao.TRANSFERENCIA_RECEBIDA, valor, "Transferência recebida.");

    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
