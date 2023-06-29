#pragma once
#include <iostream>

using std::string;

struct Nodo {
  int value; // Valor que contiene el nodo (peso)
  string txt; // Valor de texto que contiene el nodo
  int height; // Altura del nodo (una hoja tiene altura 1)
  Nodo* izq; // Puntero al hijo izquierdo
  Nodo* der; // Puntero al hijo derecho

  Nodo(int val, string texto): value(val), txt(texto), height(1), izq(NULL), der(NULL) {}; // Constructor del Nodo
};

class AVL {
private:
    Nodo* raiz; // Raíz del AVL
    
    // Utilidades del AVL (Funciones externas que se usan en las operaciones)
    int max(int a, int b); // Retorna el máximo entre dos valores
    int getAltura(Nodo* nodo); // Devuelve la altura del nodo
    void updateAltura(Nodo* nodo); // Actualiza (Recalcula) la altura del nodo
    int getBalance(Nodo* nodo); // Calcula el balance de un nodo
    Nodo* sucesorInOrder(Nodo* nodo); // Busca el sucesor de un nodo (para la eliminación)
    void imprimirNodo(Nodo* nodo, bool showText); // Imprime un nodo por consola
    
    // Balanceo del AVL (Funciones que se usan para realizar los movimientos LL, RR, LR, RL)
    Nodo* rotacionIzquierda(Nodo* nodo); // Hace una rotación a la izquierda al nodo especificado
    Nodo* rotacionDerecha(Nodo* nodo); // Hace una rotación a la derecha al nodo especificado
    
    // Funciones del Recorrido (Pues, nada más, simplemente imprimen por recorrido)
    void preOrderAlgoritmo(Nodo* nodo, bool showText);
    void inOrderAlgoritmo(Nodo* nodo, bool showText);
    void postOrderAlgoritmo(Nodo* nodo, bool showText);
    void porNivelAlgoritmo(Nodo* nodo, bool showText);
    
    // Operaciones del AVL (insertar, buscar y eliminar nodos)
    Nodo* insertarAlgoritmo(Nodo* nodo, Nodo* nuevoNodo);
    Nodo* buscarAlgoritmo(Nodo* nodo, int numero);
    Nodo* eliminarAlgoritmo(Nodo* nodo, int numero);
public:
    AVL(int value, string texto); // [Sobrecarga] Constructor: Con valor de inicialización de raíz
    AVL(); // [Sobrecarga] Constructor: Sin valor de inicialización de raíz

    void preOrder(bool showText); // Imprime pre order (RID)
    void inOrder(bool showText); // Imprime in order (IRD)
    void postOrder(bool showText); // Imprime post order (IDR)
    void porNivel(bool showText); // Imprime por nivel

    void insertar(int value, string texto); // Inserta un nodo, desde un entero 
    Nodo* buscar(int value); // Busca un valor y devuelve el nodo
    void eliminar(int value); // Elimina un nodo
};