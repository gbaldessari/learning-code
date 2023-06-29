#include <iostream>
#include "Stack.h"

Stack::Stack() { // Constructor
    head = nullptr; // La cabeza será nula al comienzo
}

void Stack::push(int elemento) { // Inserta un nodo
    nodo* nuevoNodo = new nodo(elemento, head); // Crea un puntero a un nuevo nodo
    head = nuevoNodo; // El nuevo nodo es la nueva cabezara
}

void Stack::pop() {
    nodo* oldHead = head; // Guarda el head anterior
    head = head->link; // El nuevo head es el segundo elemento
    free(oldHead); // Borra el head anterior
}

int Stack::top() { // Devuelve el head
    return head->dato; // Retorna el dato del head
}

void Stack::clear() { // Limpia la lista
    while (!isEmpty()) { // Mientras la lista no esté vacía
        this->pop(); // Quitar último elemento de la lista
    }
}

bool Stack::isEmpty() {
    return !head; // Si head es null (no existe puntero válido), entonces está vacía
}