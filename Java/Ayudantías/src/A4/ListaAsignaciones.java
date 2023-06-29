package A4;
public class ListaAsignaciones {
	Asignacion[] asignaciones;

	public ListaAsignaciones() {
		asignaciones = new Asignacion[0];
	}
	public void ingresar(Asignacion asignacion) {
		Asignacion[] lista = new Asignacion[asignaciones.length+1];
		for(int i = 0;i<asignaciones.length;i++) {
			lista[i] = asignaciones[i];
		}
		lista[asignaciones.length] = asignacion;
		asignaciones = lista;
	}
	public Asignacion getAsignacion(int posicion) {
		return asignaciones[posicion];
	}
	public int getCantidad() {
		return asignaciones.length;
	}
}