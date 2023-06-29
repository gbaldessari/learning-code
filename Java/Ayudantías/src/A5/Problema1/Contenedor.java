package A5.Problema1;

public class Contenedor {
	String id;
	String producto;
	int cantidad;
	public Contenedor(String id, String producto, int cantidad) {
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public String getId() {
		return id;
	}
	public String getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
}