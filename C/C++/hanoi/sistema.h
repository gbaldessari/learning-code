#pragma once
#include <iostream>
#include "Stack.h"

using std::string;

class Sistema
{
private:
	Stack left; // Torre de la izquierda (origen)
	Stack mid; // Torre central (auxiliar)
	Stack right; // Torre de la derecha (destino)
	
	string StringInput(string texto); // Permite la entrada de un string por consola
	void mover(Stack* origen, Stack* destino); // Mueve un disco de una torre a otra
	void hanoi(int discosOrigen, Stack* origen, Stack* auxiliar, Stack* destino); // Método recursivo de solución
public:
    Sistema() = default; // Constructor
    
    void print(string text); // Muestra un mensaje por consola
    void alarm(string text); // Alarma un mensaje por consola
    void cleanConsole(); // Permite limpiar la consola
    int IntInput(string texto); // Permite la entrada de un integer por consola
    
    void runSimulator(int cantidadDiscos); // Prepara e inicia el simulador con la cantidad de discos deseados
};