package org.example;

public class EjemploConcurrencia {

    public static void main(String[] args) {
        // Creamos dos objetos Runnable que representan tareas concurrentes
        Runnable tarea1 = new MiTarea("Tarea 1");
        Runnable tarea2 = new MiTarea("Tarea 2");

        // Creamos dos hilos y les asignamos las tareas
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        // Iniciamos la ejecución de los hilos
        hilo1.start();
        hilo2.start();
    }

    // Clase que implementa la interfaz Runnable para definir una tarea
    static class MiTarea implements Runnable {
        private String nombre;

        public MiTarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            // Simulamos una tarea que toma algún tiempo
            for (int i = 0; i < 5; i++) {
                System.out.println("Ejecutando " + nombre + " - Iteración " + i);
                try {
                    Thread.sleep((long) (Math.random() * 1000)); // Dormir entre 0 y 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nombre + " ha terminado.");
        }
    }
}
