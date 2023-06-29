#include "Lista.h"
Lista::Lista(){
    primero = NULL;
    largo = 0;
};
Nodo* Lista::get(int pos){

};
int Lista::getPos(string nombre){

};
void Lista::mostrarLista(Nodo* inicial){

};
void Lista::ingresarAlumno(string nombre){
    Nodo* nuevo = new Nodo(0,nombre);
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
void Lista::ingresarNota(string nombre,double nota){
    Nodo* nodoNota = new Nodo(0,to_string(nota));
    int pos = getPos(nombre);
    if(pos==-1){
        ingresarAlumno(nombre);
        Nodo* head = new Nodo(1,to_string((int)nodoNota));
        Nodo* aux = primero->getSiguiente();
        primero->setSiguiente(head);
        head->setSiguiente(aux);
        nodoNota->setSiguiente(nodoNota);
    }
    else{
        Nodo* lista = get(pos)->getSiguiente();
    }
};
double Lista::obtenerPromedio(string nombre){

};