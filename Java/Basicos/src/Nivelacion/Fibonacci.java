package Nivelacion;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int termino = scan.nextInt();
		while(termino!=0) {
			int primero = 0;
			int segundo = 1;
			int tercero = 0;
			if(termino<0) {
				System.out.println("Ingrese un valor valido");
			}
			else if(termino ==1) {
				System.out.println("El numero resultante es: 1");
			}
			else if(termino ==2) {
				System.out.println("El numero resultante es: 2");
			}
			else {
				for(int i = 3;i<=termino;i++) {
					tercero = primero+segundo;
					primero = segundo;
					segundo = tercero;
				}
			System.out.println("El numero resultante es: "+tercero);
			}
			termino = scan.nextInt();
		}
		scan.close();
	}
}