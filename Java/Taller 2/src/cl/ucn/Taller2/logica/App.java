/*
* Autor:
* Giacomo Baldessari Marchant
*
* Fecha Entrega: 31/10/2022
* Paralelo: C1
*/
package cl.ucn.Taller2.logica;
import java.io.*;
import java.util.Scanner;
import cl.ucn.Taller2.dominio.*;
import cl.ucn.Taller2.utils.*;
/**
* Main Class
*/
public class App {
	/**
     * Main
     */
	public static void main(String[] args) {
		aplicacion();
	}
	/**
     * Loads the application data and run it
     */
	private static void aplicacion() {
		ListaArmas armas = obtenerArmas("Armas.txt");
		ListaMateriales materiales = obtenerMateriales("Materiales.txt");
		ListaModelos modelos = obtenerModelos("Modelos.txt");
		ListaPaises paises = obtenerPaises("Países.txt");
		ListaPersonas personas = obtenerPersonas("Personas.txt");
		ListaPiezas piezas = obtenerPiezas("Piezas.txt");
		ListaRobots robots = obtenerRobots("Robots.txt");
		
		boolean tierra = true;
		Scanner scan = new Scanner(System.in);
		menuInicio(personas,scan);
		String opcionMenu = " ";
		
		while(!opcionMenu.equalsIgnoreCase("")&&tierra) {
			mostrarMenu();
			opcionMenu = scan.nextLine();
			switch(opcionMenu) {
				case "1":
					menuPiezaArma(piezas,paises,armas,scan);
					break;
				case "2":
					ensamblarRobot(piezas,armas,robots,personas,paises,scan);
					break;
				case "3":
					crearEquipo(personas,scan);
					break;
				case "4":
					buscarPieza(piezas,armas,paises,scan);
					break;
				case "5":
					buscarMaterial(materiales,scan);
					break;
				case "6":
					crearModelo(modelos,robots,piezas,armas,personas,scan);
					break;
				case "7":
					revisarPiezas(piezas,armas,robots,scan);
					break;
				case "8":
					mostrarPersonas(personas);
					break;
				case "9":
					mostrarGrupos(personas);
					break;
				case "10":
					mostrarRobots(robots);
					break;
				case "11":
					revisarMunicion(robots,scan);
					break;
				case "12":
					mostrarPaises(paises);
					break;
				case "13":
					anadirPiezas(piezas,paises,materiales,scan);
					break;
				case "14":
					anadirMateriales(materiales,scan);
					break;
				case "15":
					mostrarPiezasArmas(piezas,armas);
					break;
				case "16":
					cambiarPiezas(robots,piezas,armas,paises,scan);
					break;
				case "17":
					tierra = menuSecreto(materiales,piezas,armas,paises,modelos,personas,robots,scan);
					break;
				default:
					System.out.println("Ingrese una opcion valida");
					break;
				}
			}
		scan.close();
		guardarDatos(materiales,piezas,armas,paises,modelos,personas,robots,tierra);
		if(tierra) {System.out.println("Datos guardados");}
		else {System.out.println("La guerra...la guerra no cambia nunca.");}
	}
	/**
     * Save the data on the files
     * @param materiales A ListaMateriales where Material data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param modelos A ListaModelos where Modelo data is stored
     * @param personas A ListaPersonas where Persona data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param tierra A Boolean indicating whether or not the data was deleted
     */
	private static void guardarDatos(ListaMateriales materiales, ListaPiezas piezas, ListaArmas armas, ListaPaises paises, ListaModelos modelos, ListaPersonas personas, ListaRobots robots, boolean tierra) {
		borrarDatosArchivo("Materiales.txt");
		borrarDatosArchivo("Piezas.txt");
		borrarDatosArchivo("Armas.txt");
		borrarDatosArchivo("Países.txt");
		borrarDatosArchivo("Modelos.txt");
		borrarDatosArchivo("Personas.txt");
		borrarDatosArchivo("Robots.txt");
		PrintWriter writerMateriales = crearWriter("Materiales.txt");
		PrintWriter writerPiezas = crearWriter("Piezas.txt");
		PrintWriter writerArmas = crearWriter("Armas.txt");
		PrintWriter writerPaises = crearWriter("Países.txt");
		PrintWriter writerModelos = crearWriter("Modelos.txt");
		PrintWriter writerPersonas = crearWriter("Personas.txt");
		PrintWriter writerRobots = crearWriter("Robots.txt");
		if(tierra) {
			for(int i = 0;i<materiales.getCantidad();i++) {
				writerMateriales.print(materiales.getMaterial(i).getNombre()+","+materiales.getMaterial(i).getCantidad()+","+materiales.getMaterial(i).getPais());
				writerMateriales.println();
			}
			for(int i = 0;i<piezas.getCantidad();i++) {
				writerPiezas.print(piezas.getPieza(i).getNombre()+","+piezas.getPieza(i).getCodigo()+","+piezas.getPieza(i).getTipo()+","+piezas.getPieza(i).getPais()+","+piezas.getPieza(i).getCantidadMaterial());
				writerPiezas.println();
			}
			for(int i = 0;i<armas.getCantidad();i++) {
				writerArmas.print(armas.getArma(i).getNombre()+","+armas.getArma(i).getCodigo()+","+armas.getArma(i).getMunicion()+","+armas.getArma(i).getPais()+","+armas.getArma(i).getCantidadMaterial());
				writerArmas.println();
			}
			for(int i = 0;i<paises.getCantidad();i++) {
				writerPaises.print(paises.getPais(i).getNombre()+","+paises.getPais(i).getParte()+","+paises.getPais(i).getCodigoParte()+","+paises.getPais(i).getCantidadParte()+","+paises.getPais(i).getMaterialParte());
				writerPaises.println();
			}
			for(int i = 0;i<modelos.getCantidad();i++) {
				writerModelos.print(modelos.getModelo(i).getNombre()+","+modelos.getModelo(i).getCodigo());
				writerModelos.println();
			}
			for(int i = 0;i<modelos.getCantidad();i++) {
				writerModelos.print(modelos.getModelo(i).getNombre()+","+modelos.getModelo(i).getCodigo());
				writerModelos.println();
			}
			for(int i = 0;i<personas.getCantidad();i++) {
				writerPersonas.print(personas.getPersona(i).getNombre()+","+personas.getPersona(i).getId()+","+personas.getPersona(i).getEspecialidad()+","+personas.getPersona(i).getEquipo());
				writerPersonas.println();
			}
			for(int i = 0;i<robots.getCantidad();i++) {
				writerRobots.print(robots.getRobot(i).getNombre()+","+robots.getRobot(i).getBrazos()+","+robots.getRobot(i).getPiernas()+","+robots.getRobot(i).getTorax()+","+robots.getRobot(i).getCabeza()+","+robots.getRobot(i).getCualidad()+","+robots.getRobot(i).getArma()+","+robots.getRobot(i).getEquipo()+","+robots.getRobot(i).getCodigo());
				writerRobots.println();
			}
		}
		writerMateriales.close();
		writerPiezas.close();
		writerArmas.close();
		writerPaises.close();
		writerModelos.close();
		writerPersonas.close();
		writerRobots.close();
	}
	/**
     * Create a PrintWriter
     * @param ruta A String where is the path of the file where the data is stored
     * @return The created PrintWriter
     */
	private static PrintWriter crearWriter(String ruta) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(ruta, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return writer;
	}
	/**
     * Delete the data of the file
     * @param ruta A String where is the path of the file where the data is stored
     */
	private static void borrarDatosArchivo(String ruta) {
		try {
			BufferedWriter vaciar = new BufferedWriter(new FileWriter(ruta));
			vaciar.write("");
			vaciar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
     * Launch the secret menu
     * @param materiales A ListaMateriales where Material data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param modelos A ListaModelos where Modelo data is stored
     * @param personas A ListaPersonas where Persona data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param scan A Scanner in orden to read from the System.in
     * @return If the data was deleted
     */
	private static boolean menuSecreto(ListaMateriales materiales, ListaPiezas piezas, ListaArmas armas, ListaPaises paises, ListaModelos modelos, ListaPersonas personas, ListaRobots robots, Scanner scan) {
		boolean tierra = true;
		boolean permiso = validarCredenciales(scan);
		if(permiso) {
			String opcion = " ";
			while(!opcion.equalsIgnoreCase("")&&tierra) {
				System.out.println("=========Menu de emergencia=========");
				System.out.println("1)Produccion de recursos nucleares");
				System.out.println("2)Destruir el mundo");
				System.out.println("Presione 'Enter' para volver al menu");
				opcion = scan.nextLine();
				switch(opcion) {
					case "1":
						recursosNucleares(materiales,piezas,armas,paises,scan);
						break;
					case "2":
						tierra = destruccionTotal(materiales,piezas,armas,paises,modelos,personas,robots,scan);
						break;
					default:
						System.out.println("Ingrese una opcion valida");
						break;
				}
			}
		}
		return tierra;
	}
	/**
     * Delete the data saved up to that moment
     * @param materiales A ListaMateriales where Material data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param modelos A ListaModelos where Modelo data is stored
     * @param personas A ListaPersonas where Persona data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param scan A Scanner in orden to read from the System.in
     * @return If the data was deleted
     */
	private static boolean destruccionTotal(ListaMateriales materiales, ListaPiezas piezas, ListaArmas armas, ListaPaises paises, ListaModelos modelos, ListaPersonas personas, ListaRobots robots, Scanner scan) {
		System.out.println("Esta seguro que quiere recurrir a esta medida?[Si/No]");
		String opcion = scan.nextLine();
		while(!opcion.equalsIgnoreCase("si")&&!opcion.equalsIgnoreCase("no")) {
			System.out.println("Ingrese una opcion valida");
			opcion = scan.nextLine();
		}
		if(opcion.equalsIgnoreCase("no")) {
			return true;
		}
		return false;
	}
	/**
     * Create a new material and pieces
     * @param materiales A ListaMateriales where Material data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void recursosNucleares(ListaMateriales materiales, ListaPiezas piezas, ListaArmas armas, ListaPaises paises, Scanner scan) {
		Material material = new Material("area51",100000,"uranio");
		materiales.ingresar(material);
		System.out.println("Recursos nucleares activados");
		System.out.println("Nombre brazos:");
		String nombre = scan.nextLine();
		System.out.println("Codigo brazos:");
		String codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		int mat = Integer.parseInt(scan.nextLine());
		Pieza pieza = new Pieza(nombre,codigo,"brazos","area51",mat);
		piezas.ingresar(pieza);
		System.out.println("Nombre piernas:");
		nombre = scan.nextLine();
		System.out.println("Codigo piernas:");
		codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		mat = Integer.parseInt(scan.nextLine());
		pieza = new Pieza(nombre,codigo,"piernas","area51",mat);
		piezas.ingresar(pieza);
		System.out.println("Nombre cabeza:");
		nombre = scan.nextLine();
		System.out.println("Codigo cabeza:");
		codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		mat = Integer.parseInt(scan.nextLine());
		pieza = new Pieza(nombre,codigo,"cabeza","area51",mat);
		piezas.ingresar(pieza);
		System.out.println("Nombre torax:");
		nombre = scan.nextLine();
		System.out.println("Codigo torax:");
		codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		mat = Integer.parseInt(scan.nextLine());
		pieza = new Pieza(nombre,codigo,"torax","area51",mat);
		piezas.ingresar(pieza);
		System.out.println("Nombre cualidad extra:");
		nombre = scan.nextLine();
		System.out.println("Codigo cualidad extra:");
		codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		mat = Integer.parseInt(scan.nextLine());
		pieza = new Pieza(nombre,codigo,"cualidad extra","area51",mat);
		piezas.ingresar(pieza);
		System.out.println("Nombre arma:");
		nombre = scan.nextLine();
		System.out.println("Codigo arma:");
		codigo = scan.nextLine();
		System.out.println("Cantidad de materiales necesarios:");
		mat = Integer.parseInt(scan.nextLine());
		Arma arma = new Arma(nombre,codigo,0,"area51",mat);
		armas.ingresar(arma);
	}
	/**
     * Validate the credentials entered in the database
     * @param scan A Scanner in orden to read from the System.in
     */
	private static boolean validarCredenciales(Scanner scan) {
		System.out.println("Ingresar nombre:");
		String nombre = scan.nextLine();
		if(!nombre.equalsIgnoreCase("empanada")) {
			return false;
		}
		System.out.println("Ingresar id:");
		String id = scan.nextLine();
		if(!id.equalsIgnoreCase("porotosconriendas")) {
			return false;
		}
		System.out.println("Credenciales correctas");
		return true;
	}
	/**
     * Launch the menu to change pieces
     * @param robots A ListaRobots where Robot data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void cambiarPiezas(ListaRobots robots, ListaPiezas piezas, ListaArmas armas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre del robot:");
		String nombre = scan.nextLine();
		int pos = robots.buscarPorNombre(nombre);
		while(pos ==-1) {
			System.out.println("Ingrese un nombre valido");
			nombre = scan.nextLine();
			pos = robots.buscarPorNombre(nombre);
		}
		System.out.println("1)Brazos: "+robots.getRobot(pos).getBrazos());
		System.out.println("2)Piernas: "+robots.getRobot(pos).getPiernas());
		System.out.println("3)Torax: "+robots.getRobot(pos).getTorax());
		System.out.println("4)Cabeza: "+robots.getRobot(pos).getCabeza());
		System.out.println("5)Cualidad extra: "+robots.getRobot(pos).getCualidad());
		System.out.println("6)Armas: "+robots.getRobot(pos).getArma());
		System.out.println("Presione 'Enter' para volver al menu");
		String opcion = scan.nextLine();
		while(!opcion.equalsIgnoreCase("")) {
			switch(opcion) {
				case"1":
					ingresarBrazo(robots.getRobot(pos),piezas,paises,scan);
					break;
				case"2":
					ingresarPierna(robots.getRobot(pos),piezas,paises,scan);
					break;
				case"3":
					ingresarTorax(robots.getRobot(pos),piezas,paises,scan);
					break;
				case"4":
					ingresarCabeza(robots.getRobot(pos),piezas,paises,scan);
					break;
				case"5":
					ingresarCualidad(robots.getRobot(pos),piezas,paises,scan);
					break;
				case"6":
					ingresarArmas(robots.getRobot(pos),armas,paises,scan);
					break;
				default:
					System.out.println("Ingrese un valor valido:");
					break;
			}
			System.out.println("1)Brazos: "+robots.getRobot(pos).getBrazos());
			System.out.println("2)Piernas: "+robots.getRobot(pos).getPiernas());
			System.out.println("3)Torax: "+robots.getRobot(pos).getTorax());
			System.out.println("4)Cabeza: "+robots.getRobot(pos).getCabeza());
			System.out.println("5)Cualidad extra: "+robots.getRobot(pos).getCualidad());
			System.out.println("6)Armas: "+robots.getRobot(pos).getArma());
			System.out.println("Presione 'Enter' para volver al menu");
			opcion = scan.nextLine();
		}
	}
	/**
     * Change the gun of the robot
     * @param robot The Robot whose part is to be replaced
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarArmas(Robot robot, ListaArmas armas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  armas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(armas.getArma(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		while(pos == -1 || posPais ==-1 || stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  armas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(armas.getArma(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String armaAntigua = robot.getArma();
		robot.setArma(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = armas.buscarPorNombre(armaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(armas.getArma(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(armas.getArma(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(armas.getArma(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Change the extra quality of the robot
     * @param robot The Robot whose part is to be replaced
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarCualidad(Robot robot, ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  piezas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		
		while(pos == -1 || posPais ==-1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("cualidad extra")|| stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  piezas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String piezaAntigua = robot.getCualidad();
		robot.setCualidad(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = piezas.buscarPorNombre(piezaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Change the head of the robot
     * @param robot The Robot whose part is to be replaced
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarCabeza(Robot robot, ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  piezas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		
		while(pos == -1 || posPais ==-1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("cabeza")|| stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  piezas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String piezaAntigua = robot.getCabeza();
		robot.setCabeza(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = piezas.buscarPorNombre(piezaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Change the chest of the robot
     * @param robot The Robot whose part is to be replaced
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarTorax(Robot robot, ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  piezas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		
		while(pos == -1 || posPais ==-1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("torax")|| stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  piezas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String piezaAntigua = robot.getTorax();
		robot.setTorax(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = piezas.buscarPorNombre(piezaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Change the legs of the robot
     * @param robot The Robot whose part is to be replaced
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarPierna(Robot robot, ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  piezas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		
		while(pos == -1 || posPais ==-1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("piernas")|| stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  piezas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String piezaAntigua = robot.getPiernas();
		robot.setPiernas(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = piezas.buscarPorNombre(piezaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Change the arms of the robot
     * @param robot The Robot whose part is to be replaced
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarBrazo(Robot robot, ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Ingrese el nombre de la pieza:");
		String nombre = scan.nextLine();
		int pos =  piezas.buscarPorNombre(nombre);
		int posPais = 0;
		int stock = 0;
		if(pos!=-1) {
			posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
			if(posPais != -1) {
				stock = paises.getPais(posPais).getCantidadParte();
			}
		}
		
		while(pos == -1 || posPais ==-1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("brazos")|| stock<1) {
			System.out.println("Ingrese una pieza valida:");
			nombre = scan.nextLine();
			pos =  piezas.buscarPorNombre(nombre);
			if(pos!=-1) {
				posPais = paises.buscarPorNombre(piezas.getPieza(pos).getPais());
				if(posPais != -1) {
					stock = paises.getPais(posPais).getCantidadParte();
				}
			}
		}
		String piezaAntigua = robot.getBrazos();
		robot.setBrazos(nombre);
		paises.getPais(posPais).setCantidadParte(stock-1);
		int posPieza = piezas.buscarPorNombre(piezaAntigua);
		if(posPieza !=-1 && paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())!= -1) {
			paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).setCantidadParte(
					paises.getPais(paises.buscarPorCodigo(piezas.getPieza(posPieza).getCodigo())).getCantidadParte()+1);
		}
	}
	/**
     * Shows the pieces and the weapons
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     */
	private static void mostrarPiezasArmas(ListaPiezas piezas, ListaArmas armas) {
		System.out.println("Piezas");
		for(int i = 0;i<piezas.getCantidad();i++) {
			System.out.println(piezas.getPieza(i).toString());
		}
		System.out.println("Armas");
		for(int i = 0;i<armas.getCantidad();i++) {
			System.out.println(armas.getArma(i).toString());
		}
	}
	/**
     * Launch the menu to add materials
     * @param materiales A ListaMateriales where Material data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void anadirMateriales(ListaMateriales materiales, Scanner scan) {
		System.out.println("Ingrese el material del que desea agregar stock:");
		String material = scan.nextLine();
		int pos = materiales.buscarPorNombre(material);
		if(pos==-1) {
			materialNuevo(materiales, material,scan);
		}
		else {
			materialExistente(materiales,pos,scan);
		}
	}
	/**
     * Increases the amount of a material to the database
     * @param materiales A ListaMateriales where Material data is stored
     * @param pos An Integer that contain the position of the material
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void materialExistente(ListaMateriales materiales, int pos, Scanner scan) {
		System.out.println("Cantidad de material que desea agregar:");
		int cant = Integer.parseInt(scan.nextLine());
		materiales.getMaterial(pos).setCantidad(materiales.getMaterial(pos).getCantidad()+cant);
		System.out.println("Materiales agregados con exito");
	}
	/**
     * Add a material to the database
     * @param materiales A ListaMateriales where Material data is stored
     * @param material A String that contain the name of the material
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void materialNuevo(ListaMateriales materiales, String material,Scanner scan) {
		System.out.println("Material no encontrado, ¿Desea agregar un material nuevo?[Si/No]");
		String opcion = scan.nextLine();
		while(!opcion.equalsIgnoreCase("no")) {
			if(opcion.equalsIgnoreCase("si")) {
				System.out.println("Cantidad de material que desea agregar:");
				int cant = Integer.parseInt(scan.nextLine());
				System.out.println("Pais que lo produce:");
				String pais = scan.nextLine();
				Material nuevoMaterial = new Material(material,cant,pais);
				materiales.ingresar(nuevoMaterial);
				System.out.println("Material agregado con exito");
				break;
			}
			System.out.println("Ingrese una opcion valida");
			opcion = scan.nextLine();
		}
	}
	/**
     * Add a piece to the database
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param materiales A ListaMateriales where Material data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void anadirPiezas(ListaPiezas piezas, ListaPaises paises, ListaMateriales materiales, Scanner scan) {
		System.out.println("Ingrese el pais de la pieza que quiere agregar:");
		String pais = scan.nextLine();
		int pos = piezas.buscarPorPais(pais);
		while(pos==-1) {
			System.out.println("Ingrese el pais de la pieza que quiere agregar:");
			pais = scan.nextLine();
			pos = piezas.buscarPorPais(pais);
		}
		int posPais = -1;
		for(int i = 0;i<paises.getCantidad();i++) {
			if(piezas.getPieza(pos).getCodigo().equalsIgnoreCase(paises.getPais(i).getCodigoParte())) {
				posPais = i;
				break;
			}
		}
		if(posPais == -1) {
			System.out.println("Error inesperado: no se encuentra informacion suficiente para realizar la operacion");
		}
		else {
			int stockMaterial = materiales.getMaterial(materiales.buscarPorNombre(paises.getPais(posPais).getMaterialParte())).getCantidad();
			System.out.println("Se necesitan "+piezas.getPieza(pos).getCantidadMaterial()+" de "+paises.getPais(posPais).getMaterialParte()+" para crear esta pieza");
			System.out.println("¿Cuantas desea crear?("+stockMaterial+" disponible):");
			int cantidad = Integer.parseInt(scan.nextLine());
			while(cantidad<0||cantidad*piezas.getPieza(pos).getCantidadMaterial()>stockMaterial) {
				System.out.println("Ingrese una cantidad valida:");
				cantidad = Integer.parseInt(scan.nextLine());
			}
			paises.getPais(posPais).setCantidadParte(paises.getPais(posPais).getCantidadParte()+cantidad);
			materiales.getMaterial(materiales.buscarPorNombre(paises.getPais(posPais).getMaterialParte())).setCantidad(materiales.getMaterial(
					materiales.buscarPorNombre(paises.getPais(posPais).getMaterialParte())).getCantidad()-cantidad*piezas.getPieza(pos).getCantidadMaterial());
			System.out.println("Pieza creada con exito");
		}
	}
	/**
     * Shows the countries by their name
     * @param paises A ListaPaises where Pais data is stored
     */
	private static void mostrarPaises(ListaPaises paises) {
		System.out.println("Paises: ");
		for(int i = 0;i<paises.getCantidad();i++) {
			System.out.println("	"+paises.getPais(i).getNombre());
		}
	}
	/**
     * Increase the munition of a robot
     * @param robots A ListaRobots where Robot data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void revisarMunicion(ListaRobots robots, Scanner scan) {
		System.out.println("Robots: ");
		for(int i = 0;i<robots.getCantidad();i++) {
			System.out.println("Nombre: "+robots.getRobot(i).getNombre()+" ,Municion: "+robots.getRobot(i).getMunicion());
		}
		System.out.println("Ingrese el nombre del robot al que le quiere aumentar la municion:");
		String nombre = scan.nextLine();
		int pos = robots.buscarPorNombre(nombre);
		while(pos ==-1) {
			System.out.println("Ingrese un nombre valido:");
			nombre = scan.nextLine();
			pos = robots.buscarPorNombre(nombre);
		}
		System.out.println("¿Cuanta municion desea agregar?:");
		int municion = Integer.parseInt(scan.nextLine());
		while(municion <0) {
			System.out.println("Ingrese una cantidad valida:");
			municion = Integer.parseInt(scan.nextLine());
		}
		robots.getRobot(pos).setMunicion(robots.getRobot(pos).getMunicion()+municion);
		System.out.println("Municion aunmentada con exito");
	}
	/**
     * Shows the robots by their name
     * @param robots A ListaRobots where Robot data is stored
     */
	private static void mostrarRobots(ListaRobots robots) {
		System.out.println("Robots: ");
		for(int i = 0;i<robots.getCantidad();i++) {
			System.out.println("	"+robots.getRobot(i).getNombre());
		}
	}
	/**
     * Shows people separated by their team
     * @param personas A ListaPersonas where Persona data is stored
     */
	private static void mostrarGrupos(ListaPersonas personas) {
		String[] listaGrupos = new String[0];
		for(int i =0;i<personas.getCantidad();i++) {
			boolean repetido = false;
			for(int a =0;a<listaGrupos.length;a++) {
				if(listaGrupos[a].equalsIgnoreCase(personas.getPersona(i).getEquipo())) {
					repetido = true;
				}
			}
			if(!repetido) {listaGrupos = Herramientas.appendStr(listaGrupos,personas.getPersona(i).getEquipo());}
		}
		for(int i = 0;i<listaGrupos.length;i++) {
			System.out.println(listaGrupos[i]+":");
			for(int a = 0;a<personas.getCantidad();a++) {
				if(personas.getPersona(a).getEquipo().equalsIgnoreCase(listaGrupos[i])) {
					System.out.println("	"+personas.getPersona(a).getNombre());
				}
			}
		}
	}
	/**
     * Shows people separated by their specialty
     * @param personas A ListaPersonas where Persona data is stored
     */
	private static void mostrarPersonas(ListaPersonas personas) {
		System.out.println("Ensambladores:");
		for(int i =0;i<personas.getCantidad();i++) {
			if(personas.getPersona(i).getEspecialidad().equalsIgnoreCase("ensamblador")) {
				System.out.println("	"+personas.getPersona(i).getNombre());
			}
		}
		System.out.println("Pilotos:");
		for(int i =0;i<personas.getCantidad();i++) {
			if(personas.getPersona(i).getEspecialidad().equalsIgnoreCase("piloto")) {
				System.out.println("	"+personas.getPersona(i).getNombre());
			}
		}
	}
	/**
     * Scans robots for wrong parts
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void revisarPiezas(ListaPiezas piezas, ListaArmas armas, ListaRobots robots, Scanner scan) {
		for(int i = 0;i<robots.getCantidad();i++) {
			System.out.println(robots.getRobot(i).getNombre()+":");
			analizarRobots(piezas,armas,robots.getRobot(i),scan);
		}
	}
	/**
     * If the robot presents erroneous parts they are changed
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param robot The Robot to analyze
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void analizarRobots(ListaPiezas piezas, ListaArmas armas, Robot robot, Scanner scan) {
		boolean piezaErronea = true;
		for(int i =0;i<piezas.getCantidad();i++) {
			if(robot.getBrazos().equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("brazos")) {piezaErronea = false;System.out.println("	Brazos correctos");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese unos brazos validos:");
			String brazos = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(brazos.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("brazos")) {piezaErronea = false; robot.setBrazos(brazos); System.out.println("	Brazos correctos");}
			}
		}
		piezaErronea = true;
		for(int i =0;i<piezas.getCantidad();i++) {
			if(robot.getPiernas().equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("piernas")) {piezaErronea = false;System.out.println("	Piernas correctas");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese unas piernas validas:");
			String piernas = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(piernas.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("piernas")) {piezaErronea = false; robot.setPiernas(piernas); System.out.println("	Piernas correctas");}
			}
		}
		piezaErronea = true;
		for(int i =0;i<piezas.getCantidad();i++) {
			if(robot.getTorax().equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("torax")) {piezaErronea = false;System.out.println("	Torax correcto");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese un torax valido:");
			String torax = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(torax.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("torax")) {piezaErronea = false; robot.setTorax(torax); System.out.println("	Torax correcto");}
			}
		}
		piezaErronea = true;
		for(int i =0;i<piezas.getCantidad();i++) {
			if(robot.getCabeza().equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cabeza")) {piezaErronea = false;System.out.println("	Cabeza correcta");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese una cabeza valida:");
			String cabeza = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(cabeza.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cabeza")) {piezaErronea = false; robot.setCabeza(cabeza); System.out.println("	Cabeza correcta");}
			}
		}
		piezaErronea = true;
		for(int i =0;i<piezas.getCantidad();i++) {
			if(robot.getCualidad().equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cualidad extra")) {piezaErronea = false;System.out.println("	Cualidad extra correcta");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese una cualidad extra valida:");
			String cualidad = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(cualidad.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cualidad extra")) {piezaErronea = false; robot.setCualidad(cualidad); System.out.println("	Cualidad extra correcta");}
			}
		}
		piezaErronea = true;
		for(int i =0;i<armas.getCantidad();i++) {
			if(robot.getArma().equalsIgnoreCase(armas.getArma(i).getNombre())) {piezaErronea = false;System.out.println("	Arma correcta");}
		}
		while(piezaErronea) {
			System.out.println("Ingrese un arma valida:");
			String arma = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(arma.equalsIgnoreCase(armas.getArma(i).getNombre())) {piezaErronea = false; robot.setArma(arma);robot.setMunicion(armas.getArma(i).getMunicion()); System.out.println("	Arma correcta");}
			}
		}
	}
	/**
     * Create a new model
     * @param modelos A ListaModelos where Modelo data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param personas A ListaPersonas where Persona data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void crearModelo(ListaModelos modelos, ListaRobots robots, ListaPiezas piezas, ListaArmas armas,
			ListaPersonas personas, Scanner scan) {
		System.out.println();
		System.out.println("Ingrese el nombre del robot:");
		String robotBuscado = scan.nextLine();
		int pos = robots.buscarPorNombre(robotBuscado);
		if(pos==-1) {
			System.out.println("Error: Ingrese un nombre valido");
		}
		else {
			String brazos = piezas.getPieza(piezas.buscarPorNombre(robots.getRobot(pos).getBrazos())).getCodigo();
			String piernas =  piezas.getPieza(piezas.buscarPorNombre(robots.getRobot(pos).getPiernas())).getCodigo();
			String torax =  piezas.getPieza(piezas.buscarPorNombre(robots.getRobot(pos).getTorax())).getCodigo();
			String cabeza =  piezas.getPieza(piezas.buscarPorNombre(robots.getRobot(pos).getCabeza())).getCodigo();
			String cualidad =  piezas.getPieza(piezas.buscarPorNombre(robots.getRobot(pos).getCualidad())).getCodigo();
			String arma =  armas.getArma(armas.buscarPorNombre(robots.getRobot(pos).getArma())).getCodigo();
			String codigoPartes = brazos+piernas+torax+cabeza+cualidad+arma;
			String codigoEquipo = robots.getRobot(pos).getEquipo();
			int[] equipo = personas.buscarPorEquipoLista(codigoEquipo);
			for(int i = 0;i<equipo.length;i++) {
				String[] nombre = personas.getPersona(equipo[i]).getNombre().split("");
				codigoEquipo += nombre[0];
			}
			String codigoFinal = codigoPartes+codigoEquipo;
			Modelo modelo = new Modelo(robots.getRobot(pos).getNombre(),codigoFinal);
			modelos.ingresar(modelo);
			System.out.println("Modelo creado con exito, codigo: "+codigoFinal+" ,nombre: "+robots.getRobot(pos).getNombre());
		}
	}
	/**
     * Launch the menu to show materials
     * @param materiales A ListaMateriales where Material data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void buscarMaterial(ListaMateriales materiales, Scanner scan) {
		System.out.println("Ingrese el material:");
		System.out.println("Presione 'Enter' para volver al menu principal");
		String materialBuscado = scan.nextLine();
		int pos = materiales.buscarPorNombre(materialBuscado);
		if(pos==-1) {System.out.println("No se encontro informacion del material ingresado");}
		else {
			System.out.println(materiales.getMaterial(pos).toString());
		}
	}
	/**
     * Launch the menu to show pieces
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void buscarPieza(ListaPiezas piezas, ListaArmas armas, ListaPaises paises, Scanner scan) {
		System.out.println();
		System.out.println("¿Que tipo de pieza esta buscando?");
		System.out.println("1)Brazos");
		System.out.println("2)Piernas");
		System.out.println("3)Torax");
		System.out.println("4)Cabeza");
		System.out.println("5)Cualidad especial");
		System.out.println("Presione 'Enter' para volver al menu principal");
		String opcion = scan.nextLine();
		while(!opcion.equals("")) {
			switch(opcion) {
				case "1":
					obtenerPaisPorPieza("brazos",piezas,paises);
					break;
				case "2":
					obtenerPaisPorPieza("piernas",piezas,paises);
					break;
				case "3":
					obtenerPaisPorPieza("torax",piezas,paises);
					break;
				case "4":
					obtenerPaisPorPieza("cabeza",piezas,paises);
					break;
				case "5":
					obtenerPaisPorPieza("cualidad extra",piezas,paises);
					break;
				default:
					System.out.println("¡Ingrese una opcion valida!");
					break;
				}
			System.out.println();
			System.out.println("¿Que tipo de pieza esta buscando?");
			System.out.println("1)Brazos");
			System.out.println("2)Piernas");
			System.out.println("3)Torax");
			System.out.println("4)Cabeza");
			System.out.println("5)Cualidad extra");
			System.out.println("Presione 'Enter' para volver al menu principal");
			opcion = scan.nextLine();
		}	
	}
	/**
     * Shows pieces according to their place of origin
     * @param tipo A String which stores the type of part to look for
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     */
	private static void obtenerPaisPorPieza(String tipo, ListaPiezas piezas, ListaPaises paises) {
		int[] listaPos = piezas.buscarPorTipo(tipo);
		if(listaPos.length ==0) {
			System.out.println("No se encontraron resultados");
		}
		else {
			for(int i = 0;i<listaPos.length;i++) {
				for(int a =0; a<paises.getCantidad();a++) {
					if(piezas.getPieza(listaPos[i]).getPais().equalsIgnoreCase(paises.getPais(a).getNombre())&&piezas.getPieza(listaPos[i]).getCodigo().equalsIgnoreCase(paises.getPais(a).getCodigoParte())) {
						System.out.println(paises.getPais(a).getNombre()+": "+piezas.getPieza(listaPos[i]).getNombre()+", Stock: "+paises.getPais(a).getCantidadParte());
					}
				}
			}
		}
	}
	/**
     * Launch the menu to create a team
     * @param personas A ListaPersonas where Persona data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void crearEquipo(ListaPersonas personas, Scanner scan) {
		System.out.println("Ingrese el nombre del equipo:");
		String nombreEquipo = scan.nextLine();
		if(personas.buscarPorEquipo(nombreEquipo) !=-1) {System.out.println("Error: El equipo ingresado ya existe");}
		else {
			String especialidad = "";
			for(int i =1;i<7;i++) {
				boolean piloto = false;
				if(i==6) {especialidad = "piloto";piloto = true;} else {especialidad = "ensamblador "+i;}
				System.out.println("Ingrese el id del "+especialidad);
				String id = scan.nextLine();
				if(personas.buscarPorId(id)==-1) {
					System.out.println("Ingrese el nombre del "+especialidad);
					String nombre = scan.nextLine();
					Persona p = null;
					if(piloto) {p = new Persona(nombre,id,"piloto",nombreEquipo);}
					else {p = new Persona(nombre,id,"ensamblador",nombreEquipo);}
					personas.ingresar(p);
				}
				else {
					int pos = personas.buscarPorId(id);
					if(!personas.getPersona(pos).getEquipo().equals("")) {
						System.out.println("¡La persona ingresada ya pertenece a un equipo!");
						i--;
					}
					else {
						personas.getPersona(pos).setEquipo(nombreEquipo);
						if(piloto) {personas.getPersona(pos).setEspecialidad("piloto");}
						else {personas.getPersona(pos).setEspecialidad("ensamblador");}
					}
				}
			}
			System.out.println("Equipo ingresado correctamente");
			System.out.println();
		}
	}
	/**
     * Launch the menu to assemble a robot
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param robots A ListaRobots where Robot data is stored
     * @param personas A ListaPersonas where Persona data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ensamblarRobot(ListaPiezas piezas, ListaArmas armas,ListaRobots robots, ListaPersonas personas, ListaPaises paises, Scanner scan) {
		boolean error = false;
		System.out.println("Nombre del robot:");
		String nombre = scan.nextLine();
		while(robots.buscarPorNombre(nombre)!=-1) {
			System.out.println("Ingrese un nombre valido:");
			nombre = scan.nextLine();
		}
		System.out.println("Brazos del robot:");
		String brazos = scan.nextLine();
		int pos = piezas.buscarPorNombre(brazos);
		if(pos == -1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("brazos")) {
			error = true;} 
		while(error) {
			System.out.println("Ingrese unos brazos validos:");
			brazos = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(brazos.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("brazos")) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(piezas.getPieza(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		System.out.println("Piernas del robot:");
		String piernas = scan.nextLine();
		pos = piezas.buscarPorNombre(piernas);
		if(pos == -1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("piernas")) {
			error = true;} 
		while(error) {
			System.out.println("Ingrese unas piernas validas:");
			piernas = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(piernas.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("piernas")) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(piezas.getPieza(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		System.out.println("Torax del robot:");
		String torax = scan.nextLine();
		pos = piezas.buscarPorNombre(torax);
		if(pos == -1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("torax")) {
			error = true;} 
		while(error) {
			System.out.println("Ingrese un torax valido:");
			torax = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(torax.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("torax")) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(piezas.getPieza(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		System.out.println("Cabeza del robot:");
		String cabeza = scan.nextLine();
		pos = piezas.buscarPorNombre(cabeza);
		if(pos == -1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("cabeza")) {
			error = true;} 
		while(error) {
			System.out.println("Ingrese una cabeza valida:");
			cabeza = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(cabeza.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cabeza")) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(piezas.getPieza(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		System.out.println("Cualidad extra del robot:");
		String cualidad = scan.nextLine();
		pos = piezas.buscarPorNombre(cualidad);
		if(pos == -1 || !piezas.getPieza(pos).getTipo().equalsIgnoreCase("cualidad extra")) {
			error = true;} 
		while(error) {
			System.out.println("Ingrese una cualidad extra valida:");
			cualidad = scan.nextLine();
			for(int i =0;i<piezas.getCantidad();i++) {
				if(cualidad.equalsIgnoreCase(piezas.getPieza(i).getNombre())&&piezas.getPieza(i).getTipo().equalsIgnoreCase("cualidad extra")) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(piezas.getPieza(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		System.out.println("Arma del robot:");
		String arma = scan.nextLine();
		pos = armas.buscarPorNombre(arma);
		int municion = 0;
		if(pos == -1) {error = true;}
		while(error) {
			System.out.println("Ingrese un arma valida:");
			arma = scan.nextLine();
			for(int i =0;i<armas.getCantidad();i++) {
				if(arma.equalsIgnoreCase(armas.getArma(i).getNombre())) {
					for(int a = 0;a<paises.getCantidad();a++) {
						if(paises.getPais(a).getCodigoParte().equalsIgnoreCase(armas.getArma(i).getCodigo())&&paises.getPais(a).getCantidadParte()>0) {
							error = false;
							municion = armas.getArma(i).getMunicion();
							paises.getPais(a).setCantidadParte(paises.getPais(a).getCantidadParte()-1);
						}
					}
				}
			}
		}
		String codigo = "";
		System.out.println("Equipo:");
		String equipo = scan.nextLine();
		pos = personas.buscarPorEquipo(equipo);
		boolean repetido = false;
		for(int i =0;i<robots.getCantidad();i++) {
			if(equipo.equalsIgnoreCase(robots.getRobot(i).getEquipo())) {
				repetido = true;
				break;
			}
		}
		if(pos == -1 || repetido) {error = true;}
		while(error|| repetido) {
			repetido = false;
			System.out.println("Ingrese un equipo valido:");
			equipo = scan.nextLine();
			for(int i =0;i<robots.getCantidad();i++) {
				if(equipo.equalsIgnoreCase(robots.getRobot(i).getEquipo())) {
					repetido = true;
					break;
				}
			}
			for(int i =0;i<personas.getCantidad();i++) {
				if(equipo.equalsIgnoreCase(personas.getPersona(i).getEquipo())&&personas.getPersona(i).getEspecialidad().equalsIgnoreCase("piloto")) {
					error = false; codigo = personas.getPersona(i).getId();}
			}
		}
		Robot robot = new Robot(nombre,brazos,piernas,torax,cabeza,cualidad,arma,equipo,codigo);
		robot.setMunicion(municion);
		robots.ingresar(robot);
		System.out.println("Robot ingresado con exito");
	}
	/**
     * Launch the menu to enter a piece or a weapon
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param armas A ListaArmas where Arma data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void menuPiezaArma(ListaPiezas piezas, ListaPaises paises, ListaArmas armas, Scanner scan) {
		System.out.println();
		System.out.println("¿Que desea ingresar?");
		System.out.println("1)Pieza");
		System.out.println("2)Arma");
		System.out.println("Presione 'Enter' para volver al menu principal");
		String opcion = scan.nextLine();
		while(!opcion.equals("")) {
			switch(opcion) {
				case "1":
					ingresarPieza(piezas,paises,scan);
					break;
				case "2":
					ingresarArma(armas,paises,scan);
					break;
				default:
					System.out.println("¡Ingrese una opcion valida!");
					break;
				}
			System.out.println();
			System.out.println("¿Que desea ingresar?");
			System.out.println("1)Pieza");
			System.out.println("2)Arma");
			System.out.println("Presione 'Enter' para volver al menu principal");
			opcion = scan.nextLine();
		}	
	}
	/**
     * Launch the menu to enter a weapon
     * @param armas A ListaArmas where Arma data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarArma(ListaArmas armas, ListaPaises paises, Scanner scan) {
		System.out.println("Nombre del arma:");
		String nombre = scan.nextLine();
		System.out.println("Codigo del arma:");
		String codigo = scan.nextLine();
		System.out.println("Cantidad de municion:");
		int municion = Integer.parseInt(scan.nextLine());
		System.out.println("Pais de origen:");
		String pais = scan.nextLine();
		System.out.println("Material de fabricacion:");
		String material = scan.nextLine();
		System.out.println("Cantidad de material necesario:");
		int cant = Integer.parseInt(scan.nextLine());
		Arma arma = new Arma(nombre,codigo,municion,pais,cant);
		armas.ingresar(arma);
		Pais nuevoPais = new Pais(pais,"arma",codigo,0,material);
		paises.ingresar(nuevoPais);
	}
	/**
     * Launch the menu to enter a piece
     * @param piezas A ListaPiezas where Pieza data is stored
     * @param paises A ListaPaises where Pais data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void ingresarPieza(ListaPiezas piezas, ListaPaises paises, Scanner scan) {
		System.out.println("Nombre de la pieza:");
		String nombre = scan.nextLine();
		System.out.println("Codigo de pieza:");
		String codigo = scan.nextLine();
		System.out.println("Tipo de pieza:");
		String tipo = scan.nextLine();
		System.out.println("Pais de origen:");
		String pais = scan.nextLine();
		System.out.println("Material de fabricacion:");
		String material = scan.nextLine();
		System.out.println("Cantidad de material necesario:");
		int cant = Integer.parseInt(scan.nextLine());
		Pieza pieza = new Pieza(nombre,codigo,tipo,pais,cant);
		piezas.ingresar(pieza);
		Pais nuevoPais = new Pais(pais,"pieza",codigo,0,material);
		paises.ingresar(nuevoPais);
		
	}
	/**
     * Launch the menu to log in
     * @param personas A ListaPersonas where Persona data is stored
     * @param scan A Scanner in orden to read from the System.in
     */
	private static void menuInicio(ListaPersonas personas,Scanner scan) {
		int cant = personas.getCantidad();
		String nombre = "";
		boolean nombreAceptado = false;
		boolean idAceptado = false;
		System.out.println("Ingrese su nombre:");
		while(!nombreAceptado) {
			nombre = scan.nextLine();
			nombreAceptado = validacionNombre(personas, cant, nombre);
		}
		System.out.println("Ingrese su identificacion:");
		while(!idAceptado) {
			String id = scan.nextLine();
			idAceptado = validacionId(personas,cant,id,nombre);
		}
	}
	/**
     * Validate the id entered in the database
     * @param personas A ListaPersonas where Persona data is stored
     * @param cant An Integer indicating the number of people stored
     * @param id A String indicating the id of the person
     * @param nombre A String indicating the name of the person
     * @return If the credentials are correct
     */
	private static boolean validacionId(ListaPersonas personas, int cant, String id, String nombre) {
		for(int i = 0;i<cant;i++) {
			if(nombre.equalsIgnoreCase(personas.getPersona(i).getNombre())&&personas.getPersona(i).getEspecialidad().equalsIgnoreCase("admin")&&id.equalsIgnoreCase(personas.getPersona(i).getId())) {
				return true;
			}
		}
		System.out.println("Ingrese un Id valido:");
		return false;
	}
	/**
     * Validate the name entered in the database
     * @param personas A ListaPersonas where Persona data is stored
     * @param cant An Integer indicating the number of people stored
     * @param nombre A String indicating the name of the person
     * @return If the credentials are correct
     */
	private static boolean validacionNombre(ListaPersonas personas, int cant, String nombre) {
		for(int i = 0;i<cant;i++) {
			if(nombre.equalsIgnoreCase(personas.getPersona(i).getNombre())&&personas.getPersona(i).getEspecialidad().equalsIgnoreCase("admin")) {
				return true;
			}
		}
		System.out.println("Ingrese un nombre valido:");
		return false;
	}
	/**
     * Save the data in the ListaRobots
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaRobots with the data added
     */
	private static ListaRobots obtenerRobots(String ruta) {
		File arch = new File(ruta);
		ListaRobots lista = new ListaRobots();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Robot robot = new Robot(linea[0].strip(),linea[1].strip(),linea[2].strip(),linea[3].strip(),linea[4].strip(),linea[5].strip(),linea[6].strip(),linea[7].strip(),linea[8].strip());
			lista.ingresar(robot);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaPiezas
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaPiezas with the data added
     */
	private static ListaPiezas obtenerPiezas(String ruta) {
		File arch = new File(ruta);
		ListaPiezas lista = new ListaPiezas();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Pieza pieza = new Pieza(linea[0].strip(),linea[1].strip(),linea[2].strip(),linea[3].strip(),Integer.parseInt(linea[4].strip()));
			lista.ingresar(pieza);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaPersonas
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaPersonas with the data added
     */
	private static ListaPersonas obtenerPersonas(String ruta) {
		File arch = new File(ruta);
		ListaPersonas lista = new ListaPersonas();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Persona persona = new Persona(linea[0].strip(),linea[1].strip(),linea[2].strip(),linea[3].strip());
			lista.ingresar(persona);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaPaises
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaPaises with the data added
     */
	private static ListaPaises obtenerPaises(String ruta) {
		File arch = new File(ruta);
		ListaPaises lista = new ListaPaises();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Pais pais = new Pais(linea[0].strip(),linea[1].strip(),linea[2].strip(),Integer.parseInt(linea[3].strip()),linea[4].strip());
			lista.ingresar(pais);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaModelos
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaModelos with the data added
     */
	private static ListaModelos obtenerModelos(String ruta) {
		File arch = new File(ruta);
		ListaModelos lista = new ListaModelos();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Modelo modelo = new Modelo(linea[0].strip(),linea[1].strip());
			lista.ingresar(modelo);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaMateriales
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaMateriales with the data added
     */
	private static ListaMateriales obtenerMateriales(String ruta) {
		File arch = new File(ruta);
		ListaMateriales lista = new ListaMateriales();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Material material = new Material(linea[0].strip(),Integer.parseInt(linea[1].strip()),linea[2].strip());
			lista.ingresar(material);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Save the data in the ListaArmas
     * @param ruta A String where is the path of the file where the data is stored
     * @return The ListaArmas with the data added
     */
	private static ListaArmas obtenerArmas(String ruta) {
		File arch = new File(ruta);
		ListaArmas lista = new ListaArmas();
		Scanner scanFile = null;
		try {
			scanFile = new Scanner(arch);
		} catch (FileNotFoundException e) {
			return lista;
		}
		while(scanFile.hasNextLine()) {
			String[] linea = scanFile.nextLine().split(",");
			Arma arma = new Arma(linea[0].strip(),linea[1].strip(),Integer.parseInt(linea[2].strip()),linea[3].strip(),Integer.parseInt(linea[4].strip()));
			lista.ingresar(arma);
		}
		scanFile.close();
		return lista;
	}
	/**
     * Show the menu
     */
	private static void mostrarMenu() {
		System.out.println("============= Menu =============");
		System.out.println("1) Ingresar pieza o arma");
		System.out.println("2) Ensamblar robot");
		System.out.println("3) Crear equipo");
		System.out.println("4) Buscar por tipo de pieza");
		System.out.println("5) Buscar por material");
		System.out.println("6) Crear modelo de robot");
		System.out.println("7) Revisar piezas");
		System.out.println("8) Mostrar personas");
		System.out.println("9) Mostrar grupos");
		System.out.println("10) Mostrar robots");
		System.out.println("11) Revisar municion");
		System.out.println("12) Mostrar paises");
		System.out.println("13) Añadir stock de piezas");
		System.out.println("14) Añadir stock de materiales");
		System.out.println("15) Mostrar piezas y armas");
		System.out.println("16) Cambiar piezas");
		System.out.println("================================");
		System.out.println("Presione 'Enter' para terminar el programa");
	}
}