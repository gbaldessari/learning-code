#include "Nodo.cpp"
struct NodoP{
    string nombre;
    int puntaje;
    NodoP* siguiente;
};
class Sistema
{
private:
    Nodo* estado;
    NodoP* obtenerPuntajes();
    string toLower(string dato);
    NodoP* menuNuevoJuego(Nodo* estadoActual, NodoP* puntajes, Sistema* sistema);
    NodoP* partida(Nodo* estadoActual, NodoP* puntajes, int dificultad);
    NodoP* generarPuntaje(Nodo* estadoActual,NodoP* puntajes,int dificultad,int caso);
    void verPuntajes(NodoP* puntajes);
    void guardarPuntajes(NodoP* puntajes);
public:
    Sistema();
    void menu(Sistema* sistema);
};