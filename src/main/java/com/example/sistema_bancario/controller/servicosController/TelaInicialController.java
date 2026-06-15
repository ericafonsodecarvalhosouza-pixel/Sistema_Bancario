package com.example.sistema_bancario.controller.servicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.contas.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.example.sistema_bancario.domínios.Banco;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;

public class TelaInicialController {

    @FXML
    private Label lblValorDisponivel;

    @FXML
    private Label labelMostrarNome;

    @FXML
    private void initialize(){
        Conta conta = Banco.getContaLogada();
        atualizarSaldo();
        MostrarNome();
    }

    @FXML
    private void MostrarNome(){
        Conta conta = Banco.getContaLogada();
        labelMostrarNome.setText(String.format("Olá, " + conta.getCliente().getNome()));
    }

    @FXML
    void teladedeposito(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/deposito-view.fxml");
    }

    @FXML
    void teladeextrato(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/Extrato.fxml");
    }

    @FXML
    void teladesaque(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/saque.fxml");
    }

    @FXML
    void teladetransferencia(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/transferencia-view.fxml");
    }

    @FXML
    void teladelogin(ActionEvent event) throws IOException {
        Banco.logout();
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/login.fxml");
    }

    private void atualizarSaldo(){
        Conta conta = Banco.getContaLogada();
        if(conta != null){
            lblValorDisponivel.setText(String.format("R$ " + conta.getSaldo()));
        }
    }
}
