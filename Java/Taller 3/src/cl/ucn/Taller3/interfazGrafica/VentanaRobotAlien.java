package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaRobotAlien extends JFrame {
	private static final long serialVersionUID = 12;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int[] index;
	public VentanaRobotAlien (AdministradorVentanas administradorVentanas,Sistema sistema, int[] index) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		this.index = index;
		setSize(300, 300);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Robot alienigena");
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
		
		JLabel mensajePiloto = new JLabel("Escudo");
		mensajePiloto.setBounds(45, 100, 150, 25);
		panel.add(mensajePiloto);
		
		JComboBox<String> selectorEscudo = new JComboBox<>(Sistema.calidades);
		selectorEscudo.setBounds(100, 100, 140, 25);
        panel.add(selectorEscudo);
		
		JButton botonEnsamblar = new JButton("Ensamblar robot");
		botonEnsamblar.setBounds(70, 150, 140, 25);
		panel.add(botonEnsamblar);
		
		botonEnsamblar.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			String nombre = ingresarNombre.getText();
			int escudo = selectorEscudo.getSelectedIndex();
			if(!nombre.isEmpty()) {
				sistema.ingresarRobotAlien(index,nombre,escudo);
				administradorVentanas.menu(administradorVentanas); setVisible(false);}}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 200, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { administradorVentanas.ensamblarRobot(administradorVentanas); setVisible(false);} });
	}
}