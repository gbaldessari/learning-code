package org.example;

import java.util.concurrent.*;

public class EjemploConcurrenciaComplejo {

    public static void main(String[] args) {
        // Crear un pool de hilos con 3 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Crear una lista de tareas
        Callable<String> tarea1 = new MiTarea("Tarea 1");
        Callable<String> tarea2 = new MiTarea("Tarea 2");
        Callable<String> tarea3 = new MiTarea("Tarea 3");

        // Enviar tareas al ExecutorService y obtener los resultados futuros
        Future<String> futuro1 = executorService.submit(tarea1);
        Future<String> futuro2 = executorService.submit(tarea2);
        Future<String> futuro3 = executorService.submit(tarea3);

        try {
            // Obtener los resultados de las tareas
            String resultado1 = futuro1.get();
            String resultado2 = futuro2.get();
            String resultado3 = futuro3.get();

            System.out.println("Resultado 1: " + resultado1);
            System.out.println("Resultado 2: " + resultado2);
            System.out.println("Resultado 3: " + resultado3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Apagar el ExecutorService
            executorService.shutdown();
        }
    }

    // Clase que implementa la interfaz Callable para definir una tarea que devuelve un resultado
    static class MiTarea implements Callable<String> {
        private String nombre;

        public MiTarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String call() throws Exception {
            // Simulamos una tarea que toma algún tiempo
            for (int i = 0; i < 5; i++) {
                System.out.println("Ejecutando " + nombre + " - Iteración " + i);
                Thread.sleep((long) (Math.random() * 1000)); // Dormir entre 0 y 1 segundo
            }
            return nombre + " ha terminado.";
        }
    }
}
