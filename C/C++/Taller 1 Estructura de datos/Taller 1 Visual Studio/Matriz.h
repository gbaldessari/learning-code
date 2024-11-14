#include "Nodo.cpp"
class Matriz
{
private:
    Nodo* col;
    Nodo* fil;
public:
    Matriz();
    /*
        Esta función permite obtener la posicion de la columna
        @param string Dato a buscar en las columnas
        @return La posicion de la columna
    */
    int getPosColumna(string);
    /*
        Esta función permite obtener el puntero de la columna
        @param string Dato a buscar en las columnas
        @return El puntero de la columna
    */
    Nodo* getColumna(string);
    /*
        Esta función permite obtener la posicion de la fila
        @param string Dato a buscar en las filas
        @return La posicion de la fila
    */
    int getPosFila(string);
    /*
        Esta función permite obtener el puntero de la fila
        @param string Dato a buscar en las filas
        @return El puntero de la fila
    */
    Nodo* getFila(string);
    /*
        Esta función permite obtener el puntero de un nodo en la matriz
        @param int Fila del nodo
        @param int Columna del nodo
        @return El puntero del nodo
    */
    Nodo* getNodo(int,int);
    /*
        Esta función permite ingresar una nueva columna
        @param string Dato de la columna
    */
    void agregarColumna(string);
    /*
        Esta función permite ingresar una nueva fila
        @param string Dato de la fila
    */
    void agregarFila(string);
    /*
        Esta función permite eliminar una columna
        @param string Dato de la columna
        @return si se llevo a cabo la eliminacion
    */
    bool eliminarColumna(string);
    /*
        Esta función permite eliminar una fila
        @param string Dato de la fila
        @return si se llevo a cabo la eliminacion
    */
    bool eliminarFila(string);
    /*
        Esta función permite ingresar un nodo en la matriz
        @param int Fila del nodo
        @param int Columna del nodo
        @return El puntero del nodo
    */
    Nodo* ingresarNodo(int,int);
}; 