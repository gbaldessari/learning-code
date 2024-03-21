#include "Nodo.cpp"
class Lista
{
private:
    Nodo* primero;
    int largo;
public:
    Lista();
    Nodo* get(int);
    int lenght();
    double getPromedio();
    void add(double);
};