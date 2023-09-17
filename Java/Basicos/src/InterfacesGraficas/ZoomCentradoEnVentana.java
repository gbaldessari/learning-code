package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZoomCentradoEnVentana extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private Point dragStart;

    public ZoomCentradoEnVentana() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragStart = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragStart != null) {
                    int dx = e.getX() - dragStart.x;
                    int dy = e.getY() - dragStart.y;
                    offsetX += dx;
                    offsetY += dy;
                    dragStart = e.getPoint();
                    repaint();
                }
            }
        });

        addMouseWheelListener(e -> {
            int notches = e.getWheelRotation();
            double scaleFactor = 1.0 + notches * 0.1; // Ajusta el valor según la velocidad de zoom que desees

            // Calcula el centro de la ventana
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Calcula el nuevo desplazamiento y escala centrados en el centro de la ventana
            offsetX = (int) ((offsetX - centerX) * scaleFactor) + centerX;
            offsetY = (int) ((offsetY - centerY) * scaleFactor) + centerY;
            scale *= scaleFactor;

            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Aplica las transformaciones de zoom y desplazamiento
        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        // Dibuja algo en la vista
        int squareSize = 50;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(centerX - squareSize / 2, centerY - squareSize / 2, squareSize, squareSize);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Zoom Centrado en Ventana");
            ZoomCentradoEnVentana panel = new ZoomCentradoEnVentana();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

