import org.example.enums.TipoAcao;
import org.example.enums.TipoConta;
import org.example.enums.TipoPessoa;
import org.example.exceptions.SaldoInsuficienteException;
import org.example.models.Conta;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteAplicacao {
    @Test
    public void TestePositivoAplicacao() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);

        Assertions.assertEquals(408.0, c.aplicarFundos(TipoAcao.ACAO1, 300.00, 4));
    }

    @Test
    public void TesteNegativoAplicacao() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> c.aplicarFundos(TipoAcao.ACAO1, 9000.00, 4));
    }
}
