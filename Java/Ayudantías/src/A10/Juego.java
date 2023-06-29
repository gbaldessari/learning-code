package A10;

public class Juego {
	private String nombre;
	private double puntaje;
	int vecesJugado;
	public Juego(String nombre, double puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	public int getVecesJugado() {
		return vecesJugado;
	}
	public void addVecesJugado() {
		vecesJugado++;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPuntaje() {
		return puntaje;
	}
	
}
