#include <iostream>
using namespace std;
class Nodo{
    private:
        double dato;
        Nodo* siguiente;
    public:
        Nodo(double);
        double getDato();
        Nodo* getSiguiente();
        void setSiguiente(Nodo*);
};