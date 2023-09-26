package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class ImageDisplay extends JPanel {

    private double scale = 1.0;
    private int offsetX = 0;
    private int offsetY = 0;
    private ImageIcon imageIcon;
    private int imageX = 100;  // Coordenada x de la esquina superior izquierda de la imagen
    private int imageY = 100;  // Coordenada y de la esquina superior izquierda de la imagen

    public ImageDisplay() {
        // Carga la imagen desde un archivo (ajusta la ruta de acuerdo a tu imagen)
        imageIcon = new ImageIcon("images.jpeg");

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
                // Aquí puedes implementar acciones cuando se hace clic en la imagen
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        // Dibuja la imagen
        Image image = imageIcon.getImage();
        g2d.drawImage(image, imageX, imageY, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Display");
            ImageDisplay panel = new ImageDisplay();
            frame.add(panel);

            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

