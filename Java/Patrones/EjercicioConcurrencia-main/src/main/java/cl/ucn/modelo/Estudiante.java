package cl.ucn.modelo;

public class Estudiante implements Runnable{

    private String nombre;
    private Tarea tarea;

    private volatile boolean running = true;


    public Estudiante(String nombre, Tarea tarea){

        this.nombre = nombre;
        this.tarea = tarea;

    }

    @Override
    public void run() {

        while (running) {
            try {
                long delay = (long) (Math.random() * 3000);
                Thread.sleep(delay);
                System.out.println(this.nombre + " ha completado la tarea: " + this.tarea.obtenerDescripcionTarea());
            } catch (InterruptedException e) {
                running = false;
                System.out.println(this.nombre + " fue interrumpido - valor de isInterrupted(): ");
            }
        }
        System.out.println(this.nombre + " ha detenido la ejecución.");
    }
}