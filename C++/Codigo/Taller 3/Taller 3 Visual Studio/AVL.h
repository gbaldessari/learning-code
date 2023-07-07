#include <iostream>
#include <string>
using namespace std;

struct Nodo {
  int turno;
  string nombre;
  int altura;
  Nodo* izq;
  Nodo* der;
  Nodo(int turno, string nombre): turno(turno), nombre(nombre), altura(1), izq(NULL), der(NULL) {};
};

class AVL {
private:
    Nodo* raiz;
    int getAltura(Nodo* nodo);
    void actualizarAltura(Nodo* nodo);
    int getBalance(Nodo* nodo);
    Nodo* getSucesor(Nodo* nodo);
    Nodo* ll(Nodo* nodo);
    Nodo* rr(Nodo* nodo);
    int eliminarInOrderAlgorimo(Nodo* nodo, int numero);
    Nodo* ingresarNodo(Nodo* nodo, Nodo* nuevoNodo);
    Nodo* buscarNodo(Nodo* nodo, int turno);
    Nodo* eliminarNodo(Nodo* nodo, int turno);
    int mayor(int a, int b);
public:
    AVL();
    int eliminacionInOrder(int numero);
    void ingresar(int turno, string nombre);
    Nodo* buscar(int turno);
    void eliminar(int turno);
    bool eliminarRaiz();
};