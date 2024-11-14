/*
* Autor:
*   Giacomo Baldessari Marchant
* Rut: 
*   21.222.714-5
* Fecha de entrega:
*   12/05/2023
*/
#include "Sistema.h"
#include <iostream>

using std::string;

int main(){
    Sistema* sistema = new Sistema();
    sistema->menu(sistema);
    return 0;
};