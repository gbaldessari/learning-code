package cl.ucn.Taller3.dominio;
public abstract class Pieza {
	private String nombre;
	private String rareza;
	private String tipo;
	public Pieza(String nombre, String rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRareza() {
		return rareza;
	}
	public String getTipo() {
		return tipo;
	}
}