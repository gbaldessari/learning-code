package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaAñadirArma extends JFrame {
	private static final long serialVersionUID = 15;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaAñadirArma (AdministradorVentanas administradorVentanas,Sistema sistema) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		setSize(300, 350);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Añadir arma");
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
		mensajeNombre.setBounds(40, 50, 150, 25);
		panel.add(mensajeNombre);
		
		JTextField ingresarNombre = new JTextField(20);
		ingresarNombre.setBounds(100, 50, 140, 25);
		panel.add(ingresarNombre);
		
		JLabel mensajeDaño = new JLabel("Daño");
		mensajeDaño.setBounds(40, 100, 150, 25);
		panel.add(mensajeDaño);
		
		JTextField ingresarDaño = new JTextField(20);
		ingresarDaño.setBounds(100, 100, 140, 25);
		panel.add(ingresarDaño);
		
		JLabel mensajeVelocidad = new JLabel("Velocidad");
		mensajeVelocidad.setBounds(40, 150, 150, 25);
		panel.add(mensajeVelocidad);
		
		JTextField ingresarVelocidad = new JTextField(20);
		ingresarVelocidad.setBounds(100, 150, 140, 25);
		panel.add(ingresarVelocidad);
        
		JButton botonCrear = new JButton("Crear Arma");
		botonCrear.setBounds(70, 200, 140, 25);
		panel.add(botonCrear);
		
		botonCrear.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			String nombre = ingresarNombre.getText();
			String daño = ingresarDaño.getText();
			String velocidad = ingresarVelocidad.getText();
			if(!nombre.isEmpty()||!daño.isEmpty()||!velocidad.isEmpty()){
				int dañoInt = 0;
				int velocidadInt = 0;
				Boolean error = false;
				try {
					dañoInt = Integer.parseInt(daño);
					velocidadInt = Integer.parseInt(velocidad);
				}
				catch(java.lang.NumberFormatException e1) {
					error = true;
				}
				if(!error) {
					sistema.ingresarArma(nombre,dañoInt,velocidadInt);
					administradorVentanas.menu(administradorVentanas);setVisible(false);}}}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirPiezas(administradorVentanas);setVisible(false);}});
	}
}