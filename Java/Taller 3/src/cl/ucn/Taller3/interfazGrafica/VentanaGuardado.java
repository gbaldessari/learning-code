package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaGuardado extends JFrame {
	private static final long serialVersionUID = 0;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaGuardado (AdministradorVentanas administradorVentanas, Sistema sistema) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		setSize(250, 150);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(250,150));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Guardar datos");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		sistema.guardarDatos();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Datos Guardados");
		mensaje.setBounds(70, 0, 200, 50);
		panel.add(mensaje);

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 50, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}