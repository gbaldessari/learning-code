#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define nFilaA 20000
#define nColA 1000
#define nFilaB 1000
#define nColB 1200

// Definición de matrices globales
int A[nFilaA][nColA];
int B[nFilaB][nColB];
long C[nFilaA][nColB];

// Estructura para pasar argumentos a los hilos
typedef struct {
    int row;
} ThreadData;

// Inicializa las matrices A y B con valores en 1 para la primera prueba
void initializeMatricesWithOnes() {
    for (int i = 0; i < nFilaA; i++)
        for (int j = 0; j < nColA; j++)
            A[i][j] = 1;

    for (int i = 0; i < nFilaB; i++)
        for (int j = 0; j < nColB; j++)
            B[i][j] = 1;
}

// Inicializa las matrices A y B con valores aleatorios para la segunda prueba
void initializeMatricesWithRandomValues() {
    srand(time(NULL));  // Inicializa la semilla para los números aleatorios

    for (int i = 0; i < nFilaA; i++)
        for (int j = 0; j < nColA; j++)
            A[i][j] = rand() % 10;  // Valores aleatorios entre 0 y 9

    for (int i = 0; i < nFilaB; i++)
        for (int j = 0; j < nColB; j++)
            B[i][j] = rand() % 10;  // Valores aleatorios entre 0 y 9
}

// Multiplicación secuencial de matrices
void sequentialMultiplication() {
    for (int i = 0; i < nFilaA; i++) {
        for (int j = 0; j < nColB; j++) {
            C[i][j] = 0;
            for (int k = 0; k < nColA; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
}

// Función que ejecutarán los hilos para calcular una fila de la matriz C
void *multiplyRow(void *arg) {
    ThreadData *data = (ThreadData *)arg;
    int i = data->row;

    for (int j = 0; j < nColB; j++) {
        C[i][j] = 0;
        for (int k = 0; k < nColA; k++) {
            C[i][j] += A[i][k] * B[k][j];
        }
    }

    pthread_exit(NULL);
}

// Multiplicación paralela de matrices usando hilos
void parallelMultiplication() {
    pthread_t threads[nFilaA];
    ThreadData thread_data[nFilaA];

    for (int i = 0; i < nFilaA; i++) {
        thread_data[i].row = i;
        pthread_create(&threads[i], NULL, multiplyRow, (void *)&thread_data[i]);
    }

    for (int i = 0; i < nFilaA; i++) {
        pthread_join(threads[i], NULL);
    }
}

// Muestra los últimos 100 elementos de la última fila de la matriz C
void printLast100Elements() {
    int start = nColB - 100;
    printf("Últimos 100 elementos de la última fila de C:\n");
    for (int i = start; i < nColB; i++) {
        printf("%ld ", C[nFilaA - 1][i]);
    }
    printf("\n");
}

// Función principal para ejecutar la prueba
void runTest(void (*initializeFunc)(), const char *testName) {
    // Inicializa las matrices usando la función proporcionada (valores fijos o aleatorios)
    initializeFunc();

    // Ejecuta y mide el tiempo del algoritmo secuencial
    clock_t start_seq = clock();
    sequentialMultiplication();
    clock_t end_seq = clock();
    double time_seq = (double)(end_seq - start_seq) / CLOCKS_PER_SEC;

    // Muestra los últimos 100 elementos de la última fila
    printf("Resultados con el algoritmo secuencial (%s):\n", testName);
    printLast100Elements();
    printf("Tiempo secuencial: %f segundos\n\n", time_seq);

    // Ejecuta y mide el tiempo del algoritmo paralelo
    clock_t start_par = clock();
    parallelMultiplication();
    clock_t end_par = clock();
    double time_par = (double)(end_par - start_par) / CLOCKS_PER_SEC;

    // Muestra los últimos 100 elementos de la última fila
    printf("Resultados con el algoritmo paralelo (%s):\n", testName);
    printLast100Elements();
    printf("Tiempo paralelo: %f segundos\n", time_par);

    // Calcula la ganancia paralela
    double speedup = time_seq / time_par;
    printf("Ganancia paralela (%s): %f\n\n", testName, speedup);
}

int main() {
    // Prueba con valores fijos en 1
    printf("=== Prueba con valores en 1 ===\n");
    runTest(initializeMatricesWithOnes, "Valores en 1");

    // Prueba con valores aleatorios
    printf("\n=== Prueba con valores aleatorios ===\n");
    runTest(initializeMatricesWithRandomValues, "Valores aleatorios");

    return 0;
}
