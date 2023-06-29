#include "Nodo.h"
#pragma once
#include <iostream>
using std::string;
struct NodoP{
    string nombre;
    int puntaje;
    NodoP* siguiente;
};
class Sistema
{
private:
    Nodo* estado;
    /*
        Esta funcion obtiene el puntaje guardado en el archivo .txt
        @return La lista de puntajes actualizada
    */
    NodoP* obtenerPuntajes();
    /*
        Esta funcion permite convertir un string en minusculas
        @param string Texto de entrada
        @return El texto en minusculas
    */
    string toLower(string dato);
    /*
        Esta funcion muestra el menu para crear un nuevo juego
        @param Nodo* Estado actual de la partida
        @param NodoP* La lista de puntajes
        @param Sistema* El sistema donde se guardan los datos
        @return La lista de puntajes actualizada
    */
    NodoP* menuNuevoJuego(Nodo* estadoActual, NodoP* puntajes, Sistema* sistema);
    /*
        Esta funcion inicia una nueva ronda del juego
        @param Nodo* Estado actual de la partida
        @param NodoP* La lista de puntajes
        @param int La dificultad de la partida
        @return La lista de puntajes actualizada
    */
    NodoP* partida(Nodo* estadoActual, NodoP* puntajes, int dificultad);
    /*
        Esta funcion genera el puntaje de la partida
        @param Nodo* Estado actual de la partida
        @param NodoP* La lista de puntajes
        @param int La dificultad de la partida
        @param int El resultado de la partida
        @return La lista de puntajes actualizada
    */
    NodoP* generarPuntaje(Nodo* estadoActual,NodoP* puntajes,int dificultad,int caso);
    /*
        Esta funcion muestra los puntajes guardados
        @param NodoP* La lista de puntajes
    */
    void verPuntajes(NodoP* puntajes);
    /*
        Esta funcion guarda los puntajes almacenados en el archivo .txt
        @param NodoP* La lista de puntajes
    */
    void guardarPuntajes(NodoP* puntajes);
public:
    Sistema();
    /*
        Esta funcion muestra el menu principal
        @param Sistema* Donde se guardan los datos
    */
    void menu(Sistema* sistema);
};