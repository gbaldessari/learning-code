package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarreteraInclinacionVariableApp extends JFrame {

    private final int anchoPorDefecto = 200;
    private int anchoSuperior = anchoPorDefecto; // Ancho de la carretera en la parte superior
    private int anchoInferior = anchoPorDefecto; // Ancho de la carretera en la parte inferior
    private int inclinacion = 0; // Inclinación inicial

    public CarreteraInclinacionVariableApp() {
        setTitle("Carretera con Inclinación Variable");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarCarreteraInclinacionVariable((Graphics2D) g, getWidth() / 3, getWidth() / 2, 100,getHeight());
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Guardar la posición vertical del ratón al hacer clic
                inclinacion = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Calcular la variación de inclinación y actualizar
                int nuevaInclinacion = e.getY();
                int deltaY = nuevaInclinacion - inclinacion;
                inclinacion = nuevaInclinacion;

                anchoInferior += deltaY;
                anchoSuperior -= deltaY;

                // Redibujar la carretera
                panel.repaint();
            }
        });

        add(panel);

        setVisible(true);
    }

    private void dibujarCarreteraInclinacionVariable(Graphics2D g2d, int x1, int x2, int y1, int y2) {
        // Calcular el ancho de la carretera en función de la inclinación
        final int limiteAnchoSuperior = 10 * Math.abs(y2-y1)/getHeight();
        final int limiteAnchoInferior = 400 * Math.abs(y2-y1)/getHeight();
        if(anchoSuperior <= limiteAnchoSuperior){
            anchoSuperior = limiteAnchoSuperior;
        } else if(anchoSuperior>=anchoPorDefecto){
            anchoSuperior = anchoPorDefecto;
        }
        if(anchoInferior <= anchoPorDefecto){
            anchoInferior = anchoPorDefecto;
        } else if(anchoInferior >= limiteAnchoInferior){
            anchoInferior = limiteAnchoInferior;
        }

        int[] xPoints = {
                x1 - anchoSuperior / 2, x1 + anchoSuperior / 2,
                x2 + anchoInferior / 2, x2 - anchoInferior / 2
        };

        int[] yPoints = {y1, y1, y2, y2};

        // Configurar el color y rellenar el polígono
        g2d.setColor(Color.GRAY); // Puedes ajustar el color según tus preferencias
        g2d.fillPolygon(xPoints, yPoints, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarreteraInclinacionVariableApp());
    }
}
