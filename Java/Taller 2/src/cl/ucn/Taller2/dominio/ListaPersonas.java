package cl.ucn.Taller2.dominio;
import cl.ucn.Taller2.utils.*;
/**
 * Class ListaPersonas
 */
public class ListaPersonas {
	Persona[] personas;
	/**
     * Constructor of the class
     */
	public ListaPersonas() {
		personas = new Persona[0];
	}
	/**
     * Add a new person to the list
     * @param persona The person to add
     */
	public void ingresar(Persona persona) {
		Persona[] nuevaLista = new Persona[personas.length+1];
		for(int i = 0;i<personas.length;i++) nuevaLista[i] = personas[i];
		nuevaLista[personas.length] = persona;
		personas = nuevaLista;
	}
	/**
     * Get the amount of people stored
     * @return the amount of people stored
     */
	public int getCantidad() {
		return personas.length;
	}
	/**
     * Search person by team
     * @param equipo A String that stores the name of the team
     * @return the position in the list of the person
     */
	public int buscarPorEquipo(String equipo) {
		int pos = -1;
		for(int i = 0;i<personas.length;i++) {
			if(personas[i].getEquipo().equalsIgnoreCase(equipo)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Search people by team
     * @param equipo A String that stores the name of the team
     * @return a int[] with the positions in the list of the people
     */
	public int[] buscarPorEquipoLista(String equipo) {
		int pos[] = new int[0];
		for(int i = 0;i<personas.length;i++) {
			if(personas[i].getEquipo().equalsIgnoreCase(equipo)) {pos = Herramientas.appendInt(pos,i);}
		}
		return pos;
	}
	/**
     * Search person by id
     * @param id A String that stores the id
     * @return the position in the list of the person
     */
	public int buscarPorId(String id) {
		int pos = -1;
		for(int i = 0;i<personas.length;i++) {
			if(personas[i].getId().equalsIgnoreCase(id)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a person for its position
     * @param posicion An Integer that stores the position of the person
     * @return the person
     */
	public Persona getPersona(int posicion) {
		return personas[posicion];
	}
}