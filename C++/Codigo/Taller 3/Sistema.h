#include "AVL.cpp"
#include <queue>

class Sistema {
private:
    AVL* arbol;
    int contadorGlobal;
    int numeros[10];
    queue<Nodo*> fila;
    void ingresarArbol();
    int ingresarFila(string dato, int cont);
    void eliminar();
    string capitalize(string dato);
public:
    Sistema();
    void menu(Sistema* sistema);
};