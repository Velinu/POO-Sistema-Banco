package org.example.models;

import org.example.enums.TipoPessoa;
import org.example.exceptions.CnpjException;
import org.example.exceptions.CnpjNullException;
import org.example.exceptions.CpfException;
import org.example.exceptions.CpfNullException;
import org.example.service.Formatador;

public class Pessoa {
    private String nome;
    private TipoPessoa tipoPessoa;
    private String documento;
    private Formatador formatador = new Formatador();

    public Pessoa(String nome, TipoPessoa tipoPessoa, String documento) throws Exception {
        this.nome = nome;

        if(tipoPessoa == TipoPessoa.FISICA) {
            try {
                this.documento = formatador.formataCpf(documento);
            } catch (CpfException | CpfNullException e) {
                throw e;
            } catch (Exception e) {
                throw new Exception("Não foi possível criar usuário");
            }
        }else if(tipoPessoa == TipoPessoa.JURIDICA){
            try{
                this.documento = formatador.formataCnpj(documento);
            }catch (CnpjException | CnpjNullException e){
                throw e;
            } catch (Exception e){
                throw new Exception("Não foi possível criar usuário");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public String getDocumento() {
        return documento;
    }
}
