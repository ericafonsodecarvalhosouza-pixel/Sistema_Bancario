package com.example.sistema_bancario.controller;
import com.example.sistema_bancario.controller.Controllersinterfaces.PrincipalControllerInterface;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.ContaCorrente;
import com.example.sistema_bancario.domínios.Contas.ContaPoupanca;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
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

    public List<Cliente> init() {

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
        return null;
    }

    public void entrar(ActionEvent event) throws IOException {
        List<Cliente> clientes = init();
        String email = emailField.getText();
        String senha = passwordField.getText();
        Cliente clienteEncontrado = clientes.stream().filter(c ->
                c.getEmail().equals(email) && c.getSenha().equals(senha)).findFirst()
                .orElse(null);
        if (Objects.nonNull(clienteEncontrado)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("com/exemple/sistema_bancaraio/homepage-view.fxml"));
            Parent root = loader.load();

            PrincipalControllerInterface principalControllerInterface = loader.getController();

            principalControllerInterface.receberDadosCadastro(clienteEncontrado);

            Stage stage = (Stage) ((Node)
                    event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setContentText("Email ou senha inválida!");
            alert.setHeaderText("Mensagem");
            alert.showAndWait();

        }

    }

}
