package cl.ucn.Taller2.dominio;
/**
 * Class ListaArmas
 */
public class ListaRobots {
	Robot[] robots;
	/**
     * Constructor of the class
     */
	public ListaRobots() {
		robots = new Robot[0];
	}
	/**
     * Add a new robot to the list
     * @param robot The robot to add
     */
	public void ingresar(Robot robot) {
		Robot[] nuevaLista = new Robot[robots.length+1];
		for(int i = 0;i<robots.length;i++) nuevaLista[i] = robots[i];
		nuevaLista[robots.length] = robot;
		robots = nuevaLista;
	}
	/**
     * Get the amount of robots stored
     * @return the amount of robots stored
     */
	public int getCantidad() {
		return robots.length;
	}
	/**
     * Search robot by name
     * @param nombre A String that stores the name of the robot
     * @return the position in the list of the robot
     */
	public int buscarPorNombre(String nombre) {
		int pos = -1;
		for(int i = 0;i<robots.length;i++) {
			if(robots[i].getNombre().equalsIgnoreCase(nombre)) {pos = i; break;}
		}
		return pos;
	}
	/**
     * Get a robot for its position
     * @param posicion An Integer that stores the position of the robot
     * @return the robot
     */
	public Robot getRobot(int posicion) {
		return robots[posicion];
	}
}