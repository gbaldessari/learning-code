#include "Nodo.h"
Nodo::Nodo(int _tag,string _dato){
    tag = _tag;
    dato = _dato;
    siguiente = NULL;
};
int Nodo::getTag(){
    return tag;
};
string Nodo::getDato(){
    return dato;
};
Nodo* Nodo::getSiguiente(){
    return siguiente;
};
void Nodo::setSiguiente(Nodo* _siguiente){
    siguiente = _siguiente;
};