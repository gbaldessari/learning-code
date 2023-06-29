package cl.ucn.Taller2.dominio;
/**
 * Class ListaMateriales
 */
public class ListaMateriales {
	Material[] materiales;
	/**
     * Constructor of the class
     */
	public ListaMateriales() {
		materiales = new Material[0];
	}
	/**
     * Add a new material to the list
     * @param material The material to add
     */
	public void ingresar(Material material) {
		Material[] nuevaLista = new Material[materiales.length+1];
		for(int i = 0;i<materiales.length;i++) nuevaLista[i] = materiales[i];
		nuevaLista[materiales.length] = material;
		materiales = nuevaLista;
	}
	/**
     * Get the amount of materials stored
     * @return the amount of materials stored
     */
	public int getCantidad() {
		return materiales.length;
	}
	/**
     * Search material by name
     * @param nombre A String that stores the name of the material
     * @return the position in the list of the materials
     */
	public int buscarPorNombre(String nombre) {
		int pos = -1;
		for(int i = 0;i<materiales.length;i++) {
			if(materiales[i].getNombre().equalsIgnoreCase(nombre)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a material for its position
     * @param posicion An Integer that stores the position of the material
     * @return the material
     */
	public Material getMaterial(int posicion) {
		return materiales[posicion];
	}
}