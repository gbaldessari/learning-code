package cl.ucn.Taller3.dominio;
public class Arma {
	private String nombre;
	private double dano;
	private double velocidad;
	public Arma(String nombre, double dano, double velocidad) {
		this.nombre = nombre;
		this.dano = dano;
		this.velocidad = velocidad;
	}
	public String getNombre() {
		return nombre;
	}
	public double getDano() {
		return dano;
	}
	public double getVelocidad() {
		return velocidad;
	}
}