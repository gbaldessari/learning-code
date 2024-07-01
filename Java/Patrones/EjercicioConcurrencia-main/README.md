# Ejercicio de Concurrencia
## Uso de la clase Thread e Interfaz Runnable

---
### Contexto 
El proyecto ConcProfEst muestra estudiantes realizando una determinada tarea propuesta por un profesor, el cual consiste
en escribir un código en lenguaje Java. El trabajo se realiza y se presenta en grupo, por lo que los estudiantes decidieron
aprender solo una porción de lo que deben codificar, por lo que al lanzar este programa, las ejecuciones siempre se dan 
en forma secuencial.

El profesor al ver este problema decide implementar concurrencia, para que los estudiantes muestren que pueden programar 
cualquier parte del código, es decir, que cada estudiante conoce el programa por completo y por lo tanto, lo podrían 
programar individualmente.

---

### Tarea

Implemente el mecanismo de concurrencia para que las tareas de programación no sean implementadas en orden secuencial. 
Para esto, utilize la clase Thread e Interfaz Runnable donde sea necesario y modifique la clase MainVUI para ejecutar el 
proyecto correctamente.

---
### Pasos para convertir nuestro proyecto monotarea en concurrente:

1. Identificar quien realizar la tarea. En este caso es el estudiante que realiza una tarea de programación.
2. Implementar la interfaz Runnable: Estudiante debe implementar la interfaz Runnable para implementar el método run()
3. Implementar método **run()**: La tarea del estudiante se ejecurará concurrentemente:
4. Crear los hilos en el programa principal, con la clase Thread.

---
## Interrumpir la ejecución de un hilo.

Para detener la ejecución de un hilo, debemos hacerlo en forma segura. Para esto, se utilizarán los métodos 
**isInterrupted()** e  **interrupted()**. 

1. **isInterrupted()**: Prueba si este hilo ha sido interrumpido. El estado de interrupción del hilo no se ve afectado por este método.
2. **interrupted()**: Prueba si el hilo actual ha sido interrumpido. El estado de interrupción del hilo se borra con 
este método. En otras palabras, si este método se llamara dos veces consecutivamente, la segunda llamada devolvería **false**.

El código que se muestra a continuación corresponder con el método **run()**. Al inicio la variable running es verdadera por lo que entrará al ciclo **while** y ejecutará la tarea que se encuentra
dentro de un bloque try - catch con **InterruptedException** porque se está utilizando el método Thread.sleep para dormir
al hilo un tiempo random. 

```java
   public void run() {
1        while (running) {
2           try {
3                    long delay = (long) (Math.random() * 3000);
4                    Thread.sleep(delay);
5                    System.out.println(this.nombre + " ha completado la tarea: " + this.tarea.obtenerDescripcionTarea());
6                } catch (InterruptedException e) {
8                   running = false;
9                   System.out.println(this.nombre + " fue interrumpido.");
10               }
11        }
12       System.out.println(this.nombre + " ha detenido la ejecución.");
   }
 ```
De acuerdo con nuestro programa existe un segundo botón que parará la ejecución del programa de manera segura. El siguiente
código que se encuentra en la clase MainVUI, utiliza el método interrupt() para detener la ejecución. 

```java
    private void pararEjecucion() {

        isRunning = false;

        // Interrumpir todos los hilos de estudiantes
        for (Thread thread : hiloEstudiantes) {
            thread.interrupt();
        }

        estudiantes.clear();
        hiloEstudiantes.clear();
        System.out.println("Ejecución detenida.");
    }
```
Como se observa, los hilos de ejecución (cada estudiante), está almacenado en una estructura de datos que en este caso es una 
lista. Por lo tanto, para cada hilo almacenado, se cambiará la bandera de interrupción a verdadero, es decir, que ha sido interrumpido.
Sin embargo si usted imprime el valor de isInterrupted, en el código del método run() bloque catch, este será falso porque 
la excepción borra el estado de interrupción. Todos los hilos serán interrupidos por lo cual es seguro terminar el programa, con la condición
de running en falso.

Por lo tanto para que se refleje **isInterrupted()** como verdadero se debe escribir la línea de código: ```java Thread.currentThread().interrupt();``` en el bloque catch y reponer la interrupción.







