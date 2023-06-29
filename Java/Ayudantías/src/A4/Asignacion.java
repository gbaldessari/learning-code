package A4;
public class Asignacion {
	Empleado empleado;
	Proyecto proyecto;
	public Asignacion(Empleado empleado, Proyecto proyecto) {
		this.empleado = empleado;
		this.proyecto = proyecto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
}