#include "Sistema.h"
#include <cstdlib>
#include <ctime>
Sistema::Sistema() {
    arbol = new AVL();
    contadorGlobal = 0;
    queue<Nodo*> fila;
    int numeros[10] ={0,0,0,0,0,0,0,0,0,0};
}
void Sistema::menu(Sistema* sistema){
    int contadorQueue = 0;
    string dato;
    bool arbolLleno = false;
    do
    {
        cout<<"==Consulta Medica=="<<endl;
        cout<<"[SALIR] Para abandonar"<<endl;
        cout<<"Nombre del paciente:"<<endl;
        getline(cin,dato);
        dato = capitalize(dato);
        if (dato=="Salir"){
            cout<<"Cambio de turno"<<endl;
        }else{
            contadorQueue = sistema->ingresarFila(dato, contadorQueue);
            if(contadorGlobal == 100){
                arbolLleno = true;
            }
        }
        cout<<endl;
    } while (dato!="Salir"&&!arbolLleno);
    if(arbolLleno){
        imprimirNumeros();
    }
}
void Sistema::imprimirNumeros(){
    for(int i = 0;i<10;i++){
        cout<<to_string(i+1)<<": "<<to_string(numeros[i])<<endl;
    }
}
int Sistema::ingresarFila(string dato, int cont){
    int contadorQueue = cont;
    string nombre = dato;
    cout<<"Turno del paciente:"<<endl;
    bool error=false;
    int turno = -1;
    do{
        error = false;
        getline(cin,dato);
        try
        {
            turno = stoi(dato);
        }
        catch(const std::invalid_argument& e)
        {
            error = true;
        }
        if(!error&&turno>0&&turno<101){
            queue<Nodo*> filaAuxiliar;
            if(!fila.empty()){
                while(!fila.empty()){
                    if(fila.front()->turno==turno){
                        error = true;
                        cout<<"Ingrese un valor valido"<<endl;
                    }
                    filaAuxiliar.push(fila.front());
                    fila.pop();
                }
                fila = filaAuxiliar;
            }
            if(!error){
                Nodo* existe = arbol->buscar(turno);
                if(existe != NULL){
                    cout<<"Ingrese un valor valido"<<endl;
                    error = true;
                }
                else{
                    Nodo* nuevo = new Nodo(turno,nombre);
                    fila.push(nuevo);
                    contadorQueue++;
                    if(contadorQueue==10){
                        ingresarArbol();
                        contadorQueue = 0;
                    }
                }
            }
        }
        else{
            error = true;
            cout<<"Ingrese un valor valido"<<endl;
        }
    }while (error);
    return contadorQueue;
}
void Sistema::ingresarArbol() {
    cout<<endl;
    while (!fila.empty())
    {
        arbol->ingresar(fila.front()->turno, fila.front()->nombre);
        contadorGlobal++;
        fila.pop();
        eliminar();
        if(contadorGlobal>100){
            arbol->eliminarRaiz();
            contadorGlobal--;
        }
    }
    cout<<"Paciencia, el doctor Ángel Muñoz los atendera en un momento"<<endl;
}
void Sistema::eliminar() {
    srand(time(0));
    int numeroAleatorio = rand()% 10 + 1;
    numeros[numeroAleatorio-1]++;
    int eliminado = arbol->eliminacionInOrder(numeroAleatorio);
    if(eliminado>0){
        contadorGlobal--;
    }
}
string Sistema::capitalize(string dato){
    for(int i = 0;i<dato.length();i++){
        if(i==0){
            dato[i] = toupper(dato[i]);
        }
        else{
            dato[i] = tolower(dato[i]);
        }
    }
    return dato;
}