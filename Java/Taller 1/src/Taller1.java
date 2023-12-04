/*
* Autor:
* Giacomo Baldessari Marchant
*
* Fecha Entrega: 30/09/2022
* Paralelo: C1
*/

import java.io.*; // Paquete java.io(File, BufferedWriter, PrintWriter, etc.)
import java.util.Scanner; // Paquete java.util.Scanner

/**
* Main Class
*/
public class Taller1 {
	
	/**
     * Loads the application data and starts it
     */
	public static void main(String[] args) {
		// == Scanners ==
		Scanner scanEx = null;
		Scanner scanH = null;
		Scanner scan = new Scanner(System.in);
		
		// == Matrices para guardar los datos ==
		String [][] datosExtraterrestres = new String[0][9];
		String [][] datosHumanos = new String[0][9];
		
		// == Rutas de los archivos de texto ==
		String rutaET = "x.txt";
		String rutaH = "h.txt";
		
		// == Archivos de texto ==
		File  archivoExtraterrestre = new File(rutaET);
		File archivoHumano = new File(rutaH);
		
		// == Booleans para control de errores ==
		Boolean error = false;
		Boolean creadoEt = false;
		Boolean creadoH = false;
		
		// == Archivo Extraterrestre ==
		try {
			scanEx = new Scanner(archivoExtraterrestre); // Intenta abrir el archivo
		} catch (FileNotFoundException e1) { // En caso de que no exista
			try {
				archivoExtraterrestre.createNewFile(); // Intenta crear el archivo
				creadoEt = true; 
			} catch (IOException e) {
				System.out.println("Error al crear el archivo extraterrestre"); 
				error = true;
			}
		}	
		
		// == Archivo Humano ==
		try {
			scanH = new Scanner(archivoHumano); // Intenta abrir el archivo
		} catch (FileNotFoundException e1) { // En caso de que no exista
			try {
				archivoHumano.createNewFile(); // Intenta crear el archivo
				creadoH = true;
			} catch (IOException e) {
				System.out.println("Error al crear el archivo humano");
				error = true;
			}
		}	
		
		// == Datos Extraterrestres ==
		datosExtraterrestres = obtenerDatos(scanEx, datosExtraterrestres, error, creadoEt); // Se guardan los datos de Extraterrestres en la matriz
		if(!creadoEt&&scanEx!= null) scanEx.close(); // Cierra el archivo Extraterrestre
		
		// == Datos Humanos ==
		datosHumanos = obtenerDatos(scanH, datosHumanos, error, creadoH); // Se guardan los datos de Humanos en la matriz
		if(!creadoH&&scanH!= null) scanH.close(); // Cierra el archivo Humano
		
		// == Aplicación ==
		mostrarMenu(); // Muestra el menú
		String menu = scan.nextLine(); // Ingresa ua opción numérica
		
		while(!error&&!menu.equalsIgnoreCase("")) {
			switch(menu){ // Funciones del menú
			case "1": // Ingresar extraterrestre
				datosExtraterrestres = sumarFilaMatriz(datosExtraterrestres);
				ingresarExtraterrestre(datosExtraterrestres, scan);
				break;
			case "2": // Modificar un extraterrestre
				modificarExtraterrestre(datosExtraterrestres, scan);
				break;
			case "3": // Ingresar humano
				datosHumanos = sumarFilaMatriz(datosHumanos);
				ingresarHumanos(datosHumanos, scan);
				break;
			case "4": // Modificar un humano
				modificarHumano(datosHumanos, scan);
				break;
			case "5": // Mostrar por nacionalidad
				mostrarPorNacionalidadSimple(datosHumanos, scan);
				break;
			case "6": // Eliminar extraterrestre
				eliminarExtraterrestre(datosExtraterrestres, scan);
				break;
			case "7": // Eliminar humano
				eliminarHumano(datosHumanos, scan);
				break;
			case "8": // Buscar por identificación universal
				mostrarPorIdUniversal(datosExtraterrestres, scan);
				break;
			case "9": // Mostrar por planeta
				mostrarPorPlaneta(datosExtraterrestres,datosHumanos, scan);
				break;
			case "10": // Mostrar por nacionalidad
				mostrarPorNacionalidad(datosHumanos, scan);
				break;
			case "11": // Mostrar por estructura
				mostrarPorEstructura(datosExtraterrestres);
				break;
			default: // Opcion Invalida
				System.out.println();
				System.out.println("Ingrese un valor válido");
				System.out.println();
			}
			mostrarMenu();
			menu = scan.nextLine();
		}
		scan.close(); // Cierra el Scanner
		guardarDatos(datosExtraterrestres, datosHumanos, rutaET, rutaH, error); // Guarda los datos creados durante la sesión
	}

