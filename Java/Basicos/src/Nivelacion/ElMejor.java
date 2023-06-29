package Nivelacion;

import java.util.Scanner;

public class ElMejor {
	public static void main(String[] args) {
		
		float mayorNota = -1;
		String mayorRut = "";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de alumnos: ");
		int numeroDeAlumnos = scan.nextInt();
		
		for(int i = numeroDeAlumnos;i>0;i--) {
			System.out.println("Ingrese un rut: ");
			String rutIngresado = scan.next();
			
			System.out.println("Ingrese el promedio: ");
			float notaIngresada = scan.nextFloat();
			System.out.println("");
			
			if(notaIngresada>mayorNota) {
				mayorNota = notaIngresada;
				mayorRut = rutIngresado;
			}
		}
		System.out.println("El mayor promedio es: "+mayorNota+" del rut: "+ mayorRut);
		scan.close();
	}
}