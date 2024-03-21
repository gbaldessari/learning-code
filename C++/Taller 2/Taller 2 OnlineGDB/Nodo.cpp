#include "Nodo.h"
#include <iostream>
#include <cstring>
using std::string;
using std::cout;
using std::endl;
using std::cin;
using std::stoi;
using std::to_string;
Nodo::Nodo(int tablero[3][3])
{
    memcpy(this->tablero, tablero, sizeof(this->tablero));
    n0=n1=n2=n3=n4=n5=n6=n7=NULL;
}
int Nodo::getPrioridad(int dificultad){
    int prioridad = 0;
    if(((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 3)||((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 3)){return -1000000;}
    for(int i = 0;i<3;i++){
        if(((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 3)||((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 3)){return -1000000;}
    }
    if(((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 30)||((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 30)){return 1000000;}
    if(dificultad >0){
        if(dificultad>1){
            if((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 12){prioridad = prioridad+300;}
            if((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 12){prioridad = prioridad+300;}
        }
        if((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 20){prioridad = prioridad+300;}
        if((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 20){prioridad = prioridad+300;}
    }
    if((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 10){prioridad = prioridad+50;}
    if((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 10){prioridad = prioridad+50;}
    if((tablero[0][0]+tablero[1][1]+tablero[2][2]) == 11){prioridad = prioridad+10;}
    if((tablero[2][0]+tablero[1][1]+tablero[0][2]) == 11){prioridad = prioridad+10;}
    
    for(int i = 0;i<3;i++){
        if(((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 30)||((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 30)){return 1000000;}
        if(dificultad >0){
            if(dificultad >1){
                if((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 12){prioridad = prioridad+300;}
                if((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 12){prioridad = prioridad+300;}
            }
            if((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 20){prioridad = prioridad+300;}
            if((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 20){prioridad = prioridad+300;}
        }
        if((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 10){prioridad = prioridad+50;}
        if((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 10){prioridad = prioridad+50;}
        if((tablero[i][0]+tablero[i][1]+tablero[i][2]) == 11){prioridad = prioridad+10;}
        if((tablero[0][i]+tablero[1][i]+tablero[2][i]) == 11){prioridad = prioridad+10;}
    }
    return prioridad;
}
int Nodo::getSumaPuntos(){
    int puntos=0;
    for(int i = 0;i<3;i++){
        for(int a =0;a<3;a++){
            if(tablero[i][a]!=0){
                puntos++;
            }
        }
    }
    return puntos;
}
Nodo* Nodo::seleccionarMovimiento(Nodo* nodoActual,int dificultad){
    int prioridades[8] = {-1,-1,-1,-1,-1,-1,-1,-1};
    int mayor = -10000000;
    Nodo* nodoSeleccionado = NULL;
    if(n0!=NULL){prioridades[0] = n0->getPrioridad(dificultad);}
    if(n1!=NULL){prioridades[1] = n1->getPrioridad(dificultad);}
    if(n2!=NULL){prioridades[2] = n2->getPrioridad(dificultad);}
    if(n3!=NULL){prioridades[3] = n3->getPrioridad(dificultad);}
    if(n4!=NULL){prioridades[4] = n4->getPrioridad(dificultad);}
    if(n5!=NULL){prioridades[5] = n5->getPrioridad(dificultad);}
    if(n6!=NULL){prioridades[6] = n6->getPrioridad(dificultad);}
    if(n7!=NULL){prioridades[7] = n7->getPrioridad(dificultad);}

    for(int i = 0;i<8;i++){
        if(prioridades[i]==-1){
            break;
        }
        else if(prioridades[i]==-1000000){
            return nodoActual;
        }
        else if(prioridades[i]==1000000){
            if(i==0){return n0;}
            else if(i==1){return n1;}
            else if(i==2){return n2;}
            else if(i==3){return n3;}
            else if(i==4){return n4;}
            else if(i==5){return n5;}
            else if(i==6){return n6;}
            else if(i==7){return n7;}
        }
        else if(prioridades[i]>mayor){
            mayor = prioridades[i];
            if(i==0){nodoSeleccionado = n0;}
            else if(i==1){nodoSeleccionado = n1;}
            else if(i==2){nodoSeleccionado = n2;}
            else if(i==3){nodoSeleccionado = n3;}
            else if(i==4){nodoSeleccionado = n4;}
            else if(i==5){nodoSeleccionado = n5;}
            else if(i==6){nodoSeleccionado = n6;}
            else if(i==7){nodoSeleccionado = n7;}
        }
    }
    return nodoSeleccionado;
}
void Nodo::generarNodos(){
    for(int i = 0;i<3;i++){
        for(int a = 0;a<3;a++){
            if(tablero[i][a] == 0){
                int nuevoTablero[3][3] = {{tablero[0][0],tablero[0][1],tablero[0][2]},{tablero[1][0],tablero[1][1],tablero[1][2]},{tablero[2][0],tablero[2][1],tablero[2][2]}};
                nuevoTablero[i][a] = 10;
                if(n0 ==NULL){n0 = new Nodo(nuevoTablero);}
                else if(n1 ==NULL){n1 = new Nodo(nuevoTablero);}
                else if(n2 ==NULL){n2 = new Nodo(nuevoTablero);}
                else if(n3 ==NULL){n3 = new Nodo(nuevoTablero);}
                else if(n4 ==NULL){n4 = new Nodo(nuevoTablero);}
                else if(n5 ==NULL){n5 = new Nodo(nuevoTablero);}
                else if(n6 ==NULL){n6 = new Nodo(nuevoTablero);}
                else if(n7 ==NULL){n7 = new Nodo(nuevoTablero);}
            }
        }
    }
}
void Nodo::ingresarMovimiento()
{
    int cont = 0;
    for(int i = 0;i<3;i++){
        for(int a = 0;a<3;a++){
            if(tablero[i][a]==0){
                cont++;
            }
        }
    }
    string lista[cont];
    int cont1 = 0;
    for(int i = 0;i<3;i++){
        int cont2 = 0;
        for(int a = 0;a<3;a++){
            if(tablero[i][a]==0){
                string fil;
                if(i==0){
                    fil = "A";
                }
                else if(i==1){
                    fil = "B";
                }
                else if(i==2){
                    fil = "C";
                }
                lista[cont1] = fil+to_string(cont2);
                cont1++;
            }
            cont2++;
        }
    }
    string dato;
    bool error;
    do
    {
        error = false;
        int pos = -1;
        cout<<endl;
        cout<<"=Seleccione su proximo movimiento"<<endl;
        for(int i = 0;i<cont1;i++){
            cout<<to_string(i+1)<<") "<<lista[i]<<" ";
        }
        cout<<endl;
        getline(cin,dato);
        try
        {
            pos = stoi(dato);
        }
        catch(const std::invalid_argument& e)
        {
            error = true;
        }
        if(!error){
            pos--;
            if(pos<cont1&&pos>=0&&pos%1==0){
                string movimiento = lista[pos];
                char filc = tolower(movimiento[0]);
                char colc = tolower(movimiento[1]);
                string fils = "";
                fils+=filc;
                string cols = ""; 
                cols+=colc;
                int fil;
                if(fils == "a"){
                    fil = 0;
                }
                else if(fils == "b"){
                    fil = 1;
                }
                else if(fils == "c"){
                    fil = 2;
                }
                int col = stoi(cols);
                tablero[fil][col] = 1;
            }
            else{
                error = true;
            }
        }
        if(error){
            cout<<"Ingrese un valor valido"<<endl;
        }
        
    } while (error);
    cout<<endl;
}
void Nodo::imprimirTablero(){
    cout<<"  0 1 2 "<<endl;
    for(int i =0;i<3;i++){
        cout<<"  -----"<<endl;
        if(i==0){cout<<"A";}
        else if(i==1){cout<<"B";}
        else if(i==2){cout<<"C";}
        for(int a=0;a<3;a++){
            cout<<"|";
            if(tablero[i][a]==0){
                cout<<" ";
            }else if(tablero[i][a]==1){
                cout<<"X";
            }
            else if(tablero[i][a]==10){
                cout<<"O";
            }
        }
        cout<<"|"<<endl;
    }
    cout<<"  -----"<<endl;
}
Nodo* Nodo::getNodo0(){return n0;}