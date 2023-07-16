#include <iostream>
using namespace std;

bool busquedaSecuencial(int lista[], int elemento) {
    for (int i = 0; i < (sizeof(lista)/4); ++i) {
        if (lista[i] == elemento) {
            return true;
        }
    }
    return false;
}

bool busquedaBinaria(int lista[], int elemento) {
    int inicio = 0;
    int fin = sizeof(lista)/4 - 1;
    while (inicio <= fin) {
        int medio = inicio + (fin - inicio) / 2;
        
        if (lista[medio] == elemento) {
            return true;
        }
        
        if (lista[medio] < elemento) {
            inicio = medio + 1;
        } else {
            fin = medio - 1;
        }
    }
    return false;
}

bool busquedaInterpolacion(int lista[], int elemento) {
    int inicio = 0;
    int fin = sizeof(lista)/4 - 1;
    
    while (inicio <= fin && elemento >= lista[inicio] && elemento <= lista[fin]) {
        int posicion = inicio + ((elemento - lista[inicio]) * (fin - inicio)) / (lista[fin] - lista[inicio]);
        
        if (lista[posicion] == elemento) {
            return true;
        }
        
        if (lista[posicion] < elemento) {
            inicio = posicion + 1;
        } else {
            fin = posicion - 1;
        }
    }
    
    return false;
}
