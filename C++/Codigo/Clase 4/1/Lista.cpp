#include "Lista.h"
Lista::Lista()
{
    primero = NULL;
    largo  = 0;
};
Nodo* Lista::get(int pos){
    if(primero == NULL||pos>=largo){
        return NULL;
    }
    Nodo* nodo = primero;
    for (int i = 0; i < pos; i++)
    {
        nodo = nodo->getSiguiente();
    }
    return nodo;
};
int Lista::lenght(){
    return largo;
};
double Lista::getPromedio(){
    if(largo==0){return 0;}
    Nodo* aux = primero->getSiguiente();

    double suma=primero->getDato();
    while (aux!=primero)
    {
        suma += aux->getDato();
        aux = aux->getSiguiente();
    }
    
    return (suma/largo);
};
void Lista::add(double dato){
    Nodo* nuevo = new Nodo(dato);
    if(primero == NULL){
        primero = nuevo;
        nuevo->setSiguiente(nuevo);
    }
    else{
        nuevo->setSiguiente(primero);
        primero = nuevo;
        Nodo* aux = primero->getSiguiente();
        while (aux->getSiguiente()!=primero->getSiguiente())
        {
            aux = aux->getSiguiente();
        }
        aux->setSiguiente(primero);
    }
    largo++;
};