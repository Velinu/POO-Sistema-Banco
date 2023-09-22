package org.example.models;

import java.time.LocalDate;

public class Deposito {
    private Double valor;
    private LocalDate data;

    public Deposito(Double valor, LocalDate data) {
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
