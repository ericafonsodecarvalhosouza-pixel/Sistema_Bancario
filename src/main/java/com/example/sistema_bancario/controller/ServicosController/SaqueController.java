
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


public class SaqueController {
    @FXML
    private TextField digitarValorSaque;

    @FXML
    private Label lblValorDisponivel;

    private Conta conta;



    @FXML
    private void confiarmarSaque(ActionEvent event )throws IOException {
        try {
            Conta conta = Banco.contaLogada;
            double valor = Double.parseDouble(digitarValorSaque.getText());
            conta.sacar(valor);
            atualizarSaldo();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saque");
            alert.setHeaderText("Parabéns!");
            alert.setContentText("Saque realizado com sucesso!");
            alert.showAndWait();

            digitarValorSaque.clear();

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
        Conta conta = Banco.contaLogada;
        if(conta != null){
            lblValorDisponivel.setText(String.format("R$ " + conta.getSaldo()));
        }
    }
}
