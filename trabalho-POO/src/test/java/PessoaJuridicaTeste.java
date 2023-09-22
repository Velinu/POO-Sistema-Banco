import org.example.enums.TipoPessoa;
import org.example.exceptions.CnpjException;
import org.example.exceptions.CnpjNullException;
import org.example.exceptions.CpfException;
import org.example.exceptions.CpfNullException;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaJuridicaTeste {

    @Test
    public void TestarCnpjNull(){
        Assertions.assertThrows(CnpjNullException.class, () -> new Pessoa("Matheus", TipoPessoa.JURIDICA, null));
    }

    @Test
    public void TestarCnpjIncorreto(){
        Assertions.assertThrows(CnpjException.class, () -> new Pessoa("Matheus", TipoPessoa.JURIDICA, "1234567890"));
    }
}
