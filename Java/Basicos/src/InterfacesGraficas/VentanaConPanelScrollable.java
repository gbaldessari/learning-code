package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class VentanaConPanelScrollable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana con Panel Scrollable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        // Crear un JPanel que contendrá el contenido scrollable
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 1)); // GridLayout con 10 filas y 1 columna

        // Agregar contenido al JPanel
        for (int i = 1; i <= 20; i++) {
            panel.add(new JLabel("Etiqueta " + i));
        }

        // Crear un JScrollPane y agregar el JPanel como su vista
        JScrollPane scrollPane = new JScrollPane(panel);

        // Establecer el tamaño preferido del JPanel (opcional)
        panel.setPreferredSize(new Dimension(1000, 1000)); // Tamaño preferido del contenido

        // Agregar el JScrollPane al marco
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}