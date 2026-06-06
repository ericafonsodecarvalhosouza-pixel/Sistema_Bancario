package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TelaInicialController {


    @FXML
    private Button btnDeposito;

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
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/controller/ServicosController/DepositoController");
    }

    @FXML
    void teladeextrato(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/controller/ServicosController/ExtratoController");
    }

    @FXML
    void teladesaque(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/controller/ServicosController/SaqueController");
    }

    @FXML
    void teladetransferencia(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/controller/ServicosController/TransferenciaController");
    }

}
