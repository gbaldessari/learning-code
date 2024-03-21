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
    /*
        Esta funcion obtiene la altura del nodo
        @param Nodo* El nodo del cual se quiere obtener la altura
        @return La altura del nodo
    */
    int getAltura(Nodo* nodo);
    /*
        Esta funcion actualiza la altura del nodo
        @param Nodo* El nodo del cual se quiere actualizar la altura
    */
    void actualizarAltura(Nodo* nodo);
    /*
        Esta funcion obtiene el balance de un nodo
        @param Nodo* El nodo del cual se quiere obtener el balance
        @return El balance del nodo
    */
    int getBalance(Nodo* nodo);
    /*
        Esta funcion obtiene el sucedor de un nodo al eliminarse
        @param Nodo* El nodo del cual se quiere obtener el sucesor
        @return El sucesor
    */
    Nodo* getSucesor(Nodo* nodo);
    /*
        Esta funcion aplica el algoritmo de rotacion a la izquierda a un nodo desbalanceado
        @param Nodo* El nodo desbalanceado
        @return La raiz del subarbol rotado
    */
    Nodo* ll(Nodo* nodo);
    /*
        Esta funcion aplica el algoritmo de rotacion a la derecha a un nodo desbalanceado
        @param Nodo* El nodo desbalanceado
        @return La raiz del subarbol rotado
    */
    Nodo* rr(Nodo* nodo);
    /*
        Esta funcion recorre el AVL InOrder para eliminar un nodo dado un numero aleatorio
        @param Nodo* La raiz del arbol
        @param int El numero aleatorio
        @return El turno del nodo eliminado
    */
    int eliminarInOrderAlgorimo(Nodo* nodo, int numero);
    /*
        Esta funcion ingresa un nodo al arbol
        @param Nodo* La raiz del arbol
        @param Nodo* El nodo a ingresar
        @return La raiz del arbol
    */
    Nodo* ingresarNodo(Nodo* nodo, Nodo* nuevoNodo);
    /*
        Esta funcion retorna un nodo
        @param Nodo* La raiz del arbol
        @param int el turno del nodo
        @return El nodo buscado
    */
    Nodo* buscarNodo(Nodo* nodo, int turno);
    /*
        Esta funcion elimina un nodo
        @param Nodo* La raiz del arbol/subarbol
        @param int El turno del nodo
    */
    Nodo* eliminarNodo(Nodo* nodo, int turno);
    /*
        Esta funcion obtiene el mayor entre 2 numeros
        @param int El primer numero
        @param int El segundo numero
        @return El numero mayor
    */
    int mayor(int a, int b);
public:
    AVL();
    /*
        Esta funcion deriva a la funcion eliminarInOrderAlgorimo
        @param int El numero aleatorio
        @return El turno del nodo eliminado
    */
    int eliminacionInOrder(int numero);
    /*
        Esta funcion deriva a la funcion ingresarNodo
        @param int El turno del nodo
        @param string El nombre del nodo
    */
    void ingresar(int turno, string nombre);
    /*
        Esta funcion deriva a la funcion buscarNodo
        @param int El turno del nodo
        @return El nodo buscado
    */
    Nodo* buscar(int turno);
    /*
        Esta funcion deriva a la funcion eliminarNodo
        @param int El turno del nodo
    */
    void eliminar(int turno);
    /*
        Esta funcion elimina la raiz del arbol
        @return Si se pudo llevar a cabo la eliminacion
    */
    bool eliminarRaiz();
};