package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaAñadirPieza extends JFrame {
	private static final long serialVersionUID = 4;
	AdministradorVentanas administradorVentanas;
	public VentanaAñadirPieza (AdministradorVentanas administradorVentanas) {
		this.administradorVentanas = administradorVentanas;
		setSize(250, 400);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(250,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Añadir piezas");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Seleccione el tipo de pieza");
		mensaje.setBounds(49, 0, 150, 50);
		panel.add(mensaje);
		
		JButton botonCabeza = new JButton("Cabeza");
		botonCabeza.setBounds(50, 50, 140, 25);
		panel.add(botonCabeza);
		
		botonCabeza.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirCabeza(administradorVentanas); setVisible(false);}});
		
		JButton botonTorax = new JButton("Torax");
		botonTorax.setBounds(50, 100, 140, 25);
		panel.add(botonTorax);
		
		botonTorax.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirTorax(administradorVentanas); setVisible(false);}});
		
		JButton botonBrazos = new JButton("Brazos");
		botonBrazos.setBounds(50, 150, 140, 25);
		panel.add(botonBrazos);
		
		botonBrazos.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirBrazos(administradorVentanas); setVisible(false);}});
		
		JButton botonPiernas = new JButton("Piernas");
		botonPiernas.setBounds(50, 200, 140, 25);
		panel.add(botonPiernas);
		
		botonPiernas.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirPiernas(administradorVentanas); setVisible(false);}});

		JButton botonArma = new JButton("Arma");
		botonArma.setBounds(50, 250, 140, 25);
		panel.add(botonArma);
		
		botonArma.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.añadirArma(administradorVentanas); setVisible(false);}});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 300, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}