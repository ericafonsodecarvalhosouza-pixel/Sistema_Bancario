package com.example.sistema_bancario.domínios;

import com.example.sistema_bancario.domínios.Contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static Conta contaLogada;

     public static List<Conta> cadastroContas = new ArrayList<>();

     public static Conta buscarCPF(String cpf){
         for (Conta conta: cadastroContas){
             if(conta.getCliente().getCPF().equals(cpf)){
                 return conta;
             }
         }
         return null;
     }

}
