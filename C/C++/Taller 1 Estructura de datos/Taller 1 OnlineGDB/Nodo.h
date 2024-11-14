#pragma once
#include <iostream>

using std::string;

class Nodo{
    private:
        string dato;
        int columna;
        int fila;
        Nodo* lista;
        Nodo* derecha;
        Nodo* izquierda;
        Nodo* arriba;
        Nodo* abajo;
    public:
        Nodo();
        string getDato();
        int getColumna();
        int getFila();
        Nodo* getLista();
        Nodo* getDerecha();
        Nodo* getIzquierda();
        Nodo* getArriba();
        Nodo* getAbajo();
        void setDato(string _dato);
        void setColumna(int _columna);
        void setFila(int _fila);
        void setDerecha(Nodo* _derecha);
        void setIzquierda(Nodo* _izquierda);
        void setArriba(Nodo* _arriba);
        void setAbajo(Nodo* _abajo);
        void setLista(Nodo* _lista);
        /*
            Esta función obtiene el promedio de las notas del alumno
            @return Promedio de las notas
        */
        double getPromedio();
        /*
            Esta función permite ingresar una nota a la lista de notas
            @param string La nota a ingresar
        */
        void ingresarNota(string nota); 
}; 