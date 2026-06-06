
package com.example.sistema_bancario.controller.LoginECadastroControllers;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.domínios.cliente.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.ContaCorrente;
import com.example.sistema_bancario.domínios.Contas.ContaPoupanca;

import com.example.sistema_bancario.exceptions.loginInvalidoexception;

import java.io.IOException;

public class CadastroController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private AnchorPane cardCadastro;

    @FXML
    private AnchorPane fundoCadastro;

    @FXML
    private TextField labelCpf;

    @FXML
    private TextField labelEmail;

    @FXML
    private TextField labelNome;

    @FXML
    private PasswordField labelSenha;

    @FXML
    private ComboBox<String> tipoDeConta;

    @FXML
    private Label tituloCadastro;

    @FXML
    private Label tituloCpf;

    @FXML
    private Label tituloEmail;

    @FXML
    private Label tituloNome;

    @FXML
    private Label tituloSenha;

    @FXML
    private Button btnConfirmarSaque;

    @FXML
    private AnchorPane cardSaque;

    @FXML
    private AnchorPane fundoSaque;

    @FXML
    private Label labelValorSaque;

    @FXML
    private Label tituloSaque;

    @FXML
    private Label valorDisponivel;

    @FXML
    private TextField valorSaque;

    @FXML
    private Button btnExtrato;

    @FXML
    private AnchorPane cardSaldoAtual;

    @FXML
    private Label datePixNovaes;

    @FXML
    private Label datePixSilva;

    @FXML
    private Label dateSaqueAumonte;

    @FXML
    private Label dateSaqueLopes;

    @FXML
    private Label extratoHover;

    @FXML
    private Label extratoSidebar;

    @FXML
    private AnchorPane hojeextrato;

    @FXML
    private Label nomeAuroraConta;

    @FXML
    private Label nomeAuroraSaque;

    @FXML
    private Label nomeBanco;

    @FXML
    private Label nomeFelipeConta;

    @FXML
    private Label nomeFelipeSaque;

    @FXML
    private Label nomeJoaoConta;

    @FXML
    private Label nomeJoaoPix;

    @FXML
    private Label nomeNovaesConta;

    @FXML
    private Label nomeSilviaSaque;

    @FXML
    private Label pixRecebido1;

    @FXML
    private Label pixRecebido2;

    @FXML
    private Label pixRecebidoValorSilva;

    @FXML
    private AnchorPane quarentaecincodiasExtrato;

    @FXML
    private Label saldoAtual;

    @FXML
    private Label saldoatualTexto;

    @FXML
    private Label saqueRealizado1;

    @FXML
    private Label saqueRealizado2;

    @FXML
    private AnchorPane setediasextrato;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private Label tituloExtrato;

    @FXML
    private AnchorPane trintadiasExtrato;

    @FXML
    private AnchorPane valorRecebidoJoao;

    @FXML
    private Label valorRecebidoNovaes;

    @FXML
    private AnchorPane valorRecebidoSilva;

    @FXML
    private Label valorSacadoAumonte;

    @FXML
    private AnchorPane valorSacadoLopes;

    @FXML
    public void initialize(){
        tipoDeConta.getItems().addAll(
                "Conta Corrente",
                "Conta Poupança"
        );
    }

    public void receberDadosCadastro(Cliente cliente ){
        tituloCadastro.setText("Seja Bem Vindo(a) " + cliente.getNome());
    }

    @FXML
    public void botaoCadastrar(ActionEvent event) throws IOException {

        String nome = labelNome.getText().trim();
        String email = labelEmail.getText().trim();
        String cpf = labelCpf.getText().trim();
        String senha = labelSenha.getText().trim();

        if(nome.isEmpty()){
            mostrarErro("Digite seu nome: ");
            return;
        }

        if(cpf.isEmpty()){
            mostrarErro("Digite seu cpf: ");
            return;
        }

        if(tipoDeConta.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Selecione um tipo de conta.");
            alert.showAndWait();

            return;
        }

        try{

            Cliente cliente = new Cliente(nome, email, cpf, senha);
            Conta conta;

            if (tipoDeConta.getValue().equals("Conta Corrente")) {
                conta = new ContaCorrente(cliente, 500);
            }else{
                conta = new ContaPoupanca(cliente);
            }

            Banco.cadastroContas.add(conta);

            Banco.setContaLogada(conta);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Usuário salvo com sucesso!");
            alert.showAndWait();

            limparCampos();

            GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");


        }catch(loginInvalidoexception e){
            mostrarErro(e.getMessage());
        }
    }

    public void mostrarErro(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }

    public void limparCampos(){

        labelNome.setText("");
        labelEmail.setText("");
        labelSenha.setText("");
        labelCpf.setText("");

        tipoDeConta.setValue(null);
    }
}