package A2;
import java.util.Scanner;

public class IMC {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double []imcs = new double[0];
		double mayorImc = Double.MIN_VALUE;
		double menorImc = Double.MAX_VALUE;
		double promedio = 0;
		
		System.out.println("Ingrese la altura: ");
		double altura = scan.nextDouble();
		
		while(altura!=-1) {
			System.out.println("Ingrese la masa: ");
			double masa = scan.nextDouble();
			double imc = masa/(altura*altura);
			
			if(imc<menorImc) {
				menorImc = imc;
			}
			if(imc>mayorImc) {
				mayorImc = imc;
			}
			imcs = AppendDouble(imcs, imc);
			
			System.out.println("Ingrese la altura: ");
			altura = scan.nextDouble();
		}
		scan.close();
		
		for(int i=0;i<imcs.length;i++) {
			promedio+=imcs[i];
		}
		promedio = promedio/imcs.length;
		
		System.out.println("IMC promedio: "+promedio);
		System.out.println("IMC más alto: "+mayorImc);
		System.out.println("IMC más bajo: "+menorImc);
		
		double porcentajeSobre = 0;
		double porcentajeBajo = 0;
		
		for(int i = 0;i<imcs.length;i++) {
			if(imcs[i]<promedio) {
				porcentajeBajo++;
			}
			else if(imcs[i]>promedio) {
				porcentajeSobre++;
			}
		}
		porcentajeSobre = (porcentajeSobre/imcs.length)*100;
		porcentajeBajo = (porcentajeBajo/imcs.length)*100;
		
		System.out.println("Porcentaje de personas con IMC sobre el IMC promedio: "+porcentajeSobre+"%");
		System.out.println("Porcentaje de personas con IMC bajo el IMC promedio: "+porcentajeBajo+"%");

	}
private static double[] AppendDouble(double[] lista, double valor) {
		
		double [] aux = new double[lista.length+1];
		for(int i = 0; i <lista.length;i++) {
			aux[i]=lista[i];
		}
		aux[lista.length] = valor;
		return aux;
	}
}