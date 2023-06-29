package cl.ucn.Taller3.dominio;
public abstract class Robot {
	private String nombre;
	private Arma arma;
	private Piernas piernas;
	private Brazos brazos;
	private Torax torax;
	private Cabeza cabeza;
	private String tipo;
	public Robot(String nombre, Arma arma, Piernas piernas, Brazos brazos, Torax torax, Cabeza cabeza, String tipo) {
		this.nombre = nombre;
		this.arma = arma;
		this.piernas = piernas;
		this.brazos = brazos;
		this.torax = torax;
		this.cabeza = cabeza;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public Piernas getPiernas() {
		return piernas;
	}
	public void setPiernas(Piernas piernas) {
		this.piernas = piernas;
	}
	public Brazos getBrazos() {
		return brazos;
	}
	public void setBrazos(Brazos brazos) {
		this.brazos = brazos;
	}
	public Torax getTorax() {
		return torax;
	}
	public void setTorax(Torax torax) {
		this.torax = torax;
	}
	public Cabeza getCabeza() {
		return cabeza;
	}
	public void setCabeza(Cabeza cabeza) {
		this.cabeza = cabeza;
	}
	public String getTipo() {
		return tipo;
	}
}