package cl.ucn.Taller3.dominio;
public class RobotA extends Robot {
	private String claseEscudo;
	public RobotA(String nombre, Arma arma, Piernas piernas, Brazos brazos, Torax torax, Cabeza cabeza, String tipo, String claseEscudo) {
		super(nombre, arma, piernas, brazos, torax, cabeza, tipo);
		this.claseEscudo = claseEscudo;
	}
	public String getClaseEscudo() {
		return claseEscudo;
	}
}