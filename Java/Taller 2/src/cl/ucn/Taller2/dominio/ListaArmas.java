package cl.ucn.Taller2.dominio;
/**
 * Class ListaArmas
 */
public class ListaArmas {
	Arma[] armas;
	/**
     * Constructor of the class
     */
	public ListaArmas() {
		armas = new Arma[0];
	}
	/**
     * Add a new weapon to the list
     * @param arma The weapon to add
     */
	public void ingresar(Arma arma) {
		Arma[] nuevaLista = new Arma[armas.length+1];
		for(int i = 0;i<armas.length;i++) nuevaLista[i] = armas[i];
		nuevaLista[armas.length] = arma;
		armas = nuevaLista;
	}
	/**
     * Get the amount of weapons stored
     * @return the amount of weapons stored
     */
	public int getCantidad() {
		return armas.length;
	}
	/**
     * Search weapon by name
     * @param nombre A String that stores the name of the weapon
     * @return the position in the list of the weapon
     */
	public int buscarPorNombre(String nombre) {
		int pos = -1;
		for(int i = 0;i<armas.length;i++) {
			if(armas[i].getNombre().equalsIgnoreCase(nombre)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a weapon for its position
     * @param posicion An Integer that stores the position of the weapon
     * @return the weapon
     */
	public Arma getArma(int posicion) {
		return armas[posicion];
	}
}