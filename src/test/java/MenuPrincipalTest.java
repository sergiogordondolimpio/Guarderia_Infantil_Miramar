import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MenuPrincipalTest {

    Respuesta respuesta =new Respuesta();

    @Test
    void decide_continuar() {
        Assert.assertEquals(true, respuesta.decidir_continuar('s'));
    }

    @Test
    void decide_no_continuar() {
        Assert.assertEquals(false, respuesta.decidir_continuar('n'));
    }
}
