package A10;
public class Jugador {
	private String nombre;
	private String rut;
	double puntos;
	public Jugador(String nombre, String rut) {
		this.nombre = nombre;
		this.rut = rut;
		puntos = 0;
	}
	public double getPuntos() {
		return puntos;
	}
	public void addPuntos(double puntos) {
		this.puntos += puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRut() {
		return rut;
	}
}