package cl.ucn.Taller3.dominio;
public class Piernas extends Pieza{
	private double velocidad;
	public Piernas(String nombre, String rareza, String tipo, double velocidad) {
		super(nombre, rareza, tipo);
		this.velocidad = velocidad;
	}
	public double getVelocidad() {
		return velocidad;
	}
}