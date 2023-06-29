package A2;

import java.util.Scanner;

public class Palindromos2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una palabra: ");
		String palabra = scan.nextLine();
		palabra.replaceAll(" ", "");
		String [] division = palabra.split("");
		
		Boolean esPalindromo = EsPalindromo(division);
		
		if(esPalindromo) {System.out.println(palabra+" es palindromo");}
		else {System.out.println(palabra+" no es palindromo");}
		scan.close();
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