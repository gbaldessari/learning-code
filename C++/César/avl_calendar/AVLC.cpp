#include <iostream>

#include "AVLC.h"

/* ======================
 *      CONSTRUCTORES
 *  - void AVLC(string)
 *  - void AVLC()
 * ======================
 */

AVLC::AVLC(string value) {
    int peso = getPeso(value); // Obtenemos el peso de la palabra
    this->arbol = new AVL(peso, value); // Inicia el árbol con una raíz
}

AVLC::AVLC() {
    this->arbol = new AVL(); // Inicia el árbol sin raíz
}

/* =======================
 *      UTILIDADES
 *  - int getPeso(string)
 *  - int getPesoLetra(char)
 *  - bool existe(int)
 * =======================
 */
 
int AVLC::getPeso(string texto) {
    int peso = 0; // Acumulador del peso de la palabra
    
    for (char& caracter : texto) { // Iterará por cada caracter que contenga el string (Warning: C++ v11+ only)
        int pesoLetra = getPesoLetra(caracter); // Obtenemos el peso de esta letra
        peso = peso + pesoLetra; // Se lo sumamos al contador general
    }

    return peso; // Devolvemos el peso de la palabra
}

int AVLC::getPesoLetra(char caracter) {
    int peso = (int) caracter; // Convertimos el char a int (según tabla ASCII)
    
    if (peso <= 90) return peso - 64; // Si es letra mayúscula, le restamos el corrimiento del peso de "A"
    return peso - 96; // En caso contrario, le restamos el corriemiento del peso de "a"
}

bool AVLC::existe(int value) {
    Nodo* nodo = arbol->buscar(value); // Busca el valor en el árbol
    
    if (!nodo) return false; // Retorna false en caso de que no exista
    return true; // true en caso de que exista
}

/* =====================
 *      OPERACIONES
 *  - void imprimir(bool)
 *  - void insertar(string)
 *  - void eliminar(string)
 * =====================
 */

void AVLC::imprimir(bool mostrarMeses) {
    arbol->preOrder(mostrarMeses);
    arbol->inOrder(mostrarMeses);
    arbol->postOrder(mostrarMeses);
    arbol->porNivel(mostrarMeses);
}

void AVLC::insertar(string value) {
    int peso = getPeso(value); // Obtiene el peso de la palabra
    
    while (existe(peso)) { // Mientras este peso esté en el árbol
        peso--; // Disminuimos en 1 el peso
    }
    
    arbol->insertar(peso, value); // Insertamos el peso en el árbol
}

/* Nota:
 *  Este método eliminará un nodo del árbol según el string. O sea, eliminará
 *  según el peso original del string. Sin considerar los siguientes casos:
 *  
 *  - Strings repetidos en el árbol (el mismo string exista más de una vez en el árbol).
 *  - El string existe en el árbol, pero bajo un peso modificado, dado que ya existía ese peso por otro string.
 *  
 *  Sería implementable diferentes variantes del método eliminar, una según el
 *  comportamiento necesitado. Ahora como el contexto no define un comportamiento
 *  necesario para el método. Simplemente se dejará una opción simple.
 *  Aunque ya de por sí no pedían borrar nada... :P
 */
void AVLC::eliminar(string value) {
    int peso = getPeso(value); // Obtiene el peso de la palabra
    
    if (existe(peso)) arbol->eliminar(peso); // Elimina el valor, si es que existe en el árbol
}