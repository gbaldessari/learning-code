package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Zoom extends JPanel {

    private double scale = 1.0; // Factor de escala inicial
    private int offsetX = 0;
    private int offsetY = 0;
    private Point lastDragPoint;

    public Zoom() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastDragPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lastDragPoint = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (lastDragPoint != null) {
                    int dx = e.getX() - lastDragPoint.x;
                    int dy = e.getY() - lastDragPoint.y;
                    offsetX += dx;
                    offsetY += dy;
                    lastDragPoint = e.getPoint();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Aplicar la escala y el desplazamiento
        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        // Dibuja tu dibujo aquí (puedes utilizar coordenadas en punto flotante)
        // Por ejemplo, dibujar un rectángulo en coordenadas flotantes
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);
    }

    public void zoomIn() {
        scale *= 1.1; // Aumenta la escala en un 10%
        repaint();
    }

    public void zoomOut() {
        scale /= 1.1; // Disminuye la escala en un 10%
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Zoom y Pan Example");
            Zoom panel = new Zoom();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Agrega botones para controlar el zoom
            JPanel controlPanel = new JPanel();
            JButton zoomInButton = new JButton("Zoom In");
            JButton zoomOutButton = new JButton("Zoom Out");
            controlPanel.add(zoomInButton);
            controlPanel.add(zoomOutButton);

            frame.add(controlPanel, BorderLayout.SOUTH);

            zoomInButton.addActionListener(e -> panel.zoomIn());
            zoomOutButton.addActionListener(e -> panel.zoomOut());
        });
    }
}
