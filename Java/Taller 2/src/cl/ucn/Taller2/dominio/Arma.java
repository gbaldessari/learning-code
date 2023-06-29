package cl.ucn.Taller2.dominio;
/**
 * Class Arma
 */
public class Arma {
	String nombre;
	String codigo;
	int municion;
	String pais;
	int cantidadMaterial;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the weapon
     * @param codigo A String that stores the code of the weapon
     * @param municion An Integer that stores the amount of ammunition of the weapon
     * @param pais A String that stores the country of origin of the weapon
     * @param cantidadMaterial An Integer that stores the amount of material needed to create the weapon
     */
	public Arma(String nombre, String codigo, int municion, String pais, int cantidadMaterial) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.municion = municion;
		this.pais = pais;
		this.cantidadMaterial = cantidadMaterial;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getMunicion() {
		return municion;
	}
	public String getPais() {
		return pais;
	}
	public int getCantidadMaterial() {
		return cantidadMaterial;
	}
}