package A10;

public class Nodo {
	private Nodo siguiente;
	private Jugador jugador;
	public Nodo(Jugador jugador) {
		this.jugador = jugador;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Jugador getJugador() {
		return jugador;
	}
}