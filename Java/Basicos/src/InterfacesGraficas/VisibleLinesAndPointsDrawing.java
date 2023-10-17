package InterfacesGraficas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.geom.Line2D;

class MyRectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public MyRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(int offsetX, int offsetY, double scale) {
        this.x = (int) (offsetX);
        this.y = (int) (offsetY);
        this.width = (int) (width * scale);
        this.height = (int) (height * scale);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, width, height);
    }
}

public class VisibleLinesAndPointsDrawing extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private int prevMouseX;
    private int prevMouseY;
    private ArrayList<Line2D> lines = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();
    private int lineLength = 100;
    private MyRectangle myRectangle = new MyRectangle(50, 50, 50, 50); // Rectángulo de ejemplo

    public VisibleLinesAndPointsDrawing() {
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                double scaleFactor = (notches < 0) ? 1.1 : 0.9;

                Point mouse = e.getPoint();
                Point2D.Double mouseScaled = new Point2D.Double((mouse.x - offsetX) / scale, (mouse.y - offsetY) / scale);

                scale *= scaleFactor;

                // Ajusta el desplazamiento para que el punto bajo el mouse permanezca fijo
                offsetX = (int) (mouse.x - mouseScaled.x * scale);
                offsetY = (int) (mouse.y - mouseScaled.y * scale);

                updateRectangle();
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevMouseX = e.getX();
                prevMouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // Calcula el desplazamiento según el movimiento del ratón
                offsetX += mouseX - prevMouseX;
                offsetY += mouseY - prevMouseY;

                prevMouseX = mouseX;
                prevMouseY = mouseY;

                updateRectangle();
                repaint();
            }
        });
    }

    private void updateRectangle() {
        myRectangle.update(offsetX, offsetY, scale);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        // Dibuja solo las líneas que están dentro de los límites visibles
        for (Line2D line : lines) {
            g2d.setColor(Color.BLUE);
            g2d.draw(line);
        }

        // Dibuja solo los puntos que están dentro de los límites visibles
        for (Point point : points) {
            int x = (int) (point.x);
            int y = (int) (point.y);

            g2d.setColor(Color.RED);
            g2d.fillOval(x - 2, y - 2, 4, 4);
        }

        // Dibuja el rectángulo
        myRectangle.draw(g2d);
    }

    public void addLine(Line2D line) {
        lines.add(line);
        repaint();
    }

    public void addPoint(Point point) {
        points.add(point);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Visible Lines and Points Drawing");
            VisibleLinesAndPointsDrawing panel = new VisibleLinesAndPointsDrawing();
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
