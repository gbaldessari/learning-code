package A10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		List<Juego> juegos = new ArrayList<>(0);
		List<Jugada> jugadas = new LinkedList<>();
		ListaNexoSimple jugadores = new ListaNexoSimple();
		
		File arch = new File("juegos.txt");
		Scanner scan = new Scanner(arch);
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			String[] porcentaje = linea[1].split("");
			String numero = "";
			for(int i = 0;i<porcentaje.length-1;i++) {
				numero+=porcentaje[i];
			}
			Juego juego = new Juego(linea[0], Double.valueOf(numero)+100);
			juegos.add(juego);
		}
		scan.close();
		arch = new File("jugados.txt");
		scan = new Scanner(arch);
		while(scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
			int posicion = jugadores.buscarPorRut(linea[0]);
			Jugador jugador = null;
			if(posicion==-1) {
				jugador = new Jugador(linea[1], linea[0]);
				jugadores.ingresar(jugador);
			}
			else {
				jugador = jugadores.get(posicion);
			}
			Juego juego = null;
			for(int i = 0;i<juegos.size();i++) {
				if(juegos.get(i).getNombre().equalsIgnoreCase(linea[2])) {
					juego = juegos.get(i);
					juego.addVecesJugado();
					jugador.addPuntos(juego.getPuntaje());
					Jugada jugada = new Jugada(jugador, juego);
					jugadas.add(jugada);
					break;
				}
			}
		}
		scan.close();
		
		double mayor = -1;
		String nombreMayor = "";
		for(int i = 0;i<jugadores.largo();i++) {
			if(jugadores.get(i).getPuntos()>mayor) {
				mayor = jugadores.get(i).getPuntos();
				nombreMayor = jugadores.get(i).getNombre();
			}
		}
		System.out.println("Jugador con mas puntos("+mayor+"): "+nombreMayor);
		mayor = -1;
		nombreMayor = "";
		for(int i = 0;i<juegos.size();i++) {
			if(juegos.get(i).getVecesJugado()>mayor) {
				mayor = juegos.get(i).getVecesJugado();
				nombreMayor = juegos.get(i).getNombre();
			}
		}
		System.out.println("Juego mas popular(jugado "+mayor+" veces): "+nombreMayor);
		
		for(int a = 0;a<juegos.size();a++) {
			System.out.println(juegos.get(a).getNombre()+":");
			for(int i = 0;i<jugadas.size();i++){
				if(jugadas.get(i).getJuego().getNombre().equalsIgnoreCase(juegos.get(a).getNombre())) {
					System.out.println("    "+jugadas.get(i).getJugador().getNombre());
				}
			}
		}
	}
}