#pragma once
#include <iostream>
#include "AVL.h"

using std::string;

/* =================================================================================
 *                               AVLC: "AVL-Calendar"
 *
 * Pues, es simplemente una "súper-clase" del AVL.
 * Integra las funciones y métodos apropiados para realizar las operaciones
 * de convertir textos de meses a enteros (para ser aceptados por el AVL).
 *
 * Nota: Como no se especifica en el enunciado,
 * se asumirá que todo lo que se ingrese al AVLC serán
 * textos (aceptando mayúsculas o minúsculas) de los meses del año, o sea,
 * que no tendrá otros caracteres especiales (como puntiación, números o tildes).
 * =================================================================================
 */

class AVLC {
private:
    AVL* arbol; // Árbol AVL que opera el AVLC
    
    int getPeso(string texto); // Calcula el peso de un texto
    int getPesoLetra(char caracter); // Calcula el peso de una letra en específico
    bool existe(int value); // Revisa la existencia de un nodo en el árbol
public:
    AVLC(string value); // [Sobrecarga] Constructor: Con valor de inicialización de raíz
    AVLC(); // [Sobrecarga] Constructor: Sin valor de inicialización de raíz

    void imprimir(bool mostrarMeses); // Imprime el árbol usando algún recorrido 
    void insertar(string value); // Inserta un nodo
    void eliminar(string value); // Elimina un nodo. Nota importante sobre este método en el .cpp
};