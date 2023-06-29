package nexoDoble;
public class ListaNexoDoble {
	private Nodo primero;
	private Nodo ultimo;
	
	public ListaNexoDoble() {
		primero = null;
		ultimo = null;
	}
	public Nodo getPrimero() {
		return primero;
	}
	public Nodo getUltimo() {
		return ultimo;
	}
	public void insertarPrimero(double dato) {
		Nodo nuevo = new  Nodo(dato);
		if(primero == null) {
			ultimo = nuevo;
		}
		else {
			nuevo.setSiguiente(primero);
			primero.setAnterior(nuevo);
		}
		primero = nuevo;
	}
	public void insertar(double dato) {
		Nodo nuevo = new  Nodo(dato);
		if(ultimo == null) {
			primero = nuevo;
		}
		else {
			nuevo.setAnterior(ultimo);
			ultimo.setSiguiente(nuevo);
		}
		ultimo = nuevo;
	}
	public void eliminarPrimero() {}
	public void eliminarUltimo() {}
	
	public void mostrarLista() {
		String lista = "[";
		Nodo actual = primero;
		while(actual!=null) {
			String dato = Double.toString(actual.getDato());
			if(actual.getSiguiente()!=null) {dato+=",";}
			lista+=dato;
			actual = actual.getSiguiente();
		}
		lista+="]";
		System.out.println(lista);
	}
}
