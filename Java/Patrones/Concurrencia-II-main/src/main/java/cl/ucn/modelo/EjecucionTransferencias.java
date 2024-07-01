package cl.ucn.modelo;

import org.apache.logging.log4j.Logger;

public class EjecucionTransferencias implements Runnable {

	Banco banco;
	int cuentaOrigen;
	double maximaCantidad;
	private Logger logger;

	
	public EjecucionTransferencias(Banco banco, int cuentaOrigen, double maximaCantidad, Logger logger) {
		
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.maximaCantidad = maximaCantidad;
		this.logger = logger;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			
			int cuentaDestino = (int) (100*Math.random());
			double cantidad = maximaCantidad*Math.random();
			this.banco.transferencia(this.cuentaOrigen, cuentaDestino, cantidad, logger);
			
		}
	}
	

}
