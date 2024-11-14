#include "Nodo.cpp"

class Pila {
    private:
        Nodo* tope;

    public:
        // constructor
        Pila() {
            tope = NULL;
        };

        // insertar un elemento en la pila
        void push(int dato) {
            Nodo* nuevo_nodo = new Nodo;
            nuevo_nodo->setDato(dato);
            nuevo_nodo->setSiguiente(tope);
            tope = nuevo_nodo;
        };

        // eliminar el primer elemento de la pila
        void pop() {
            if (tope == NULL) {
                cout << "La pila esta vacia" << endl;
            } else {
                tope = tope->getSiguiente();
            }
        };

        // eliminar todos los elementos de la pila
        void Void(){
            tope = NULL;
        };

        // retornar el primer elemento de la pila
        Nodo* top(){
            return tope;
        };

        // retornar si esta vacia la pila
        bool isEmpty(){
            if(tope == NULL) return true;
            return false;
        };
};

int main() {
    Pila pila;
    pila.push(1);
    cout<<pila.top()->getDato()<<endl;
    pila.push(2);
    pila.pop();
    cout<<pila.top()->getDato()<<endl;
    pila.push(3);
    cout<<pila.top()->getDato()<<endl;
    pila.push(4);
    cout<<pila.top()->getDato()<<endl;
    pila.pop();
    pila.pop();
    pila.pop();
    pila.pop();
    return 0;
};