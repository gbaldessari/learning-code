import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HerramientasClimaTest {
    @Test
    public void testConstructorPorDefecto() {
        new HerramientasClima();
    }

    @Test
    public void testConsejoClimaticoCancelarPorVelocidad() {
        Assertions.assertEquals("CANCELAR", HerramientasClima.consejoClimatico(71.0, 0.0));
    }

    @Test
    public void testConsejoClimaticoCancelarPorLluvia() {
        Assertions.assertEquals("CANCELAR", HerramientasClima.consejoClimatico(0.0, 6.1));
    }

    @Test
    public void testConsejoClimaticoCancelarPorVelocidadYLluvia() {
        Assertions.assertEquals("CANCELAR", HerramientasClima.consejoClimatico(46.0, 4.1));
    }

    @Test
    public void testConsejoClimaticoAdvertenciaPorVelocidad() {
        Assertions.assertEquals("ADVERTENCIA", HerramientasClima.consejoClimatico(50.0, 0.0));
    }

    @Test
    public void testConsejoClimaticoAdvertenciaPorLluvia() {
        Assertions.assertEquals("ADVERTENCIA", HerramientasClima.consejoClimatico(0.0, 5.0));
    }

    @Test
    public void testConsejoClimaticoTodoClaro() {
        Assertions.assertEquals("TODO CLARO", HerramientasClima.consejoClimatico(30.0, 2.0));
    }

    @Test
    public void testConsejoClimaticoExcepcionConVelocidadNegativa() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            HerramientasClima.consejoClimatico(-10.0, 0.0);
        });
    }

    @Test
    public void testConsejoClimaticoExcepcionConLluviaNegativa() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            HerramientasClima.consejoClimatico(0.0, -5.0);
        });
    }
}
