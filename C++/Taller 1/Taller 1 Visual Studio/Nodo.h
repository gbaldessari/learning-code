#include <iostream>
#include <string>
using namespace std;
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
        void setDato(string);
        void setColumna(int);
        void setFila(int);
        void setDerecha(Nodo*);
        void setIzquierda(Nodo*);
        void setLista(Nodo*);
        void setArriba(Nodo*);
        void setAbajo(Nodo*);
        /*
            Esta función obtiene el promedio de las notas del alumno
            @return Promedio de las notas
        */
        double getPromedio();
        /*
            Esta función permite ingresar una nota a la lista de notas
            @param string La nota a ingresar
        */
        void ingresarNota(string); 
}; 