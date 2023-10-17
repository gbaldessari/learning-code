package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class GeographicPointsPanel extends JPanel {
    private List<Point.Double> geographicPoints;

    public GeographicPointsPanel() {
        geographicPoints = new ArrayList<>();
        // Agrega algunos puntos geográficos (latitud, longitud) de ejemplo
        geographicPoints.add(new Point.Double(-34.6037, -58.3816)); // Buenos Aires, Argentina
        geographicPoints.add(new Point.Double(40.7128, -74.0060)); // New York City, USA
        geographicPoints.add(new Point.Double(51.5074, -0.1278)); // London, UK
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Define el área geográfica que deseas mostrar (por ejemplo, un área centrada en Buenos Aires)
        double centerLatitude = -34.6037;
        double centerLongitude = -58.3816;
        double zoomLevel = 500000; // Ajusta el nivel de zoom según tus necesidades

        // Calcula las coordenadas en píxeles para cada punto geográfico
        List<Point> points = new ArrayList<>();
        for (Point.Double geoPoint : geographicPoints) {
            int x = (int) ((geoPoint.getY() - centerLongitude) * zoomLevel + panelWidth / 2);
            int y = (int) ((centerLatitude - geoPoint.getX()) * zoomLevel + panelHeight / 2);
            points.add(new Point(x, y));
        }

        // Dibuja los puntos
        g2d.setColor(Color.BLUE);
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
            g2d.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Geographic Points Panel");
            GeographicPointsPanel panel = new GeographicPointsPanel();
            frame.add(panel);

            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
