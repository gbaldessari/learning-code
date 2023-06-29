package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEstadisticasCombate extends JFrame {
	private static final long serialVersionUID = 16;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaEstadisticasCombate (AdministradorVentanas administradorVentanas, Sistema sistema) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		setSize(250, 300);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(250,300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Estadisticas de combate");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		double[] datos = sistema.obtenerEstadisticasCombate();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Estadisticas");
		mensaje.setBounds(90, 0, 200, 50);
		panel.add(mensaje);
		
		JLabel mensajeNombre = new JLabel("Batallas totales: "+(int)datos[0]);
		mensajeNombre.setBounds(50, 50, 200, 50);
		panel.add(mensajeNombre);
		
		JLabel mensajePiloto = new JLabel("Victorias: "+(int)datos[1]);
		mensajePiloto.setBounds(50, 100, 250, 50);
		panel.add(mensajePiloto);
		
		JLabel mensajeEquipo = new JLabel("Porcentaje de victorias: "+datos[2]+"%");
		mensajeEquipo.setBounds(50, 150, 200, 50);
		panel.add(mensajeEquipo);

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 200, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}