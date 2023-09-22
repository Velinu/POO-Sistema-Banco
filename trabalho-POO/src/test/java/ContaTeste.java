import org.example.enums.TipoConta;
import org.example.enums.TipoPessoa;
import org.example.exceptions.ContaPoupancaException;
import org.example.models.Conta;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaTeste {

    @Test
    public void CriacaoContaTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Pessoa p2 =new Pessoa("Matheus",TipoPessoa.JURIDICA, "123.456.789-00000");

        //(Pessoa proprietario, Double saldo, TipoConta tipoConta, Integer identificador)
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);
        Assertions.assertEquals(1200.00, c.getSaldo());
    }

    @Test
    public void CriacaoContaPoupancaTeste() throws Exception{
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");

        Assertions.assertThrows(ContaPoupancaException.class, ()->new Conta(p,0.0, TipoConta.CONTA_POUPANCA,1));
    }

    @Test
    public void CriacaoContaPoupancaValidoTeste() throws Exception{
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");


        Conta c = new Conta(p,1200.00, TipoConta.CONTA_POUPANCA,1);
        Assertions.assertEquals(1200.00, c.getSaldo());
    }
}
