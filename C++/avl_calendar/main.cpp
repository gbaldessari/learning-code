// Estructura de Datos: Taller 3 (Final)
// Segundo Semestre 2022

// Integrantes:
// - César Muñoz
// - Pedro Herrera
// - Felipe Salazar

#include <iostream>
#include "AVLC.h"

using std::cout;
using std::endl;

int main () {
    AVLC* arbol = new AVLC("Enero"); // Peso: 57
    arbol->insertar("Febrero"); // Peso: 69
    arbol->insertar("Marzo"); // Peso: 73
    arbol->insertar("Abril"); // Peso: 42
    arbol->insertar("Mayo"); // Peso: 54
    arbol->insertar("Junio"); // Peso: 69
    arbol->insertar("Julio"); // Peso: 67
    arbol->insertar("Agosto"); // Peso: 77
    arbol->insertar("Septiembre"); // Peso: 112
    arbol->insertar("Octubre"); // Peso: 84
    arbol->insertar("Noviembre"); // Peso: 103
    arbol->insertar("Diciembre"); // Peso: 68
    
    cout << "Recorridos del AVLC (Pesos):" << endl;
    arbol->imprimir(false); // Imprimirá los pesos de AVLC
    
    cout << "\n\nRecorridos del AVLC (Textos):" << endl;
    arbol->imprimir(true); // Imprimirá los textos del AVLC
    

    return 0;
}