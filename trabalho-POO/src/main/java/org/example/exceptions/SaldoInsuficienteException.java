package org.example.exceptions;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(){
        super("Saldo insuficiente");
    }
}
