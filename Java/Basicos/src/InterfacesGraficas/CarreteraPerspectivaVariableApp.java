package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class CarreteraPerspectivaVariableApp extends JFrame {

    public CarreteraPerspectivaVariableApp() {
        setTitle("Carretera con Perspectiva Variable");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarCarreteraPerspectivaVariable((Graphics2D) g, getWidth() / 2, getHeight());
            }
        };

        add(panel);

        setVisible(true);
    }

    private void dibujarCarreteraPerspectivaVariable(Graphics2D g2d, int x, int altura) {
        int anchoBase = 20; // Ancho de la carretera en la parte inferior
        int anchoTope = 200; // Ancho de la carretera en la parte superior

        // Calcular el ancho de la carretera en función de la posición vertical
        double factorPosicion = (double) altura / getHeight();
        int anchoActual = (int) (anchoTope - (anchoTope-anchoBase) * factorPosicion);

        int[] xPoints = {
                x - anchoActual / 2, x + anchoActual / 2,
                x + anchoTope / 2, x - anchoTope / 2
        };

        int[] yPoints = {0, 0, altura, altura};

        // Configurar el color y rellenar el polígono
        g2d.setColor(Color.GRAY); // Puedes ajustar el color según tus preferencias
        g2d.fillPolygon(xPoints, yPoints, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarreteraPerspectivaVariableApp());
    }
}
