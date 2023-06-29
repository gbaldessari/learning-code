package cl.ucn.Taller3.logica;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import cl.ucn.Taller3.dominio.*;
public class SistemaImpl implements Sistema{
	private List<RobotA> listaRobotsA;
	private List<RobotH> listaRobotsH;
	private List<Robot> listaRobots;
	private List<Brazos> listaBrazos;
	private List<Cabeza> listaCabezas;
	private List<Piernas> listaPiernas;
	private List<Torax> listaTorax;
	private List<Arma> listaArmas;
	private List<Combate> listaCombates;
	public SistemaImpl() {
		listaBrazos = new ArrayList<Brazos>(0);
		listaCabezas = new ArrayList<Cabeza>(0);
		listaPiernas = new ArrayList<Piernas>(0);
		listaTorax = new ArrayList<Torax>(0);
		listaArmas = new ArrayList<Arma>(0);
		listaRobotsA = new ArrayList<RobotA>(0);
		listaRobotsH = new ArrayList<RobotH>(0);
		listaRobots = new ArrayList<Robot>(0);
		listaCombates = new ArrayList<Combate>();
	}
	public void ingresarRobotHumano(int[] index,String[] datos) {
		String nombre = datos[0];
		Arma arma = listaArmas.get(index[4]);
		Piernas pierna = listaPiernas.get(index[3]);
		Brazos brazo = listaBrazos.get(index[2]);
		Torax torax = listaTorax.get(index[1]);
		Cabeza cabeza = listaCabezas.get(index[0]);
		String piloto = datos[1];
		String equipo = datos[2];
		RobotH r = new RobotH(nombre, arma, pierna, brazo, torax, cabeza, "H", piloto, equipo);
		listaRobotsH.add(r);
		listaRobots.add(r);
	}
	public void ingresarRobotAlien(int[] index,String nombre,int posEscudo) {
		Arma arma = listaArmas.get(index[4]);
		Piernas pierna = listaPiernas.get(index[3]);
		Brazos brazo = listaBrazos.get(index[2]);
		Torax torax = listaTorax.get(index[1]);
		Cabeza cabeza = listaCabezas.get(index[0]);
		String escudo = calidades[posEscudo];
		RobotA r = new RobotA(nombre, arma, pierna, brazo, torax, cabeza, "A", escudo);
		listaRobotsA.add(r);
		listaRobots.add(r);
	}
	public void cambiarPieza(int[] index,int robot) {
		Robot r = listaRobots.get(robot);
		r.setPiernas(listaPiernas.get(index[3]));
		r.setBrazos(listaBrazos.get(index[2]));
		r.setTorax(listaTorax.get(index[1]));
		r.setCabeza(listaCabezas.get(index[0]));
	}
	public void cambiarArma(int index, int robot) {
		Robot r = listaRobots.get(robot);
		r.setArma(listaArmas.get(index));		
	}
	public String[] obtenerEstadisticas(int robot){
		Robot r = listaRobots.get(robot);
		String[] lista = new String[12];
		double[] listaExtras = new double[2];
		
		lista[0] = r.getNombre();
		lista[1] = r.getArma().getNombre();
		lista[2] = r.getPiernas().getNombre();
		listaExtras = guardarExtras(listaExtras, r.getPiernas().getRareza());
		lista[3] = r.getBrazos().getNombre();
		listaExtras = guardarExtras(listaExtras, r.getBrazos().getRareza());
		lista[4] = r.getTorax().getNombre();
		listaExtras = guardarExtras(listaExtras, r.getTorax().getRareza());
		lista[5] = r.getCabeza().getNombre();
		listaExtras = guardarExtras(listaExtras, r.getCabeza().getRareza());
		lista[6] = r.getTipo();
		
		double ataque = r.getArma().getDaño()+r.getBrazos().getAtaque()+listaExtras[1];
		double velocidad = r.getArma().getVelocidad()+r.getPiernas().getVelocidad()+r.getCabeza().getVelocidad();
		double vida = r.getTorax().getVida()+r.getCabeza().getVida()+listaExtras[0];
		
		if(r.getTipo().equalsIgnoreCase("H")) {
			int pos = -1;
			for(int i = 0;i<listaRobotsH.size();i++) {
				if(listaRobotsH.get(i).getNombre().equalsIgnoreCase(lista[0])) {pos = i;break;}
			}
			RobotH r1 = listaRobotsH.get(pos);
			lista[7] = r1.getPiloto();
			lista[8] = r1.getEquipo();
			lista[9] = String.valueOf(ataque);
			lista[10] = String.valueOf(velocidad);
			lista[11] = String.valueOf(vida);
		}
		else if(r.getTipo().equalsIgnoreCase("A")) {
			int pos = -1;
			for(int i = 0;i<listaRobotsA.size();i++) {
				if(listaRobotsA.get(i).getNombre().equalsIgnoreCase(lista[0])) {pos = i;break;}
			}
			RobotA r1 = listaRobotsA.get(pos);
			lista[7] = r1.getClaseEscudo();
			
			if(lista[7].equalsIgnoreCase("SS+")) {vida+=5000;ataque+=500;}
			else if(lista[7].equalsIgnoreCase("S+")) {vida+=3000;ataque+=400;}
			else if(lista[7].equalsIgnoreCase("S")) {vida+=2000;ataque+=300;}
			else if(lista[7].equalsIgnoreCase("A")) {vida+=1000;ataque+=200;}
			else if(lista[7].equalsIgnoreCase("B")) {vida+=500;ataque+=100;}
			
			lista[8] = String.valueOf(ataque);
			lista[9] = String.valueOf(velocidad);
			lista[10] = String.valueOf(vida);
		}
		return lista;
	}
	public String[] getListaRobots() {
		String[] lista = new String[listaRobots.size()];
		for(int i =0;i<listaRobots.size();i++) {
			lista[i] = listaRobots.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaRobotsH() {
		String[] lista = new String[listaRobotsH.size()];
		for(int i =0;i<listaRobotsH.size();i++) {
			lista[i] = listaRobotsH.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaRobotsA() {
		String[] lista = new String[listaRobotsA.size()];
		for(int i =0;i<listaRobotsA.size();i++) {
			lista[i] = listaRobotsA.get(i).getNombre();
		}
		return lista;
	}
	public String[] obtenerResultadosSimulacion(int[] index) {
		String[] resultados = new String[4];
		int[] sumas = new int[2];
		String[] datosRH1 = obtenerDatosRobotH(index[0]);
		String[] datosRA1 = obtenerDatosRobotA(index[3]);
		resultados[0] = simulacion(datosRH1,datosRA1,sumas);
		String[] datosRH2 = obtenerDatosRobotH(index[1]);
		String[] datosRA2 = obtenerDatosRobotA(index[4]);
		resultados[1] = simulacion(datosRH2,datosRA2,sumas);
		String[] datosRH3 = obtenerDatosRobotH(index[2]);
		String[] datosRA3 = obtenerDatosRobotA(index[5]);
		resultados[2] = simulacion(datosRH3,datosRA3,sumas);
		if(sumas[0]>=sumas[1]) {resultados[3]="H";}
		else {resultados[3]="A";}
		Combate c = new Combate(datosRH1[0],datosRH2[0],datosRH3[0],datosRA1[0],datosRA2[0],datosRA3[0],resultados[3]);
		listaCombates.add(c);
		return resultados;
	}
	public double[] obtenerEstadisticasCombate() {
		double[] datos = new double[3];
		datos[0] = listaCombates.size();
		
		for(int i =0;i<listaCombates.size();i++) {
			if(listaCombates.get(i).getGanador().equalsIgnoreCase("H")) {datos[1]++;}
		}
		if(listaCombates.size()!=0) {
			datos[2] = (datos[1]/datos[0])*100;
		}
		return datos;
	}
	public DefaultTableModel getRobotsTripulados(DefaultTableModel modeloTablaRobots) {
		for(int i = 0;i<listaRobotsH.size();i++) {
			if(!listaRobotsH.get(i).getPiloto().equalsIgnoreCase("")) {
	            Vector<String> robotVector = new Vector<>();
	            robotVector.add(listaRobotsH.get(i).getNombre());
	            robotVector.add(listaRobotsH.get(i).getPiloto());
	            modeloTablaRobots.addRow(robotVector);
			}
		}
		return modeloTablaRobots;
	}
	public DefaultTableModel getRobotsEquipo(DefaultTableModel modeloTablaRobots, String equipo) {
		for(int i = 0;i<listaRobotsH.size();i++) {
			if(listaRobotsH.get(i).getEquipo().equalsIgnoreCase(equipo)) {
	            Vector<String> robotVector = new Vector<>();
	            robotVector.add(listaRobotsH.get(i).getNombre());
	            modeloTablaRobots.addRow(robotVector);
			}
		}
		return modeloTablaRobots;
	}
	public String[] getListaBrazos(){
		String[] lista = new String[listaBrazos.size()];
		for(int i =0;i<listaBrazos.size();i++) {
			lista[i] = listaBrazos.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaCabezas(){
		String[] lista = new String[listaCabezas.size()];
		for(int i =0;i<listaCabezas.size();i++) {
			lista[i] = listaCabezas.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaPiernas(){
		String[] lista = new String[listaPiernas.size()];
		for(int i =0;i<listaPiernas.size();i++) {
			lista[i] = listaPiernas.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaTorax(){
		String[] lista = new String[listaTorax.size()];
		for(int i =0;i<listaTorax.size();i++) {
			lista[i] = listaTorax.get(i).getNombre();
		}
		return lista;
	}
	public String[] getListaArmas(){
		String[] lista = new String[listaArmas.size()];
		for(int i =0;i<listaArmas.size();i++) {
			lista[i] = listaArmas.get(i).getNombre();
		}
		return lista;
	}
	public void ingresarCabeza(String nombre, int posRareza, int velocidadInt, int vidaInt) {
		String rareza = rarezas[posRareza];
		Cabeza cabeza = new Cabeza(nombre, rareza, "C", velocidadInt, vidaInt);
		listaCabezas.add(cabeza);
	}
	public void ingresarTorax(String nombre, int posRareza, int vida) {
		String rareza = rarezas[posRareza];
		Torax torax = new Torax(nombre, rareza, "T", vida);
		listaTorax.add(torax);
	}
	public void ingresarBrazos(String nombre, int posRareza, int ataque) {
		String rareza = rarezas[posRareza];
		Brazos brazos = new Brazos(nombre, rareza, "B", ataque);
		listaBrazos.add(brazos);
	}
	public void ingresarPiernas(String nombre, int posRareza, int velocidad) {
		String rareza = rarezas[posRareza];
		Piernas piernas = new Piernas(nombre, rareza, "P", velocidad);
		listaPiernas.add(piernas);		
	}
	public void ingresarArma(String nombre, int daño, int velocidad) {
		Arma arma = new Arma(nombre, daño, velocidad);
		listaArmas.add(arma);
	}
	public void guardarDatos() {
		borrarDatosArchivo("armas.txt");
		borrarDatosArchivo("piezas.txt");
		borrarDatosArchivo("combates.txt");
		borrarDatosArchivo("robots.txt");
		PrintWriter writerRobots = crearWriter("robots.txt");
		PrintWriter writerPiezas = crearWriter("piezas.txt");
		PrintWriter writerArmas = crearWriter("armas.txt");
		PrintWriter writerCombates = crearWriter("combates.txt");
		
		for(int i = 0;i<listaRobotsA.size();i++) {
			writerRobots.print(listaRobotsA.get(i).getNombre()+","+listaRobotsA.get(i).getArma().getNombre()+","+listaRobotsA.get(i).getPiernas().getNombre()+","+
					listaRobotsA.get(i).getBrazos().getNombre()+","+listaRobotsA.get(i).getTorax().getNombre()+","+listaRobotsA.get(i).getCabeza().getNombre()+","+
					listaRobotsA.get(i).getTipo()+","+listaRobotsA.get(i).getClaseEscudo());
			writerRobots.println();
		}
		for(int i = 0;i<listaRobotsH.size();i++) {
			writerRobots.print(listaRobotsH.get(i).getNombre()+","+listaRobotsH.get(i).getArma().getNombre()+","+listaRobotsH.get(i).getPiernas().getNombre()+","+
					listaRobotsH.get(i).getBrazos().getNombre()+","+listaRobotsH.get(i).getTorax().getNombre()+","+listaRobotsH.get(i).getCabeza().getNombre()+","+
					listaRobotsH.get(i).getTipo()+","+listaRobotsH.get(i).getPiloto()+","+listaRobotsH.get(i).getEquipo());
			writerRobots.println();
		}
		for(int i = 0;i<listaPiernas.size();i++) {
			writerPiezas.print(listaPiernas.get(i).getNombre()+","+listaPiernas.get(i).getRareza()+","+listaPiernas.get(i).getTipo()+","+listaPiernas.get(i).getVelocidad());
			writerPiezas.println();
		}
		for(int i = 0;i<listaBrazos.size();i++) {
			writerPiezas.print(listaBrazos.get(i).getNombre()+","+listaBrazos.get(i).getRareza()+","+listaBrazos.get(i).getTipo()+","+listaBrazos.get(i).getAtaque());
			writerPiezas.println();
		}
		for(int i = 0;i<listaTorax.size();i++) {
			writerPiezas.print(listaTorax.get(i).getNombre()+","+listaTorax.get(i).getRareza()+","+listaTorax.get(i).getTipo()+","+listaTorax.get(i).getVida());
			writerPiezas.println();
		}
		for(int i = 0;i<listaCabezas.size();i++) {
			writerPiezas.print(listaCabezas.get(i).getNombre()+","+listaCabezas.get(i).getRareza()+","+listaCabezas.get(i).getTipo()+","+listaCabezas.get(i).getVelocidad()+","+listaCabezas.get(i).getVida());
			writerPiezas.println();
		}
		for(int i = 0;i<listaArmas.size();i++) {
			writerArmas.print(listaArmas.get(i).getNombre()+","+listaArmas.get(i).getDaño()+","+listaArmas.get(i).getVelocidad());
			writerArmas.println();
		}
		for(int i = 0;i<listaCombates.size();i++) {
			writerCombates.print(listaCombates.get(i).getRobotH1()+","+listaCombates.get(i).getRobotH2()+","+listaCombates.get(i).getRobotH3()+","+
					listaCombates.get(i).getRobotA1()+","+listaCombates.get(i).getRobotA2()+","+listaCombates.get(i).getRobotA3()+","+listaCombates.get(i).getGanador());
			writerCombates.println();
		}
		writerCombates.close();
		writerPiezas.close();
		writerArmas.close();
		writerRobots.close();
	}
	public void obtenerRobots(String[] linea) {
		Arma a = null;
		Piernas p = null;
		Brazos b = null;
		Torax t = null;
		Cabeza c = null;
		
		for(int i = 0;i<listaArmas.size();i++) {
			if(listaArmas.get(i).getNombre().equalsIgnoreCase(linea[1])) {
				a = listaArmas.get(i);
				break;
			}
		}
		for(int i = 0;i<listaPiernas.size();i++) {
			if(listaPiernas.get(i).getNombre().equalsIgnoreCase(linea[2])) {
				p = listaPiernas.get(i);
				break;
			}
		}
		for(int i = 0;i<listaBrazos.size();i++) {
			if(listaBrazos.get(i).getNombre().equalsIgnoreCase(linea[3])) {
				b = listaBrazos.get(i);
				break;
			}
		}
		for(int i = 0;i<listaTorax.size();i++) {
			if(listaTorax.get(i).getNombre().equalsIgnoreCase(linea[4])) {
				t = listaTorax.get(i);
				break;
			}
		}
		for(int i = 0;i<listaCabezas.size();i++) {
			if(listaCabezas.get(i).getNombre().equalsIgnoreCase(linea[5])) {
				c = listaCabezas.get(i);
				break;
			}
		}
		if(linea[6].equalsIgnoreCase("H")) {
			RobotH r = null;
			if(linea.length==7) {
				r = new RobotH(linea[0],a,p,b,t,c,linea[6],"","");
			}
			else if(linea.length==8) {
				r = new RobotH(linea[0],a,p,b,t,c,linea[6],linea[7],"");
			}
			else {
				r = new RobotH(linea[0],a,p,b,t,c,linea[6],linea[7],linea[8]);
			}
			listaRobotsH.add(r);
			listaRobots.add(r);
		}
		else if(linea[6].equalsIgnoreCase("A")) {
			RobotA r = new RobotA(linea[0],a,p,b,t,c,linea[6],linea[7]);
			listaRobotsA.add(r);
			listaRobots.add(r);
		}			
	}
	public void obtenerArmas(String[] linea) {
		Arma a = new Arma(linea[0].strip(),Double.parseDouble(linea[1].strip()),Double.parseDouble(linea[2].strip()));
		listaArmas.add(a);
	}
	public void obtenerPiezas(String[] linea) {
		if(linea[2].equalsIgnoreCase("P")) {
			Piernas p = new Piernas(linea[0].strip(),linea[1].strip(),linea[2].strip(),Double.parseDouble(linea[3].strip()));
			listaPiernas.add(p);
		}
		else if(linea[2].equalsIgnoreCase("B")) {
			Brazos b = new Brazos(linea[0].strip(),linea[1].strip(),linea[2].strip(),Double.parseDouble(linea[3].strip()));
			listaBrazos.add(b);	
		}
		else if(linea[2].equalsIgnoreCase("T")) {
			Torax t = new Torax(linea[0].strip(),linea[1].strip(),linea[2].strip(),Double.parseDouble(linea[3].strip()));
			listaTorax.add(t);	
		}
		else if(linea[2].equalsIgnoreCase("C")) {
			Cabeza c = new Cabeza(linea[0].strip(),linea[1].strip(),linea[2].strip(),Double.parseDouble(linea[3].strip()),Double.parseDouble(linea[4].strip()));
			listaCabezas.add(c);
		}
	}
	public void obtenerCombates(String[] linea) {
		Combate c = new Combate(linea[0].strip(),linea[1].strip(),linea[2].strip(),linea[3].strip(),linea[4].strip(),linea[5].strip(),linea[6].strip());
		listaCombates.add(c);
	}
	private double[] guardarExtras(double[] lista, String rareza) {
		lista[0]+=2000;
		if(rareza.equalsIgnoreCase("PP")) {lista[0]+=3000;lista[1]+=200;}
		else if(rareza.equalsIgnoreCase("PE")) {lista[0]+=2000;lista[1]+=100;}
		else if(rareza.equalsIgnoreCase("PC")) {lista[0]+=1000;}
		return lista;
	}
	private String simulacion(String[] datosRH, String[] datosRA, int[] suma) {
		String robotH = datosRH[0];
		String robotA = datosRA[0];
		double velocidadRH = Double.parseDouble(datosRH[1]);
		double velocidadRA = Double.parseDouble(datosRA[1]);
		double vidaRH = Double.parseDouble(datosRH[2]);
		double vidaRA = Double.parseDouble(datosRA[2]);
		double ataqueRH = Double.parseDouble(datosRH[3]);
		double ataqueRA = Double.parseDouble(datosRA[3]);
		String ganador = "";
		
		if(velocidadRH==velocidadRA) {
			Random random = new Random();
			int num = random.nextInt(2);
			if(num ==1) {velocidadRH+=1;}
			else {velocidadRA+=1;}
		}
		if(velocidadRH>velocidadRA) {
			while(true) {
				vidaRA-=ataqueRH;
				if(vidaRA<=0) {ganador = robotH;suma[0]++;break;}
				vidaRH-=ataqueRA;
				if(vidaRH<=0) {ganador = robotA;suma[1]++;break;}
			}
		}
		else {
			while(true) {
				vidaRH-=ataqueRA;
				if(vidaRH<=0) {ganador = robotA;suma[1]++;break;}
				vidaRA-=ataqueRH;
				if(vidaRA<=0) {ganador = robotH;suma[0]++;break;}
			}
		}
		return ganador;
	}
	private String[] obtenerDatosRobotH(int robot){
		RobotH r = listaRobotsH.get(robot);
		String[] lista = new String[4];
		double[] listaExtras = new double[2];
		lista[0] = r.getNombre();
		
		listaExtras = guardarExtras(listaExtras, r.getPiernas().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getBrazos().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getTorax().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getCabeza().getRareza());
		
		double ataque = r.getArma().getDaño()+r.getBrazos().getAtaque()+listaExtras[1];
		double velocidad = r.getArma().getVelocidad()+r.getPiernas().getVelocidad()+r.getCabeza().getVelocidad();
		double vida = r.getTorax().getVida()+r.getCabeza().getVida()+listaExtras[0];
		
		lista[1] = String.valueOf(ataque);
		lista[2] = String.valueOf(velocidad);
		lista[3] = String.valueOf(vida);
		return lista;
	}	
	private String[] obtenerDatosRobotA(int robot){
		RobotA r = listaRobotsA.get(robot);
		String[] lista = new String[4];
		double[] listaExtras = new double[2];
		lista[0] = r.getNombre();
		
		listaExtras = guardarExtras(listaExtras, r.getPiernas().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getBrazos().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getTorax().getRareza());
		listaExtras = guardarExtras(listaExtras, r.getCabeza().getRareza());
		
		double ataque = r.getArma().getDaño()+r.getBrazos().getAtaque()+listaExtras[1];
		double velocidad = r.getArma().getVelocidad()+r.getPiernas().getVelocidad()+r.getCabeza().getVelocidad();
		double vida = r.getTorax().getVida()+r.getCabeza().getVida()+listaExtras[0];
		
		if(r.getClaseEscudo().equalsIgnoreCase("SS+")) {vida+=5000;ataque+=500;}
		else if(r.getClaseEscudo().equalsIgnoreCase("S+")) {vida+=3000;ataque+=400;}
		else if(r.getClaseEscudo().equalsIgnoreCase("S")) {vida+=2000;ataque+=300;}
		else if(r.getClaseEscudo().equalsIgnoreCase("A")) {vida+=1000;ataque+=200;}
		else if(r.getClaseEscudo().equalsIgnoreCase("B")) {vida+=500;ataque+=100;}
		
		lista[1] = String.valueOf(ataque);
		lista[2] = String.valueOf(velocidad);
		lista[3] = String.valueOf(vida);
		return lista;
	}
	private PrintWriter crearWriter(String ruta) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(ruta, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Error al encontrar el archivo");
		}
		return writer;
	}
	private void borrarDatosArchivo(String ruta) {
		try {
			BufferedWriter vaciar = new BufferedWriter(new FileWriter(ruta));
			vaciar.write("");
			vaciar.close();
		} catch (IOException e) {
			System.out.println("Error al encontrar el archivo");
		}
	}
}