// == Estructura de Datos 2022-2: Taller 2 ==
// == Torres de Hanoi Recursivo ==
/* Integrantes:
*   - César Muñoz Francke
*   - Pedro Herrera Rodríguez
*   - Felipe Salazar Rodríguez
*
*  Fecha: 11/11/2022
*/
#include <iostream>
#include "sistema.h"

int main()
{
    Sistema sistema; // Inicializa un sistema
    sistema.cleanConsole(); // Limpia la consola
    sistema.print("Bienvenido al Simulador de las Torres de Hanói");
    int cantidadDiscos = sistema.IntInput("Ingrese la cantidad de discos (ingrese 0 para salir): "); // Pregunta por cantidad de discos
    
    while (cantidadDiscos != 0) {
        sistema.runSimulator(cantidadDiscos); // Prepara e inicia el simulador
        sistema.alarm("Simulador terminado."); // Espera por input de usuario para continuar
        sistema.cleanConsole(); // Limpia la consola
        cantidadDiscos = sistema.IntInput("Ingrese la cantidad de discos (ingrese 0 para salir): "); // Pregunta por cantidad de discos
    };
    
    sistema.print("Saliendo...");
}
