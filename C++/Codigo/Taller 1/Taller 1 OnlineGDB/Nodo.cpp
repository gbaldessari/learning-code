#include "Nodo.h"
#include <iostream>

using std::string;

Nodo::Nodo(){
    dato = "";
    columna = 0;
    fila = 0;
    lista = NULL;
    derecha = NULL; 
    izquierda = NULL;
    arriba = NULL;
    abajo = NULL;
}

string Nodo::getDato(){
    return dato;
}

int Nodo::getColumna(){
    return columna;
}

int Nodo::getFila(){
    return fila;
}

Nodo* Nodo::getLista(){
    return lista;
}

Nodo* Nodo::getDerecha(){
    return derecha;
}

Nodo* Nodo::getIzquierda(){
    return izquierda;
}

Nodo* Nodo::getArriba(){
    return arriba;
}

Nodo* Nodo::getAbajo(){
    return abajo;
}

double Nodo::getPromedio(){
    if(lista==NULL){
        return 0;
    }
    Nodo* aux = lista;
    double promedio = 0;
    int cont = 0;
    while(aux != NULL){
        cont++;
        promedio+=stod(aux->getDato());
        aux = aux->getDerecha();
    }
    promedio = promedio/cont;
    return promedio;
}

void Nodo::setDato(string _dato){
    dato = _dato;
}

void Nodo::setColumna(int _columna){
    columna = _columna;
}

void Nodo::setFila(int _fila){
    fila = _fila;
}

void Nodo::setDerecha(Nodo* _derecha){
    derecha = _derecha;
}

void Nodo::setIzquierda(Nodo* _izquierda){
    izquierda = _izquierda;
}

void Nodo::setArriba(Nodo* _arriba){
    arriba = _arriba;
}

void Nodo::setAbajo(Nodo* _abajo){
    abajo = _abajo;
}

void Nodo::setLista(Nodo* _lista){
    lista = _lista;
}

void Nodo::ingresarNota(string nota){
    Nodo* nodo = new Nodo();
    nodo->setDato(nota);
    if(lista==NULL){
        lista = nodo;
    }
    else{
        Nodo* aux = lista;
        while (aux->getDerecha()!=NULL)
        {
            aux = aux->getDerecha();
        }
        aux->setDerecha(nodo);
        nodo->setIzquierda(aux);
    }
}