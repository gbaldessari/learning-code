#include <iostream>
using namespace std;

void bubbleSort(int lista[]) {
    int largo = sizeof(lista)/4;
    for (int i = 0; i < largo - 1; i++) {
        for (int j = 0; j < largo - i - 1; j++) {
            if (lista[j] > lista[j + 1]) {
                // Intercambiar elementos si están en el orden incorrecto
                int temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
}

void selectionSort(int lista[]) {
    int largo = sizeof(lista)/4;
    for (int i = 0; i < largo - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < largo; j++) {
            if (lista[j] < lista[minIndex]) {
                minIndex = j;
            }
        }
        // Intercambiar el elemento mínimo encontrado con el primer elemento sin ordenar
        int temp = lista[minIndex];
        lista[minIndex] = lista[i];
        lista[i] = temp;
    }
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            // Intercambiar elementos si el elemento actual es menor que el pivote
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // Colocar el pivote en su posición correcta
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return (i + 1);
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
