package InterfacesGraficas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;

public class ContinuousZoom extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;

    public ContinuousZoom() {
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                double scaleFactor = (notches < 0) ? 1.1 : 0.9;  // Ajusta según la dirección del zoom

                // Obtiene la posición del mouse en el sistema de coordenadas no escalado
                Point mouse = e.getPoint();
                Point2D.Double mouseScaled = new Point2D.Double((mouse.x - offsetX) / scale, (mouse.y - offsetY) / scale);

                // Aplica el zoom
                scale *= scaleFactor;

                // Ajusta el desplazamiento para que el punto bajo el mouse permanezca fijo
                offsetX = (int) (mouse.x - mouseScaled.x * scale);
                offsetY = (int) (mouse.y - mouseScaled.y * scale);

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        int startX = getWidth() / 4;
        int startY = getHeight() / 2;
        int endX = 3 * getWidth() / 4;
        int endY = getHeight() / 2;

        g2d.setColor(Color.BLUE);
        g2d.drawLine(startX, startY, endX, endY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Continuous Zoom");
            ContinuousZoom panel = new ContinuousZoom();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
