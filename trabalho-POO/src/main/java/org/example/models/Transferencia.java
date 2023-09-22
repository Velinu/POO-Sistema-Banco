package org.example.models;

import java.time.LocalDate;

public class Transferencia {
    private Double valor;
    private LocalDate data;

    public Transferencia(Double valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
