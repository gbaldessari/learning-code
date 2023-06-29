package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaCambiarPiezas extends JFrame {
	private static final long serialVersionUID = 14;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	int robot;
	public VentanaCambiarPiezas (AdministradorVentanas administradorVentanas, Sistema sistema, int robot) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		this.robot = robot;
		setSize(300, 400);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cambiar piezas");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Seleccione las nuevas piezas");
		mensaje.setBounds(55, 0, 200, 50);
		panel.add(mensaje);
		
		JLabel mensajeCabeza = new JLabel("Cabeza");
		mensajeCabeza.setBounds(50, 50, 250, 25);
		panel.add(mensajeCabeza);
		
		JComboBox<String> selectorCabeza = new JComboBox<>(sistema.getListaCabezas());
        selectorCabeza.setBounds(100, 50, 140, 25);
        panel.add(selectorCabeza);
        
        JLabel mensajeTorax = new JLabel("Torax");
        mensajeTorax.setBounds(50, 100, 250, 25);
		panel.add(mensajeTorax);
        
        JComboBox<String> selectorTorax = new JComboBox<>(sistema.getListaTorax());
        selectorTorax.setBounds(100, 100, 140, 25);
        panel.add(selectorTorax);
		
        JLabel mensajeBrazos = new JLabel("Brazos");
        mensajeBrazos.setBounds(50, 150, 250, 25);
		panel.add(mensajeBrazos);
        
		JComboBox<String> selectorBrazos = new JComboBox<>(sistema.getListaBrazos());
		selectorBrazos.setBounds(100, 150, 140, 25);
        panel.add(selectorBrazos);
		
        JLabel mensajePiernas = new JLabel("Piernas");
        mensajePiernas.setBounds(50, 200, 250, 25);
		panel.add(mensajePiernas);
        
        JComboBox<String> selectorPiernas = new JComboBox<>(sistema.getListaPiernas());
        selectorPiernas.setBounds(100, 200, 140, 25);
        panel.add(selectorPiernas);
        
		if(sistema.getListaArmas().length!=0&&sistema.getListaBrazos().length!=0&&sistema.getListaTorax().length!=0&&sistema.getListaPiernas().length!=0&&sistema.getListaCabezas().length!=0) {
			JButton botonSiguiente = new JButton("Siguiente");
		    botonSiguiente.setBounds(70, 250, 140, 25);
		    panel.add(botonSiguiente);
		    botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { 
		    	int[] index= {selectorCabeza.getSelectedIndex(),selectorTorax.getSelectedIndex(),selectorBrazos.getSelectedIndex(),
		    			selectorPiernas.getSelectedIndex()};
		    	sistema.cambiarPieza(index,robot);
		    	administradorVentanas.menu(administradorVentanas);
		    	setVisible(false);
		    	}});}
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 300, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotCambiarPiezas(administradorVentanas); setVisible(false);}});
	}
}