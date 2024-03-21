#include <queue>
#include "AVL.h"

class Sistema {
private:
    AVL* arbol;
    int contadorGlobal;
    int numeros[10];
    queue<Nodo*> fila;
    /*
        Esta funcion ingresa los nodos de la queue al AVL
    */
    void ingresarArbol();
    /*
        Esta funcion obtiene el turno de la persona y hace las respectivas comprobaciones
        @param string El nombre de la persona
        @param int La cantidad de nodos que tiene la queue
        @return La cantidad de nodos que tiene la queue actualizada
    */
    int ingresarFila(string dato, int cont);
    /*
        Esta funcion elimina nodos a partir de un numero aleatorio a partir de la hora del sistema
    */
    void eliminar();
    /*
        Esta funcion capitaliza el texto ingresado
        @param string El nombre de la persona
        @return El nombre de la persona con la primera letra mayuscula
    */
    string capitalize(string dato);
    /*
        Esta funcion imprime por consola cuantas veces se han generado los numeros aleatorios
    */
    void imprimirNumeros();
public:
    Sistema();
    /*
        Esta funcion muestra el menu principal
        @param Sistema* Donde se guardan los datos
    */
    void menu(Sistema* sistema);
};