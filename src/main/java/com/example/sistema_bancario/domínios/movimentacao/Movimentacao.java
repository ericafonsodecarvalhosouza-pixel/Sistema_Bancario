package com.example.sistema_bancario.domínios.movimentacao;

import com.example.sistema_bancario.enums.TipoMovimentacao;

import java.time.LocalDateTime;

public class Movimentacao {

    private TipoMovimentacao tipomovimentacao;
    private double valor;
    private LocalDateTime dataHora;
    private String descricao;

    public Movimentacao(TipoMovimentacao tipomovimentacao, double valor, String descricao) {
        this.tipomovimentacao = tipomovimentacao;
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
    }

    public TipoMovimentacao getTipomovimentacao() {
        return tipomovimentacao;
    }

    public void setTipomovimentacao(TipoMovimentacao tipomovimentacao) {
        this.tipomovimentacao = tipomovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
