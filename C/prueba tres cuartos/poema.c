#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

// Arreglo global para almacenar los tiempos de espera
int sleep_times[4];

// Estructura para pasar argumentos a los hilos
typedef struct {
    int index; // Índice del verso
} thread_params_t;

// Función que será ejecutada por cada hilo
void* wait_and_signal(void* arg) {
    thread_params_t* params = (thread_params_t*)arg;
    int index = params->index;

    sleep(sleep_times[index]); // Dormir el tiempo asignado
    pthread_exit(NULL);
}

int main() {
    srand(getpid()); // Semilla para generar números aleatorios

    // Inicializar los tiempos de espera
    for (int i = 0; i < 4; i++) {
        sleep_times[i] = (rand() % 10) + 1;
    }

    // Versos en el orden correcto
    const char* verses[] = {
        "Dame la mano y danzaremos,",
        "dame la mano y me amaras.",
        "Como una sola flor seremos,",
        "como una flor, y nada mas..."
    };

    pthread_t threads[4]; // Arreglo para los identificadores de los hilos

    // Crear los hilos
    for (int i = 0; i < 4; i++) {
        thread_params_t* params = malloc(sizeof(thread_params_t));
        params->index = i;

        if (pthread_create(&threads[i], NULL, wait_and_signal, (void*)params) != 0) {
            perror("Error al crear el hilo");
            return 1;
        }
    }

    // Esperar a cada hilo en orden
    for (int i = 0; i < 4; i++) {
        if (pthread_join(threads[i], NULL) != 0) {
            perror("Error al unir el hilo");
            return 1;
        }

        // Imprimir el verso correspondiente una vez que el hilo termina
        printf("Verso %d: %s\n", i + 1, verses[i]);
    }

    printf("Todos los versos han sido escritos en orden.\n");
    return 0;
}
