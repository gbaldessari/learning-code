package cl.ucn.Taller3.interfazGrafica;
import cl.ucn.Taller3.logica.Sistema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaSeleccionCombates extends JFrame {
	private static final long serialVersionUID = 2;
	AdministradorVentanas administradorVentanas;
	Sistema sistema;
	public VentanaSeleccionCombates (AdministradorVentanas administradorVentanas, Sistema sistema) {
		this.sistema = sistema;
		this.administradorVentanas = administradorVentanas;
		setSize(500, 350);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Seleccion de combates");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Seleccione los robots que combatirán");
		mensaje.setBounds(130, 0, 300, 50);
		panel.add(mensaje);
		
		JLabel mensajeRobotsH = new JLabel("Robots Humanidad");
		mensajeRobotsH.setBounds(65, 50, 250, 25);
		panel.add(mensajeRobotsH);
		
		JLabel mensajeRobotsA = new JLabel("Robots Alienigenas");
		mensajeRobotsA.setBounds(315, 50, 250, 25);
		panel.add(mensajeRobotsA);
		
		JLabel mensajeVS1 = new JLabel("vs");
		mensajeVS1.setBounds(240, 100, 250, 25);
		panel.add(mensajeVS1);
		
		JLabel mensajeVS2 = new JLabel("vs");
		mensajeVS2.setBounds(240, 150, 250, 25);
		panel.add(mensajeVS2);
		
		JLabel mensajeVS3 = new JLabel("vs");
		mensajeVS3.setBounds(240, 200, 250, 25);
		panel.add(mensajeVS3);
		
		JComboBox<String> selectorRobotH1 = new JComboBox<>(sistema.getListaRobotsH());
		selectorRobotH1.setBounds(50, 100, 140, 25);
        panel.add(selectorRobotH1);
        
        JComboBox<String> selectorRobotH2 = new JComboBox<>(sistema.getListaRobotsH());
        selectorRobotH2.setBounds(50, 150, 140, 25);
        panel.add(selectorRobotH2);
        
        JComboBox<String> selectorRobotH3 = new JComboBox<>(sistema.getListaRobotsH());
        selectorRobotH3.setBounds(50, 200, 140, 25);
        panel.add(selectorRobotH3);
        
		JComboBox<String> selectorRobotA1 = new JComboBox<>(sistema.getListaRobotsA());
		selectorRobotA1.setBounds(300, 100, 140, 25);
        panel.add(selectorRobotA1);
        
        JComboBox<String> selectorRobotA2 = new JComboBox<>(sistema.getListaRobotsA());
        selectorRobotA2.setBounds(300, 150, 140, 25);
        panel.add(selectorRobotA2);
        
        JComboBox<String> selectorRobotA3 = new JComboBox<>(sistema.getListaRobotsA());
        selectorRobotA3.setBounds(300, 200, 140, 25);
        panel.add(selectorRobotA3);
        
		if(sistema.getListaRobotsH().length!=0&&sistema.getListaRobotsA().length!=0) {
			JButton botonSiguiente = new JButton("Siguiente");
		    botonSiguiente.setBounds(300, 250, 140, 25);
		    panel.add(botonSiguiente);
		    botonSiguiente.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
			int[] index= {selectorRobotH1.getSelectedIndex(),selectorRobotH2.getSelectedIndex(),selectorRobotH3.getSelectedIndex(),selectorRobotA1.getSelectedIndex(),selectorRobotA2.getSelectedIndex(),selectorRobotA3.getSelectedIndex()};
			administradorVentanas.simulacionCombate(administradorVentanas,index);setVisible(false);}});
		}
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(50, 250, 140, 25);
		panel.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {administradorVentanas.menu(administradorVentanas); setVisible(false);}});
	}
}