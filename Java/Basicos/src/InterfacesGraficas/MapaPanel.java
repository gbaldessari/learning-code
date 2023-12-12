package InterfacesGraficas;
import javax.swing.*;
import java.awt.*;

public class MapaPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Establecer el punto de vista
        int puntoVistaY = 150;

        // Dibujar un cubo cercano
        dibujarCubo(g, Color.BLUE, 50, puntoVistaY, 30);

        // Dibujar un cubo lejano
        int factorReduccion = 2;
        dibujarCubo(g, Color.RED, 150, puntoVistaY - 30 / factorReduccion, 30);
    }

    private void dibujarCubo(Graphics g, Color color, int x, int y, int size) {
        g.setColor(color);

        // Dibujar caras del cubo
        g.fillRect(x, y, size, size);
        g.drawLine(x, y, x + size, y);
        g.drawLine(x + size, y, x + size, y + size);
        g.drawLine(x, y, x, y + size);
        g.drawLine(x, y + size, x + size, y + size);

        // Dibujar línea diagonal para simular perspectiva
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x + size, y + size);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mapa en Perspectiva");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.add(new MapaPanel());
            frame.setVisible(true);
        });
    }
}
