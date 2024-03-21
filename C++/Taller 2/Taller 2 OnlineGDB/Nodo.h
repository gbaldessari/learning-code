#pragma once
#include <iostream>
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
    Nodo(int tablero[3][3]);
    /*
        Esta funcion obtiene la prioridad de un estado de la partida
        @param int La dificultad de la partida
        @return La prioridad del estado
    */
    int getPrioridad(int dificultad);
    /*
        Esta funcion obtiene los espacios usados del tablero
        @return Los espacios usados del tablero
    */
    int getSumaPuntos();
    /*
        Esta funcion selecciona el estado de la partida mas conveniente para la maquina
        @param Nodo* El estado actual de la partida
        @param int La dificultad de la partida
        @return El estado mas conveniente
    */
    Nodo* seleccionarMovimiento(Nodo* nodoActual,int dificultad);
    /*
        Esta funcion genera los estados posibles de la partida
    */
    void generarNodos();
    /*
        Esta funcion permite ingresar un movimiento al jugador
    */
    void ingresarMovimiento();
    /*
        Esta funcion permite ver el estado actual del tablero
    */
    void imprimirTablero();
    /*
        Esta funcion obtiene el nodo hijo mas a la izquierda de la raiz
        @return El nodo mas a la izquierda
    */
    Nodo* getNodo0();
};