package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LineWithButton extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private Line2D line = new Line2D.Double(100, 200, 300, 200);
    private int buttonRadius = 5;

    public LineWithButton() {
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

                // Verifica si el clic está dentro del "botón" (con un margen de 5 píxeles)
                Point2D.Double buttonCenterScaled = new Point2D.Double(line.getX1(), line.getY1());
                Point2D.Double buttonCenter = new Point2D.Double(buttonCenterScaled.x * scale + offsetX, buttonCenterScaled.y * scale + offsetY);

                if (mousePointScaled.distance(buttonCenter) <= buttonRadius) {
                    JOptionPane.showMessageDialog(LineWithButton.this, "¡Haz hecho clic en el botón!");
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        g2d.setColor(Color.BLUE);
        g2d.draw(line);

        // Dibuja el "botón" en la posición transformada
        Point2D.Double buttonCenterScaled = new Point2D.Double(line.getX1(), line.getY1());
        Point2D.Double buttonCenter = new Point2D.Double(buttonCenterScaled.x * scale + offsetX, buttonCenterScaled.y * scale + offsetY);
        g2d.setColor(Color.RED);
        g2d.fillOval((int) (buttonCenter.x - buttonRadius), (int) (buttonCenter.y - buttonRadius), 2 * buttonRadius, 2 * buttonRadius);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Line with Button");
            LineWithButton panel = new LineWithButton();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
