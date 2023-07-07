#include "AVL.h"

AVL::AVL() {
    raiz = NULL;
}
int AVL::mayor(int a, int b) {
    if (a > b) return a;
    return b;
}
int AVL::getAltura(Nodo* nodo) {
    if (!nodo) return 0;
    return nodo->altura;
}
void AVL::actualizarAltura(Nodo* nodo) {
    if (nodo) {
        int alturaIzq = getAltura(nodo->izq);
        int alturaDer = getAltura(nodo->der);
        nodo->altura = 1 + mayor(alturaIzq, alturaDer);
    }
}
int AVL::getBalance(Nodo* nodo) {
    if (!nodo) return 0;
    return getAltura(nodo->izq) - getAltura(nodo->der);
}
Nodo* AVL::getSucesor(Nodo* nodo) {
    Nodo* actual = nodo;
    while (actual && actual->izq){
        actual = actual->izq;}
    return actual;
}
Nodo* AVL::ll(Nodo* nodo) {
    Nodo* hDer = nodo->der;
    Nodo* hDerI = hDer->izq;
    hDer->izq = nodo;
    nodo->der = hDerI;
    actualizarAltura(nodo);
    actualizarAltura(hDer);
    return hDer;
}
Nodo* AVL::rr(Nodo* nodo) {
    Nodo* hIzq = nodo->izq;
    Nodo* hIzqD = hIzq->der;
    hIzq->der = nodo;
    nodo->izq = hIzqD;
    actualizarAltura(nodo);
    actualizarAltura(hIzq);
    return hIzq;
}
int AVL::eliminarInOrderAlgorimo(Nodo* nodo, int numero) {
    int turnoEliminado = -1;
    if (nodo != NULL) {
        turnoEliminado = eliminarInOrderAlgorimo(nodo->izq, numero);
        if(turnoEliminado<0&&nodo->turno%numero==0){
            int turno = nodo->turno;
            cout<<"Turno: "<<to_string(turno)<<endl;
            cout<<"Se llama al/la señor/ra: "<<nodo->nombre<<endl;
            cout<<endl;
            eliminar(nodo->turno);
            return turno;
        }
        if(turnoEliminado<0){
            turnoEliminado = eliminarInOrderAlgorimo(nodo->der, numero);
        }
    }
    return turnoEliminado;
}
int AVL::eliminacionInOrder(int numero) {
    return eliminarInOrderAlgorimo(raiz, numero);;
}
Nodo* AVL::ingresarNodo(Nodo* nodo, Nodo* nuevoNodo) {
    if (nodo == NULL) {
        return nuevoNodo;
    }
    if (nodo->turno > nuevoNodo->turno) {
        nodo->izq = ingresarNodo(nodo->izq, nuevoNodo);
    } else if (nodo->turno < nuevoNodo->turno) {
        nodo->der = ingresarNodo(nodo->der, nuevoNodo);
    } else {
        return nodo;
    }
    actualizarAltura(nodo);
    int factorBalanceo = getBalance(nodo);
    if (factorBalanceo > 1 && nodo->izq->turno > nuevoNodo->turno) {
        return rr(nodo);
    } else if (factorBalanceo < -1 && nodo->der->turno < nuevoNodo->turno) {
        return ll(nodo);
    } else if (factorBalanceo > 1 && nodo->izq->turno < nuevoNodo->turno) {
        nodo->izq = ll(nodo->izq);
        return rr(nodo);
    } else if (factorBalanceo < -1 && nodo->der->turno > nuevoNodo->turno) {
        nodo->der = rr(nodo->der);
        return ll(nodo);
    }
    return nodo;
}
void AVL::ingresar(int turno, string nombre) {
    Nodo* nuevoNodo = new Nodo(turno, nombre);
    raiz = ingresarNodo(raiz, nuevoNodo);
}
Nodo* AVL::buscarNodo(Nodo* nodo, int turno) {
    if (!nodo) return NULL;
    if (nodo->turno == turno) return nodo;
    if (nodo->turno > turno) return buscarNodo(nodo->izq, turno);
    if (nodo->turno < turno) return buscarNodo(nodo->der, turno);
    return NULL;
}
Nodo* AVL::buscar(int turno) { 
    return buscarNodo(raiz, turno);
}
Nodo* AVL::eliminarNodo(Nodo* nodo, int turno) {
    if (!nodo) return NULL;
    if (nodo->turno < turno) nodo->der = eliminarNodo(nodo->der, turno);
    else if (nodo->turno > turno) nodo->izq = eliminarNodo(nodo->izq, turno);
    else {
        if (!nodo->izq) {
            Nodo* hijo = nodo->der;
            free(nodo);
            return hijo;
        } else if (!nodo->der) {
            Nodo* hijo = nodo->izq;
            free(nodo);
            return hijo;
        }
        Nodo* sucesor = getSucesor(nodo->der);
        nodo->turno = sucesor->turno;
        nodo->der = eliminarNodo(nodo->der, nodo->turno);
    }
    if (!nodo) {
        return nodo;
    }
    actualizarAltura(nodo);
    int factorBalanceo = getBalance(nodo);
    if (factorBalanceo > 1 && getBalance(nodo->izq) >= 0) {
        return rr(nodo);
    } else if (factorBalanceo < -1 && getBalance(nodo->der) <= 0) {
        return ll(nodo);
    } else if (factorBalanceo > 1 && getBalance(nodo->izq) < 0) {
        nodo->izq = ll(nodo->izq);
        return rr(nodo);
    } else if (factorBalanceo < -1 && getBalance(nodo->der) > 0) {
        nodo->der = rr(nodo->der);
        return ll(nodo);
    }
    return nodo;
}
void AVL::eliminar(int turno) {
    eliminarNodo(raiz, turno);
}
bool AVL::eliminarRaiz(){
    if(raiz!=NULL){
        cout<<"Turno: "<<to_string(raiz->turno)<<endl;
        cout<<"Se llama al/la señor/ra: "<<raiz->nombre<<endl;
        eliminar(raiz->turno);
        return true;
    }
    return false;
}