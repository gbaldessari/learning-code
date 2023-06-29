package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaMostrarEstadisticasRobot extends JFrame {
	private static final long serialVersionUID = 18;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int robot;
	public VentanaMostrarEstadisticasRobot (AdministradorVentanas administradorVentanas, Sistema sistema, int robot) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		this.robot = robot;
		setSize(500, 450);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500,450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Mostrar estadisticas");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		String[] datos = sistema.obtenerEstadisticas(robot);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Estadisticas del Robot");
		mensaje.setBounds(50, 0, 200, 50);
		panel.add(mensaje);
		
		if(datos[6].equalsIgnoreCase("H")) {
			JLabel mensajeNombre = new JLabel("Nombre:");
			mensajeNombre.setBounds(50, 50, 200, 50);
			panel.add(mensajeNombre);
			
			JLabel mensajeNombreT = new JLabel(datos[0]);
			mensajeNombreT.setBounds(120, 50, 200, 50);
			panel.add(mensajeNombreT);
			
			JLabel mensajePiloto = new JLabel("Piloto:");
			mensajePiloto.setBounds(50, 100, 200, 50);
			panel.add(mensajePiloto);
			
			JLabel mensajePilotoT = new JLabel(datos[7]);
			mensajePilotoT.setBounds(120, 100, 200, 50);
			panel.add(mensajePilotoT);
			
			JLabel mensajeEquipo = new JLabel("Equipo:");
			mensajeEquipo.setBounds(50, 150, 200, 50);
			panel.add(mensajeEquipo);
			
			JLabel mensajeEquipoT = new JLabel(datos[8]);
			mensajeEquipoT.setBounds(120, 150, 200, 50);
			panel.add(mensajeEquipoT);
			
			JLabel mensajeVida = new JLabel("Vida:");
			mensajeVida.setBounds(50, 200, 200, 50);
			panel.add(mensajeVida);
			
			JLabel mensajeVidaT = new JLabel(datos[11]);
			mensajeVidaT.setBounds(120, 200, 200, 50);
			panel.add(mensajeVidaT);
			
			JLabel mensajeVelocidad = new JLabel("Velocidad:");
			mensajeVelocidad.setBounds(50, 250, 200, 50);
			panel.add(mensajeVelocidad);
			
			JLabel mensajeVelocidadT = new JLabel(datos[10]);
			mensajeVelocidadT.setBounds(120, 250, 200, 50);
			panel.add(mensajeVelocidadT);
			
			JLabel mensajeAtaque = new JLabel("Ataque:");
			mensajeAtaque.setBounds(50, 300, 200, 50);
			panel.add(mensajeAtaque);
			
			JLabel mensajeAtaqueT = new JLabel(datos[9]);
			mensajeAtaqueT.setBounds(120, 300, 200, 50);
			panel.add(mensajeAtaqueT);
			
			JLabel mensajeCabeza = new JLabel("Cabeza:");
			mensajeCabeza.setBounds(250, 50, 200, 50);
			panel.add(mensajeCabeza);
			
			JLabel mensajeCabezaT = new JLabel(datos[5]);
			mensajeCabezaT.setBounds(320, 50, 200, 50);
			panel.add(mensajeCabezaT);
			
			JLabel mensajeTorax = new JLabel("Torax:");
			mensajeTorax.setBounds(250, 100, 200, 50);
			panel.add(mensajeTorax);
			
			JLabel mensajeToraxT = new JLabel(datos[4]);
			mensajeToraxT.setBounds(320, 100, 200, 50);
			panel.add(mensajeToraxT);
			
			JLabel mensajeBrazos = new JLabel("Brazos:");
			mensajeBrazos.setBounds(250, 150, 200, 50);
			panel.add(mensajeBrazos);
			
			JLabel mensajeBrazosT = new JLabel(datos[3]);
			mensajeBrazosT.setBounds(320, 150, 200, 50);
			panel.add(mensajeBrazosT);
			
			JLabel mensajePiernas = new JLabel("Piernas:");
			mensajePiernas.setBounds(250, 200, 200, 50);
			panel.add(mensajePiernas);
			
			JLabel mensajePiernasT = new JLabel(datos[2]);
			mensajePiernasT.setBounds(320, 200, 200, 50);
			panel.add(mensajePiernasT);
			
			JLabel mensajeArma = new JLabel("Arma:");
			mensajeArma.setBounds(250, 250, 200, 50);
			panel.add(mensajeArma);
			
			JLabel mensajeArmaT = new JLabel(datos[1]);
			mensajeArmaT.setBounds(320, 250, 200, 50);
			panel.add(mensajeArmaT);
		}
		else if(datos[6].equalsIgnoreCase("A")) {
			JLabel mensajeNombre = new JLabel("Nombre:");
			mensajeNombre.setBounds(50, 50, 200, 50);
			panel.add(mensajeNombre);
			
			JLabel mensajeNombreT = new JLabel(datos[0]);
			mensajeNombreT.setBounds(120, 50, 200, 50);
			panel.add(mensajeNombreT);
			
			JLabel mensajeVida = new JLabel("Vida:");
			mensajeVida.setBounds(50, 100, 200, 50);
			panel.add(mensajeVida);
			
			JLabel mensajeVidaT = new JLabel(datos[10]);
			mensajeVidaT.setBounds(120, 100, 200, 50);
			panel.add(mensajeVidaT);
			
			JLabel mensajeVelocidad = new JLabel("Velocidad:");
			mensajeVelocidad.setBounds(50, 150, 200, 50);
			panel.add(mensajeVelocidad);
			
			JLabel mensajeVelocidadT = new JLabel(datos[9]);
			mensajeVelocidadT.setBounds(120, 150, 200, 50);
			panel.add(mensajeVelocidadT);
			
			JLabel mensajeAtaque = new JLabel("Ataque:");
			mensajeAtaque.setBounds(50, 200, 200, 50);
			panel.add(mensajeAtaque);
			
			JLabel mensajeAtaqueT = new JLabel(datos[8]);
			mensajeAtaqueT.setBounds(120, 200, 200, 50);
			panel.add(mensajeAtaqueT);
			
			JLabel mensajeCabeza = new JLabel("Cabeza:");
			mensajeCabeza.setBounds(250, 50, 200, 50);
			panel.add(mensajeCabeza);
			
			JLabel mensajeCabezaT = new JLabel(datos[5]);
			mensajeCabezaT.setBounds(320, 50, 200, 50);
			panel.add(mensajeCabezaT);
			
			JLabel mensajeTorax = new JLabel("Torax:");
			mensajeTorax.setBounds(250, 100, 200, 50);
			panel.add(mensajeTorax);
			
			JLabel mensajeToraxT = new JLabel(datos[4]);
			mensajeToraxT.setBounds(320, 100, 200, 50);
			panel.add(mensajeToraxT);
			
			JLabel mensajeBrazos = new JLabel("Brazos:");
			mensajeBrazos.setBounds(250, 150, 200, 50);
			panel.add(mensajeBrazos);
			
			JLabel mensajeBrazosT = new JLabel(datos[3]);
			mensajeBrazosT.setBounds(320, 150, 200, 50);
			panel.add(mensajeBrazosT);
			
			JLabel mensajePiernas = new JLabel("Piernas:");
			mensajePiernas.setBounds(250, 200, 200, 50);
			panel.add(mensajePiernas);
			
			JLabel mensajePiernasT = new JLabel(datos[2]);
			mensajePiernasT.setBounds(320, 200, 200, 50);
			panel.add(mensajePiernasT);
			
			JLabel mensajeArma = new JLabel("Arma:");
			mensajeArma.setBounds(250, 250, 200, 50);
			panel.add(mensajeArma);
			
			JLabel mensajeArmaT = new JLabel(datos[1]);
			mensajeArmaT.setBounds(320, 250, 200, 50);
			panel.add(mensajeArmaT);
			
			JLabel mensajeEscudo = new JLabel("Escudo:");
			mensajeEscudo.setBounds(250, 300, 200, 50);
			panel.add(mensajeEscudo);
			
			JLabel mensajeEscudoT = new JLabel(datos[7]);
			mensajeEscudoT.setBounds(320, 300, 200, 50);
			panel.add(mensajeEscudoT);
		}
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 350, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotEstadisticas(administradorVentanas); setVisible(false);}});
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setBounds(290, 350, 140, 25);
		panel.add(botonSiguiente);
		
		botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}