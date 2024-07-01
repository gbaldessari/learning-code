package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoRebote extends JFrame {
    private LaminaPelota laminaPelota;

    public MarcoRebote() {
        setBounds(600, 300, 400, 350);
        laminaPelota = new LaminaPelota();
        add(laminaPelota, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();
        add(laminaBotones, BorderLayout.SOUTH);  // Agregar panel de botones al marco

        ponerBoton(laminaBotones, "Iniciar", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comenzarJuego();
            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void ponerBoton(Container panel, String nombre, ActionListener accion) {
        JButton boton = new JButton(nombre);
        panel.add(boton);
        boton.addActionListener(accion);
    }

    public void comenzarJuego() {
        Pelota pelota = new Pelota();
        laminaPelota.add(pelota);
        Runnable hilosPelota = new HilosPelota(pelota, laminaPelota);
        Thread hilosThread = new Thread(hilosPelota);
        hilosThread.start();
    }
}
