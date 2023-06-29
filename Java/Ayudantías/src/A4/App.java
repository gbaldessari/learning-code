package A4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		ListaProyectos proyectos = new ListaProyectos();
		ListaEmpleados empleados = new ListaEmpleados();
		ListaAsignaciones asignaciones = new ListaAsignaciones();
		Scanner scan = obtenerScanner("proyectos.txt");
		obtenerProyectos(proyectos, scan);
		scan = obtenerScanner("empleados.txt");
		obtenerEmpleados(empleados, scan);
		scan = obtenerScanner("asignaciones.txt");
		obtenerAsignaciones(proyectos, empleados, asignaciones, scan);
		
		for(int i = 0;i<empleados.getCantidad();i++) {
			System.out.println(empleados.getEmpleado(i).getNombre()+":");
			for(int a = 0;a<asignaciones.getCantidad();a++) {
				if(asignaciones.getAsignacion(a).getEmpleado().equals(empleados.getEmpleado(i))) {
					System.out.println("    "+asignaciones.getAsignacion(a).getProyecto().getNombre());
				}
			}
		}
		
		for(int i = 0;i<proyectos.getCantidad();i++) {
			System.out.println(proyectos.getProyecto(i).getNombre()+":");
			for(int a = 0;a<asignaciones.getCantidad();a++) {
				if(asignaciones.getAsignacion(a).getProyecto().equals(proyectos.getProyecto(i))) {
					System.out.println("    "+asignaciones.getAsignacion(a).getEmpleado().getNombre());
				}
			}
		}
	}

	private static void obtenerAsignaciones(ListaProyectos proyectos, ListaEmpleados empleados,
			ListaAsignaciones asignaciones, Scanner scan) {
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			Empleado empleado = null;
			Proyecto proyecto = null;
			for(int i = 0;i<empleados.getCantidad();i++) {
				if(linea[0].equalsIgnoreCase(empleados.getEmpleado(i).getRut())) {
					empleado = empleados.getEmpleado(i);
					break;
				}
			}
			for(int i = 0;i<proyectos.getCantidad();i++) {
				if(linea[1].equalsIgnoreCase(proyectos.getProyecto(i).getId())) {
					proyecto = proyectos.getProyecto(i);
					break;
				}
			}
			Asignacion asignacion = new Asignacion(empleado, proyecto);
			asignaciones.ingresar(asignacion);
		}
	}

	private static void obtenerEmpleados(ListaEmpleados empleados, Scanner scan) {
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			Empleado empleado = new Empleado(linea[0], linea[1], Double.valueOf(linea[2]));
			empleados.ingresar(empleado);
		}
	}

	private static void obtenerProyectos(ListaProyectos proyectos, Scanner scan) {
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			Proyecto proyecto = new Proyecto(linea[0], linea[1], Double.valueOf(linea[2]));
			proyectos.ingresar(proyecto);
		}
	}

	private static Scanner obtenerScanner(String ruta) throws FileNotFoundException {
		File arch = new File(ruta);
		Scanner scan = new Scanner(arch);
		return scan;
	}
}
