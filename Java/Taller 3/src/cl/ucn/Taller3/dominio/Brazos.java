package cl.ucn.Taller3.dominio;
public class Brazos extends Pieza{
	private double ataque;
	public Brazos(String nombre, String rareza, String tipo, double ataque) {
		super(nombre, rareza, tipo);
		this.ataque = ataque;
	}
	public double getAtaque() {
		return ataque;
	}
}