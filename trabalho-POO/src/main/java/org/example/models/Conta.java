package org.example.models;

import org.example.enums.FormaPagamento;
import org.example.enums.TipoAcao;
import org.example.enums.TipoConta;
import org.example.enums.TipoVinculo;
import org.example.exceptions.ContaPoupancaException;
import org.example.exceptions.MesesException;
import org.example.exceptions.SaldoInsuficienteException;
import org.example.interfaces.ContaInterface;
import org.example.service.VerificadorConta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conta implements ContaInterface {
    private Pessoa proprietario;
    private Pessoa vinculado;
    private Double saldo;
    private TipoConta tipoConta;
    private Integer identificador;
    private TipoVinculo tipoVinculo;
    private List<Compra> compras;
    private List<Transferencia> transferencias;
    private List<Deposito> depositos;

    private VerificadorConta verificador = new VerificadorConta();

    public Conta(Pessoa proprietario, Double saldo, TipoConta tipoConta, Integer identificador) throws ContaPoupancaException {
        if(tipoConta == TipoConta.CONTA_POUPANCA) {
            try {
                verificador.validarContaPoupanca(saldo);
            } catch (ContaPoupancaException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }
            this.proprietario = proprietario;
            this.saldo = saldo;
            this.tipoConta = tipoConta;
            this.identificador = identificador;
            this.compras = new ArrayList<>();
            this.transferencias = new ArrayList<>();
            this.depositos = new ArrayList<>();
    }

    public Conta(Pessoa proprietario, Pessoa vinculado, Double saldo, Integer identificador, TipoVinculo tipoVinculo) {
        this.proprietario = proprietario;
        this.vinculado = vinculado;
        this.saldo = saldo;
        this.tipoConta = TipoConta.CONTA_CONJUNTA;
        this.identificador = identificador;
        this.tipoVinculo = tipoVinculo;
        this.compras = new ArrayList<>();
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public Pessoa getVinculado() {
        return vinculado;
    }

    public Double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    @Override
    public void deposito(Double valor, LocalDate data) {
        depositos.add(new Deposito(valor, data));
        saldo += valor;
    }

    @Override
    public void transferir(Conta conta, Double valor, LocalDate data) throws SaldoInsuficienteException {
        try {
            if (saldo - valor >= 0) {
                conta.deposito(valor, data);
                saldo -= valor;
                Transferencia t = new Transferencia(valor, data);
                transferencias.add(t);
            }else{
                throw new SaldoInsuficienteException();
            }
        }catch (SaldoInsuficienteException e){
            throw e;
        }

    }

    @Override
    public void comprar(String produto, Double valor, LocalDate data, FormaPagamento formaPagamento) {
        Compra novaCompra = new Compra(valor, produto, formaPagamento, data);
        compras.add(novaCompra);
        saldo-=novaCompra.getValor();
    }

    @Override
    public Double gerarExtrato(int mes, int ano){
        List<Compra> comprasDoMes = new ArrayList<>();
        List<Transferencia> tDoMes = new ArrayList<>();
        List<Deposito> ganhosDoMes = new ArrayList<>();
        Double gastos = 0.0;
        if(compras.isEmpty() && transferencias.isEmpty()){
            return gastos;
        }
        for(Compra compra : compras){
            if(compra.getDataVenda().getMonthValue() == mes  && compra.getDataVenda().getYear() == ano){
                comprasDoMes.add(compra);
            }
        }

        for (Transferencia t : transferencias){
            if (t.getData().getMonthValue() == mes && t.getData().getYear() == ano){
                tDoMes.add(t);
            }
        }
        for(Compra compra : comprasDoMes){
                gastos-=compra.getValor();
        }
        for (Transferencia t : tDoMes){
            gastos-=t.getValor();
        }

        for(Deposito deposito : depositos){
            if(deposito.getData().getMonthValue() == mes && deposito.getData().getYear() == ano){
                gastos+=deposito.getValor();
            }
        }
            return gastos;
    }

    @Override
    public Double aplicarFundos(TipoAcao acao, Double valor, Integer meses) throws SaldoInsuficienteException {
        try{
            if(valor-saldo <= 0){
                saldo -= valor;
                return ((valor*acao.getRendimento())*meses)+valor;
            }else {
                throw  new SaldoInsuficienteException();
            }
        } catch (SaldoInsuficienteException e){
            throw e;
        }
    }

    public String financeamento(Double valor, Integer meses) throws MesesException {
        try{
            if (meses <= 0){
                throw new MesesException();
            }else{
                return "Você terá que pagar " + Math.floor(valor/meses) + " durante " + meses +" meses para este financeamento";
            }
        } catch (MesesException e) {
            throw e;
        }
    }


}
