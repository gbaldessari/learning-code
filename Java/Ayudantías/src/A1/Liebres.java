package A1;
import java.io.*;
import java.util.*;

public class Liebres {
	public static void main(String[] args) throws FileNotFoundException {
		File arch = new File("liebres.txt");
		Scanner scan = new Scanner(arch);
		
		String [] liebres = new String[0];
		String [] participacion = new String[0];
		double [] tiempo = new double[0];
		double [] tiemposOrdenados = new double[0];

		int contador = 0;
		
		while(scan.hasNextLine()) {
			
			String [] linea = scan.nextLine().split(",");
			liebres = Append(liebres, linea[0]);
			participacion = Append(participacion, linea[1]);
			if(participacion[contador].equalsIgnoreCase("0")) {
				tiempo = AppendDouble(tiempo, 0);
			}
			else {
				tiempo = AppendDouble(tiempo, Double.parseDouble(linea[2]));
				tiemposOrdenados = AppendDouble(tiemposOrdenados, Double.parseDouble(linea[2]));
			}
			contador++;
		}
		scan.close();
				
		ordenamiento(tiemposOrdenados);
		
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Ingrese un nombre: ");
		String consulta = scan1.next();
		
		while(!consulta.equalsIgnoreCase("-1")) {
			Boolean encontrado=false;
			int conejo =0;
			for(int i = 0;i<liebres.length;i++) {
				if(liebres[i].equalsIgnoreCase(consulta)) {
					conejo=i;
					encontrado = true;
					break;
				}
			}
			if(encontrado) {
				System.out.println("Nombre: "+liebres[conejo]);
				System.out.print("Asistió? ");
				if(participacion[conejo].equals("1")) {
					System.out.println("Si");
					System.out.println("Tiempo: "+tiempo[conejo]);
					System.out.print("Posición: ");
					int posicion = 0;
					for(int i = 0;i<tiemposOrdenados.length;i++) {
						if(tiempo[conejo]==tiemposOrdenados[i]) {
							posicion = i+1;
							break;
						}
					}
					System.out.println(posicion);
				}
				else if(participacion[conejo].equals("0")) {System.out.println("No");}
			}
			else {System.out.println("Liebre no encontrada");}
			
			System.out.println("Ingrese un nombre: ");
			consulta = scan1.next();
		}
		scan1.close();
		
		for(int i = 0;i<3;i++) {
			System.out.print((i+1)+" lugar: ");
			for(int a =0;a<tiemposOrdenados.length;a++) {
				if(tiemposOrdenados[i]==tiempo[a]) {
					System.out.println(liebres[a]);
				}
			}
		}
		double suma = 0;
		for(int i = 0;i<participacion.length;i++) {
			suma+= Double.parseDouble(participacion[i]);
		}
		System.out.println("");
		suma = (suma/participacion.length)*100;
		System.out.println("La asistencia fue del: "+suma+"%");
		System.out.println("La inasistencia fue del: "+(100-suma)+"%");
	}
	private static String[] Append(String[] lista, String valor) {
		String [] aux = new String[lista.length+1];
		for(int i = 0; i <lista.length;i++) {
			aux[i]=lista[i];
		}
		aux[lista.length] = valor;
		return aux;
	}
	private static double[] AppendDouble(double[] lista, double valor) {
		double [] aux = new double[lista.length+1];
		for(int i = 0; i <lista.length;i++) {
			aux[i]=lista[i];
		}
		aux[lista.length] = valor;
		return aux;
	}
	private static void ordenamiento(double lista[]){
		for(int i=0;i<(lista.length-1);i++){
            for(int j=i+1;j<lista.length;j++){
                if(lista[i]>lista[j]){
                	double variableauxiliar=lista[i];
                    lista[i]=lista[j];
                    lista[j]=variableauxiliar;
                }
            }
        }
    }
}