package cl.ucn.Taller2.dominio;
/**
 * Class ListaModelos
 */
public class ListaModelos {
	Modelo[] modelos;
	/**
     * Constructor of the class
     */
	public ListaModelos() {
		modelos = new Modelo[0];
	}
	/**
     * Add a new model to the list
     * @param modelo The model to add
     */
	public void ingresar(Modelo modelo) {
		Modelo[] nuevaLista = new Modelo[modelos.length+1];
		for(int i = 0;i<modelos.length;i++) nuevaLista[i] = modelos[i];
		nuevaLista[modelos.length] = modelo;
		modelos = nuevaLista;
	}
	/**
     * Get the amount of models stored
     * @return the amount of models stored
     */
	public int getCantidad() {
		return modelos.length;
	}
	/**
     * Get a model for its position
     * @param posicion An Integer that stores the position of the model
     * @return the model
     */
	public Modelo getModelo(int posicion) {
		return modelos[posicion];
	}
}