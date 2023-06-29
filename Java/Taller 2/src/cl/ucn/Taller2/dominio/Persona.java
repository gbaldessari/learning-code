package cl.ucn.Taller2.dominio;
/**
 * Class Persona
 */
public class Persona {
	String nombre;
	String id;
	String especialidad;
	String equipo;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the person
     * @param id A String that stores the id of the person
     * @param especialidad A String that stores the specialty of the person
     * @param equipo A String that stores the team of the person
     */
	public Persona(String nombre, String id, String especialidad, String equipo) {
		this.nombre = nombre;
		this.id = id;
		this.especialidad = especialidad;
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}