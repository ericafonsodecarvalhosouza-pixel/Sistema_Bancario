package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TransferenciaController {

    @FXML
    private Button btnEnviarPix;

    @FXML
    private Button btnInicio;

    @FXML
    private Label lblValorDisponivel;

    @FXML
    private TextField txtDigitarCPF;

    @FXML
    private TextField txtDigitarValorDeposito;

    @FXML
    private void initialize(){
        Conta conta = Banco.getContaLogada();
        atualizarSaldo();
    }

    @FXML
    void confirmarPix(ActionEvent event) throws IOException {
        try {
            Conta conta = Banco.contaLogada;
            double valor = Double.parseDouble(txtDigitarValorDeposito.getText());
            String CPF = txtDigitarCPF.getText();
            conta.transferir(CPF,valor);
            atualizarSaldo();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saque");
            alert.setHeaderText("Parabéns!");
            alert.setContentText("Transação realizada com sucesso!");
            alert.showAndWait();

            txtDigitarValorDeposito.clear();
            txtDigitarCPF.clear();

            GerenciadorTelas.trocarTela(event, "/com/exemple/sistema_bancario/tela_Inicial.fxml");

        }catch (valorInvalidoException ex){
            alertaDeErro(ex.getMessage());

        }catch (saldoInsuficienteException ex){
            alertaDeErro(ex.getMessage());

        }catch (NumberFormatException ex){
            alertaDeErro("Digite um valor númerico válido!");
        }
    }

    private void alertaDeErro(String msg){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Erro");
        alerta.setHeaderText("");
        alerta.setContentText(msg);
        alerta.showAndWait();

    }

    private void atualizarSaldo(){

        Conta conta = Banco.getContaLogada();

        if(conta != null){
            lblValorDisponivel.setText(String.format("R$ " + conta.getSaldo()));
        }
    }

    @FXML
    void voltarInicio3(ActionEvent event) throws IOException{
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");
    }
}
