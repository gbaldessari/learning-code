package A4;
public class ListaProyectos {
	Proyecto[] proyectos;

	public ListaProyectos() {
		proyectos = new Proyecto[0];
	}
	public void ingresar(Proyecto proyecto) {
		Proyecto[] lista = new Proyecto[proyectos.length+1];
		for(int i = 0;i<proyectos.length;i++) {
			lista[i] = proyectos[i];
		}
		lista[proyectos.length] = proyecto;
		proyectos = lista;
	}
	public Proyecto getProyecto(int posicion) {
		return proyectos[posicion];
	}
	public int getCantidad() {
		return proyectos.length;
	}
}