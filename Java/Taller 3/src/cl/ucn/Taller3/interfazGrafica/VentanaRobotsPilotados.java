package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import cl.ucn.Taller3.logica.Sistema;

public class VentanaRobotsPilotados extends JFrame {
	private static final long serialVersionUID = 20;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaRobotsPilotados (AdministradorVentanas administradorVentanas,Sistema sistema) {
		this.administradorVentanas = administradorVentanas;
		this.sistema = sistema;
		setSize(300, 300);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,250));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Robots tripulados");
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
			private static final long serialVersionUID = 201;
			public boolean isCellEditable(int row, int column) { return false;};};
			
        DefaultTableModel modeloTablaRobots = new DefaultTableModel();
        for (String nombreColumna : new String[] {"Robot", "Piloto"}) modeloTablaRobots.addColumn(nombreColumna);
        tablaRobots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modeloTablaRobots = sistema.getRobotsTripulados(modeloTablaRobots);
        tablaRobots.setModel(modeloTablaRobots); 
        
        JScrollPane tablaScrollable = new JScrollPane(tablaRobots);
        tablaScrollable.setBounds(45, 0, 200, 170);
        panel.add(tablaScrollable);
        
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(70, 200, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas);setVisible(false);}});
	}
}