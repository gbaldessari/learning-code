#include <iostream>
#include <stack>
#include <cmath>
using namespace std;

struct Nodo {
  int value;
  Nodo* izq;
  Nodo* der;
  
  Nodo(int value, Nodo* izq=nullptr, Nodo* der=nullptr) {
      this->value = value;
      this->izq = izq;
      this->der = der;
  }
};

void insertar(Nodo* nodo, Nodo* newNodo, int nivel=0, int pos=0) {
    cout << pos << ", " << nivel << ", " << pow(2, nivel) - 1 << ", " << nodo->value << endl;
    
    if (!nodo->izq) {
        nodo->izq = newNodo;
    } else if (!nodo->der) {
        nodo->der = newNodo;
    } else if (pos == pow(2, nivel) - 1){ // Habra qué seguir con el sgte nivel
        insertar(nodo->izq, newNodo, nivel+1, 0);
        insertar(nodo->der, newNodo, nivel+1, pos+1);
    } else {
        return;
    }
};

int main()
{
    Nodo k = Nodo(27, nullptr, nullptr);
    Nodo j = Nodo(19, nullptr, nullptr);
    Nodo i = Nodo(35, &j, &k);
    Nodo h = Nodo(14, nullptr, nullptr);
    Nodo d = Nodo(31, &h, nullptr);
    Nodo g = Nodo(26, nullptr, nullptr);
    Nodo f = Nodo(10, nullptr, nullptr);
    Nodo c = Nodo(33, &f, &g);
    Nodo b = Nodo(42, &c, &d);
    Nodo a = Nodo(44, &b, &i);

    Nodo newNodo = Nodo(100, nullptr, nullptr);
    
    insertar(&a, &newNodo);

    return 0;
};