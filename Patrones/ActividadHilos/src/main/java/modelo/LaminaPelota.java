package modelo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LaminaPelota extends JPanel {
    private ArrayList<Pelota> pelotas = new ArrayList<>();

    public void add(Pelota pelota) {
        pelotas.add(pelota);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Pelota pelota : pelotas) {
            g2d.fill(pelota.getShape());
        }
    }
}
