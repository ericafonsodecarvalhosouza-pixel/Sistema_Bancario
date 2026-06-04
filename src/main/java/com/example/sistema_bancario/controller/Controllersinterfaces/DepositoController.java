package com.example.sistema_bancario.controller.Controllersinterfaces;

import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepositoController {

    @FXML
    private TextField txtDigitarValorDeposito;

    @FXML
    private Label lblValorDisponivel;


    private Conta conta;


    public void setConta(Conta conta){
        this.conta = conta;
        atualizarSaldo();
    }

    @FXML
    private void confirmarDeposito(){
        try {
            double valor = Double.parseDouble(txtDigitarValorDeposito.getText());
            conta.depositar(valor);
            atualizarSaldo();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Depósito");
            alert.setTitle("Sucesso!");
            alert.setContentText("Seu depósito foi realizado com sucesso!");
            alert.showAndWait();

            txtDigitarValorDeposito.clear();
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

        conta = Banco.contaLogada;

        if(conta != null){
            lblValorDisponivel.setText(String.format("R$ " + conta.getSaldo()));
        }
    }
}



