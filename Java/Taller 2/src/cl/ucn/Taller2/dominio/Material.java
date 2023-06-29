package cl.ucn.Taller2.dominio;
/**
 * Class Material
 */
public class Material {
	String nombre;
	int cantidad;
	String pais;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the material
     * @param cantidad A Integer that stores the stock of the material
     * @param pais A String that stores the country of origin of the material
     */
	public Material(String nombre, int cantidad, String pais) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public String getPais() {
		return pais;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}