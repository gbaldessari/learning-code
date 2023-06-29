#include "Nodo.cpp"

class Fila {
    private:
        Nodo* frente;
        Nodo* final;

    public:
        // constructor
        Fila() {
            frente = NULL;
            final = NULL;
        };

        // insertar un elemento al final de la fila
        void push(double dato) {
            Nodo* nuevo_nodo = new Nodo();
            nuevo_nodo->setDato(dato);
            nuevo_nodo->setSiguiente(NULL);

            if (frente == NULL) {
                frente = nuevo_nodo;
            } else {
                final->setSiguiente(nuevo_nodo);
            }
            final = nuevo_nodo;
        };

        // eliminar el primer elemento de la fila
        void pop() {
            if (frente == NULL) {
                cout << "La fila esta vacia" << endl;
            } 
            else if (frente == final)
            {
                frente = final = NULL;
            }
            else {
                frente = frente->getSiguiente();
            }
        };

        // eliminar todos los datos de la fila
        void Void(){
            frente = final = NULL;
        };

        // retornar el primer elemento de la fila
        Nodo* top(){
            return frente;
        };

        // retornar si esta vacia la fila
        bool isEmpty(){
            if(frente == NULL) return true;
            return false;
        };
};

int main() {
    Fila fila;
    fila.push(1);
    cout<<fila.top()->getDato()<<endl;
    fila.push(2);
    fila.pop();
    cout<<fila.top()->getDato()<<endl;
    fila.push(3);
    fila.pop();
    cout<<fila.top()->getDato()<<endl;
    fila.push(4);
    fila.pop();
    cout<<fila.top()->getDato()<<endl;
    fila.pop();
    fila.pop();
    fila.pop();
    return 0;
};