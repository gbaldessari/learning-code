package vista;

import modelo.MarcoRebote;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new MarcoRebote();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
