package cl.ucn.Taller3.dominio;
public class Torax extends Pieza{
	private double vida;
	public Torax(String nombre, String rareza, String tipo, double vida) {
		super(nombre, rareza, tipo);
		this.vida = vida;
	}
	public double getVida() {
		return vida;
	}
}