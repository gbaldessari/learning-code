#include <iostream>
#include <string>
using namespace std;
class Nodo
{
private:
    int tag;
    string dato;
    Nodo* siguiente;
public:
    Nodo(int,string);
    int getTag();
    string getDato();
    Nodo* getSiguiente();
    void setSiguiente(Nodo*);
};