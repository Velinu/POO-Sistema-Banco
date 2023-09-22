package org.example.exceptions;

public class CpfNullException extends Exception{
    public CpfNullException(){
        super("CPF nulo");
    }
}
