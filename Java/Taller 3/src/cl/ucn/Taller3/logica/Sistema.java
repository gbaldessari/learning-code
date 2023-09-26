package cl.ucn.Taller3.logica;
import javax.swing.table.DefaultTableModel;
/**
* Interface Sistema
*/
public interface Sistema {
	/**
     * Contiene los tipos de robots
     */
	public String[] tipos = {"Humano","Alien"};
	/**
     * Contiene las calidades de los escudos
     */
	public String[] calidades = {"SS+","S+","S","A","B"};
	/**
     * Contiene las rarezas de las piezas
     */
	public String[] rarezas = {"PP","PE","PC"};
	  /**
     * Anade un nuevo robot de la humanidad al sistema.
     * Restricciones:
     *  Pre:
     *      Todos los parametros deben de ser no nulos y contener valores validos.
     *  Pos:
     *      Generara un nuevo robot.
     * @param index Posiciones de las piezas en sus respectivas listas.
     * @param datos Contiene el nombre del robot, del piloto y del equipo.
     */
	void ingresarRobotHumano(int[] index, String[] datos);
	/**
     * Anade un nuevo robot alienigena al sistema.
     * Restricciones:
     *  Pre:
     *      Todos los parametros deben ser no nulos y contener valores validos.
     *  Pos:
     *      Generara un nuevo robot
     * @param index Posiciones de las piezas en sus respectivas listas.
     * @param nombre Contiene el nombre del robot.
     * @param escudo Posicion del escudo en su respectiva lista.
     */
	void ingresarRobotAlien(int[] index, String nombre, int escudo);
	  /**
     * Cambia las piezas de un robot.
     * Restricciones:
     *  Pre:
     *      Todos los parametros deben ser no nulos y contener valores validos.
     *  Pos:
     *      Se reemplazaran las piezas del robot.
     * @param index Posiciones de las piezas en sus respectivas listas.
     * @param robot Posicion del robot en su respectiva lista.
     */
	void cambiarPieza(int[] index, int robot);
	 /**
     * Cambia el arma de un robot.
     * Restricciones:
     *  Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se reemplaza el arma del robot.
     * @param index Posicion del arma en su respectiva lista.
     * @param robot Posicion del robot en su respectiva lista.
     */
	void cambiarArma(int index, int robot);
	 /**
     * Obtiene las estadisticas de un robot.
     * Restricciones:
     * 	Pre:
     *      El parametro debe ser valido y no nulo.
     *  Pos:
     *      Se obtienen las estadisticas del robot.
     * @param robot Posicion del robot en su respectiva lista.
     * @return String[] con las estadisticas del robot.
     */
	String[] obtenerEstadisticas(int robot);
	/**
     * Obtiene los nombres de los robots.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de los robots.
     * @return String[] con los nombres de los robots.
     */
	String[] getListaRobots();
	/**
     * Obtiene los nombres de los robots de la humanidad.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de los robots de la humanidad.
     * @return String[] con los nombres de los robots de la humanidad.
     */
	String[] getListaRobotsH();
	/**
     * Obtiene los nombres de los robots alienigenas.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de los robots alienigenas.
     * @return String[] con los nombres de los robots alienigenas.
     */
	String[] getListaRobotsA();
	/**
     * Obtiene los resultados de la simulacion.
     * Restricciones:
     * 	Pre:
     *      El parametro debe ser no nulo y contener valores validos.
     *  Pos:
     *      Se obtienen los resultados de la simulacion.
     * @param index Posiciones de los robots en su respectiva lista.
     * @return String[] con los resultados de las batallas.
     */
	String[] obtenerResultadosSimulacion(int[] index);
	/**
     * Obtiene las estadisticas de los combates.
     * Restricciones:
     * 	Pre:
     * 		La lista debe existir.
     *  Pos:
     *      Se obtienen las estadisticas de la simulacion.
     * @return double[] con las estadisticas de las batallas.
     */
	double[] obtenerEstadisticasCombate();
	/**
     * Obtiene una tabla con los datos de los robots tripulados.
     * Restricciones:
     * 	Pre:
     *      El parametro debe ser no nulo.
     *  Pos:
     *      Se obtiene la tabla con los datos de los robots tripulados.
     * @param modeloTablaRobots La tabla en la que se dispondran los datos.
     * @return DefaultTableModel con los datos de los robots tripulados.
     */
	DefaultTableModel getRobotsTripulados(DefaultTableModel modeloTablaRobots);
	/**
     * Obtiene una tabla con los datos de los robots del equipo especificado.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se obtiene la tabla con los datos de los robots tripulados.
     * @param modeloTablaRobots La tabla en la que se dispondran los datos.
     * @param equipo El nombre del equipo.
     * @return DefaultTableModel con los datos de los robots del equipo especificado.
     */
	DefaultTableModel getRobotsEquipo(DefaultTableModel modeloTablaRobots, String equipo);
	/**
     * Obtiene los nombres de los brazos.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de los brazos.
     * @return String[] con los nombres de los brazos.
     */
	String[] getListaBrazos();
	/**
     * Obtiene los nombres de las cabezas.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de las cabezas.
     * @return String[] con los nombres de las cabezas.
     */
	String[] getListaCabezas();
	/**
     * Obtiene los nombres de las piernas.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de las piernas.
     * @return String[] con los nombres de las piernas.
     */
	String[] getListaPiernas();
	/**
     * Obtiene los nombres de los torax.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de los torax.
     * @return String[] con los nombres de los torax.
     */
	String[] getListaTorax();
	/**
     * Obtiene los nombres de las armas.
     * Restricciones:
     *  Pre:
     *      La lista debe existir.
     *  Pos:
     *      Se obtienen los nombres de las armas.
     * @return String[] con los nombres de las armas.
     */
	String[] getListaArmas();
	/**
     * Anade una cabeza al sistema.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se ingresa una cabeza al sistema.
     * @param nombre Nombre de la cabeza.
     * @param rareza Posicion en la lista de rarezas.
     * @param velocidad Valor de velocidad.
     * @param vida Valor de vida.
     */
	void ingresarCabeza(String nombre, int rareza, int velocidad, int vida);
	/**
     * Anade un torax al sistema.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se ingresa un torax al sistema.
     * @param nombre Nombre del torax.
     * @param rareza Posicion en la lista de rarezas.
     * @param vida Valor de vida.
     */
	void ingresarTorax(String nombre, int rareza, int vida);
	/**
     * Anade unos brazos al sistema.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se ingresa unos brazos  al sistema.
     * @param nombre Nombre de los brazos.
     * @param rareza Posicion en la lista de rarezas.
     * @param ataque Valor de ataque.
     */
	void ingresarBrazos(String nombre, int rareza, int ataque);
	/**
     * Anade unas piernas al sistema.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se ingresa unas piernas al sistema.
     * @param nombre Nombre de las piernas.
     * @param rareza Posicion en la lista de rarezas.
     * @param velocidad Valor de velocidad.
     */
	void ingresarPiernas(String nombre, int rareza, int velocidad);
	/**
     * Anade un arma al sistema.
     * Restricciones:
     * 	Pre:
     *      Todos los parametros deben ser validos y no nulos.
     *  Pos:
     *      Se ingresa un arma al sistema.
     * @param nombre Nombre de la cabeza.
     * @param dano Valor de dano.
     * @param velocidad Valor de velocidad.
     */
	void ingresarArma(String nombre, int dano, int velocidad);
	/**
     * Guarda los datos del sistema en los archivos.
     * Restricciones:
     * 	Pre:
     *      El sistema debe estar inicializado.
     *  Pos:
     *      Se ingresa un arma al sistema.
     */
	void guardarDatos();
	/**
     * Anade un robot al sistema.
     * Restricciones:
     * 	Pre:
     *      El sistema debe estar inicializado.
     *  Pos:
     *      Se ingresa un robot al sistema.
     * @param linea Datos del robot.
     */
	void obtenerRobots(String[] linea);
	/**
     * Anade un arma al sistema.
     * Restricciones:
     * 	Pre:
     *      El sistema debe estar inicializado.
     *  Pos:
     *      Se ingresa un arma al sistema.
     * @param linea Datos del arma.
     */
	void obtenerArmas(String[] linea);
	/**
     * Anade una pieza al sistema.
     * Restricciones:
     * 	Pre:
     *      El sistema debe estar inicializado.
     *  Pos:
     *      Se ingresa una pieza al sistema.
     * @param linea Datos de la pieza.
     */
	void obtenerPiezas(String[] linea);
	/**
     * Anade un combate al sistema.
     * Restricciones:
     * 	Pre:
     *      El sistema debe estar inicializado.
     *  Pos:
     *      Se ingresa un combate al sistema.
     * @param linea Datos del combate.
     */
	void obtenerCombates(String[] linea);
}