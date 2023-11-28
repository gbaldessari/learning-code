package A5.Problema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		ListaContenedores contenedores = new ListaContenedores();
		File arch = new File("contenedores.txt");
		Scanner scan = new Scanner(arch);
		while(scan.hasNextLine()) {
			Boolean existente = false;
			Boolean pesoMax = false;
			String[] linea = scan.nextLine().split(",");
			Contenedor contenedor = null;
			for(int i = 0;i<contenedores.getCantidad();i++) {
				if(linea[0].equalsIgnoreCase(contenedores.getContenedor(i).getId())) {
					existente = true;
					if((contenedores.getContenedor(i).getPeso()+(Integer.parseInt(linea[2])*Integer.parseInt(linea[3])))>25000) {
						pesoMax = true;
						break;
					}
					else {
						contenedor = contenedores.getContenedor(i);
						break;
					}
				}
			}
			if(!existente) {
				contenedor = new Contenedor(linea[0], Integer.parseInt(linea[2])*Integer.parseInt(linea[3]));
				contenedores.ingresar(contenedor);
			}
			else if(existente&&!pesoMax&&contenedor!=null) {
				contenedor.setPeso(Integer.parseInt(linea[2])*Integer.parseInt(linea[3]));
			}
		}
		for(int i = 0;i<contenedores.getCantidad();i++) {
			System.out.println("Id contenedor: "+contenedores.getContenedor(i).getId()+", peso: "+contenedores.getContenedor(i).getPeso()+" kg");
		}
		scan.close();
	}
}