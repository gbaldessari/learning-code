package Objetos;
public class Avion {
	private String matricula;
	private String fabricante;
	private String modelo;
	private int capacidad;
	public Avion(String matricula, String fabricante, String modelo, int capacidad) {
		super();
		this.matricula = matricula;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getFabricante() {
		return fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return "Avion [matricula=" + matricula + ", fabricante=" + fabricante + ", modelo=" + modelo + ", capacidad="
				+ capacidad + "]";
	}
	
}
