package A5.Problema1;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		ListaContenedores contenedores = new ListaContenedores();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el numero de contenedor:");
		String valor = scan.nextLine();
		while(!valor.equals("-1")) {
			String numero = valor;
			System.out.println("Ingrese el nombre del producto:");
			valor = scan.nextLine();
			String nombre = valor;
			System.out.println("Ingrese la cantidad de productos:");
			valor = scan.nextLine();
			int cantidad = Integer.parseInt(valor);
			Contenedor contenedor = new Contenedor(numero, nombre, cantidad);
			contenedores.ingresar(contenedor);
			System.out.println("Ingrese el numero de contenedor:");
			valor = scan.nextLine();
		}
		for(int i = 0;i<contenedores.getCantidad();i++) {
			System.out.println("Contenedor: "+contenedores.getContenedor(i).getId());
			System.out.println("    Producto: "+contenedores.getContenedor(i).getProducto());
			System.out.println("    Cantidad: "+contenedores.getContenedor(i).getCantidad());
		}
		scan.close();
	}
}