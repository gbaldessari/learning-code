package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaSeleccionRobotArma extends JFrame {
	private static final long serialVersionUID = 21;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaSeleccionRobotArma (AdministradorVentanas administradorVentanas,Sistema sistema) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		setSize(300, 250);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cambiar arma");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Seleccione un robot");
		mensaje.setBounds(85, 0, 200, 50);
		panel.add(mensaje);
		
		JComboBox<String> selectorRobot = new JComboBox<>(sistema.getListaRobots());
		selectorRobot.setBounds(70, 50, 140, 25);
        panel.add(selectorRobot);
        
        if(sistema.getListaRobots().length!=0) {
			JButton botonSiguiente = new JButton("Siguiente");
			botonSiguiente.setBounds(70, 100, 140, 25);
			panel.add(botonSiguiente);
	        
			int index = selectorRobot.getSelectedIndex();
			botonSiguiente.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.cambiarArma(administradorVentanas, index);setVisible(false);}});
        }
        
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 150, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas);setVisible(false);}});
	}
}