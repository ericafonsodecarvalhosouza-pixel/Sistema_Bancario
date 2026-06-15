package com.example.sistema_bancario.extrato;


import com.example.sistema_bancario.domínios.contas.Conta;
import com.example.sistema_bancario.domínios.movimentacao.Movimentacao;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class GerarExtratoPDF {

    public static void gerarExtrato(Conta conta, String endereco) throws Exception{

        try{

            PdfWriter writer = new PdfWriter(endereco);
            PdfDocument pdf = new PdfDocument(writer);
            Document document =  new Document(pdf);

            document.add(new Paragraph("EXTRATO DE MOVIMENTAÇÕES BANCÁRIAS"));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Titular: " + conta.getCliente().getNome()));
            document.add(new Paragraph("CPF: " + conta.getCliente().getCPF()));
            document.add(new Paragraph("Saldo atual: " + conta.getSaldo()));
            document.add(new Paragraph(" "));

            for (Movimentacao movs: conta.getMovimentacoes()){

                String linha = movs.getDataHora() + " - " + movs.getValor() + " - " + movs.getTipomovimentacao() + " - " + movs.getDescricao();

                document.add(new Paragraph(linha));
            }

            document.add(new Paragraph(" "));

            document.close();



        }catch (Exception e){
            e.getCause();
        }
    }

}
