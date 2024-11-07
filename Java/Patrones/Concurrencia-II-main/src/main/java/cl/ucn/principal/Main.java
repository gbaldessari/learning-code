package cl.ucn.principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cl.ucn.modelo.Banco;
import cl.ucn.modelo.EjecucionTransferencias;

public class Main {

	
	
	public static void main(String[] argss) {
		
        Logger bancoLogger = LogManager.getFormatterLogger(Banco.class);
		Banco banco = new Banco();
		for (int i = 0; i < 100; i++) {
			
			EjecucionTransferencias ejecucionTransferencias = new EjecucionTransferencias(banco, i, 2000, bancoLogger);
			Thread hilo = new Thread(ejecucionTransferencias);
			hilo.start();
		}
	}
}