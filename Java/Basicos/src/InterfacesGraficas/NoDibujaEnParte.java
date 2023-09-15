package InterfacesGraficas;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class NoDibujaEnParte extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Define un rectángulo que representa la región donde no se debe dibujar
        Rectangle2D noDrawRegion = new Rectangle2D.Double(100, 100, 200, 100);

        // Establece la región de recorte para que no se dibuje dentro del rectángulo
        g2d.setClip(noDrawRegion);

        // Dibuja algo en toda la ventana
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Dibuja algo fuera de la región de recorte (esto se dibujará)
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);

        // Restaura la región de recorte
        g2d.setClip(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("No Dibujar en Parte de la Ventana");
            frame.add(new NoDibujaEnParte());
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
