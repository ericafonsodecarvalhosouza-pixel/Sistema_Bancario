package com.example.sistema_bancario.controller.Controllersinterfaces;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CadastroController {

    @FXML
    private ComboBox<String> tipoDeConta;

    @FXML
    public void initialize(){
        tipoDeConta.getItems().addAll(
                "Conta Corrente",
                "Conta Poupança"
        );
    }
}