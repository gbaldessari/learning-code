#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

// Semáforos globales
sem_t semUno, semDos;

// Función para generar un número aleatorio entre 1 y 10
int duerme() {
    int MINI = 1, MAXI = 10;
    return (MINI + rand() % (MAXI - MINI + 1));
}

// Función que ejecuta hiloUno
void *algoUno(void *arg) {
    while (1) {
        sem_wait(&semUno);
        printf("Hilo uno pasando\n");
        sem_post(&semDos);
        sleep(duerme());
    }
    return NULL;
}

// Función que ejecuta hiloDos
void *algoDos(void *arg) {
    while (1) {
        sem_wait(&semDos);
        printf("Hilo dos pasando\n");
        sem_post(&semUno);
        sleep(duerme());
    }
    return NULL;
}

int main() {
    pthread_t hiloUno, hiloDos;

    // Inicializar semilla de números aleatorios
    srand(time(NULL));

    // Inicializar los semáforos
    sem_init(&semUno, 0, 1); // Hilo uno comienza
    sem_init(&semDos, 0, 0); // Hilo dos espera

    // Crear los hilos una sola vez
    pthread_create(&hiloUno, NULL, algoUno, NULL);
    pthread_create(&hiloDos, NULL, algoDos, NULL);

    // Esperar a que los hilos terminen (aunque esto nunca sucederá por el bucle infinito)
    pthread_join(hiloUno, NULL);
    pthread_join(hiloDos, NULL);

    // Liberar los semáforos
    sem_destroy(&semUno);
    sem_destroy(&semDos);

    return 0;
}
