package A10;

public class ListaNexoSimple {
	Nodo primero;
	int largo;

	public ListaNexoSimple() {
		primero = null;
		largo = 0;
	}
	public int largo() {
		return largo;
	}
	public void ingresar(Jugador jugador) {
		Nodo nuevoNodo = new Nodo(jugador);
		if(primero != null) {
			nuevoNodo.setSiguiente(primero);
		}
		primero = nuevoNodo;
		largo++;
	}
	public int buscarPorRut(String rut) {
		for(int i = 0;i<largo;i++) {
			Jugador jugador = get(i);
			if(jugador.getRut().equalsIgnoreCase(rut)) {
				return i;
			}
		}
		return -1;
	}
	public Jugador get(int posicion) {
		if(posicion>largo-1||posicion<0) return null;
		Nodo actual = primero;
		for(int i =0;i<posicion;i++) {
			actual = actual.getSiguiente();
		}
		return actual.getJugador();
	}
}