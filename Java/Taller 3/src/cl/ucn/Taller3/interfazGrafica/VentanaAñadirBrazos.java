package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaAñadirBrazos extends JFrame {
	private static final long serialVersionUID = 7;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaAñadirBrazos (AdministradorVentanas administradorVentanas,Sistema sistema) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		setSize(300, 350);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Añadir brazos");
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
		
		JLabel mensajeRareza = new JLabel("Rareza");
		mensajeRareza.setBounds(40, 100, 150, 25);
		panel.add(mensajeRareza);
		
		JComboBox<String> selectorRareza = new JComboBox<>(Sistema.rarezas);
		selectorRareza.setBounds(100, 100, 140, 25);
        panel.add(selectorRareza);
		
		JLabel mensajeAtaque = new JLabel("Ataque");
		mensajeAtaque.setBounds(40, 150, 150, 25);
		panel.add(mensajeAtaque);
		
		JTextField ingresarAtaque = new JTextField(20);
		ingresarAtaque.setBounds(100, 150, 140, 25);
		panel.add(ingresarAtaque);
        
		JButton botonCrear = new JButton("Crear pieza");
		botonCrear.setBounds(70, 200, 140, 25);
		panel.add(botonCrear);
		
		botonCrear.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			String nombre = ingresarNombre.getText();
			String ataque = ingresarAtaque.getText();
			int rareza = selectorRareza.getSelectedIndex();
			if(!nombre.isEmpty()||!ataque.isEmpty()){
				int ataqueInt = 0;
				Boolean error = false;
				try {
					ataqueInt = Integer.parseInt(ataque);
				}
				catch(java.lang.NumberFormatException e1) {
					error = true;
				}
				if(!error) {
					sistema.ingresarBrazos(nombre,rareza,ataqueInt);
					administradorVentanas.menu(administradorVentanas);setVisible(false);}}}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirPiezas(administradorVentanas);setVisible(false);}});
	}
}