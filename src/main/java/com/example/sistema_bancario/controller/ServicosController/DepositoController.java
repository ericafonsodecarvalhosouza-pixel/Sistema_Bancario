package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DepositoController {


    @FXML
    private TextField txtDigitarValorDeposito;

    @FXML
    private Label lblValorDisponivel;


    @FXML
    public void initialize(){
        Conta conta = Banco.getContaLogada();
        atualizarSaldo();
    }

    @FXML
    private void btnVoltar(ActionEvent event) throws IOException {

        GerenciadorTelas.trocarTela(
                event,
                "/com/example/sistema_bancario/tela_Inicial.fxml"
        );
    }

    @FXML
    private void confirmarDeposito(ActionEvent event ) throws IOException {
        try {
            Conta conta = Banco.contaLogada;
            double valor = Double.parseDouble(txtDigitarValorDeposito.getText());
            conta.depositar(valor);
            atualizarSaldo();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Depósito");
            alert.setTitle("Sucesso!");
            alert.setContentText("Seu depósito foi realizado com sucesso!");
            alert.showAndWait();

            txtDigitarValorDeposito.clear();

            GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");


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
    public void voltarParaInicio2(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");
    }
}

