import org.example.enums.TipoPessoa;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormatadorServiceTeste {



    @Test
    public void FormatadorCpfTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus",TipoPessoa.FISICA, "123.456.789-00");
        Assertions.assertEquals("12345678900", p.getDocumento());
    }

    @Test
    public void FormatadorCnpjTeste() throws Exception {
        Pessoa p =new Pessoa("Matheus",TipoPessoa.JURIDICA, "123.456.789-00000");
        Assertions.assertEquals("12345678900000", p.getDocumento());
    }
}
