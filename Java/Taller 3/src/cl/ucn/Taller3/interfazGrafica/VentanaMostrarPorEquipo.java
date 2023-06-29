package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaMostrarPorEquipo extends JFrame {
	private static final long serialVersionUID = 19;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	String equipo;
	public VentanaMostrarPorEquipo (AdministradorVentanas administradorVentanas,Sistema sistema, String equipo) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		this.equipo = equipo;
		setSize(300, 350);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Equipo: "+equipo);
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JTextArea descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setBounds(10, 140, 195, 50);

        JTable tablaRobots = new JTable() {
			private static final long serialVersionUID = 191;
			public boolean isCellEditable(int row, int column) {return false;};};
			
        DefaultTableModel modeloTablaRobots = new DefaultTableModel();
        for (String nombreColumna : new String[] {"Robot"}) modeloTablaRobots.addColumn(nombreColumna);
        tablaRobots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modeloTablaRobots = sistema.getRobotsEquipo(modeloTablaRobots, equipo);
        tablaRobots.setModel(modeloTablaRobots); 
        
        JScrollPane tablaScrollable = new JScrollPane(tablaRobots);
        tablaScrollable.setBounds(45, 0, 200, 170);
        panel.add(tablaScrollable);
        
        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBounds(70, 200, 140, 25);
		panel.add(botonSiguiente);
		
		botonSiguiente.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas);setVisible(false);}});

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.ingresarEquipo(administradorVentanas);setVisible(false);}});
	}
}