package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarreteraInclinacionVariableApp extends JFrame {

    private int anchoSuperior = 200; // Ancho de la carretera en la parte superior
    private int anchoInferior = 200; // Ancho de la carretera en la parte inferior
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
                dibujarCarreteraInclinacionVariable((Graphics2D) g, getWidth() / 2, getHeight());
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
                anchoInferior += deltaY;
                anchoSuperior -= deltaY;
                if(anchoSuperior<=10){
                    anchoSuperior = 10;
                } else if(anchoSuperior>=200){
                    anchoSuperior = 200;
                }
                if(anchoInferior <=200){
                    anchoInferior = 200;
                } else if(anchoInferior >= 400){
                    anchoInferior = 400;
                }
                inclinacion = nuevaInclinacion;

                // Redibujar la carretera
                panel.repaint();
            }
        });

        add(panel);

        setVisible(true);
    }

    private void dibujarCarreteraInclinacionVariable(Graphics2D g2d, int x, int altura) {
        // Calcular el ancho de la carretera en función de la inclinación
        int anchoActual = anchoSuperior;

        int[] xPoints = {
                x - anchoActual / 2, x + anchoActual / 2,
                x + anchoInferior / 2, x - anchoInferior / 2
        };

        int[] yPoints = {0, 0, altura, altura};

        // Configurar el color y rellenar el polígono
        g2d.setColor(Color.GRAY); // Puedes ajustar el color según tus preferencias
        g2d.fillPolygon(xPoints, yPoints, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarreteraInclinacionVariableApp());
    }
}
