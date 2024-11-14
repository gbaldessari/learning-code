#include <iostream>
using namespace std;

int busquedaSecuencial(int lista[],int largo, int elemento) {
    for (int i = 0; i < largo; ++i) {
        if (lista[i] == elemento) {
            return i;
        }
    }
    return -1;
}

int busquedaBinaria(int lista[], int largo, int elemento) {
    int inicio = 0;
    int fin =  largo- 1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (lista[medio] == elemento) {
            return medio;
        }
        if (lista[medio] < elemento) {
            inicio = medio + 1;
        } else {
            fin = medio - 1;
        }
    }
    return -1;
}

int busquedaInterpolacion(int lista[], int largo, int elemento) {
    int inicio = 0;
    int fin = largo - 1;
    while (inicio <= fin && elemento >= lista[inicio] && elemento <= lista[fin]) {
        int posicion = inicio+((elemento-lista[inicio])*(fin-inicio))/(lista[fin]-lista[inicio]);
        if (lista[posicion] == elemento) {
            return posicion;
        }
        if (lista[posicion] < elemento) {
            inicio = posicion + 1;
        } else {
            fin = posicion - 1;
        }
    }
    return -1;
}
