package cl.ucn.Taller3.dominio;
public class RobotH extends Robot {
	private String piloto;
	private String equipo;
	public RobotH(String nombre, Arma arma, Piernas piernas, Brazos brazos, Torax torax, Cabeza cabeza, String tipo, String piloto, String equipo) {
		super(nombre, arma, piernas, brazos, torax, cabeza, tipo);
		this.piloto = piloto;
		this.equipo = equipo;
	}
	public String getPiloto() {
		return piloto;
	}
	public String getEquipo() {
		return equipo;
	}
}