package cl.ucn.modelo;

import org.apache.logging.log4j.Logger;

public class Banco {

	private final double[] cuentas;

	public Banco() {
		cuentas = new double[100];
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}
	}

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad, Logger logger) {
		if (cuentas[cuentaOrigen] < cantidad)
			return;

		cuentas[cuentaOrigen] -= cantidad;
		logger.info(Thread.currentThread());
		logger.info("Transferencia: %10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
		cuentas[cuentaDestino] += cantidad;
		logger.info("Saldo total: %10.2f%n", this.getSaldoTotal());
	}

	public synchronized double getSaldoTotal() {
		double sumaCuentas = 0;
		for (double a : this.cuentas)
			sumaCuentas += a;

		return sumaCuentas;
	}

	public synchronized void setCantidad(int cuenta, double cantidad) {
		this.cuentas[cuenta] = cantidad;
	}
}
