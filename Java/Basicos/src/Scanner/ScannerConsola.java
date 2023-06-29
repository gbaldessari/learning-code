package Scanner;

import java.util.Scanner;

public class ScannerConsola {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero(int): ");
		int intIngresado = Integer.parseInt(scan.nextLine());
		System.out.println("El numero ingresado es "+intIngresado);
		
		System.out.println("");
		System.out.println("Ingrese un numero(float): ");
		float floatIngresado = Float.valueOf(scan.nextLine());
		System.out.println("El numero ingresado es "+ floatIngresado);
		
		System.out.println("");
		System.out.println("Ingrese un numero(double): ");
		double doubleIngresado = Double.valueOf(scan.nextLine());
		System.out.println("El numero ingresado es "+ doubleIngresado);
		
		System.out.println("");
		System.out.println("Ingrese un nombre(string): ");
		String stringIngresado = scan.nextLine();
		System.out.println("El nombre ingresado es "+ stringIngresado);
		
		scan.close();
	}
}