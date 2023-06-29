package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
public class AdministradorVentanas {
	private Sistema sistema;
	public AdministradorVentanas(Sistema sistema) {
		this.sistema = sistema;
	}
	public void menu(AdministradorVentanas administradorVentanas) {
		VentanaMenu v = new VentanaMenu(administradorVentanas);
		v.setVisible(true);
	}
	public void seleccionCombates(AdministradorVentanas administradorVentanas) {
		VentanaSeleccionCombates v = new VentanaSeleccionCombates(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void añadirPiezas(AdministradorVentanas administradorVentanas) {
		VentanaAñadirPieza v = new VentanaAñadirPieza(administradorVentanas);
		v.setVisible(true);
	}
	public void ensamblarRobot(AdministradorVentanas administradorVentanas) {
		VentanaEnsamblarRobot v = new VentanaEnsamblarRobot(administradorVentanas,sistema);
		v.setVisible(true);
	}
	public void robotHumano(AdministradorVentanas administradorVentanas, int[] index) {
		VentanaRobotHumano v = new VentanaRobotHumano(administradorVentanas, sistema, index);
		v.setVisible(true);
	}
	public void robotAlien(AdministradorVentanas administradorVentanas, int[] index) {
		VentanaRobotAlien v = new VentanaRobotAlien(administradorVentanas, sistema, index);
		v.setVisible(true);
	}
	public void añadirCabeza(AdministradorVentanas administradorVentanas) {
		VentanaAñadirCabeza v = new VentanaAñadirCabeza(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void añadirTorax(AdministradorVentanas administradorVentanas) {
		VentanaAñadirTorax v = new VentanaAñadirTorax(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void añadirBrazos(AdministradorVentanas administradorVentanas) {
		VentanaAñadirBrazos v = new VentanaAñadirBrazos(administradorVentanas, sistema);
		v.setVisible(true);		
	}
	public void añadirPiernas(AdministradorVentanas administradorVentanas) {
		VentanaAñadirPiernas v = new VentanaAñadirPiernas(administradorVentanas, sistema);
		v.setVisible(true);			
	}
	public void añadirArma(AdministradorVentanas administradorVentanas) {
		VentanaAñadirArma v = new VentanaAñadirArma(administradorVentanas, sistema);
		v.setVisible(true);			
	}
	public void robotCambiarPiezas(AdministradorVentanas administradorVentanas) {
		VentanaSeleccionRobotPieza v = new VentanaSeleccionRobotPieza(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void cambiarPiezas(AdministradorVentanas administradorVentanas, int index) {
		VentanaCambiarPiezas v = new VentanaCambiarPiezas(administradorVentanas, sistema, index);
		v.setVisible(true);
	}
	public void robotCambiarArma(AdministradorVentanas administradorVentanas) {
		VentanaSeleccionRobotArma v = new VentanaSeleccionRobotArma(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void cambiarArma(AdministradorVentanas administradorVentanas, int index) {
		VentanaCambiarArma v = new VentanaCambiarArma(administradorVentanas, sistema, index);
		v.setVisible(true);		
	}
	public void robotEstadisticas(AdministradorVentanas administradorVentanas) {
		VentanaSeleccionRobotEstadistica v = new VentanaSeleccionRobotEstadistica(administradorVentanas, sistema);
		v.setVisible(true);	
	}
	public void mostrarEstadisticasRobot(AdministradorVentanas administradorVentanas, int index) {
		VentanaMostrarEstadisticasRobot v = new VentanaMostrarEstadisticasRobot(administradorVentanas, sistema, index);
		v.setVisible(true);				
	}
	public void robotsPilotados(AdministradorVentanas administradorVentanas, int index) {
		VentanaRobotsPilotados v = new VentanaRobotsPilotados(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void ingresarEquipo(AdministradorVentanas administradorVentanas) {
		VentanaIngresarEquipo v = new VentanaIngresarEquipo(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void mostrarPorEquipos(AdministradorVentanas administradorVentanas, String equipo) {
		VentanaMostrarPorEquipo v = new VentanaMostrarPorEquipo(administradorVentanas, sistema, equipo);
		v.setVisible(true);
	}
	public void simulacionCombate(AdministradorVentanas administradorVentanas, int[] index) {
		VentanaSimulacionCombate v = new VentanaSimulacionCombate(administradorVentanas, sistema, index);
		v.setVisible(true);
	}
	public void estadisticasCombate(AdministradorVentanas administradorVentanas) {
		VentanaEstadisticasCombate v = new VentanaEstadisticasCombate(administradorVentanas, sistema);
		v.setVisible(true);
	}
	public void guardar(AdministradorVentanas administradorVentanas) {
		VentanaGuardado v = new VentanaGuardado(administradorVentanas, sistema);
		v.setVisible(true);
	}
}