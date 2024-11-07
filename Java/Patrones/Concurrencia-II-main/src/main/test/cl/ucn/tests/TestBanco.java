package cl.ucn.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import cl.ucn.modelo.Banco;

public class TestBanco {

	@Test
    public void testTransferencia() {
        Banco banco = new Banco();
        Logger mockLogger = mock(Logger.class);

        // Establecer un saldo inicial conocido
        banco.setCantidad(0, 5000);

        // Ejecutar la transferencia con un monto que debería ser menor al saldo
        banco.transferencia(0, 1, 3000, mockLogger);

        // Verificar que el saldo total sea correcto después de la transferencia
        assertEquals(200000, banco.getSaldoTotal(), 0.01);
    }
}