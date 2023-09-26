package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class NearestPointSelection extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private List<Point> points = new ArrayList<>();
    private int pointRadius = 5;
    private Point selectedPoint = null;

    public NearestPointSelection() {
        addMouseWheelListener(e -> {
            int notches = e.getWheelRotation();
            double scaleFactor = (notches < 0) ? 1.1 : 0.9;

            Point mouse = e.getPoint();
            Point2D.Double mouseScaled = new Point2D.Double((mouse.x - offsetX) / scale, (mouse.y - offsetY) / scale);

            scale *= scaleFactor;

            // Ajusta el desplazamiento para que el punto bajo el mouse permanezca fijo
            offsetX = (int) (mouse.x - mouseScaled.x * scale);
            offsetY = (int) (mouse.y - mouseScaled.y * scale);

            repaint();
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point mousePoint = e.getPoint();
                Point2D.Double mousePointScaled = new Point2D.Double((mousePoint.x - offsetX) / scale, (mousePoint.y - offsetY) / scale);

                // Encuentra el punto más cercano al punto de clic
                double minDistance = Double.MAX_VALUE;
                selectedPoint = null;

                for (Point point : points) {
                    double distance = calculateDistance(mousePointScaled, point);
                    if (distance < minDistance) {
                        minDistance = distance;
                        selectedPoint = point;
                    }
                }

                repaint();
            }
        });
    }

    private double calculateDistance(Point2D.Double p1, Point p2) {
        return p1.distance(p2.x, p2.y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        // Dibuja los puntos
        for (Point point : points) {
            int x = (int) (point.x * scale);
            int y = (int) (point.y * scale);

            g2d.setColor(point.equals(selectedPoint) ? Color.RED : Color.BLUE);
            g2d.fillOval(x - pointRadius, y - pointRadius, 2 * pointRadius, 2 * pointRadius);
        }
    }

    public void addPoint(Point point) {
        points.add(point);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nearest Point Selection");
            NearestPointSelection panel = new NearestPointSelection();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Agrega algunos puntos de ejemplo
            panel.addPoint(new Point(100, 100));
            panel.addPoint(new Point(200, 200));
            panel.addPoint(new Point(300, 300));
        });
    }
}
