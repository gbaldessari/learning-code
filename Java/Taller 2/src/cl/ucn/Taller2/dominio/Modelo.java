package cl.ucn.Taller2.dominio;
/**
 * Class Modelo
 */
public class Modelo {
	String nombre;
	String codigo;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the model
     * @param codigo A String that stores the code of the model
     */
	public Modelo(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCodigo() {
		return codigo;
	}
}