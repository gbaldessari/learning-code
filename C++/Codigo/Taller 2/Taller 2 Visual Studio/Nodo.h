#include <iostream>
#include <string.h>
#include <stdio.h>
using namespace std;
class Nodo
{
private:
    int tablero[3][3];
    Nodo* n0;
    Nodo* n1;
    Nodo* n2;
    Nodo* n3;
    Nodo* n4;
    Nodo* n5;
    Nodo* n6;
    Nodo* n7;
public:
    Nodo* getNodo0();
    Nodo(int tablero[3][3]);
    int getPrioridad(int dificultad);
    int getSumaPuntos();
    Nodo* seleccionarMovimiento(Nodo* nodoActual,int dificultad);
    void generarNodos();
    void ingresarMovimiento();
    void imprimirTablero();
};