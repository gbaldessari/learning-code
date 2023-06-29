#include "Sistema.h"
Sistema::Sistema()
{
    int tablero[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    estado = new Nodo(tablero);
}
NodoP* Sistema::obtenerPuntajes(){
    FILE* archivo;
    archivo = fopen("puntajes.txt","r");
    if(archivo == NULL){
        return NULL;
    }
    NodoP* primero= NULL;
    NodoP* aux = primero;
    char linea[100];
    char *token;
    char nombre[50];
    char puntaje[50];
    while (fgets(linea, sizeof(linea), archivo) != NULL) {
        token = strtok(linea, ",");
        if (token != NULL) {
            strcpy(nombre, token);
            token = strtok(NULL, ",");
            if (token != NULL) { 
                strcpy(puntaje, token);
                NodoP* nuevo = new NodoP();
                nuevo->nombre=nombre;
                nuevo->puntaje=stoi(puntaje);
                if(primero ==NULL){
                    primero = nuevo;
                    aux=primero;
                }
                else{
                    aux->siguiente = nuevo;
                    aux = aux->siguiente;
                }
            }
        }
    }
    fclose(archivo);
    return primero;
}
void Sistema::guardarPuntajes(NodoP* puntajes){
    FILE* archivo = fopen("puntajes.txt", "w");
    while (puntajes!=NULL)
    {
        string texto;
        if(puntajes->siguiente!=NULL){
            texto= puntajes->nombre+","+to_string(puntajes->puntaje)+"\n";
        }
        else{
            texto= puntajes->nombre+","+to_string(puntajes->puntaje);
            }
        char textoC[100];
        for(int i =0;i<sizeof(texto);i++){
            textoC[i]=texto[i];
        }
        fprintf(archivo, textoC);
        puntajes = puntajes->siguiente;
    }
    fclose(archivo);
    cout<<"Datos Guardados"<<endl;
}

void Sistema::menu(Sistema* sistema){
    NodoP* puntajes = obtenerPuntajes();
    string dato;
    do
    {
        cout<<"==Menu Principal=="<<endl;
        cout<<"[A] Nuevo Juego"<<endl;
        cout<<"[B] Ver Puntuaciones"<<endl;
        cout<<"[SALIR] Para abandonar"<<endl;
        cout<<"Ingrese una opcion"<<endl;
        getline(cin,dato);
        dato = sistema->toLower(dato);
        if(dato=="a"){
            puntajes = sistema->menuNuevoJuego(estado,puntajes,sistema);
        }else if(dato=="b"){
            sistema->verPuntajes(puntajes);
        }else if ((dato=="salir"||dato=="s")){
            if(puntajes!=NULL){
                sistema->guardarPuntajes(puntajes);
            }
        }else{
            cout<<"Ingrese una opcion valida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="salir"&&dato!="s");
}
NodoP* Sistema::menuNuevoJuego(Nodo* estadoActual, NodoP* puntajes,Sistema* sistema){
    string dato;
    do
    {
        cout<<endl;
        cout<<"==Nuevo Juego=="<<endl;
        cout<<"=Seleccione la dificultad"<<endl;
        cout<<"[A] Facil"<<endl;
        cout<<"[B] Normal"<<endl;
        cout<<"[C] Dificil"<<endl;
        cout<<"Ingrese una opcion"<<endl;
        getline(cin,dato);
        dato = sistema->toLower(dato);
        if(dato=="a"){
            cout<<"==Nuevo Juego=="<<endl;
            puntajes = sistema->partida(estado,puntajes,0);   
        }
        else if(dato=="b"){
            cout<<"==Nuevo Juego=="<<endl;
            puntajes = sistema->partida(estado,puntajes,1);
        }else if(dato=="c"){
            cout<<"==Nuevo Juego=="<<endl;
            puntajes = sistema->partida(estado,puntajes,2);   
        }else{
            cout<<"Ingrese una opcion valida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="a"&&dato!="b"&&dato!="c");
    return puntajes;
}
void Sistema::verPuntajes(NodoP* puntajes){
    cout<<"==Puntajes Guardados=="<<endl;
    NodoP* aux = puntajes;
    int cont = 1;
    while(aux!=NULL){
        cout<<cont<<") "<<aux->nombre<<": "<<aux->puntaje<<" ptos"<<endl;
        aux = aux->siguiente;
        cont++;
    }
    cout<<endl;
}
NodoP* Sistema::generarPuntaje(Nodo* estadoActual,NodoP* puntajes,int dificultad,int caso){
    int puntaje = 0;
    if(caso == -1){
        puntaje = estadoActual->getSumaPuntos();
    }
    else if(!caso){
        puntaje=5*(dificultad+1)+estadoActual->getSumaPuntos();
    }
    else if(caso){
        puntaje = 30*(dificultad+1)-estadoActual->getSumaPuntos();
    }
    cout<<"Su puntaje es: "<<puntaje<<endl;
    string nombre;
    cout<<"Ingrese su nombre"<<endl;
    getline(cin,nombre);
    NodoP* nuevoP = new NodoP();
    nuevoP->nombre = nombre;
    nuevoP->puntaje = puntaje;
    if(puntajes==NULL){
        return nuevoP;
    }
    NodoP* aux = puntajes;
    while(aux->siguiente!= NULL){
        aux = aux->siguiente;
    }
    aux->siguiente = nuevoP;
    return puntajes;
}
NodoP* Sistema::partida(Nodo* estadoActual,NodoP* puntajes,int dificultad){
    if(estadoActual->getPrioridad(dificultad) == -1000000){
        cout<<endl;
        cout<<"==Ganaste=="<<endl;
        estadoActual->imprimirTablero();
        puntajes = generarPuntaje(estadoActual,puntajes,dificultad,1);
        int tablero[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        estado = new Nodo(tablero);
        return puntajes;
    }
    if(estadoActual->getPrioridad(dificultad)== 1000000){
        cout<<endl;
        cout<<"==Perdiste=="<<endl;
        estadoActual->imprimirTablero();
        puntajes = generarPuntaje(estadoActual,puntajes,dificultad,-1);
        int tablero[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        estado = new Nodo(tablero);
        return puntajes;
    }
    estadoActual->imprimirTablero();
    estadoActual->ingresarMovimiento();
    estadoActual->generarNodos();
    if(estadoActual->getNodo0() == NULL){
        cout<<endl;
        cout<<"==Empate=="<<endl;
        estadoActual->imprimirTablero();
        puntajes = generarPuntaje(estadoActual,puntajes,dificultad,0);
        int tablero[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        estado = new Nodo(tablero);
        return puntajes;
    }
    return partida(estadoActual->seleccionarMovimiento(estadoActual,dificultad),puntajes,dificultad);
}
string Sistema::toLower(string dato){
    for(int i = 0;i<dato.length();i++){
        dato[i] = tolower(dato[i]);
    }
    return dato;
};