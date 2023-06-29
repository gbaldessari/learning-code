package A5.Problema2;
public class ListaContenedores {
	Contenedor[] contenedores;
	public ListaContenedores() {
		contenedores = new Contenedor[0];
	}
	public void ingresar(Contenedor contenedor) {
		Contenedor[] lista = new Contenedor[contenedores.length+1];
		for(int i = 0;i<contenedores.length;i++) {
			lista[i] = contenedores[i];
		}
		lista[contenedores.length] = contenedor;
		contenedores = lista;
	}
	public int getCantidad() {
		return contenedores.length;
	}
	public Contenedor getContenedor(int posicion) {
		return contenedores[posicion];
	}
}