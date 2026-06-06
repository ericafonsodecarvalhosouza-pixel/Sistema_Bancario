package com.example.sistema_bancario.controller.ServicosController;

import com.example.sistema_bancario.controller.utils.GerenciadorTelas;
import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.Contas.Conta;
import com.example.sistema_bancario.exceptions.saldoInsuficienteException;
import com.example.sistema_bancario.exceptions.valorInvalidoException;
import com.example.sistema_bancario.extrato.GerarExtratoPDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    public void initialize(){
        Conta conta = Banco.getContaLogada();
        atualizarSaldo();

    }

    @FXML
    void gerarextrato(ActionEvent event) throws Exception {
        try {
            Conta conta = Banco.getContaLogada();

            GerarExtratoPDF.gerarExtrato(conta, "Extrato.pdf");

        } catch (Exception e){
            e.getCause();
        }
    }

    @FXML
    void tela_Inicial(ActionEvent event) throws IOException {
        GerenciadorTelas.trocarTela(event, "/com/example/sistema_bancario/tela_Inicial.fxml");
    }

    private void atualizarSaldo(){
        Conta conta = Banco.getContaLogada();
        if(conta != null){
            lblValorDisponivel.setText(String.format("R$ " + conta.getSaldo()));
        }
    }

}
