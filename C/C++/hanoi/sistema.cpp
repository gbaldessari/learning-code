#include "sistema.h"

using std::string;
using std::cout;
using std::cin;
using std::endl;
using std::getline;
using std::isdigit;
using std::to_string;

/*
	Escribe una línea por consola. El output incluye salto de línea.
	@param text Texto a escribir.
*/
void Sistema::print(string text)
{
	cout << text << endl;
}

/*
	Escribe un mensaje por consola. El output incluye salto de línea. El método esperará por una intervención
	del usuario para continuar con la ejecución.
	@param text Texto a escribir.
*/
void Sistema::alarm(string text)
{
	if (text != "") { // Si hay texto que imprimir
		cout << "\n" + text << endl; // Imprime el texto de alarma
	}

	cout << "Presione [Enter] para continuar..."; // Pide un input al usuario

	string placeholder; // Crea una variable para almacenar un texto arbitrario
	getline(cin, placeholder); // Espera por una entrada
}

/*
	Limpia la consola. Simplemente imprimirá líneas en blanco para deshacerse de líneas antiguas.
*/
void Sistema::cleanConsole()
{
	for (int i = 0; i < 100; i++) { // Imprime líneas en blanco 100 veces
		print("");
	}
}

/*
	Permite la entrada de un string por consola
	@param text Texto de salida.
*/
string Sistema::StringInput(string text)
{
	string entrada; // Declara una variable de entrada
	cout << text; // Muestra un texto por pantalla
	getline(cin, entrada); // Pregunta por consola

	while (entrada == "") { // Mientras sea una entrada nula
		cout << text; // Muestra un texto por pantalla
		getline(cin, entrada); // Pregunta por consola
	}

	return entrada; // Devuelve el texto ingresado
}

/*
	Permite la entrada de un int por consola. El método incluye verificación de entrada.
	@param text Texto de salida.
*/
int Sistema::IntInput(string text)
{
	bool entradaEsDigito = false; // Al comienzo se toma el input invalido
	string entrada = StringInput(text); // Declara una variable de entrada
	
	while (!entradaEsDigito) { // Si no es un dato numérico
		entradaEsDigito = true; // Decimos que el input es valido

		for (char const& ch : entrada) { // Por cada caracter del string
			if (!isdigit(ch)) { // Si ese caracter no es digito
				entrada = StringInput("Valor invalido. " + text); // Pregunta otra vez
				entradaEsDigito = false; // El string no paso la prueba
				break; // Paramos el ciclo
			}
		}
	}
	
	return stoi(entrada); // Devuelve el integer ingresado
}

/*
    Prepara el sistema y luego inicia una simulación, usando un método recursivo para la cantidad de discos descrito.
    
    @param cantidadDiscos cantidad de discos que tendrá la simulación
*/
void Sistema::runSimulator(int cantidadDiscos) { // Inicia el simulador
    left.clear(); // Limpia la torre izquierda
    mid.clear(); // Limpia la torre central
    right.clear(); // Limpia la torre derecha
    for (int i = cantidadDiscos; i > 0; i--) { left.push(i); } // Prepara la torre de la izquierda

    hanoi(cantidadDiscos, &left, &mid, &right); // Inicia la recusión
}

/*
    Mueve el disco del tope de un tubo a otro.
    @param origen Tubo de origen.
    @param destino Tubo de destino.
*/
void Sistema::mover(Stack* origen, Stack* destino) { // Mueve un disco de una torre a otra
    int disco = origen->top(); // Obtiene el disco top del origen
    origen->pop(); // Quita el disco top del origen
    destino->push(disco); // Inserta el disco al destino

    int numeroPoste = 3; // default es poste "right"
    if (destino == &left) { // si el poste es "left"
        numeroPoste = 1;
    } else if (destino == &mid) { // si el poste es "mid"
        numeroPoste = 2;
    }
    
    print("- Se mueve el disco " + to_string(disco) + " al poste " + to_string(numeroPoste));
}

/*
    [Recursivo] Realiza el algoritmo de resolución de las Torres de Hanói para una torre de n discos.
    
    Caso base: pirámide de "discosOrigen=1" disco, solamente se tendrá que mover este disco
    desde el origen hacia el destino.
    
    Caso recursivo: se tiene que aplicar el algoritmo de Hanoi a una pirámide de "discosOrigen=n-1" discos
    hacia la torre auxiliar (auxiliar pasa a ser el destino en este caso), esto se hace para llegar al caso en
    donde se pueda llevar el disco n hacia el destino del caso original (no el auxiliar), una vez hecho esto,
    se aplicará el algoritmo de Hanói (tomando el origen como la fila auxiliar, dado que esta contiene ahora
    la pirámide ordenada) hacia la fila de destino, para mover la pirámide de "discosOrigen=n-1" discos hacia el
    término del simulador.
    
    Algoritmo:
        - Si es caso base:
            * mover la última ficha hacia el destino.
        - Si es caso recursivo:
            * Resolver n-1 discos para el auxiliar.
            * Mover el disco n hacia el destino.
            * Resolver n-1 discos hacia el destino.
    
    @param discosOrigen cantidad de discos a considerar del tubo de origen.
    @param origen Tubo de origen (donde se encuentre una pirámide ordenada de "discosOrigen" discos)
    @param auxiliar Tubo auxiliar (donde se puedan guardar discos de manera temporal)
    @param destino Tubo de destino (lugar donde se tendrá la pirámide ordenada de "discosOrigen" discos al final)
*/
void Sistema::hanoi(int discosOrigen, Stack* origen, Stack* auxiliar, Stack* destino) {
    if (discosOrigen == 1) { // Caso base: el origen solo tiene el disco 1
        mover(origen, destino); // Movemos el disco 1 al destino
    } else { // Caso recursivo: Resolver una pirámide de n-1 discos
        hanoi(discosOrigen-1, origen, destino, auxiliar); // Primero, resolvemos la pirámide de n-1 discos en la torre central
        mover(origen, destino); // Movemos el disco final n hacia el destino
        hanoi(discosOrigen-1, auxiliar, origen, destino); // Finalmente, resolvemos la pirámide de n-1 discos hacia la torre destino
    }
}