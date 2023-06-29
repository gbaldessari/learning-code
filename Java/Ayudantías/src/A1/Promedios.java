package A1;
import java.util.Scanner;

public class Promedios {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el nombre del estudiante: ");
		String nombre = scan.next();
		System.out.println("Ingrese el Rut del estudiante: ");
		String rut = scan.next();
		
		System.out.println("Ingrese la asignatura que quiere analizar(Cálculo o Álgebra): ");
		String asignatura = scan.next();
		if(asignatura.equalsIgnoreCase("Calculo")||asignatura.equalsIgnoreCase("Cálculo")) {
			System.out.println("Prueba 1: ");
			double promedio = scan.nextDouble()*0.35;
			System.out.println("Prueba 2: ");
			promedio += scan.nextDouble()*0.35;
			System.out.println("Control: ");
			promedio += scan.nextDouble()*0.3;
			
			System.out.println("El promedio del estudiante "+nombre+" de Rut "+rut+" en la asignatura Cálculo es de "+promedio);
		}
		else if(asignatura.equalsIgnoreCase("Algebra")||asignatura.equalsIgnoreCase("Álgebra")) {
			System.out.println("Prueba: ");
			double promedio = scan.nextDouble()*0.8;
			System.out.println("Control 1: ");
			promedio += scan.nextDouble()*0.1;
			System.out.println("Control 2: ");
			promedio += scan.nextDouble()*0.1;
			
			System.out.println("El promedio del estudiante "+nombre+" de Rut "+rut+" en la asignatura Álgebra es de "+promedio);
		}
		else {System.out.println("Ingrese una asignatura válida");}
		scan.close();
	}
}