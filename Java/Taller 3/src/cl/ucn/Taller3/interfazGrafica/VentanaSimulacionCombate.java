package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaSimulacionCombate extends JFrame {
	private static final long serialVersionUID = 3;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int[] index;
	public VentanaSimulacionCombate (AdministradorVentanas administradorVentanas, Sistema sistema, int[] index) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		this.index = index;
		setSize(250, 400);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(250,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Resultados de la simulación");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		String[] datos = sistema.obtenerResultadosSimulacion(index);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Resultados");
		mensaje.setBounds(90, 0, 200, 50);
		panel.add(mensaje);
		
		JLabel mensajeB1 = new JLabel("Batalla 1: "+datos[0]);
		mensajeB1.setBounds(50, 50, 200, 50);
		panel.add(mensajeB1);
		
		JLabel mensajeB2 = new JLabel("Batalla 2: "+datos[1]);
		mensajeB2.setBounds(50, 100, 200, 50);
		panel.add(mensajeB2);
		
		JLabel mensajeB3 = new JLabel("Batalla 3: "+datos[2]);
		mensajeB3.setBounds(50, 150, 200, 50);
		panel.add(mensajeB3);
		
		String bando = "";
		if(datos[3].equalsIgnoreCase("H")) {bando="Humanidad";}
		else {bando="Alienigenas";}
		
		JLabel mensajeBG = new JLabel("Bando Ganador: "+bando);
		mensajeBG.setBounds(50, 200, 200, 50);
		panel.add(mensajeBG);

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.seleccionCombates(administradorVentanas); setVisible(false);}});
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setBounds(50, 300, 140, 25);
		panel.add(botonSiguiente);
		
		botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}