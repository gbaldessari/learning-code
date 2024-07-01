package modelo;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Pelota {
    public static final int TAMX = 15;
    public static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx;
    private double dy;

    public Pelota() {
        Random rand = new Random();
        dx = rand.nextDouble() * 2 - 1; // Velocidad aleatoria entre -1 y 1
        dy = rand.nextDouble() * 2 - 1; // Velocidad aleatoria entre -1 y 1
    }

    public Shape getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    public void muevePelota(Rectangle2D limites) {
        x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }

        // Asegurarse de que las velocidades no sean cero
        if (dx == 0) {
            dx = 1;
        }
        if (dy == 0) {
            dy = 1;
        }
    }
}
