#pragma once
#include <iostream>
#include "Matriz.h"

using std::string;

class Sistema
{
private:
    Matriz* matriz;
    /*
        Esta función ingresa los datos iniciales al sistema
    */
    void configuracionInicial();
    /*
        En esta función se agregan filas y columnas a la matriz
    */
    void agregarFilaColumna();
    /*
        En esta función se modifican filas y columnas de la matriz
    */
    void modificarFilaColumna();
    /*
        En esta función se eliminan filas y columnas de la matriz
    */
    void eliminarFilaColumna();
    /*
        En esta función muestra el menu donde se escojera que hacer con las filas y columnas
    */
    void menuModificarFilaColumnas();
    /*
        Esta funcion permite ingresar un alumno 
        @param string Nombre del alumno
        @return Si se ingreso el alumno
    */
    bool errorAlumno(string alumno);
    /*
        Esta funcion permite ingresar un ramo 
        @param string Nombre del ramo
        @return Si se ingreso el ramo
    */
    bool errorRamo(string ramo);
    /*
        Esta funcion permite inscribir un alumno a un ramo 
        @param Nodo* El nodo donde se guardaran las notas del alumno
        @param int Posicion de la fila
        @param int Posicion de la columna
        @return El nodo donde se guardaran las notas del alumno
    */
    Nodo* errorInscripcion(Nodo* nodo,int posAlumno,int posRamo);
    /*
        Esta funcion permite ingresar notas 
        @param Nodo* Donde se guardan las notas
    */
    void ingresarNotas(Nodo* nodo);
    /*
        Esta funcion permite cambiar notas 
        @param Nodo* Donde se guardan las notas
    */
    void cambiarNota(Nodo* nodo);
    /*
        Esta funcion permite eliminar notas 
        @param Nodo* Donde se guardan las notas
    */
    void eliminarNota(Nodo* nodo);
    /*
        Esta funcion muestra el menu donde se ingresan las notas
    */
    void ingresarNodos();
    /*
        Esta funcion muestra el menu donde se modifican las notas
    */
    void modificarNotas();
    /*
        Esta funcion muestra el menu donde se escojera que hacer con las notas
        @param Nodo* Donde se guardan las notas
    */
    void menuNotas(Nodo* nodo);
    /*
        Esta funcion muestra el promedio de un alumno en un ramo
    */
    void calcularPromedio();
    /*
        Esta funcion permite convertir un string en minusculas
        @param string Texto de entrada
        @return El texto en minusculas
    */
    string toLower(string dato);
    /*
        Esta funcion permite convertir la primera letra de un string en mayuscula
        @param string Texto de entrada
        @return El texto con la primera letra en mayuscula
    */
    string toCap(string dato);
public:
    Sistema();
    /*
        Esta funcion muestra el menu principal
        @param Sistema* Donde se guardan los datos
    */
    void menu(Sistema* sistema);
};