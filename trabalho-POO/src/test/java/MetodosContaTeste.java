import org.example.enums.TipoConta;
import org.example.enums.TipoPessoa;
import org.example.exceptions.SaldoInsuficienteException;
import org.example.models.Conta;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MetodosContaTeste {
    @Test
    public void depositarTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,12000.00, TipoConta.CONTA_POUPANCA,1);
        Conta c2 = new Conta(p,1200.00, TipoConta.CONTA_CORRENTE,2);

        c.transferir(c2, 400.00,LocalDate.of(2009,9,19));
        Assertions.assertEquals(1600.00, c2.getSaldo());
    }

    @Test
    public void depositarErroDeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,100.00, TipoConta.CONTA_POUPANCA,1);
        Conta c2 = new Conta(p,1200.00, TipoConta.CONTA_CORRENTE,2);

        Assertions.assertThrows(SaldoInsuficienteException.class, ()->c.transferir(c2,500.00, LocalDate.of(2009,9,19)));
    }
}
