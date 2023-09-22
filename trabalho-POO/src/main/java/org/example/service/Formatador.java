package org.example.service;

import org.example.exceptions.CnpjException;
import org.example.exceptions.CnpjNullException;
import org.example.exceptions.CpfException;
import org.example.exceptions.CpfNullException;

public class Formatador {
    public String formataCnpj(String cnpj) throws CnpjNullException, CnpjException {
        if(cnpj == null){
            throw new CnpjNullException();
        }else {
            cnpj = cnpj.replaceAll("[^0-9]", "");
            if (cnpj.length() != 14) {
                throw new CnpjException();
            } else {
                return cnpj;
            }
        }
    }

    public String formataCpf(String cpf) throws CpfException, CpfNullException {
        if(cpf == null){
            throw new CpfNullException();
        }else {
            cpf = cpf.replaceAll("[^0-9]", "");
            if (cpf.length() != 11) {
                throw new CpfException();
            } else {
                return cpf;
            }
        }
    }
}
