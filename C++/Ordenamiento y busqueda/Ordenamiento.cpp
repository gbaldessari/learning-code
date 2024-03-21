#include <iostream>
using namespace std;


void ordenamiento_burbuja(int lista[], int largo) {
    for (int i = 0; i < largo - 1; i++) {
        for (int j = i+1; j < largo - 1; j++) {
            if (lista[i] > lista[j]) {
                int aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        }
    }
}

void selectionSort(int lista[], int largo) {
    for (int i = 0; i < largo - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < largo; j++) {
            if (lista[j] < lista[minIndex]) {
                minIndex = j;
            }
        }
        int aux = lista[minIndex];
        lista[minIndex] = lista[i];
        lista[i] = aux;
    }
}

void insertionSort(int lista[], int largo) {
    for (int i = 1; i < largo; i++) {
        int aux = lista[i];
        int j = i - 1;
        while (j >= 0 && lista[j] > aux) {
            lista[j + 1] = lista[j];
            j--;
        }
        lista[j + 1] = aux;
    }
}
