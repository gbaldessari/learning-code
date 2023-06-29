package A1;
import java.util.Scanner;

public class Primos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero: ");
		int numero = scan.nextInt();
		System.out.print("El numero "+numero);
		if(EsPrimo(numero)) {
			System.out.println(" es primo");
		}
		else {
			System.out.println(" no es primo");
		}
		scan.close();
	}

	private static Boolean EsPrimo(int numero) {
		if(numero<2)return false;
		for(int i = 2;i<numero;i++) {
			if(numero%i ==0) {
				return false;
			}
		}
		return true;
	}
}