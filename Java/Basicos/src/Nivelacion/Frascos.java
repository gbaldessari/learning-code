package Nivelacion;

import java.util.Scanner;

public class Frascos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int contadorGeneral = 0;
		int recorrerLista = 0;
		
		String numFactura[] = new String[1000];
		int cantidadAComprar[] = new int[1000];
		int kilos[] = new int[1000];
		double venta[] = new double[1000];
		
		int kilosVendidos=0;
		double ventaTotal = 0;
		
		double mayorVenta = -1;
		String mayorFactura = "";
		double menorVenta = 999999999;
		String menorFactura = "";
		
		System.out.println("======Ingrese una opcion======");
		System.out.println("Registrar venta Frasco 3kg:[1]");
		System.out.println("Registrar venta Frasco 5kg:[2]");
		System.out.println("Registrar venta Frasco 9kg:[3]");
		System.out.println("Salir:                     [4]");
		int opcion = scan.nextInt();
		System.out.println("");
		
		while(opcion !=4) {
			switch(opcion) {
			case 1:
				System.out.println("Ingrese el numero de factura: ");
				numFactura[contadorGeneral] = scan.next();
				System.out.println("Ingrese la cantidad de frascos comprados: ");
				cantidadAComprar[contadorGeneral] = scan.nextInt();
				venta[contadorGeneral] = cantidadAComprar[contadorGeneral]*1.8;
				ventaTotal+=venta[contadorGeneral];
				kilosVendidos+=cantidadAComprar[contadorGeneral]*3;
				kilos[contadorGeneral] = cantidadAComprar[contadorGeneral]*3;
				
				if(venta[contadorGeneral]>mayorVenta) {
					mayorVenta = venta[contadorGeneral];
					mayorFactura = numFactura[contadorGeneral];
				}
				if(venta[contadorGeneral]<menorVenta) {
					menorVenta = venta[contadorGeneral];
					menorFactura = numFactura[contadorGeneral];
				}
				System.out.println("");
				break;
			case 2:
				System.out.println("Ingrese el numero de factura: ");
				numFactura[contadorGeneral] = scan.next();
				System.out.println("Ingrese la cantidad de frascos comprados: ");
				cantidadAComprar[contadorGeneral] = scan.nextInt();
				venta[contadorGeneral] = cantidadAComprar[contadorGeneral]*1.5;
				ventaTotal+=venta[contadorGeneral];
				kilosVendidos+=cantidadAComprar[contadorGeneral]*5;
				kilos[contadorGeneral] = cantidadAComprar[contadorGeneral]*5;
				
				if(venta[contadorGeneral]>mayorVenta) {
					mayorVenta = venta[contadorGeneral];
					mayorFactura = numFactura[contadorGeneral];
				}
				if(venta[contadorGeneral]<menorVenta) {
					menorVenta = venta[contadorGeneral];
					menorFactura = numFactura[contadorGeneral];
				}
				System.out.println("");
				break;
			case 3:
				System.out.println("Ingrese el numero de factura: ");
				numFactura[contadorGeneral] = scan.next();
				System.out.println("Ingrese la cantidad de frascos comprados: ");
				cantidadAComprar[contadorGeneral] = scan.nextInt();
				venta[contadorGeneral] = cantidadAComprar[contadorGeneral]*1.2;
				ventaTotal+=venta[contadorGeneral];
				kilosVendidos+=cantidadAComprar[contadorGeneral]*9;
				kilos[contadorGeneral] = cantidadAComprar[contadorGeneral]*9;
				
				if(venta[contadorGeneral]>mayorVenta) {
					mayorVenta = venta[contadorGeneral];
					mayorFactura = numFactura[contadorGeneral];
				}
				if(venta[contadorGeneral]<menorVenta) {
					menorVenta = venta[contadorGeneral];
					menorFactura = numFactura[contadorGeneral];
				}
				System.out.println("");
				break;
			}
			contadorGeneral++;
			
			System.out.println("======Ingrese una opcion======");
			System.out.println("Registrar venta Frasco 3kg:[1]");
			System.out.println("Registrar venta Frasco 5kg:[2]");
			System.out.println("Registrar venta Frasco 9kg:[3]");
			System.out.println("Salir:                     [4]");
			opcion = scan.nextInt();
			System.out.println("");
		}
		scan.close();
		while(recorrerLista!= contadorGeneral) {
			System.out.println("Numero de factura: "+numFactura[recorrerLista]);
			System.out.println("Numero de frascos vendidos: "+cantidadAComprar[recorrerLista]);
			System.out.println("Cantidad de kilos vendidos: "+kilos[recorrerLista]);
			System.out.println("Monto de la venta: "+venta[recorrerLista]);
			System.out.println("");
			recorrerLista++;
		}
		System.out.println("Kilos vendidos en el dia: "+kilosVendidos);
		System.out.println("");
		
		System.out.println("Total ingresos: "+ventaTotal);
		System.out.println("");
		
		System.out.println("Mayor cantidad de kilos vendidos: "+mayorVenta+" Factura: "+mayorFactura);
		System.out.println("");
		
		System.out.println("Menor cantidad de kilos vendidos: "+menorVenta+" Factura: "+menorFactura);
		System.out.println("");
	}
}
