package Nivelacion;

import java.util.Scanner;

public class LosMejores {

	public static void main(String[] args) {
		float mayorNota = 0;
		float mayorNota2 = 0;
		String mayorRut = "";
		String mayorRut2 = "";
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Ingrese un rut: ");
		String rutIngresado = scan.next();
		
		while(!rutIngresado.equals("-1")) {
			System.out.println("Ingrese el promedio: ");
			float notaIngresada = scan.nextFloat();
			System.out.println("");
			
			if(notaIngresada>mayorNota) {
				mayorNota2 = mayorNota;
				mayorRut2 = mayorRut;
				mayorNota = notaIngresada;
				mayorRut = rutIngresado;
			}
			else if(notaIngresada>mayorNota2) {
				mayorNota2 = notaIngresada;
				mayorRut2 = rutIngresado;
			}
			System.out.println("Ingrese un rut: ");
			rutIngresado = scan.next();
		}
		System.out.println("El mayor promedio es: "+mayorNota+" del rut: "+ mayorRut);
		System.out.println("El segundo mayor promedio es: "+mayorNota2+" del rut: "+ mayorRut2);
		scan.close();

	}

}
