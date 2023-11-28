/*
* Autor:
* Giacomo Baldessari Marchant
* 
* Fecha Entrega: 16/12/2022
* Paralelo: C1
*/
package cl.ucn.Taller3.logica;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cl.ucn.Taller3.interfazGrafica.AdministradorVentanas;
/**
* Main Class
*/
public class App {
	private static Sistema sistema;
	private static AdministradorVentanas administradorVentanas;
	public static void main(String[] args) {
		aplicacion();
	}
	/**
     * Loads the application data and run it
     */
	private static void aplicacion() {
		sistema = new SistemaImpl();
		obtenerPiezas();
		obtenerArmas();
		obtenerRobots();
		obtenerCombates();
		administradorVentanas = new AdministradorVentanas(sistema);
		administradorVentanas.menu(administradorVentanas);
	}
	/**
     * Loads the battles data
     */
	private static void obtenerCombates() {
		File arch = new File("combates.txt");
		Scanner scanFile = null;
		boolean error = false;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			error = true;
		}
		if(!error&&scanFile!=null) {
			while(scanFile.hasNextLine()) {
				String[] linea = scanFile.nextLine().split(",");
					sistema.obtenerCombates(linea);
				}
			scanFile.close();
		}
	}
	/**
     * Loads the robots data
     */
	private static void obtenerRobots() {
		File arch = new File("robots.txt");
		Scanner scanFile = null;
		boolean error = false;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			error = true;
		}
		if(!error&&scanFile!=null) {
			while(scanFile.hasNextLine()) {
				String[] linea = scanFile.nextLine().split(",");
				sistema.obtenerRobots(linea);
			}
			scanFile.close();
		}
	}
	/**
     * Loads the weapons data
     */
	private static void obtenerArmas() {
		File arch = new File("armas.txt");
		Scanner scanFile = null;
		boolean error = false;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			error = true;
		}
		if(!error&&scanFile!=null) {
			while(scanFile.hasNextLine()) {
				String[] linea = scanFile.nextLine().split(",");
				sistema.obtenerArmas(linea);
				}
			scanFile.close();
		}
	}
	/**
     * Loads the pieces data
     */
	private static void obtenerPiezas() {
		File arch = new File("piezas.txt");
		Scanner scanFile = null;
		boolean error = false;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			error = true;
		}
		if(!error&&scanFile!=null) {
			while(scanFile.hasNextLine()) {
				String[] linea = scanFile.nextLine().split(",");
				sistema.obtenerPiezas(linea);
			}
			scanFile.close();
		}
	}
}