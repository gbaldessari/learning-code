#include "Nodo.cpp"
class Lista
{
private:
    Nodo* primero;
    int largo;
    void ingresarAlumno(string);
public:
    Lista();
    Nodo* get(int);
    int getPos(string);
    void mostrarLista(Nodo*);
    void ingresarNota(string,double);
    double obtenerPromedio(string);
};

