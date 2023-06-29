package cl.ucn.Taller3.dominio;
public class Arma {
	private String nombre;
	private double daño;
	private double velocidad;
	public Arma(String nombre, double daño, double velocidad) {
		this.nombre = nombre;
		this.daño = daño;
		this.velocidad = velocidad;
	}
	public String getNombre() {
		return nombre;
	}
	public double getDaño() {
		return daño;
	}
	public double getVelocidad() {
		return velocidad;
	}
}