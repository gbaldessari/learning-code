package A2;
import java.util.Scanner;

public class Palindromos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una palabra: ");
		String palabra = scan.nextLine();
		String [] division = palabra.split("");
		
		division = EliminadorEspacios(division);
		
		Boolean esPalindromo = EsPalindromo(division);
		
		if(esPalindromo) {System.out.println(palabra+" es palindromo");}
		else {System.out.println(palabra+" no es palindromo");}
		scan.close();
	}

	private static String[] EliminadorEspacios(String[] division) {
		int contadorEspacios=0;
		for(int i = 0;i<division.length;i++) {
			if(division[i].equalsIgnoreCase(" ")) {
				contadorEspacios++;
				for(int a = i;a<division.length-1;a++) {
					division[a]=division[a+1];
				}
			}
		}
		String [] aux = new String[division.length-contadorEspacios];
		for(int i =0;i<aux.length;i++) {
			aux[i]=division[i];
		}
		return aux;
		
	}

	private static Boolean EsPalindromo(String[] division) {
		String [] palindromo = new String[division.length];
		for(int i = 0;i<division.length;i++) {
			palindromo[division.length-1-i] = division[i];
		}
		for(int i = 0;i<division.length;i++) {
			if(!palindromo[i].equalsIgnoreCase(division[i])) {
				return false;
			}
		}
		return true;
	}
}