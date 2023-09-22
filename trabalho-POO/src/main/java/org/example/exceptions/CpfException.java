package org.example.exceptions;

public class CpfException extends Exception{
    public CpfException(){
        super("CPF inválido");
    }
}
