package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class EfficientClippingExample extends JPanel {
    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private List<Line2D> lines = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private int lineLength = 100;

    private BufferedImage bufferImage;

    public EfficientClippingExample() {
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                double scaleFactor = (notches < 0) ? 1.1 : 0.9;
                scale *= scaleFactor;
                updateBufferImage();
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Handle mouse click if needed
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bufferImage != null) {
            Graphics2D g2d = (Graphics2D) g;

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calcula el tamaño y posición del área visible después del zoom y desplazamiento
            int visibleWidth = (int) (panelWidth / scale);
            int visibleHeight = (int) (panelHeight / scale);

            int visibleX = (int) (-offsetX / scale) + (panelWidth - visibleWidth) / 2;
            int visibleY = (int) (-offsetY / scale) + (panelHeight - visibleHeight) / 2;

            // Dibuja la parte relevante de la imagen en el panel
            g2d.drawImage(bufferImage, 0, 0, panelWidth, panelHeight, visibleX, visibleY,
                    visibleX + visibleWidth, visibleY + visibleHeight, null);
        }
    }

    private void updateBufferImage() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        bufferImage = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dBuffer = bufferImage.createGraphics();

        // Aplica el zoom solo a las líneas y los puntos
        g2dBuffer.scale(scale, scale);

        // Dibuja las líneas y los puntos (afectados por el zoom)
        g2dBuffer.setColor(Color.BLUE);
        for (Line2D line : lines) {
            g2dBuffer.draw(line);
        }

        g2dBuffer.setColor(Color.RED);
        for (Point point : points) {
            int x = (int) (point.x);
            int y = (int) (point.y);
            g2dBuffer.fillOval(x - 2, y - 2, 4, 4);
        }

        g2dBuffer.dispose();
    }

    public void addLine(Line2D line) {
        lines.add(line);
        updateBufferImage();
        repaint();
    }

    public void addPoint(Point point) {
        points.add(point);
        updateBufferImage();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Efficient Clipping Example");
            EfficientClippingExample panel = new EfficientClippingExample();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Agrega algunas líneas y puntos de ejemplo
            panel.addLine(new Line2D.Double(100, 100, 100 + panel.lineLength, 100));
            panel.addLine(new Line2D.Double(200, 200, 200 + panel.lineLength, 200));
            panel.addLine(new Line2D.Double(300, 300, 300 + panel.lineLength, 300));

            panel.addPoint(new Point(50, 50));
            panel.addPoint(new Point(150, 150));
            panel.addPoint(new Point(250, 250));
        });
    }
}