	/**
     * Save the data in the corresponding String[][]
     * @param scanFile A Scanner in orden to read from the File
     * @param matriz A String[][] where data will be stored
     * @param error A Boolean what does it say if an error has occurred
     * @param creado A Boolean what does it say if the File was recently created
     * @return The String[][] with new data saved
     */
	private static String[][] obtenerDatos(Scanner scanFile, String[][] matriz, Boolean error, Boolean creado) {
		while(!creado && !error && scanFile.hasNextLine()) {
			String [] linea = scanFile.nextLine().split(", ");
			matriz = sumarFilaMatriz(matriz);
			for(int i = 0;i<linea.length;i++) {
				matriz[matriz.length-1][i] = linea[i];
			}
		}
		return matriz;
	}
	
	/**
     * Save the data in the corresponding txt files
     * @param matrizET A String[][] where alien data is stored
     * @param matrizH A String[][] where human data is stored
     * @param rutaET A String where the path of the file in which the data will be saved is saved
     * @param rutaH A String where the path of the file in which the data will be saved is saved
     * @param error A Boolean what does it say if an error has occurred
     */
	private static void guardarDatos(String[][] matrizET, String[][] matrizH, String rutaET, String rutaH, Boolean error) {
		System.out.println("Guardando datos...");
		System.out.println();
		try {
			BufferedWriter vaciarEt = new BufferedWriter(new FileWriter(rutaET));
			vaciarEt.write("");
			vaciarEt.close();
		} catch (IOException e) {
			error = true;
			System.out.println("Ha ocurrido un error inesperado al guardar");
		}
		try {
			BufferedWriter vaciarH = new BufferedWriter(new FileWriter(rutaH));
			vaciarH.write("");
			vaciarH.close();
		} catch (IOException e) {
			error = true;
			System.out.println("Ha ocurrido un error inesperado al guardar");
		}
		if(!error) {
			PrintWriter writerET = null;
			PrintWriter writerH = null;
			try {
				writerET = new PrintWriter(rutaET, "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				System.out.println("Ha ocurrido un error inesperado al guardar");
				error = true;
			}
			try {
				writerH = new PrintWriter(rutaH, "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				System.out.println("Ha ocurrido un error inesperado al guardar");
				error = true;
			}
			if(!error&&writerET!= null&&writerH!= null) {
				for(int i = 0;i<matrizET.length;i++) {
					if(!matrizET[i][2].equalsIgnoreCase("")) {
						writerET.print(matrizET[i][0]+", "+matrizET[i][1]+", "+matrizET[i][2]+", "+
								matrizET[i][3]+", "+matrizET[i][4]+", "+matrizET[i][5]+", "+
								matrizET[i][6]+", "+matrizET[i][7]);
						writerET.println();
					}
				}
				writerET.close();
				
				for(int i = 0;i<matrizH.length;i++) {
					if(!matrizH[i][2].equalsIgnoreCase("")) {
						writerH.print(matrizH[i][0]+", "+matrizH[i][1]+", "+matrizH[i][2]+", "+
								matrizH[i][3]+", "+matrizH[i][4]+", "+matrizH[i][5]+", "+
								matrizH[i][6]+", "+matrizH[i][7]+", "+matrizH[i][8]);
						writerH.println();
					}
				}
				writerH.close();
				System.out.println("Guardado exitoso");
			}
		}
	}
	
	/**
     * Shows the aliens of the entered structure
     * @param matrizET A String[][] where alien data is stored
     */
	private static void mostrarPorEstructura(String[][] matrizET) {
		Boolean resultadoEncontrado = false;
		Boolean algunResultado = false;
		double contI = 0;
		double contV = 0;
		double contF = 0;
		System.out.println();
		System.out.println("Invertebrados: ");
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][7].equalsIgnoreCase("I") && !matrizET[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				algunResultado = true;
				contI+=1;
				String especie = traductor(matrizET[i][0]);
				String nombre = traductor(matrizET[i][1]);
				String planeta = traductor(matrizET[i][3]);
				System.out.println(" Especie: "+especie+" Nombre: "+nombre+" IDU: "+matrizET[i][2]
						+" Planeta: "+planeta+" Edad: "+Double.parseDouble(matrizET[i][4])*8+" Altura: "+Double.parseDouble(matrizET[i][5])/100
						+" Peso: "+Double.parseDouble(matrizET[i][6])/1000);
			}
		}
		if(!resultadoEncontrado) {
			System.out.println(" No se encontraron extraterrestres invertebrados");
		}
		System.out.println();
		
		resultadoEncontrado = false;
		System.out.println("Vertebrados: ");
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][7].equalsIgnoreCase("V") && !matrizET[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				algunResultado = true;
				contV+=1;
				String especie = traductor(matrizET[i][0]);
				String nombre = traductor(matrizET[i][1]);
				String planeta = traductor(matrizET[i][3]);
				System.out.println(" Especie: "+especie+" Nombre: "+nombre+" IDU: "+matrizET[i][2]
						+" Planeta: "+planeta+" Edad: "+Double.parseDouble(matrizET[i][4])*8+" Altura: "+Double.parseDouble(matrizET[i][5])/100
						+" Peso: "+Double.parseDouble(matrizET[i][6])/1000);
			}
		}
		if(!resultadoEncontrado) {
			System.out.println(" No se encontraron extraterrestres vertebrados");
		}
		System.out.println();
		
		resultadoEncontrado = false;
		System.out.println("Flexibles: ");
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][7].equalsIgnoreCase("F") && !matrizET[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				algunResultado = true;
				contF+=1;
				String especie = traductor(matrizET[i][0]);
				String nombre = traductor(matrizET[i][1]);
				String planeta = traductor(matrizET[i][3]);
				System.out.println(" Especie: "+especie+" Nombre: "+nombre+" IDU: "+matrizET[i][2]
						+" Planeta: "+planeta+" Edad: "+Double.parseDouble(matrizET[i][4])*8+" Altura: "+Double.parseDouble(matrizET[i][5])/100
						+" Peso: "+Double.parseDouble(matrizET[i][6])/1000);
			}
		}
		if(!resultadoEncontrado) {
			System.out.println(" No se encontraron extraterrestres flexibles");
		}
		System.out.println();
		
		System.out.print("Cantidad de Invertebrados: "+contI);
		if(algunResultado) System.out.println(" "+(contI/(contI+contF+contV))*100+"%");
		else System.out.println(" 0%");
		System.out.println();
		
		System.out.print("Cantidad de Vertebrados: "+contV);
		if(algunResultado) System.out.println(" "+(contV/(contI+contF+contV))*100+"%");
		else System.out.println(" 0%");
		System.out.println();
		
		System.out.print("Cantidad de Flexibles: "+contF);
		if(algunResultado) System.out.println(" "+(contF/(contI+contF+contV))*100+"%");
		else System.out.println(" 0%");
		System.out.println();
	}
	
	/**
     * Shows humans of the entered nationality
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void mostrarPorNacionalidad(String[][] matrizH,Scanner scanVoid) {
		Boolean resultadoEncontrado = false;
		double total = 0;
		double contador = 0;
		System.out.println("Ingrese nacionalidad: ");
		String nacionalidad = scanVoid.nextLine();
		System.out.println();
		System.out.println("Resultados: ");
		for(int i = 0;i<matrizH.length;i++) {
			if(matrizH[i][0].equalsIgnoreCase(nacionalidad) && !matrizH[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				contador +=1;
				System.out.println(" Nombre: "+matrizH[i][1]+" ID: "+matrizH[i][2]
				+" Región: "+matrizH[i][3]+" Ciudad: "+matrizH[i][4]+" Edad: "+matrizH[i][5]
				+" Altura: "+Double.parseDouble(matrizH[i][6])/100+" Peso: "+Double.parseDouble(matrizH[i][7])/1000+" Planetas: "+matrizH[i][8]);
			}
			if(!matrizH[i][2].equalsIgnoreCase("")) {
				total+=1;
			}
		}
		if(!resultadoEncontrado) {
			if(!nacionalidad.equalsIgnoreCase(""))System.out.println(" No se encontraron humanos de la nacionalidad "+nacionalidad);
			else System.out.println("Ingrese una nacionalidad válida");
		}
		else {
			System.out.println();
			System.out.println("Porcentaje de humanos registrados de la nacionalidad ingresada: "+((contador/total)*100)+"%");
		}
		System.out.println();
	}
	
	/**
     * Shows humans of the entered nationality
     * @param matrizET A String[][] where alien data is stored
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void mostrarPorPlaneta(String[][] matrizET, String[][] matrizH,Scanner scanVoid ) {
		Boolean resultadoEncontrado = false;
		double totalEt = matrizET.length;
		double contEt = 0;
		int contH = 0;
		System.out.println("Ingrese el planeta: ");
		String planeta = scanVoid.nextLine();
		System.out.println();
		System.out.println("Resultado:");
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][3].equalsIgnoreCase(planeta) && !matrizET[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				contEt+=1;
				String especie = traductor(matrizET[i][0]);
				String nombre = traductor(matrizET[i][1]);
				String tipo = "Otro";
				if(matrizET[i][7].equalsIgnoreCase("F")) { tipo = "Flexible";}
				else if(matrizET[i][7].equalsIgnoreCase("V")) { tipo = "Vertebrado";}
				else if(matrizET[i][7].equalsIgnoreCase("I")) { tipo = "Invertebrado";}
				System.out.println(" Especie: "+especie+" Nombre: "+nombre+" IDU: "+matrizET[i][2]
						+" Edad: "+Double.parseDouble(matrizET[i][4])*8+" Altura: "+Double.parseDouble(matrizET[i][5])/100
						+" Peso: "+Double.parseDouble(matrizET[i][6])/1000+" Tipo: "+tipo);
			}
		}
		if(!resultadoEncontrado) {
			if(!planeta.equalsIgnoreCase("")) {
				System.out.println(" No se encontraron extraterrestres registrados en el planeta: "+planeta);
			}
			else {
				System.out.println(" Ingrese un planeta válido");
			}
			
		}
		else {
			for(int i = 0;i<matrizET.length;i++) {
				if(matrizET[i][2].equalsIgnoreCase("")) {
					totalEt-=1;
				}
			}
			System.out.println();
			System.out.println("Porcentaje de extraterrestres registrados que viven en el planeta: "+((contEt/totalEt)*100)+"%");
			System.out.println();
			for(int i = 0;i<matrizH.length;i++) {
				String[] listaPlanetas = matrizH[i][8].split("/");
				for(int a = 0;a<listaPlanetas.length;a++) {
					if(listaPlanetas[a].equalsIgnoreCase(planeta)&&!matrizH[i][2].equalsIgnoreCase("")) {
						contH++;
					}
				}
			}
			System.out.println("Humanos en el planeta: "+contH);
		}
		if(!planeta.equalsIgnoreCase("")) {
			if(!resultadoEncontrado) {
				System.out.println();
				for(int i = 0;i<matrizH.length;i++) {
					String[] listaPlanetas = matrizH[i][8].split("/");
					for(int a = 0;a<listaPlanetas.length;a++) {
						if(listaPlanetas[a].equalsIgnoreCase(planeta)&&!matrizH[i][2].equalsIgnoreCase("")) {
							contH++;
						}
					}
				}
				System.out.println("Humanos en el planeta: "+contH);
			}
		}
		System.out.println();
	}
	
	/**
     * Find an alien with its universal ID
     * @param matrizET A String[][] where alien data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void mostrarPorIdUniversal(String[][] matrizET, Scanner scanVoid) {
		Boolean resultadoEncontrado = false;
		System.out.println("Ingrese ID universal: ");
		String id = scanVoid.nextLine();
		System.out.println();
		System.out.println("Resultado:");
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][2].equalsIgnoreCase(id)&& !matrizET[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				String especie = traductor(matrizET[i][0]);
				String nombre = traductor(matrizET[i][1]);
				String planeta = traductor(matrizET[i][3]);
				String tipo = "Otro";
				if(matrizET[i][7].equalsIgnoreCase("F")) { tipo = "Flexible";}
				else if(matrizET[i][7].equalsIgnoreCase("V")) { tipo = "Vertebrado";}
				else if(matrizET[i][7].equalsIgnoreCase("I")) { tipo = "Invertebrado";}
				System.out.println(" Especie: "+especie
				+" Nombre: "+nombre
				+" IDU: "+matrizET[i][2]
				+" Planeta: "+planeta
				+" Edad: "+Integer.parseInt(matrizET[i][4])*8
				+" Altura: "+Double.parseDouble(matrizET[i][5])/100
				+" Peso: "+Double.parseDouble(matrizET[i][6])/1000
				+" Tipo: "+tipo);
				break;
			}
		}
		if(!resultadoEncontrado) {
			if(!id.equalsIgnoreCase("")) {
				System.out.println(" No se encontró al extraterrestre de IDU: "+id);
			}
			else {
				System.out.println(" Ingrese un IDU válido");
			}
		}
		System.out.println();
	}
	
	/**
     * Translate a String into alien language 
     * @param palabra A String to translate
     * @return The translated String
     */
	private static String traductor(String palabra) {
		String [] listaPalabra = palabra.split("");
		String palabraTraducida = "";
		for(int i = 0;i<listaPalabra.length;i++) {
			if(listaPalabra[i].equals("a")) listaPalabra[i] = "e";
			else if(listaPalabra[i].equals("e")) listaPalabra[i] = "a";
			else if(listaPalabra[i].equals("i")) listaPalabra[i] = "o";
			else if(listaPalabra[i].equals("o")) listaPalabra[i] = "i";
			else if(listaPalabra[i].equals("A")) listaPalabra[i] = "E";
			else if(listaPalabra[i].equals("E")) listaPalabra[i] = "A";
			else if(listaPalabra[i].equals("I")) listaPalabra[i] = "O";
			else if(listaPalabra[i].equals("O")) listaPalabra[i] = "I";
			palabraTraducida+=listaPalabra[i];
		}
		return palabraTraducida;
	}
	
	/**
     * Find a human with his ID and delete it from the database
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void eliminarHumano(String[][] matrizH, Scanner scanVoid) {
		Boolean resultadoEncontrado = false;
		System.out.println("Ingrese el ID del humano a eliminar:");
		String id = scanVoid.nextLine();
		for(int i = 0;i<matrizH.length;i++) {
			if(matrizH[i][2].equalsIgnoreCase(id) && !matrizH[i][2].equalsIgnoreCase("")) {
				matrizH[i][2] = "";
				System.out.println("El humano de ID: '"+id+"' se ha eliminado de la base de datos");
				resultadoEncontrado = true;
				break;
			}
		}
		if(!resultadoEncontrado) {
			if(!id.equalsIgnoreCase("")) {
				System.out.println("No se encontró el humano de ID: "+id);
			}
			else {
				System.out.println("Ingrese un ID válido");
			}
		}
		System.out.println();
	}
	
	/**
     * Find an alien with his ID and delete it from the database
     * @param matrizET A String[][] where alien data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void eliminarExtraterrestre(String[][] matrizET, Scanner scanVoid) {
		Boolean resultadoEncontrado = false;
		System.out.println("Ingrese el ID universal del extraterrestre a eliminar:");
		String id = scanVoid.nextLine();
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][2].equalsIgnoreCase(id) && !matrizET[i][2].equalsIgnoreCase("")) {
				matrizET[i][2] = "";
				System.out.println("El extraterrestrede de IDU: '"+id+"' se ha eliminado de la base de datos");
				System.out.println();
				resultadoEncontrado = true;
				break;
			}
		}
		if(!resultadoEncontrado) {
			if(!id.equalsIgnoreCase("")) {
				System.out.println("No se encontró el extraterrestre de IDU: "+id);
				System.out.println();
			}
			else {
				System.out.println("Ingrese un IDU válido");
				System.out.println();
			}
		}
	}
	
	/**
     * Shows humans of the entered nationality
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void mostrarPorNacionalidadSimple(String[][] matrizH, Scanner scanVoid) {
		Boolean resultadoEncontrado = false;
		System.out.println("Ingrese nacionalidad: ");
		String nacionalidad = scanVoid.nextLine();
		System.out.println();
		System.out.println("Resultados: ");
		for(int i = 0;i<matrizH.length;i++) {
			if(matrizH[i][0].equalsIgnoreCase(nacionalidad) && !matrizH[i][2].equalsIgnoreCase("")) {
				resultadoEncontrado = true;
				System.out.println(" Nombre: "+matrizH[i][1]+" ID: "+matrizH[i][2]);
			}
		}
		if(!resultadoEncontrado) {
			if(!nacionalidad.equalsIgnoreCase(""))System.out.println(" No se encontraron humanos de la nacionalidad "+nacionalidad);
			else System.out.println(" Ingrese una nacionalidad válida");
		}
		System.out.println();
	}
	
	/**
     * Modify a human of the entered ID
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void modificarHumano(String[][] matrizH, Scanner scanVoid) {
		int posHumano = -1;
		System.out.println("Ingrese el ID del humano a modificar: ");
		String id = scanVoid.nextLine();
		for(int i = 0;i<matrizH.length;i++) {
			if(matrizH[i][2].equals(id) && !matrizH[i][2].equalsIgnoreCase("")) {
				posHumano = i;
				break;
			}
		}
		if(posHumano!=-1) {
			System.out.println("Ingrese los nuevos datos del humano");
			System.out.println(" Nacionalidad: ");
			String nacionalidad = scanVoid.nextLine();
			matrizH[posHumano][0] = nacionalidad;
			
			System.out.println(" Nombre: ");
			String nombre = scanVoid.nextLine();
			matrizH[posHumano][1] = nombre;
			
			System.out.println(" Región: ");
			String region = scanVoid.nextLine();
			matrizH[posHumano][3] = region;
			
			System.out.println(" Ciudad: ");
			String ciudad = scanVoid.nextLine();
			matrizH[posHumano][4] = ciudad;
			
			System.out.println(" Edad: ");
			String edad = scanVoid.nextLine();
			matrizH[posHumano][5] = edad;
			
			System.out.println(" Altura: ");
			String altura = scanVoid.nextLine();
			matrizH[posHumano][6] = altura;
			
			System.out.println(" Peso: ");
			String peso = scanVoid.nextLine();
			matrizH[posHumano][7] = peso;
			
			System.out.println(" Planetas de trabajo: ");
			String planetas = scanVoid.nextLine();
			matrizH[posHumano][8] = planetas;
			
			System.out.println();
			System.out.println("Humano modificado correctamente");
			System.out.println();
		}
		else {
			if(!id.equalsIgnoreCase("")) {
				System.out.println("Humano no encontrado");
			}
			else {
				System.out.println("Ingrese un ID válido");
			}
			System.out.println();
		}
	}
	
	/**
     * Add a human to the database
     * @param matrizH A String[][] where human data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void ingresarHumanos(String[][] matrizH, Scanner scanVoid) {
		
		System.out.println("Ingrese los datos del humano");
		
		System.out.println(" Nacionalidad: ");
		String nacionalidad = scanVoid.nextLine();
		matrizH[matrizH.length-1][0] = nacionalidad;
		
		System.out.println(" Nombre: ");
		String nombre = scanVoid.nextLine();
		matrizH[matrizH.length-1][1] = nombre;
		
		System.out.println(" Identificación: ");
		String id = scanVoid.nextLine();
		matrizH[matrizH.length-1][2] = id;
		
		System.out.println(" Región: ");
		String region = scanVoid.nextLine();
		matrizH[matrizH.length-1][3] = region;
		
		System.out.println(" Ciudad: ");
		String ciudad = scanVoid.nextLine();
		matrizH[matrizH.length-1][4] = ciudad;
		
		System.out.println(" Edad: ");
		String edad = scanVoid.nextLine();
		matrizH[matrizH.length-1][5] = edad;
		
		System.out.println(" Altura: ");
		String altura = scanVoid.nextLine();
		matrizH[matrizH.length-1][6] = altura;
		
		System.out.println(" Peso: ");
		String peso = scanVoid.nextLine();
		matrizH[matrizH.length-1][7] = peso;
		
		System.out.println(" Planetas de trabajo: ");
		String planetas = scanVoid.nextLine();
		matrizH[matrizH.length-1][8] = planetas;
		
		System.out.println();
		System.out.println("Humano ingresado correctamente");
		System.out.println();
	}
	
	/**
     * Modify an alien of the entered universal ID
     * @param matrizET A String[][] where alien data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void modificarExtraterrestre(String[][] matrizET, Scanner scanVoid) {
		int posExtraterrestre = -1;
		System.out.println("Ingrese el ID universal del extraterrestre: ");
		String id = scanVoid.nextLine();
		for(int i = 0;i<matrizET.length;i++) {
			if(matrizET[i][2].equals(id) && !matrizET[i][2].equalsIgnoreCase("")) {
				posExtraterrestre = i;
				break;
			}
		}
		if(posExtraterrestre!=-1) {
			System.out.println("Ingrese los nuevos datos del extraterrestre");
			System.out.println(" Nombre de especie: ");
			String especie = scanVoid.nextLine();
			matrizET[posExtraterrestre][0] = especie;
			
			System.out.println(" Nombre: ");
			String nombre = scanVoid.nextLine();
			matrizET[posExtraterrestre][1] = nombre;
			
			System.out.println(" Planeta de origen: ");
			String planeta = scanVoid.nextLine();
			matrizET[posExtraterrestre][3] = planeta;
			
			System.out.println(" Edad: ");
			String edad = scanVoid.nextLine();
			matrizET[posExtraterrestre][4] = edad;
			
			System.out.println(" Altura: ");
			String altura = scanVoid.nextLine();
			matrizET[posExtraterrestre][5] = altura;
			
			System.out.println(" Peso: ");
			String peso = scanVoid.nextLine();
			matrizET[posExtraterrestre][6] = peso;
			
			System.out.println(" Tipo: ");
			String tipo = scanVoid.nextLine();
			matrizET[posExtraterrestre][7] = tipo;
			
			System.out.println();
			System.out.println("Extraterrestre modificado correctamente");
			System.out.println();
		}
		else {
			if(!id.equalsIgnoreCase("")) {
				System.out.println("Extraterrestre no encontrado");
			}
			else {
				System.out.println("Ingrese un IDU válido");
			}
			System.out.println();
		}
	}
	
	/**
     * Add an alien to the database
     * @param matrizET A String[][] where alien data is stored
     * @param scanVoid A Scanner in orden to read from the System.in
     */
	private static void ingresarExtraterrestre(String[][] matrizET, Scanner scanVoid) {
		System.out.println("Ingrese los datos del extraterrestre");
		System.out.println(" Nombre de especie: ");
		String especie = scanVoid.nextLine();
		matrizET[matrizET.length-1][0] = especie;
		
		System.out.println(" Nombre: ");
		String nombre = scanVoid.nextLine();
		matrizET[matrizET.length-1][1] = nombre;
		
		System.out.println(" Identificación universal: ");
		String uniId = scanVoid.nextLine();
		matrizET[matrizET.length-1][2] = uniId;
		
		System.out.println(" Planeta de origen: ");
		String planeta = scanVoid.nextLine();
		matrizET[matrizET.length-1][3] = planeta;
		
		System.out.println(" Edad: ");
		String edad = scanVoid.nextLine();
		matrizET[matrizET.length-1][4] = edad;
		
		System.out.println(" Altura: ");
		String altura = scanVoid.nextLine();
		matrizET[matrizET.length-1][5] = altura;
		
		System.out.println(" Peso: ");
		String peso = scanVoid.nextLine();
		matrizET[matrizET.length-1][6] = peso;
		
		System.out.println(" Tipo: ");
		String tipo = scanVoid.nextLine();
		matrizET[matrizET.length-1][7] = tipo;
		
		System.out.println();
		System.out.println("Extraterrestre ingresado correctamente");
		System.out.println();
	}
	
	/**
     * Show the menu
     */
	private static void mostrarMenu() {
		System.out.println("===========Menú===========");
		System.out.println("1) Ingresar extraterrestre");
		System.out.println("2) Modificar un extraterrestre");
		System.out.println("3) Ingresar humano");
		System.out.println("4) Modificar un humano");
		System.out.println("5) Mostrar por nacionalidad");
		System.out.println("6) Eliminar extraterrestre");
		System.out.println("7) Eliminar humano");
		System.out.println("8) Buscar por identificación universal");
		System.out.println("9) Mostrar por planeta");
		System.out.println("10) Mostrar por nacionalidad");
		System.out.println("11) Mostrar tabla");
		System.out.println("Presione 'Enter' para terminar el programa");
	}
	
	/**
     * Add a row to the String[][]
     * @param matriz A String[][] to which you want to add a row
     * @return The String[][] with a row added
     */
	private static String[][] sumarFilaMatriz(String[][] matriz) {
		int col = 9;
		String[][]aux = new String[matriz.length+1][col];
		for(int i = 0;i<matriz.length;i++) {
			for(int a = 0; a<col;a++) {
				aux[i][a] = matriz[i][a];
			}
		}
		return aux;
	}
}