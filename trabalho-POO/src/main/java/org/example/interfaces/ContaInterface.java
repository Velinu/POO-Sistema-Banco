package org.example.interfaces;

import org.example.enums.FormaPagamento;
import org.example.enums.TipoAcao;
import org.example.exceptions.SaldoInsuficienteException;
import org.example.models.Conta;

import java.time.LocalDate;

public interface ContaInterface {
    void deposito(Double valor, LocalDate data);
    void transferir(Conta conta, Double valor, LocalDate data) throws SaldoInsuficienteException;
    void comprar(String produto, Double valor, LocalDate data, FormaPagamento formaPagamento);
    Double gerarExtrato(int mes, int ano);
    Double aplicarFundos(TipoAcao acao, Double valor, Integer meses) throws SaldoInsuficienteException;
}
