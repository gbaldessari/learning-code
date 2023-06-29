package cl.ucn.Taller2.dominio;
/**
 * Class Pais
 */
public class Pais {
	String nombre;
	String parte;
	String codigoParte;
	int cantidadParte;
	String materialParte;
	/**
     * Constructor of the class
     * @param nombre A String that stores the name of the country
     * @param parte A String that stores the tipe of piece that the country produces
     * @param codigoParte A String that stores the code of the piece
     * @param cantidadParte An Integer that stores the amount of pieces stored
     * @param materialParte A String that stores the material the part is made of
     */
	public Pais(String nombre, String parte, String codigoParte, int cantidadParte, String materialParte) {
		this.nombre = nombre;
		this.parte = parte;
		this.codigoParte = codigoParte;
		this.cantidadParte = cantidadParte;
		this.materialParte = materialParte;
	}
	public String getNombre() {
		return nombre;
	}
	public String getParte() {
		return parte;
	}
	public String getCodigoParte() {
		return codigoParte;
	}
	public int getCantidadParte() {
		return cantidadParte;
	}
	public String getMaterialParte() {
		return materialParte;
	}
	public void setCantidadParte(int cantidadParte) {
		this.cantidadParte = cantidadParte;
	}
}