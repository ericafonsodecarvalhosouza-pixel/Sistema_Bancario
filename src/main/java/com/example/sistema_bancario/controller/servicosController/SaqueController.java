
package com.example.sistema_bancario.controller.servicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.contas.Conta;
import com.example.sistema_bancario.exceptions.SaldoInsuficienteException;
import com.example.sistema_bancario.exceptions.ValorInvalidoException;
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

    @FXML
    private void initialize(){
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
    private void confirmarSaque(ActionEvent event )throws IOException {
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

            GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");

        }catch (ValorInvalidoException ex){
            alertaDeErro(ex.getMessage());

        }catch (SaldoInsuficienteException ex){
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
    public void voltarParaInicio1(ActionEvent event) throws IOException{
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");
    }
}
