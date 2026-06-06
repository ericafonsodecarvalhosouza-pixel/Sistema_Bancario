package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class TransferenciaController {

    @FXML
    private void btnVoltar(ActionEvent event) throws IOException {

        GerenciadorTelas.trocarTela(
                event,
                "/com/example/sistema_bancario/tela_Inicial.fxml"
        );
    }

    @FXML
    private void confirmarDeposito(ActionEvent event) {

    }



}
