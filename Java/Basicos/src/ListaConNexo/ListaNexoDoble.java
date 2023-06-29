package ListaConNexo;
public class ListaNexoDoble {
	private Nodo primero;
	private Nodo ultimo;
	private int largo;
	
	public ListaNexoDoble() {
		primero = null;
		ultimo = null;
		largo = 0;
	}
	public Nodo getPrimero() {
		return primero;
	}
	public Nodo getUltimo() {
		return ultimo;
	}
	public int getLargo() {
		return largo;
	}
	public Nodo getPos(int posicion) {
		Nodo actual = primero;
		for(int i = 0;i<posicion;i++) {
			actual = actual.getSiguiente();
		}
		return actual;
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
		largo++;
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
		largo++;
	}
	public Boolean eliminarPrimero() {
		if(primero == null) return false;
		Nodo nuevoPrimero = primero.getSiguiente();
		if(nuevoPrimero != null) nuevoPrimero.setAnterior(null);
		primero = nuevoPrimero;
		largo--;
		return true;
	}
	public Boolean eliminarUltimo() {
		if(ultimo == null) return false;
		Nodo nuevoUltimo = ultimo.getAnterior();
		if(nuevoUltimo != null)nuevoUltimo.setSiguiente(null);
		ultimo = nuevoUltimo;
		largo--;
		return true;
	}
	public Boolean eliminarPos(int posicion) {
		if(posicion>largo-1||posicion<0) {return false;}
		Nodo actual = primero;
		for(int i = 0;i<posicion;i++) {
			actual = actual.getSiguiente();
		}
		if(actual.getAnterior()!=null) {actual.getAnterior().setSiguiente(actual.getSiguiente());}
		else {primero = actual.getSiguiente();}
		if(actual.getSiguiente()!=null) actual.getSiguiente().setAnterior(actual.getAnterior());
		else {ultimo = actual.getAnterior();}
		return true;
	}
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