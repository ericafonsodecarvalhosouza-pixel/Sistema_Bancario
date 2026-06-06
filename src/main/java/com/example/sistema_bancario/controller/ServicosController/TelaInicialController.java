package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TelaInicialController {


    @FXML
    private Button btnDeposito;

    @FXML
    private Button btninicio0;

    @FXML
    private Button btnExtrato;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnSaque;

    @FXML
    private Button btnTransferencia;

    @FXML
    private Label lblValorDisponivel;


    @FXML
    void teladedeposito(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/deposito.fxml");
    }

    @FXML
    void teladeextrato(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/Extrato.fxml");
    }

    @FXML
    void teladesaque(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/saque.fxml");
    }

    @FXML
    void teladetransferencia(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/transferencia.fxml");
    }

    @FXML
    void teladelogin(ActionEvent event) throws IOException {
        Banco.logout();
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/login.fxml");
    }

}
