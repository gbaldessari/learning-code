package A10;

public class Jugada {
	private Jugador jugador;
	private Juego juego;
	public Jugada(Jugador jugador, Juego juego) {
		this.jugador = jugador;
		this.juego = juego;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public Juego getJuego() {
		return juego;
	}
}