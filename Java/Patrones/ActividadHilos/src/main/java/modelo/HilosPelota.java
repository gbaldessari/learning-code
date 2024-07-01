package modelo;

public class HilosPelota implements Runnable {

    private Pelota pelota;
    private LaminaPelota laminaPelota;

    public HilosPelota(Pelota pelota, LaminaPelota laminaPelota) {
        this.pelota = pelota;
        this.laminaPelota = laminaPelota;
    }

    @Override
    public void run() {
        for (int i = 1; i < 3000; i++) {
            pelota.muevePelota(laminaPelota.getBounds());
            laminaPelota.repaint();  // repaint en vez de paint
            try {
                Thread.sleep(5); // Aumentar el tiempo de sueño para ver mejor el movimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
