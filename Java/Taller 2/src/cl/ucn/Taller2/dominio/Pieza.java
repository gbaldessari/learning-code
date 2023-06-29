package cl.ucn.Taller2.dominio;
/**
 * Class Pieza
 */
public class Pieza {
	String nombre;
	String codigo;
	String tipo;
	String pais;
	int cantidadMaterial;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the piece
     * @param codigo A String that stores the code of the piece
     * @param tipo A String that stores the tipe of the piece
     * @param pais A String that stores the country of origin of the piece
     * @param cantidadMaterial An Integer that stores the amount of materials to create the piece
     */
	public Pieza(String nombre, String codigo, String tipo, String pais, int cantidadMaterial) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.pais = pais;
		this.cantidadMaterial = cantidadMaterial;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public String getPais() {
		return pais;
	}
	public int getCantidadMaterial() {
		return cantidadMaterial;
	}
}