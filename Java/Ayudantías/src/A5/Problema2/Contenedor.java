package A5.Problema2;
public class Contenedor {
	String id;
	int peso;
	public Contenedor(String id, int peso) {
		this.id = id;
		this.peso = peso;
	}
	public String getId() {
		return id;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso+=peso;
	}
}