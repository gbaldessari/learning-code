package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaRobotHumano extends JFrame {
	private static final long serialVersionUID = 11;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int[] index;
	public VentanaRobotHumano (AdministradorVentanas administradorVentanas,Sistema sistema, int[] index) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		this.index = index;
		setSize(300, 350);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Robot humanidad");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Ingrese los datos");
		mensaje.setBounds(90, 0, 200, 50);
		panel.add(mensaje);
		
		JLabel mensajeNombre = new JLabel("Nombre");
		mensajeNombre.setBounds(45, 50, 150, 25);
		panel.add(mensajeNombre);
		
		JTextField ingresarNombre = new JTextField(20);
		ingresarNombre.setBounds(100, 50, 140, 25);
		panel.add(ingresarNombre);
		
		JLabel mensajePiloto = new JLabel("Piloto");
		mensajePiloto.setBounds(45, 100, 150, 25);
		panel.add(mensajePiloto);
		
		JTextField ingresarPiloto = new JTextField(20);
		ingresarPiloto.setBounds(100, 100, 140, 25);
		panel.add(ingresarPiloto);
		
		JLabel mensajeEquipo = new JLabel("Equipo");
		mensajeEquipo.setBounds(45, 150, 150, 25);
		panel.add(mensajeEquipo);
		
		JTextField ingresarEquipo = new JTextField(20);
		ingresarEquipo.setBounds(100, 150, 140, 25);
		panel.add(ingresarEquipo);
		
		JButton botonEnsamblar = new JButton("Ensamblar robot");
		botonEnsamblar.setBounds(70, 200, 140, 25);
		panel.add(botonEnsamblar);
		
		botonEnsamblar.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			String nombre = ingresarNombre.getText();
			String piloto = ingresarPiloto.getText();
			String equipo = ingresarEquipo.getText();
			if(!nombre.isEmpty()) {
				if(piloto.isEmpty())piloto = "";
				if(equipo.isEmpty())equipo = "";
				String[] datos = {nombre,piloto,equipo};
				sistema.ingresarRobotHumano(index,datos);
				administradorVentanas.menu(administradorVentanas); setVisible(false);}}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { administradorVentanas.ensamblarRobot(administradorVentanas); setVisible(false);} });
	}
}