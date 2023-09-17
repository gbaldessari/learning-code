package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DoubleBufferingWithDrag extends JPanel {

    private BufferedImage bufferImage;
    private Graphics2D bufferGraphics;
    private int offsetX = 0;
    private int offsetY = 0;
    private Point lastDragPoint;

    public DoubleBufferingWithDrag() {
        bufferImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = bufferImage.createGraphics();

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

        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        bufferGraphics.setColor(Color.RED);
        bufferGraphics.fillRect(50, 50, 100, 100);

        // Dibuja la imagen en el JPanel, teniendo en cuenta el desplazamiento
        g.drawImage(bufferImage, -offsetX, -offsetY, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Double Buffering With Drag");
            DoubleBufferingWithDrag panel = new DoubleBufferingWithDrag();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}

