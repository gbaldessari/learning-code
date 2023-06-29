package cl.ucn.Taller2.dominio;
import cl.ucn.Taller2.utils.*;
/**
 * Class ListaPiezas
 */
public class ListaPiezas {
	Pieza[] piezas;
	/**
     * Constructor of the class
     */
	public ListaPiezas() {
		piezas = new Pieza[0];
	}
	/**
     * Add a new piece to the list
     * @param pieza The piece to add
     */
	public void ingresar(Pieza pieza) {
		Pieza[] nuevaLista = new Pieza[piezas.length+1];
		for(int i = 0;i<piezas.length;i++) nuevaLista[i] = piezas[i];
		nuevaLista[piezas.length] = pieza;
		piezas = nuevaLista;
	}
	/**
     * Get the amount of pieces stored
     * @return the amount of pieces stored
     */
	public int getCantidad() {
		return piezas.length;
	}
	/**
     * Search piece by name
     * @param nombre A String that stores the name of the piece
     * @return the position in the list of the piece
     */
	public int buscarPorNombre(String nombre) {
		int pos = -1;
		for(int i = 0;i<piezas.length;i++) {
			if(piezas[i].getNombre().equalsIgnoreCase(nombre)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Search piece by tipe
     * @param tipo A String that stores the tipe of the piece
     * @return the position in the list of the piece
     */
	public int[] buscarPorTipo(String tipo) {
		int pos[] = new int[0];
		for(int i = 0;i<piezas.length;i++) {
			if(piezas[i].getTipo().equalsIgnoreCase(tipo)) {pos = Herramientas.appendInt(pos,i);}
		}
		return pos;
	}
	/**
     * Search piece by country of origin
     * @param pais A String that stores the country of origin of the piece
     * @return the position in the list of the piece
     */
	public int buscarPorPais(String pais) {
		int pos = -1;
		for(int i = 0;i<piezas.length;i++) {
			if(piezas[i].getPais().equalsIgnoreCase(pais)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a piece for its position
     * @param posicion An Integer that stores the position of the piece
     * @return the piece
     */
	public Pieza getPieza(int posicion) {
		return piezas[posicion];
	}
}