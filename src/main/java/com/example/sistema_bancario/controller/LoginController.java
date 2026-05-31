package com.example.sistema_bancario.controller;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.domínios.Contas.ContaCorrente;
import com.example.sistema_bancario.domínios.Contas.ContaPoupanca;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class LoginController {


    @FXML
    private Button btnEntrar;

    @FXML
    private TextField emailField;

    @FXML
    private Hyperlink linkCadrastro;

    @FXML
    private PasswordField passwordField;

    public void init() {

        Cliente cliente1 = new Cliente(
                "João Silva",
                "joao@gmail.com",
                "11111111111",
                "senha123"
        );

        ContaCorrente conta1 = new ContaCorrente(cliente1, 1000);

        Cliente cliente2 = new Cliente(
                "Maria Souza",
                "maria@hotmail.com",
                "22222222222",
                "senha123"
        );

        ContaPoupanca conta2 = new ContaPoupanca(cliente2);

        Banco.cadastroContas.add(conta1);
        Banco.cadastroContas.add(conta2);
    }



}
