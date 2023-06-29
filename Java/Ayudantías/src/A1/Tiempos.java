package A1;
import java.util.Scanner;

public class Tiempos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double menor = Double.MAX_VALUE;
		System.out.println("Numero de tiempos: ");
		int numero = scan.nextInt();
		
		for(int i = 0;i < numero;i++) {
			System.out.println("Ingrese un tiempo: ");
			double tiempoIngresado = scan.nextDouble();
			
			if(tiempoIngresado<menor) {
				menor = tiempoIngresado;
			}
		}
		if(menor<Double.MAX_VALUE) {
			System.out.println("Su mejor tiempo es: "+menor+" minutos");
		}
		else {
			System.out.println("No ha ingresado ningun tiempo");
		}
		scan.close();
	}
}