package cl.ucn.Taller3.dominio;
public class Cabeza extends Pieza{
	private double velocidad;
	private double vida;
	public Cabeza(String nombre, String rareza, String tipo, double velocidad, double vida) {
		super(nombre, rareza, tipo);
		this.velocidad = velocidad;
		this.vida = vida;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public double getVida() {
		return vida;
	}
}