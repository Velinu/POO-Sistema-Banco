package org.example.enums;

public enum TipoAcao {
    ACAO1(0.09),
    ACAO2(0.05),
    ACAO3(0.075);

    Double rendimento;
    TipoAcao(Double rendimento){
        this.rendimento = rendimento;
    }

    public Double getRendimento(){
        return this.rendimento;
    }
}
