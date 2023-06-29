package cl.ucn.Taller2.dominio;
/**
 * Class ListaArmas
 */
public class ListaPaises {
	Pais[] paises;
	/**
     * Constructor of the class
     */
	public ListaPaises() {
		paises = new Pais[0];
	}
	/**
     * Add a new country to the list
     * @param pais The country to add
     */
	public void ingresar(Pais pais) {
		Pais[] nuevaLista = new Pais[paises.length+1];
		for(int i = 0;i<paises.length;i++) nuevaLista[i] = paises[i];
		nuevaLista[paises.length] = pais;
		paises = nuevaLista;
	}
	/**
     * Get the amount of countries saved
     * @return the amount of countries saved
     */
	public int getCantidad() {
		return paises.length;
	}
	/**
     * Search country by name
     * @param nombre A String that stores the name of the country
     * @return the position in the list of the country
     */
	public int buscarPorNombre(String nombre) {
		int pos = -1;
		for(int i = 0;i<paises.length;i++) {
			if(paises[i].getNombre().equalsIgnoreCase(nombre)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Search country by code
     * @param codigo A String that stores the code of the piece
     * @return the position in the list of the country
     */
	public int buscarPorCodigo(String codigo) {
		int pos = -1;
		for(int i = 0;i<paises.length;i++) {
			if(paises[i].getCodigoParte().equalsIgnoreCase(codigo)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a country for its position
     * @param posicion An Integer that stores the position of the country
     * @return the country
     */
	public Pais getPais(int posicion) {
		return paises[posicion];
	}
}