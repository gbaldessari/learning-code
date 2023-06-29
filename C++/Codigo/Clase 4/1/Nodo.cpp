#include "Nodo.h"
Nodo::Nodo(double _dato){
    dato = _dato;
    siguiente = NULL;
};
double Nodo::getDato(){
    return dato;
};
Nodo* Nodo::getSiguiente(){
    return siguiente;
};
void Nodo::setSiguiente(Nodo* _siguiente){
    siguiente = _siguiente;
};
