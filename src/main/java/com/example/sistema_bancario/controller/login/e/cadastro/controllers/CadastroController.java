package com.example.sistema_bancario.controller.login.e.cadastro.controllers;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.contas.Conta;
import com.example.sistema_bancario.domínios.contas.ContaCorrente;
import com.example.sistema_bancario.domínios.contas.ContaPoupanca;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import com.example.sistema_bancario.exceptions.LoginInvalidoexception;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CadastroController {

    @FXML
    private Label textCadastro;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldNome;

    @FXML
    private PasswordField textFieldSenha;

    @FXML
    private ComboBox<String> tipoDeConta;

    @FXML
    public void initialize() {
        tipoDeConta.getItems().addAll(
                "Conta Corrente",
                     "Conta Poupança"
        );
    }

    public void receberDadosCadastro(Cliente cliente) {
        textCadastro.setText("Seja Bem Vindo(a) " + cliente.getNome());
    }

    @FXML
    public void botaoCadastrar(ActionEvent event) throws IOException {

        String nome = textFieldNome.getText().trim();
        String email = textFieldEmail.getText().trim();
        String cpf = textFieldCpf.getText().trim();
        String senha = textFieldSenha.getText().trim();

        if (nome.isEmpty()) {
            mostrarErro("Digite seu nome:");
            return;
        }

        if (email.isEmpty()) {
            mostrarErro("Digite seu email:");
            return;
        }

        if (cpf.isEmpty()) {
            mostrarErro("Digite seu CPF:");
            return;
        }

        if (senha.isEmpty()) {
            mostrarErro("Digite sua senha:");
            return;
        }

        if (tipoDeConta.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um tipo de conta:");
            alert.showAndWait();
            return;
        }

        if (Banco.emailExiste(email)){
            mostrarErro("Email ja cadastrado. Use um novo email!");
            return;
        }

        if (Banco.cpfExiste(cpf)){
            mostrarErro("CPF já cadastrado. Use um novo CPF!");
            return;
        }

        if (Banco.senhaExiste(senha)){
            mostrarErro("Senha já cadastrada. Use uma nova senha!");
        }

        try {

            Cliente cliente = new Cliente(nome, email, cpf, senha);

            Conta conta;

            if (tipoDeConta.getValue().equals("Conta Corrente")) {
                conta = new ContaCorrente(cliente, 500);
            } else {
                conta = new ContaPoupanca(cliente);
            }

            Banco.cadastroContas.add(conta);

            Banco.setContaLogada(conta);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Usuário cadastrado com sucesso!");
            alert.showAndWait();

            limparCampos();

            GerenciadorTelas.trocarTela(
                    event,
                    "/com/example/sistema_bancario/tela_Inicial.fxml"
            );

        } catch (LoginInvalidoexception e) {
            mostrarErro(e.getMessage());
        }
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldEmail.setText("");
        textFieldCpf.setText("");
        textFieldSenha.setText("");

        tipoDeConta.setValue(null);
    }
}