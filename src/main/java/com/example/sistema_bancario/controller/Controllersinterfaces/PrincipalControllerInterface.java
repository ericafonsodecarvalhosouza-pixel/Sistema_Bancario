package com.example.sistema_bancario.controller.Controllersinterfaces;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrincipalControllerInterface {

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
    private ComboBox<?> tipoDeConta;

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

    private Usuarios usuariosSelecionar;

    private List<Usuarios> listaDeUsuarios = new ArrayList<>();


    public void receberDadosCadastro(Usuarios usuario ){
        tituloCadastro.setText("Seja Bem Vindo(a) " + usuario.getNome());
    }


    @FXML
    public void botaoCadastrar(){

        String nome = labelNome.getText();
        String email = labelEmail.getText();
        String cpf = labelCpf.getText();
        String senha = labelSenha.getText();

    if(Objects.nonNull(usuariosSelecionar)){
        usuariosSelecionar.setNome(nome);
        usuariosSelecionar.setEmail(email);
        usuariosSelecionar.setCpf(cpf);
        usuariosSelecionar.setSenha(senha);

        usuariosSelecionar = null;

    }else{
        Usuarios usuario = new Usuarios(nome, email, senha, cpf);
        listaDeUsuarios.add(usuario);
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Usuário salvo com sucesso!");
    alert.showAndWait();
    }

    public void limparCampos(){

        labelNome.setText("");
        labelEmail.setText("");
        labelSenha.setText("");
        labelCpf.setText("");
    }



}
