#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define ARRAY_SIZE 2000000
#define REPEAT_COUNT 1000  // Número de repeticiones para mejor precisión

// Variables globales
int array[ARRAY_SIZE];
long SUMA = 0;
pthread_mutex_t mutex;  // Exclusión mutua para la suma compartida
int global_num_threads;  // Variable global para el número de hilos en paralelo

// Inicializa el arreglo con todos sus valores en 1 para la primera prueba
void initializeArrayWithOnes() {
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = 1;
    }
}

// Inicializa el arreglo con valores aleatorios entre 0 y 9 para la segunda prueba
void initializeArrayWithRandomValues() {
    srand(time(NULL));
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = rand() % 10;
    }
}

// Suma secuencial de los elementos del arreglo
long sequentialSum() {
    long sum = 0;
    for (int i = 0; i < ARRAY_SIZE; i++) {
        sum += array[i];
    }
    return sum;
}

// Estructura para pasar datos a los hilos
typedef struct {
    int start;
    int end;
} ThreadData;

// Función que ejecutan los hilos para realizar la suma parcial
void *partialSum(void *arg) {
    ThreadData *data = (ThreadData *)arg;
    long partial_sum = 0;

    for (int i = data->start; i < data->end; i++) {
        partial_sum += array[i];
    }

    pthread_mutex_lock(&mutex);  // Exclusión mutua
    SUMA += partial_sum;
    pthread_mutex_unlock(&mutex);

    pthread_exit(NULL);
}

// Función para calcular la suma en paralelo con el número de hilos definido en global_num_threads
long parallelSum() {
    pthread_t threads[global_num_threads];
    ThreadData thread_data[global_num_threads];
    int segment_size = ARRAY_SIZE / global_num_threads;

    // Reiniciar la variable global de suma
    SUMA = 0;

    for (int i = 0; i < global_num_threads; i++) {
        thread_data[i].start = i * segment_size;
        thread_data[i].end = (i == global_num_threads - 1) ? ARRAY_SIZE : (i + 1) * segment_size;
        pthread_create(&threads[i], NULL, partialSum, (void *)&thread_data[i]);
    }

    for (int i = 0; i < global_num_threads; i++) {
        pthread_join(threads[i], NULL);
    }

    return SUMA;
}

// Función para medir el tiempo promedio de ejecución de una función de suma
double measureExecutionTime(long (*sumFunction)(), int repetitions) {
    clock_t start = clock();
    long result;
    for (int i = 0; i < repetitions; i++) {
        result = sumFunction();
    }
    clock_t end = clock();
    return (double)(end - start) / CLOCKS_PER_SEC / repetitions;
}

// Función de prueba que calcula la ganancia paralela
void runTest(const char *testName, void (*initializeFunc)()) {
    initializeFunc();

    // Suma secuencial
    double time_seq = measureExecutionTime(sequentialSum, REPEAT_COUNT);
    long seq_result = sequentialSum();

    printf("Resultados (%s) - Suma secuencial:\n", testName);
    printf("Suma total: %ld\n", seq_result);
    printf("Tiempo secuencial promedio: %f segundos\n\n", time_seq);

    // Prueba con diferentes números de hilos
    int thread_counts[] = {2, 4, 10};
    for (int i = 0; i < 3; i++) {
        global_num_threads = thread_counts[i];

        // Mide el tiempo para la suma en paralelo con el número específico de hilos
        double time_par = measureExecutionTime(parallelSum, REPEAT_COUNT);
        long par_result = parallelSum();

        // Cálculo de la ganancia paralela
        double speedup = time_seq / time_par;

        printf("Resultados (%s) - %d hilos:\n", testName, global_num_threads);
        printf("Suma total: %ld\n", par_result);
        printf("Tiempo paralelo promedio (%d hilos): %f segundos\n", global_num_threads, time_par);
        printf("Ganancia paralela: %f\n\n", speedup);
    }
}

int main() {
    pthread_mutex_init(&mutex, NULL);

    // Prueba con valores en 1
    printf("=== Prueba con valores en 1 ===\n");
    runTest("Valores en 1", initializeArrayWithOnes);

    // Prueba con valores aleatorios
    printf("\n=== Prueba con valores aleatorios ===\n");
    runTest("Valores aleatorios", initializeArrayWithRandomValues);

    pthread_mutex_destroy(&mutex);
    return 0;
}
