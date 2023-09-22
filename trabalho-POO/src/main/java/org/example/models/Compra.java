package org.example.models;

import org.example.enums.FormaPagamento;

import java.time.LocalDate;
import java.util.*;

public class Compra {
    private Double valor;
    private String produto;
    private FormaPagamento formaPagamento;
    private LocalDate dataVenda;

    public Compra(Double valor, String produto, FormaPagamento formaPagamento, LocalDate dataVenda) {
        this.valor = valor;
        this.produto = produto;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
    }

    public Double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }


}
