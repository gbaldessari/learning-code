package A4;
public class Empleado {
	String nombre;
	String rut;
	double sueldo;
	public Empleado(String nombre, String rut, double sueldo) {
		this.nombre = nombre;
		this.rut = rut;
		this.sueldo = sueldo;
	}
	public String getRut() {
		return rut;
	}
	public String getNombre() {
		return nombre;
	}
}