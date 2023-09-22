package org.example.service;

import org.example.exceptions.ContaPoupancaException;
import org.example.models.Conta;

public class VerificadorConta {
    public boolean validarContaPoupanca(Double saldo) throws ContaPoupancaException {
        if(saldo >= 50){
            return true;
        }else{
            throw new ContaPoupancaException();
        }
    }


}
