package cl.ucn.Taller3.dominio;
public class Combate {
	private String robotH1;
	private String robotH2;
	private String robotH3;
	private String robotA1;
	private String robotA2;
	private String robotA3;
	private String ganador;
	public Combate(String robotH1, String robotH2, String robotH3, String robotA1, String robotA2, String robotA3, String ganador) {
		this.robotH1 = robotH1;
		this.robotH2 = robotH2;
		this.robotH3 = robotH3;
		this.robotA1 = robotA1;
		this.robotA2 = robotA2;
		this.robotA3 = robotA3;
		this.ganador = ganador;
	}
	public String getRobotH1() {
		return robotH1;
	}
	public String getRobotH2() {
		return robotH2;
	}
	public String getRobotH3() {
		return robotH3;
	}
	public String getRobotA1() {
		return robotA1;
	}
	public String getRobotA2() {
		return robotA2;
	}
	public String getRobotA3() {
		return robotA3;
	}
	public String getGanador() {
		return ganador;
	}
}
