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
            protected void paintComponent(final Graphics g) {
                super.paintComponent(g);
                dibujarCarreteraPerspectivaVariable(
                (Graphics2D) g, getWidth() / (2 + 1),
                getWidth() / 2, 0, getHeight());
            }
        };

        add(panel);

        setVisible(true);
    }

    private void dibujarCarreteraPerspectivaVariable(final Graphics2D g2d,
            final int x1, final int x2, final int y1, final int y2) {
        final int anchoBase = 20;
        final int anchoTope = 200;

        double factorPosicion = (double) (y2 - y1) / getHeight();
        final int anchoActual = (int) (anchoTope
                - (anchoTope - anchoBase) * factorPosicion);

        int[] xPoints = {
                x1 - anchoActual / 2, x1 + anchoActual / 2,
                x2 + anchoTope / 2, x2 - anchoTope / 2
        };

        int[] yPoints = {y1, y1, y2, y2};

        g2d.setColor(Color.GRAY);
        final int vertices = 4;
        g2d.fillPolygon(xPoints, yPoints, vertices);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new CarreteraPerspectivaVariableApp());
    }
}
