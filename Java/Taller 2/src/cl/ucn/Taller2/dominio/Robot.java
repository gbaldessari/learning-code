package cl.ucn.Taller2.dominio;
/**
 * Class Robot
 */
public class Robot {
	String nombre;
	String brazos;
	String piernas;
	String torax;
	String cabeza;
	String cualidad;
	String arma;
	String equipo;
	String codigo;
	int municion;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the robot
     * @param brazos A String that stores the name of the arms
     * @param piernas A String that stores the name of the legs
     * @param torax A String that stores the name of the chest
     * @param cabeza A String that stores the name of the head
     * @param cualidad A String that stores the name extra quality
     * @param arma A String that stores the name of the weapon
     * @param equipo A String that stores the name of the team
     * @param codigo A String that stores the id of the pilot
     */
	public Robot(String nombre, String brazos, String piernas, String torax, String cabeza, String cualidad, String arma, String equipo, String codigo) {
		this.nombre = nombre;
		this.brazos = brazos;
		this.piernas = piernas;
		this.torax = torax;
		this.cabeza = cabeza;
		this.cualidad = cualidad;
		this.arma = arma;
		this.equipo = equipo;
		this.codigo = codigo;
		this.municion = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public String getBrazos() {
		return brazos;
	}
	public String getPiernas() {
		return piernas;
	}
	public String getTorax() {
		return torax;
	}
	public String getCabeza() {
		return cabeza;
	}
	public String getCualidad() {
		return cualidad;
	}
	public String getArma() {
		return arma;
	}
	public String getEquipo() {
		return equipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getMunicion() {
		return municion;
	}
	public void setBrazos(String brazos) {
		this.brazos = brazos;
	}
	public void setPiernas(String piernas) {
		this.piernas = piernas;
	}
	public void setTorax(String torax) {
		this.torax = torax;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public void setCualidad(String cualidad) {
		this.cualidad = cualidad;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	public void setMunicion(int municion) {
		this.municion = municion;
	}
}