package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ExtratoController {

    @FXML
    private void gerarExtrato(ActionEvent event) {
        System.out.println("Saldo: " + Banco.contaLogada.getSaldo());
    }

    @FXML
    private void tela_Inicial(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(
                event,
                "/com/example/sistema_bancario/tela_Inicial.fxml"
        );
    }
}