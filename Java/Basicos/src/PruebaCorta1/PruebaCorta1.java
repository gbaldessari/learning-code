//Giacomo Baldessari Marchant
package PruebaCorta1;
import java.util.Scanner;

public class PruebaCorta1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [][] asientos = new int[10][10];
		System.out.println("Ingrese el numero de fila: ");
		int fila = scan.nextInt();
		while(fila !=-1) {
			System.out.println("Ingrese el numero de columna: ");
			int columna = scan.nextInt();
			
			if(fila%2==0&&columna%2!=0||fila%2!=0&&columna%2==0) {
				if(asientos[fila][columna] != 1) {
					asientos[fila][columna] = 1;
				}
				else {
					System.out.println("No se pudo realizar la venta: Asiento ocupado");
				}
			}
			else {
				System.out.println("Asiento invalido");
			}
			System.out.println("Ingrese el numero de fila: ");
			fila = scan.nextInt();
		}
		scan.close();
		
		int contadorNoVendidos = 0;
		int filasPares = 0;
		int filasImpares = 0;
		
		for(int i = 0;i<10;i+=2) {
			for(int a = 0;a<10;a++) {
				filasPares += asientos[i][a];
				if(asientos[i][a]==0) {
					contadorNoVendidos++;
				}
			}
		}		
		for(int i = 1;i<10;i+=2) {
			for(int a = 0;a<10;a++) {
				filasImpares += asientos[i][a];
				if(asientos[i][a]==0) {
					contadorNoVendidos++;
				}
			}
		}
		
		System.out.println("Asientos vendidos en filas pares: "+filasPares);
		System.out.println("Asientos vendidos en filas impares: "+filasImpares);
		System.out.println("Asientos no vendidos: "+contadorNoVendidos);
		System.out.println("");
		
		for(int fil = 0;fil<10;fil++) {
			for(int col = 0;col<10;col++) {
				if(asientos[fil][col]==1) {
					System.out.print("[x]");
				}
				else {System.out.print("[ ]");}
			}
			System.out.println();
		}
	}
}