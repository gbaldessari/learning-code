package InterfacesGraficas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StackOverflow extends JFrame {
    public static void main(String[] args) {
        new StackOverflow();
    }

    private StackOverflow() {
        setTitle( "Clip with a hole" );
        setSize( 320,300 );
        getContentPane().add( new ClipPanel() );
        setVisible( true );
    }
}

class ClipPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Polygon clip = new Polygon(
                new int[]{ 0, 100, 100,  0,  0, 20, 20, 80, 80,  0 },
                new int[]{ 0,   0,  60, 60, 20, 20, 40, 40, 20, 20 },
                10
            );
        g.setClip(clip);
        g.setColor( Color.BLACK );
        g.fillRect( 0,0,100,60 );
        g.setColor( Color.WHITE );
        g.drawLine( 0,0,100,60 );
    }
}