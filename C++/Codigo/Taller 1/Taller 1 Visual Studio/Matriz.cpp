#include "Matriz.h"
Matriz::Matriz(){
    col = NULL;
    fil = NULL;
};
int Matriz::getPosColumna(string _dato){
    Nodo* aux = col;
    while (aux!=NULL && aux->getDato()!=_dato)
    {
        aux=aux->getDerecha();
    }
    if(aux==NULL){
        return 0;
    }
    return aux->getColumna();
};
Nodo* Matriz::getColumna(string _dato){
    Nodo* aux = col;
    while (aux!=NULL && aux->getDato()!=_dato)
    {
        aux=aux->getDerecha();
    }
    return aux;
};
int Matriz::getPosFila(string _dato){
    Nodo* aux = fil;
    while (aux!=NULL && aux->getDato()!=_dato)
    {
        aux=aux->getAbajo();
    }
    if(aux==NULL){
        return 0;
    }
    return aux->getFila();
};
Nodo* Matriz::getFila(string _dato){
    Nodo* aux = fil;
    while (aux!=NULL && aux->getDato()!=_dato)
    {
        aux=aux->getAbajo();
    }
    return aux;
};
Nodo* Matriz::getNodo(int _fila,int _columna){
    Nodo* aux = fil;
    while (aux!=NULL && aux->getFila()!=_fila)
    {
        aux = aux->getAbajo();
    }
    if(aux==NULL){
        return NULL;
    }
    else{
        while (aux != NULL && aux->getColumna()!=_columna)
        {
            aux = aux->getDerecha();
        }
        if(aux == NULL){
            return NULL;
        }
    }
    return aux;
};
void Matriz::agregarColumna(string _dato){
    Nodo* nodo = new Nodo();
    nodo->setDato(_dato);

    if(col == NULL){
        nodo->setColumna(1);
        col = nodo;
    }
    else{
        Nodo* aux = col;
        int cont = 1;
        while (aux->getDerecha()!=NULL&&cont==aux->getColumna())
        {
            cont++;
            aux = aux->getDerecha();
        }

        if(cont==1<aux->getColumna()){
            col->setIzquierda(nodo);
            nodo->setDerecha(col);
            col = nodo;
        }
        else if(cont<aux->getColumna()){
            nodo->setIzquierda(aux->getIzquierda());
            aux->setIzquierda(nodo);
            aux->getIzquierda()->setDerecha(nodo);
            nodo->setDerecha(aux);
        }
        else{
            cont++;
            nodo->setIzquierda(aux);
            aux->setDerecha(nodo);
        }
        nodo->setColumna(cont);
    }
};
void Matriz::agregarFila(string _dato){
    Nodo* nodo = new Nodo();
    nodo->setDato(_dato);

    if(fil == NULL){
        nodo->setFila(1);
        fil = nodo;
    }
    else{
        Nodo* aux = fil;
        int cont = 1;
        while (aux->getAbajo()!=NULL&&cont==aux->getFila())
        {
            cont++;
            aux = aux->getAbajo();
        }

        if(cont==1<aux->getFila()){
            fil->setArriba(nodo);
            nodo->setAbajo(fil);
            fil = nodo;
        }
        else if(cont<aux->getFila()){
            nodo->setArriba(aux->getArriba());
            aux->setArriba(nodo);
            aux->getArriba()->setAbajo(nodo);
            nodo->setAbajo(aux);
        }
        else{
            cont++;
            nodo->setArriba(aux);
            aux->setAbajo(nodo);
        }
        nodo->setFila(cont);
    }
};
bool Matriz::eliminarColumna(string dato){
    Nodo* aux = col;
    while (aux!=NULL && aux->getDato()!=dato)
    {
        aux = aux->getDerecha();
    }

    if(aux==col){
        col = NULL;
    }
    if(aux ==NULL){
        return false;
    }
    else{
        while (aux!=NULL)
        {
            if(aux->getIzquierda()!=NULL){aux->getIzquierda()->setDerecha(aux->getDerecha());}
            if(aux->getDerecha()!=NULL){aux->getDerecha()->setIzquierda(aux->getIzquierda());}
            aux->setArriba(NULL);
            aux = aux->getAbajo();
        }
    }
    return true;
};
bool Matriz::eliminarFila(string dato){
    Nodo* aux = fil;
    while (aux!=NULL && aux->getDato()!=dato)
    {
        aux = aux->getAbajo();
    }

    if(aux==fil){
        fil = NULL;
    }
    if(aux ==NULL){
        return false;
    }
    else{
        while (aux!=NULL)
        {
            if(aux->getArriba()!=NULL){aux->getArriba()->setAbajo(aux->getAbajo());}
            if(aux->getAbajo()!=NULL){aux->getAbajo()->setArriba(aux->getArriba());}
            aux->setIzquierda(NULL);
            aux = aux->getDerecha();
        }
    }
    return true;
};
Nodo* Matriz::ingresarNodo(int _fila,int _columna){
    Nodo* auxFil = fil;
    Nodo* auxCol = col;

    while (auxFil->getFila()!=_fila)
    {
        if(auxFil->getAbajo()==NULL||auxFil->getFila()>_fila){
            return NULL;
        }
        auxFil = auxFil->getAbajo();
    }

    while (auxCol->getColumna()!=_columna)
    {
        if(auxCol->getDerecha()==NULL||auxCol->getColumna()>_columna){
            return NULL;
        }
        auxCol = auxCol->getDerecha();
    }

    Nodo* nodo = new Nodo();
    nodo->setFila(_fila); nodo->setColumna(_columna);

    if(auxFil->getDerecha() == NULL){
        nodo->setIzquierda(auxFil);
        auxFil->setDerecha(nodo);
    }
    else{
        Nodo* aux = auxFil;
        while (aux->getDerecha()!=NULL && aux->getDerecha()->getColumna()<_columna)
        {
            aux = aux->getDerecha();
        }
        
        if (aux->getDerecha()==NULL)
        {
            aux->setDerecha(nodo);
            nodo->setIzquierda(aux);
        }
        else if(aux->getDerecha()->getColumna()>_columna){
            aux->getDerecha()->setIzquierda(nodo);
            nodo->setDerecha(aux->getDerecha());
            nodo->setIzquierda(aux);
            aux->setDerecha(nodo);
        }
        else{
            return NULL;
        }
    }

    if(auxCol->getAbajo()==NULL){
        nodo->setArriba(auxCol);
        auxCol->setAbajo(nodo);
    }
    else{
        Nodo* aux = auxCol;
        while (aux->getAbajo()!=NULL && aux->getAbajo()->getFila()<_fila)
        {
            aux = aux->getAbajo();
        }

        if (aux->getAbajo()==NULL)
        {
            aux->setAbajo(nodo);
            nodo->setArriba(aux);
        }
        else if(aux->getAbajo()->getFila()>_fila){
            aux->getAbajo()->setArriba(nodo);
            nodo->setAbajo(aux->getAbajo());
            nodo->setArriba(aux);
            aux->setAbajo(nodo);
            
        }
        else{
            return NULL;
        }
    }
    return nodo;
};