package A4;
public class ListaEmpleados {
	Empleado[] empleados;

	public ListaEmpleados() {
		empleados = new Empleado[0];
	}
	public void ingresar(Empleado empleado) {
		Empleado[] lista = new Empleado[empleados.length+1];
		for(int i = 0;i<empleados.length;i++) {
			lista[i] = empleados[i];
		}
		lista[empleados.length] = empleado;     
		empleados = lista;
	}
	public Empleado getEmpleado(int posicion) {
		return empleados[posicion];
	}
	public int getCantidad() {
		return empleados.length;
	}
}