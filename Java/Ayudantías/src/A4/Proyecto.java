package A4;
public class Proyecto {
	String nombre;
	String id;
	double presupuesto;
	public Proyecto(String nombre, String id, double presupuesto) {
		this.nombre = nombre;
		this.id = id;
		this.presupuesto = presupuesto;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
}