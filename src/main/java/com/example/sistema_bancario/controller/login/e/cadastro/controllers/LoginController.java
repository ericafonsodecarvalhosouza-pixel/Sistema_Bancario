package com.example.sistema_bancario.controller.login.e.cadastro.controllers;
import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.contas.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    public void entrar(ActionEvent event) throws IOException {
        String email = emailField.getText();
        String senha = passwordField.getText();

        Conta contaEncontrada = Banco.cadastroContas.stream()
                .filter(c ->
                        c.getCliente().getEmail().equals(email)
                                && c.getCliente().getSenha().equals(senha))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(contaEncontrada)) {

            Banco.setContaLogada(contaEncontrada);

            GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setContentText("Email ou senha inválida!");
            alert.setHeaderText("Mensagem");
            alert.showAndWait();

        }


    }

    public void direcionarParaCadastro(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/cadastro.fxml");

    }

}
