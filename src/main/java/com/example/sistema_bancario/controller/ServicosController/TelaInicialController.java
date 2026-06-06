package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class TelaInicialController {

    @FXML
    public void teladesaque(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(
                event, "/com/example/sistema_bancario/saque.fxml"
        );
    }

    @FXML
    public void teladedeposito(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(
                event, "/com/example/sistema_bancario/deposito-view.fxml"
        );
    }

    @FXML
    public void teladetransferencia(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(
                event, "/com/example/sistema_bancario/transferencia-view.fxml"
        );
    }

    @FXML
    public void teladeextrato(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(
                event, "/com/example/sistema_bancario/Extrato.fxml"
        );
    }
}
