#include <iostream>
using namespace std;

class Nodo{
    private:
        double dato;
        Nodo* siguiente;
    public:
        Nodo(){
            dato = 0;
            siguiente = NULL;
        };
        double getDato(){
            return dato;
        };
        Nodo* getSiguiente(){
            return siguiente;
        };
        void setDato(double _dato){
            dato = _dato;
        };
        void setSiguiente(Nodo* _siguiente){
            siguiente = _siguiente;
        };
};