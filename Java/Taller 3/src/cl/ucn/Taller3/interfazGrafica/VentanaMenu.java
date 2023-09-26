package cl.ucn.Taller3.interfazGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaMenu extends JFrame{
	private static final long serialVersionUID = 1;
	AdministradorVentanas administradorVentanas;
	public VentanaMenu(AdministradorVentanas administradorVentanas) {
		this.administradorVentanas = administradorVentanas;
		setSize(500, 600);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Menu");
		IniciarComponentes();
	}
	
	private void IniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel mensaje = new JLabel("Bienvenido al Simulador de Combates");
		mensaje.setBounds(140, 0, 250, 50);
		panel.add(mensaje);
		
		JButton botonSimulacion = new JButton("Iniciar Simulacion");
		botonSimulacion.setBounds(180, 50, 140, 25);
		panel.add(botonSimulacion);
		
		botonSimulacion.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.seleccionCombates(administradorVentanas); setVisible(false);}});
		
		JButton botonAnadirPiezas = new JButton("Anadir Piezas");
		botonAnadirPiezas.setBounds(180, 100, 140, 25);
		panel.add(botonAnadirPiezas);
		
		botonAnadirPiezas.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.anadirPiezas(administradorVentanas); setVisible(false);}});
		
		JButton botonEnsamblarRobot = new JButton("Ensamblar Robot");
		botonEnsamblarRobot.setBounds(180, 150, 140, 25);
		panel.add(botonEnsamblarRobot);
		
		botonEnsamblarRobot.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.ensamblarRobot(administradorVentanas); setVisible(false);}});
		
		JButton botonCambiarPiezas = new JButton("Cambiar Piezas");
		botonCambiarPiezas.setBounds(180, 200, 140, 25);
		panel.add(botonCambiarPiezas);
		
		botonCambiarPiezas.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotCambiarPiezas(administradorVentanas); setVisible(false);}});
		
		JButton botonCambiarArmas = new JButton("Cambiar Arma");
		botonCambiarArmas.setBounds(180, 250, 140, 25);
		panel.add(botonCambiarArmas);
		
		botonCambiarArmas.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotCambiarArma(administradorVentanas); setVisible(false);}});
		
		JButton botonEstadisticasRobots = new JButton("Estadisticas de Robots");
		botonEstadisticasRobots.setBounds(150, 300, 200, 25);
		panel.add(botonEstadisticasRobots);
		
		botonEstadisticasRobots.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotEstadisticas(administradorVentanas); setVisible(false);}});
		
		JButton botonRobotsTripulados = new JButton("Robots Tripulados");
		botonRobotsTripulados.setBounds(150, 350, 200, 25);
		panel.add(botonRobotsTripulados);
		
		botonRobotsTripulados.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.robotsPilotados(administradorVentanas, ABORT); setVisible(false);}});
		
		JButton botonRobotsPorEquipo = new JButton("Buscar Robots por Equipo");
		botonRobotsPorEquipo.setBounds(150, 400, 200, 25);
		panel.add(botonRobotsPorEquipo);
		
		botonRobotsPorEquipo.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.ingresarEquipo(administradorVentanas); setVisible(false);}});
		
		JButton botonEstadisticas = new JButton("Estadisticas");
		botonEstadisticas.setBounds(150, 450, 200, 25);
		panel.add(botonEstadisticas);
		
		botonEstadisticas.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.estadisticasCombate(administradorVentanas); setVisible(false);}});
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(180, 500, 140, 25);
		panel.add(botonGuardar);
		
		botonGuardar.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {administradorVentanas.guardar(administradorVentanas); setVisible(false);}});
	}
}