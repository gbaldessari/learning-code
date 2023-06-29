package PruebaDiagnostico;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PruebaDiagnostico {
	public static void main(String[] args) throws FileNotFoundException {
		File arch = new File("datos.txt");
		Scanner scan = new Scanner(arch);
		
		String[] listaMascotas = new String[0];
		String[] listaClinicas = new String[0];
		String[] listaDiagnosticos = new String[0];
		int[] listaAtenciones = new int[0];
		
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			
			Boolean mascotaEnLista = false;
			Boolean diagnosticoEnLista = false;
			Boolean clinicaEnLista = false;
			
			for(int i = 0;i<listaMascotas.length;i++) {
				if(linea[0].equalsIgnoreCase(listaMascotas[i])) mascotaEnLista = true;
			}
			for(int i = 0;i<listaClinicas.length;i++) {
				if(linea[2].equalsIgnoreCase(listaClinicas[i])) clinicaEnLista = true;
				
			}
			for(int i = 0;i<listaDiagnosticos.length;i++) {
				if(linea[3].equalsIgnoreCase(listaDiagnosticos[i])) diagnosticoEnLista = true;
			}
			
			if(mascotaEnLista ==false) {
				listaMascotas = Append(listaMascotas,linea[0]);
			}	
			if(clinicaEnLista ==false) {
				listaClinicas = Append(listaClinicas,linea[2]);
				listaAtenciones = AppendInt(listaAtenciones,0);
			}	
			if(diagnosticoEnLista ==false) {
				listaDiagnosticos = Append(listaDiagnosticos,linea[3]);
			}	
		}
		int [][] matrizMascotaDiagnostico = new int[listaMascotas.length][listaDiagnosticos.length];
		int [][] matrizMascotaClinica = new int[listaMascotas.length][listaClinicas.length];
		
		scan.close();
		Scanner scan1 = new Scanner(arch);
		
		while(scan1.hasNextLine()) {
			String[] linea = scan1.nextLine().split(",");
			for(int i = 0;i<listaMascotas.length;i++) {
				for(int a = 0;a<listaDiagnosticos.length;a++) {
					if(listaMascotas[i].equalsIgnoreCase(linea[0])&&listaDiagnosticos[a].equalsIgnoreCase(linea[3])) {
						matrizMascotaDiagnostico[i][a]++;
					}
				}
			}
		}
		System.out.println("por cada mascota, diagnósticos más repetidos");
		
		for(int i = 0;i<listaMascotas.length;i++) {
			int mayor = 0;
			for(int a = 0;a<listaDiagnosticos.length;a++) {
				if(matrizMascotaDiagnostico[i][a]>mayor)mayor = matrizMascotaDiagnostico[i][a];
			}
			System.out.println(listaMascotas[i]);
			for(int e = 0;e<listaDiagnosticos.length;e++) {
				if(matrizMascotaDiagnostico[i][e] == mayor) {
					System.out.println("         "+listaDiagnosticos[e]);
				}
			}
		}
		
		scan1.close();
		arch = new File("datos.txt");
		Scanner scan2 = new Scanner(arch);
		
		while(scan2.hasNextLine()) {
			String[] linea = scan2.nextLine().split(",");
			for(int i = 0;i<listaClinicas.length;i++) {
				if(linea[2].equalsIgnoreCase(listaClinicas[i])) {
					listaAtenciones[i]++;
				}
			}
		}
		
		float suma = 0;
		for(int i = 0;i<listaAtenciones.length;i++) suma+=listaAtenciones[i];
		
		double promedio = suma/(listaAtenciones.length);
		
		System.out.println();
		System.out.println("promedio atenciones "+promedio);
		
		for(int i = 0;i<listaAtenciones.length;i++) {
			if(listaAtenciones[i]<promedio) {
				System.out.println("eliminando "+listaClinicas[i]+" "+listaAtenciones[i]);
			}
		}
		
		System.out.println();
		System.out.println("por cada mascota, clínicas donde se atendió");
		
		scan2.close();
		arch = new File("datos.txt");
		Scanner scan3 = new Scanner(arch);
		
		while(scan3.hasNextLine()) {
			String[] linea = scan3.nextLine().split(",");
			
			for(int i = 0;i<listaMascotas.length;i++) {
				for(int a=0;a<listaClinicas.length;a++) {
					if(listaMascotas[i].equalsIgnoreCase(linea[0])&&listaClinicas[a].equalsIgnoreCase(linea[2])) {
						matrizMascotaClinica[i][a]++;
					}
				}
			}
		}
		
		for(int i =0;i<listaMascotas.length;i++) {
			System.out.println(listaMascotas[i]);
			for(int e =0;e<listaClinicas.length;e++) {
				System.out.println("         "+listaClinicas[e]+" "+matrizMascotaClinica[i][e]);
			}
		}
		scan3.close();
	}
	private static String[] Append(String[] lista, String valor) {
		
		String [] aux = new String[lista.length+1];
		for(int i = 0; i <lista.length;i++) {
			aux[i]=lista[i];
		}
		aux[lista.length] = valor;
		return aux;
	}
	private static int[] AppendInt(int[] lista, int valor) {
		
		int [] aux = new int[lista.length+1];
		for(int i = 0; i <lista.length;i++) {
			aux[i]=lista[i];
		}
		aux[lista.length] = valor;
		return aux;
	}
}