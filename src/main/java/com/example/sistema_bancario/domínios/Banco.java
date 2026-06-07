package com.example.sistema_bancario.domínios;

import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.domínios.Contas.ContaCorrente;
import com.example.sistema_bancario.domínios.Contas.ContaPoupanca;
import com.example.sistema_bancario.domínios.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static List<Conta> cadastroContas = new ArrayList<>();

    public static Conta contaLogada;

    static {

        Cliente cliente1 = new Cliente(
                "João Silva",
                "joao.silva@gmail.com",
                "11111111111",
                "senha123"
        );

        ContaCorrente conta1 = new ContaCorrente(
                cliente1,
                1000
        );

        Cliente cliente2 = new Cliente(
                "Maria Souza",
                "maria.souza@hotmail.com",
                "22222222222",
                "senha123"
        );

        ContaPoupanca conta2 = new ContaPoupanca(
                cliente2
        );

        cadastroContas.add(conta1);
        cadastroContas.add(conta2);
    }

    public static Conta buscarCPF(String cpf) {

        for (Conta conta : cadastroContas) {

            if (conta.getCliente().getCPF().equals(cpf)) {
                return conta;
            }
        }

        return null;
    }

    public static Conta getContaLogada() {
        return contaLogada;
    }

    public static void setContaLogada(Conta contaLogada) {
        Banco.contaLogada = contaLogada;
    }

    public static void logout(){
        contaLogada = null;
    }
}
