package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.extrato.GerarExtratoPDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ExtratoController {

    @FXML
    private Button btnExtrato;

    @FXML
    private Button btnInicio;

    @FXML
    private Label lblValorDisponivel;

    @FXML
    private Label saldoatualTexto;

    @FXML
    private Label tituloExtrato;

    @FXML
    public void initialize(){
        Conta conta = Banco.getContaLogada();
        atualizarSaldo();

    }

    @FXML
    void gerarExtrato(ActionEvent event) throws Exception {
        try {
            Conta conta = Banco.getContaLogada();
            GerarExtratoPDF.gerarExtrato(conta, "extrato.pdf");
        }catch (Exception e){
            alertaDeErro(e.getMessage());
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
        private void tela_Inicial(ActionEvent event) throws IOException {

            GerenciadorTelas.trocarTela(
                    event,
                    "/com/example/sistema_bancario/tela_Inicial.fxml"
            );

    }

}
