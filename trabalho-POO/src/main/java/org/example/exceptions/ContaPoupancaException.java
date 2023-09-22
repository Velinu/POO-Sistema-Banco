package org.example.exceptions;

public class ContaPoupancaException extends Exception{
    public ContaPoupancaException(){
        super("Não é possível criar uma conta poupança com menos de 50 reais");
    }
}
