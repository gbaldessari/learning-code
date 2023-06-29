package A2;
import java.util.Scanner;

public class Matrices {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Filas: ");
		int filas = scan.nextInt();
		System.out.println("Columnas: ");
		int columnas = scan.nextInt();
		int [][] matriz = new int[filas][columnas];
		int [] sumaFilas = new int[filas];
		
		llenarMatriz(filas, columnas, matriz);
		obtenerMatriz(filas,columnas,matriz);
		sumaFilas = sumarFilas(filas,columnas,matriz);
		ordenarMatriz(filas,columnas,matriz,sumaFilas);
		obtenerMatriz(filas,columnas,matriz);
		
		scan.close();
		
	}

	private static void obtenerMatriz(int filas, int columnas, int[][] matriz) {
		for(int i = 0;i<filas;i++) {
			for(int a = 0;a<columnas;a++) {
				System.out.print("["+matriz[i][a]+"]");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void ordenarMatriz(int filas, int columnas, int[][] matriz, int[] sumaFilas) {
		for(int i = 0;i<filas;i++) {
			for(int a = 0;a<filas-1;a++) {
				if(sumaFilas[a] > sumaFilas[a+1]) {
					int aux = sumaFilas[a];
					sumaFilas[a] = sumaFilas[a+1];
					sumaFilas[a+1] = aux;
					for(int e = 0;e<columnas;e++) {
						int auxCol = matriz[a][e];
						matriz[a][e] = matriz[a+1][e];
						matriz[a+1][e] = auxCol;
						
					}
				}
			}
		}
	}
	private static int[] sumarFilas(int filas, int columnas, int[][] matriz) {
		int[] listaSuma = new int[filas];
		for(int i = 0;i<filas;i++) {
			int suma = 0;
			for(int a = 0;a<columnas;a++) {
				suma+=matriz[i][a];
			}
			listaSuma[i] = suma;
		}
		return listaSuma;
	}
	private static void llenarMatriz(int filas, int columnas, int[][] matriz) {
		for(int i = 0;i<filas;i++) {
			for(int a = 0;a<columnas;a++) {
				matriz[i][a] = (int) (Math.random()*10);
			}
		}
	}
}