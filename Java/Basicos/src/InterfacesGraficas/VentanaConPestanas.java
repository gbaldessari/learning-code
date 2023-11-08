package InterfacesGraficas;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;

public class VentanaConPestanas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de pestañas en Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Cambiar el color de fondo de las pestañas
        UIManager.put("TabbedPane.background", Color.RED);
        UIManager.put("TabbedPane.selected", Color.GREEN);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido de la pestaña 1"));
        tabbedPane.addTab("Pestaña 1", panel1);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido de la pestaña 2"));
        tabbedPane.addTab("Pestaña 2", panel2);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
