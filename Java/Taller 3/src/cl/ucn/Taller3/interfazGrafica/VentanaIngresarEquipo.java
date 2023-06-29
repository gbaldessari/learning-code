package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaIngresarEquipo extends JFrame {
	private static final long serialVersionUID = 17;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaIngresarEquipo (AdministradorVentanas administradorVentanas,Sistema sistema) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		setSize(250, 250);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(250,250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ingresar equipo");
		IniciarComponentes();
	}
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Ingrese el equipo");
		mensaje.setBounds(70, 0, 200, 50);
		panel.add(mensaje);
		
		JTextField ingresarEquipo = new JTextField(20);
		ingresarEquipo.setBounds(50, 50, 140, 25);
		panel.add(ingresarEquipo);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setBounds(50, 100, 140, 25);
		panel.add(botonSiguiente);
		
		botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			String equipo = ingresarEquipo.getText();
			if(!equipo.isEmpty()) {
				administradorVentanas.mostrarPorEquipos(administradorVentanas, equipo); setVisible(false);}}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 150, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}