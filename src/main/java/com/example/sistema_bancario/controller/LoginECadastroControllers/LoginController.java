package com.example.sistema_bancario.controller.LoginECadastroControllers;
import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.domínios.Contas.ContaCorrente;
import com.example.sistema_bancario.domínios.Contas.ContaPoupanca;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginController {


    @FXML
    private Button btnEntrar;

    @FXML
    private TextField emailField;

    @FXML
    private Hyperlink linkCadrastro;

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
            Banco.contaLogada = contaEncontrada;

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
