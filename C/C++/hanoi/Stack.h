#pragma once

struct nodo { // Un nodo será un elemento del Stack
    int dato; // Valor que aloja el nodo, valor por defecto en cero
    nodo* link; // Siguiente nodo que estará enlazado, por defecto es null
    
    nodo(int dato, nodo* link) { // Constructor del nodo
        this->dato = dato;
        this->link = link;
    }
};

class Stack { // Clase Stack para almacenar enteros (int), simbolizando el radio/diámetro de los discos
private:
    nodo* head; // Cabeza de la pila
public:
    Stack(); // Constructor
    void push(int elemento); // Inserta un nodo
    void pop(); // Elimina un nodo
    int top(); // Devuelve el nodo del tope
    void clear(); // Limpia la lista completamente
    bool isEmpty(); // True si la lista está vacía
};