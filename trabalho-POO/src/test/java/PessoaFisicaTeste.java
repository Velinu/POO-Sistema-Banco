import org.example.enums.TipoPessoa;
import org.example.exceptions.CpfException;
import org.example.exceptions.CpfNullException;
import org.example.models.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaFisicaTeste {


    @Test
    public void TestarCpfNull(){
        Assertions.assertThrows(CpfNullException.class, () -> new Pessoa("Matheus", TipoPessoa.FISICA, null));
    }

    @Test
    public void TestarCpfIncorreto(){
        Assertions.assertThrows(CpfException.class, () -> new Pessoa("Matheus", TipoPessoa.FISICA, "1234567890"));
    }
}
