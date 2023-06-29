package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaCambiarArma extends JFrame {
	private static final long serialVersionUID = 9;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int robot;
	public VentanaCambiarArma (AdministradorVentanas administradorVentanas, Sistema sistema, int robot) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		this.robot = robot;
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
		
		JLabel mensaje = new JLabel("Seleccione la nueva arma");
		mensaje.setBounds(55, 0, 200, 50);
		panel.add(mensaje);
		
		JComboBox<String> selectorArma = new JComboBox<>(sistema.getListaArmas());
		selectorArma.setBounds(70, 50, 140, 25);
        panel.add(selectorArma);
        
		if(sistema.getListaArmas().length!=0) {
			JButton botonSiguiente = new JButton("Siguiente");
		    botonSiguiente.setBounds(70, 100, 140, 25);
		    panel.add(botonSiguiente);
		    botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { 
		    	int index= selectorArma.getSelectedIndex();
		    	sistema.cambiarArma(index,robot);
		    	administradorVentanas.menu(administradorVentanas);
		    	setVisible(false);}});
		}
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 150, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotCambiarPiezas(administradorVentanas); setVisible(false);}});
	}
}