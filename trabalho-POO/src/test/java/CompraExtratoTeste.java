import org.example.enums.FormaPagamento;
import org.example.enums.TipoConta;
import org.example.enums.TipoPessoa;
import org.example.models.Conta;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CompraExtratoTeste {

    @Test
    public void NovaCompraTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);

        c.comprar("Tartaruga ninja", 20.00, LocalDate.of(2023, 9, 11), FormaPagamento.DEBITO);

        Assertions.assertEquals("Tartaruga ninja", c.getCompras().get(0).getProduto());
    }

    @Test
    public void NovaExtratoTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);

        c.comprar("Tartaruga ninja", 20.00, LocalDate.of(2023, 9, 11), FormaPagamento.DEBITO);
        c.comprar("Tartaruga", 20.00, LocalDate.of(2023, 9, 13), FormaPagamento.DEBITO);
        c.deposito(400.00,LocalDate.of(2023,9,20));
        Assertions.assertEquals(360.00, c.gerarExtrato(9,2023));
    }
}
