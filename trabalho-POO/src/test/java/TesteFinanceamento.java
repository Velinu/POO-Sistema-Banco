import org.example.enums.TipoConta;
import org.example.enums.TipoPessoa;
import org.example.exceptions.ContaPoupancaException;
import org.example.exceptions.MesesException;
import org.example.models.Conta;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteFinanceamento {

    @Test
    public void FinanceamentoPositivoTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);
        Assertions.assertEquals("Você terá que pagar 33.0 durante 120 meses para este financeamento", c.financeamento(4000.00, 120));
    }

    @Test
    public void FinanceamentoNegativoTeste() throws Exception{
        Pessoa p =new Pessoa("Matheus", TipoPessoa.FISICA, "123.456.789-00");
        Conta c = new Conta(p,1200.00, TipoConta.CONTA_SALARIAL,1);
        Assertions.assertThrows(MesesException.class, () -> c.financeamento(100.00, 0));
    }
}
