package ListaConNexo;
public class Nodo {
	private double dato;
	private Nodo anterior;
	private Nodo siguiente;
	
	public Nodo(double dato) {
		this.dato = dato;
		anterior = null;
		siguiente = null;
	}

	public void setDato(double dato) {
		this.dato = dato;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public double getDato() {
		return dato;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}
}