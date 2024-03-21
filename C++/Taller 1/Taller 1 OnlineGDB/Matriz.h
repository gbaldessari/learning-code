#pragma once
#include <iostream>
#include "Nodo.h"

using std::string;

class Matriz
{
private:
    Nodo* col;
    Nodo* fil;
public:
    Matriz();
    /*
        Esta función permite obtener la posicion de la columna
        @param string Dato a buscar en las columnas
        @return La posicion de la columna
    */
    int getPosColumna(string _dato);
    /*
        Esta función permite obtener el puntero de la columna
        @param string Dato a buscar en las columnas
        @return El puntero de la columna
    */
    Nodo* getColumna(string _dato);
    /*
        Esta función permite obtener la posicion de la fila
        @param string Dato a buscar en las filas
        @return La posicion de la fila
    */
    int getPosFila(string _dato);
    /*
        Esta función permite obtener el puntero de la fila
        @param string Dato a buscar en las filas
        @return El puntero de la fila
    */ 
    Nodo* getFila(string _dato);
    /*
        Esta función permite obtener el puntero de un nodo en la matriz
        @param int Fila del nodo
        @param int Columna del nodo
        @return El puntero del nodo
    */
    Nodo* getNodo(int _fila,int _columna);
    /*
        Esta función permite ingresar una nueva columna
        @param string Dato de la columna
    */
    void agregarColumna(string _dato);
    /*
        Esta función permite ingresar una nueva fila
        @param string Dato de la fila
    */
    void agregarFila(string _dato);
    /*
        Esta función permite eliminar una columna
        @param string Dato de la columna
        @return si se llevo a cabo la eliminacion
    */
    bool eliminarColumna(string dato);
    /*
        Esta función permite eliminar una fila
        @param string Dato de la fila
        @return si se llevo a cabo la eliminacion
    */
    bool eliminarFila(string dato);
    /*
        Esta función permite ingresar un nodo en la matriz
        @param int Fila del nodo
        @param int Columna del nodo
        @return El puntero del nodo
    */
    Nodo* ingresarNodo(int _fila,int _columna);
}; 