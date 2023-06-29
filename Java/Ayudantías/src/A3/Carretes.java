package A3;
import java.io.*;
import java.util.Scanner;

public class Carretes {
	public static void main(String[] args) throws FileNotFoundException {
		File file = null;
		Scanner scan = null;
		file = new File("config.txt");
		scan = new Scanner(file);
		
		String[][] filamentos = new String[0][3];
		String[] linea = scan.nextLine().split(",");
		int cantidad = Integer.parseInt(linea[0]);
		while(scan.hasNextLine()) {
			linea = scan.nextLine().split(",");
			filamentos = ingresarDatos(filamentos,linea);
		}
		double contConD = 0;
		double contSinD = 0;
		
		for(int i = 1;i<=cantidad;i++) {
			System.out.println("Periodo "+i+":");
			double mayor = -Double.MAX_VALUE;
			String idMayor = "";
			double menor = Double.MAX_VALUE;
			String idMenor = "";
			double tiempoTotal = 0;
			file = new File("P"+i+".txt");
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				linea = scan.nextLine().split(",");
				double metros = Double.valueOf(linea[1]);
				for(int a = 0;a<filamentos.length;a++) {
					if(linea[3].equalsIgnoreCase(filamentos[a][0])) {
						filamentos[a][2] = String.valueOf(Double.valueOf(filamentos[a][2])+metros);
						break;
					}
				}
				double tiempo = 0;
				if(linea[2].equalsIgnoreCase("Verdadero")) {tiempo = metros*46;contConD++;}
				else {tiempo = metros*30;contSinD++;}
				tiempoTotal+=tiempo;
				if(tiempo>mayor) {mayor=tiempo;idMayor=linea[0];}
				if(tiempo<menor) {menor=tiempo;idMenor=linea[0];}
			}
			System.out.println("Tiempo total de impresion: "+cambiarFormato(tiempoTotal));
			System.out.println("Impresion mas rapida: "+idMenor+" "+cambiarFormato(menor));
			System.out.println("Impresion mas extensa: "+idMayor+" "+cambiarFormato(mayor));
		}
		double contT = contConD+contSinD;
		System.out.println();
		System.out.println("Impresiones totales: "+(int)contT);
		System.out.println("Impresiones con detalle: "+((contConD/contT)*100)+"%");
		System.out.println("Impresiones sin detalle: "+((contSinD/contT)*100)+"%");
		System.out.println();
		for(int i = 0;i<filamentos.length;i++) {
			System.out.println(filamentos[i][0]+": $"+(Double.valueOf(filamentos[i][2])/330)*Double.valueOf(filamentos[i][1]));
		}
		scan.close();
	}

	private static String cambiarFormato(double tiempoTotal) {
		double min=tiempoTotal;
		double hrs = min/60;
		double dias = hrs/24;
		hrs = (dias-(int)dias)*24;
		min = (hrs-(int)hrs)*60;
		String tiempo = String.valueOf((int)dias)+" dias "+String.valueOf((int)hrs)+" horas "+String.valueOf((int)min)+" minutos";
		return tiempo;
	}

	private static String[][] ingresarDatos(String[][] matriz, String[] lista) {
		String[][] nuevaMatriz = new String[matriz.length+1][3];
		for(int i = 0;i<3;i++) {
			for(int a = 0;a<matriz.length;a++) {
				nuevaMatriz[a][i] = matriz[a][i];
			}
		}
		nuevaMatriz[matriz.length][0] = lista[0];
		nuevaMatriz[matriz.length][1] = lista[1];
		nuevaMatriz[matriz.length][2] = "0";
		return nuevaMatriz;
	}
}