#include "Sistema.h" 
Sistema::Sistema()
{
    matriz = new Matriz();
};
void Sistema::configuracionInicial(){
    matriz->agregarColumna("estructura de datos");
    matriz->agregarColumna("programacion de aplicaciones");
    matriz->agregarColumna("bases de datos no relacionales");
    matriz->agregarColumna("proyecto integrador ii");
    matriz->agregarFila("jose");
    matriz->agregarFila("luis");
    Nodo* n = matriz->ingresarNodo(2,1);
    n->ingresarNota("4.5");
    n->ingresarNota("5.6");
    n->ingresarNota("6.4");
};
void Sistema::menu(Sistema* sistema){
    configuracionInicial();
    string dato;
    do
    {
        cout<<"======Menu Principal======"<<endl;
        cout<<"[A] Menu alumnos y ramos"<<endl;
        cout<<"[B] Inscribir a un alumno"<<endl;
        cout<<"[C] Menu notas"<<endl;
        cout<<"[D] Calcular el promedio de un alumno"<<endl;
        cout<<"[SALIR] Para abandonar"<<endl;
        cout<<"Ingrese una opcion"<<endl;
        getline(cin,dato);
        dato = sistema->toLower(dato);
        if(dato=="a"){
            sistema->menuModificarFilaColumnas();
        }else if(dato=="b"){
            sistema->ingresarNodos();
        }else if (dato=="c"){
            sistema->modificarNotas();
        }else if (dato=="d"){
            sistema->calcularPromedio();
        }else if (dato=="salir"||dato=="s"){
            cout<<"Programa terminado con exito"<<endl;
        }else{
            cout<<"Ingrese una opcion valida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="salir"&&dato!="s");
};
string Sistema::toLower(string dato){
    for(int i = 0;i<dato.length();i++){
        dato[i] = tolower(dato[i]);
    }
    return dato;
};
string Sistema::toCap(string dato){
    dato[0] = toupper(dato[0]);
    return dato;
};
void Sistema::agregarFilaColumna(){
    string dato;
    do
    {
        cout<<"¿Desea agregar un Alumno[A] o un Ramo[R]?"<<endl;
        cout<<"[VOLVER] Para regresar al menu anterior"<<endl;
        getline(cin,dato);
        dato = toLower(dato);
        if(dato=="a"){
            cout<<"Ingrese el nombre del alumno"<<endl;
            string nombre;
            getline(cin,nombre);
            nombre = toLower(nombre);
            if(matriz->getPosFila(nombre)==0){
                matriz->agregarFila(nombre);
                cout<<"Alumno ingresado con exito"<<endl;
            }
            else{
                cout<<"El alumno ya esta registrado"<<endl;
            }
            cout<<""<<endl;
        }else if(dato=="r"){
            cout<<"Ingrese el nombre del ramo"<<endl;
            string nombre;
            getline(cin,nombre);
            nombre = toLower(nombre);
            if(matriz->getPosColumna(nombre)==0){
                matriz->agregarColumna(nombre);
                cout<<"Ramo ingresado con exito"<<endl;
            }
            else{
                cout<<"El ramo ya esta registrado"<<endl;
            }
            cout<<""<<endl;
        }else if (dato=="volver"||dato=="v"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
        }
    } while (dato!="volver"&&dato!="v");
};
void Sistema::modificarFilaColumna(){
    string dato;
    do
    {
        cout<<"¿Desea modificar un Alumno[A] o un Ramo[R]?"<<endl;
        cout<<"[VOLVER] Para regresar al menu anterior"<<endl;
        getline(cin,dato);
        dato = toLower(dato);
        if(dato=="a"){
            cout<<"Ingrese el nombre del alumno a modificar"<<endl;
            string nombre;
            getline(cin,nombre);
            Nodo* nodo = matriz->getFila(nombre);
            if(nodo==NULL){
                cout<<"Alumno no encontrado"<<endl;
            }else{
                cout<<"Ingrese el nuevo nombre del alumno"<<endl;
                getline(cin,nombre);
                nodo->setDato(nombre);
                cout<<"Alumno modificado con exito"<<endl;
            }
            cout<<""<<endl;
        }else if(dato=="r"){
            cout<<"Ingrese el nombre del ramo a modificar"<<endl;
            string nombre;
            getline(cin,nombre);
            Nodo* nodo = matriz->getColumna(nombre);
            if(nodo==NULL){
                cout<<"Ramo no encontrado"<<endl;
            }else{
                cout<<"Ingrese el nuevo nombre del ramo"<<endl;
                getline(cin,nombre);
                nodo->setDato(nombre);
                cout<<"Ramo modificado con exito"<<endl;
            }
            cout<<""<<endl;
        }else if (dato=="volver"||dato=="v"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="volver"&&dato!="v");
};
void Sistema::eliminarFilaColumna(){
    string dato;
    do
    {
        cout<<"¿Desea eliminar un Alumno[A] o un Ramo[R]?"<<endl;
        cout<<"[VOLVER] Para regresar al menu anterior"<<endl;
        getline(cin,dato);
        dato = toLower(dato);
        if(dato=="a"){
            cout<<"Ingrese el nombre del alumno a eliminar"<<endl;
            string nombre;
            getline(cin,nombre);
            bool eliminado = matriz->eliminarFila(nombre);
            if(eliminado){
                cout<<"Alumno borrado con exito"<<endl;
            }
            else{
                cout<<"Alumno no encontrado"<<endl;
            }
            cout<<""<<endl;
        }else if(dato=="r"){
            cout<<"Ingrese el nombre del ramo a eliminar"<<endl;
            string nombre;
            getline(cin,nombre);
            bool eliminado = matriz->eliminarColumna(nombre);
            if(eliminado){
                cout<<"Ramo borrado con exito"<<endl;
            }
            else{
                cout<<"Ramo no encontrado"<<endl;
            }
            cout<<""<<endl;
        }else if (dato=="volver"||dato=="v"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="volver"&&dato!="v");
};
void Sistema::menuModificarFilaColumnas(){
    string dato;
    do
    {
        cout<<"===Menu alumnos y ramos==="<<endl;
        cout<<"[A] Agregar alumnos o ramos"<<endl;
        cout<<"[B] Modificar alumnos o ramos"<<endl;
        cout<<"[C] Eliminar alumnos o ramos"<<endl;
        cout<<"[VOLVER] Para regresar al menu principal"<<endl;
        cout<<"Ingrese una opcion"<<endl;
        getline(cin,dato);
        dato = toLower(dato);
        if(dato=="a"){
            agregarFilaColumna();
        }else if(dato=="b"){
            modificarFilaColumna();
        }else if (dato=="c"){
            eliminarFilaColumna();
        }else if (dato=="volver"||dato=="v"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="volver"&&dato!="v");
};
bool Sistema::errorAlumno(string alumno){
    bool ingresado = true;
    string opcion;
    do
    {
        cout<<"El alumno no esta registrado ¿Desea ingresarlo?[SI/NO]"<<endl;
        getline(cin,opcion);
        opcion = toLower(opcion);
        if(opcion=="si"||opcion=="s"){
            matriz->agregarFila(alumno);
        }else if(opcion=="no"||opcion=="n"){
            ingresado = false;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
        }
        cout<<""<<endl;
    } while (opcion!="si"&&opcion!="s"&&opcion!="no"&&opcion!="n");
    return ingresado;
};
bool Sistema::errorRamo(string ramo){
    bool ingresado = true;
    string opcion;
    do
    {
        cout<<"El ramo no esta registrado ¿Desea ingresarlo?[SI/NO]"<<endl;
        getline(cin,opcion);
        opcion = toLower(opcion);
        if(opcion=="si"||opcion=="s"){
            matriz->agregarColumna(ramo);
        }else if(opcion=="no"||opcion=="n"){
            ingresado = false;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
        }
        cout<<""<<endl;
    } while (opcion!="si"&&opcion!="s"&&opcion!="no"&&opcion!="n");
    return ingresado;
};
void Sistema::ingresarNodos(){
    string alumno;
    cout<<"Ingrese el nombre del alumno"<<endl;
    getline(cin,alumno);
    alumno = toLower(alumno);
    int posAlumno = matriz->getPosFila(alumno);
    string ramo;
    cout<<"Ingrese el nombre del ramo"<<endl;
    getline(cin,ramo);
    ramo = toLower(ramo);
    int posRamo = matriz->getPosColumna(ramo);
    bool ingresados = true;
    if(posAlumno==0){
        ingresados = errorAlumno(alumno);
    }
    if(posRamo==0&&ingresados){
        ingresados = errorRamo(ramo);
    }
    if(ingresados){
        if(posRamo==0){posRamo = matriz->getPosColumna(ramo);}
        if(posAlumno==0){posAlumno = matriz->getPosFila(alumno);}
        Nodo* inscrito = matriz->ingresarNodo(posAlumno,posRamo);
        if(inscrito!=NULL){cout<<"Alumno inscrito exitosamente"<<endl;}
        else{cout<<"El alumno ya esta inscrito"<<endl;}
        cout<<""<<endl;
    }
    else{
        cout<<"Error al inscribir al alumno"<<endl;
        cout<<""<<endl;
    }
};
Nodo* Sistema::errorInscripcion(Nodo* nodo, int posAlumno, int posRamo){
    string opcion;
    do
    {
        cout<<"El alumno no esta inscrito en el ramo¿Desea inscribirlo?[SI/NO]"<<endl;
        getline(cin,opcion);
        opcion = toLower(opcion);
        if(opcion=="si"||opcion=="s"){
            nodo = matriz->ingresarNodo(posAlumno,posRamo);
        }else if(opcion=="no"||opcion=="n"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (opcion!="si"&&opcion!="s"&&opcion!="no"&&opcion!="n");
    return nodo;
};
void Sistema::ingresarNotas(Nodo* nodo){
    string nota;
    double notaTransformada;
    bool ingresar = true;
    bool error =false;
    do
    {
        cout<<"Ingrese una nota:"<<endl;
        getline(cin,nota);
        try
        {
            notaTransformada = stod(nota);
        }
        catch(const std::invalid_argument& e)
        {
            cout<<"Ingrese una nota valida"<<endl;
            cout<<""<<endl;
            error = true;
        }
        if(!error){
            nodo->ingresarNota(nota);
            cout<<"Nota ingresada correctamente"<<endl;
            cout<<""<<endl;
        }
        cout<<""<<endl;
        cout<<"¿Desea ingresar mas notas?[SI/NO]"<<endl;
        string opcion;
        getline(cin,opcion);
        toLower(opcion);
        if(opcion=="si"||opcion=="s"){
            cout<<""<<endl;
        }
        else if(opcion=="no"||opcion=="n"){
            ingresar = false;
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (ingresar);
};
void Sistema::cambiarNota(Nodo* nodo){
    if(nodo->getLista()!=NULL){
        bool valida = true;
        Nodo* aux;
        int opcionNum;
        do
        {
            valida = true;
            aux = nodo->getLista();
            int cont = 1;
            string opcion;
            int opcionNum;
            bool valida = true;
            while (aux!=NULL)
            {
                cout<<"["<<cont<<"]"<<aux->getDato()<<endl;
                cont++;
                aux = aux->getDerecha();
            }
            cout<<"Escoja la nota a cambiar"<<endl;
            getline(cin,opcion);
            try
            {
                opcionNum = stoi(opcion);
            }
            catch(const std::invalid_argument& e)
            {
                cout<<"Ingrese una opcion valida"<<endl;
                valida = false;
            }
            if(valida){
                aux = nodo->getLista();
                int nuevoCont = 1;
                while (aux!=NULL&&nuevoCont!=opcionNum)
                {
                    nuevoCont++;
                    aux = aux->getDerecha();
                }
                if(aux==NULL){
                    valida = false;
                }
                else{
                    string nota;
                    double notaTransformada;
                    bool error;
                    do
                    {
                        error = false;
                        cout<<"Ingrese la nueva nota:"<<endl;
                        getline(cin,nota);
                        try
                        {
                            notaTransformada = stod(nota);
                        }
                        catch(const std::invalid_argument& e)
                        {
                            cout<<"Ingrese una nota valida"<<endl;
                            cout<<""<<endl;
                            error = true;
                        }
                        if(!error){
                            aux->setDato(nota);
                            cout<<"Nota modificada correctamente"<<endl;
                            cout<<""<<endl;
                        }
                    } while (error);
                }
            }
        } while (!valida);
    }
    else{
        cout<<"El alumno no tiene notas"<<endl;
        cout<<""<<endl;
    }
};
void Sistema::eliminarNota(Nodo* nodo){
    if(nodo->getLista()!=NULL){
        bool valida = true;
        Nodo* aux;
        int opcionNum;
        do
        {
            valida = true;
            aux = nodo->getLista();
            int cont = 1;
            string opcion;
            int opcionNum;
            bool valida = true;
            while (aux!=NULL)
            {
                cout<<"["<<cont<<"]"<<aux->getDato()<<endl;
                cont++;
                aux = aux->getDerecha();
            }
            cout<<"Escoja la nota a eliminar"<<endl;
            getline(cin,opcion);
            try
            {
                opcionNum = stoi(opcion);
            }
            catch(const std::invalid_argument& e)
            {
                cout<<"Ingrese una opcion valida"<<endl;
                cout<<""<<endl;
                valida = false;
            }
            if(valida){
                aux = nodo->getLista();
                int nuevoCont = 1;
                while (aux!=NULL&&nuevoCont!=opcionNum)
                {
                    nuevoCont++;
                    aux = aux->getDerecha();
                }
                if(aux==NULL){
                    valida = false;
                }
                else{
                    if(aux->getIzquierda()==NULL&&aux->getDerecha()==NULL){
                        nodo->setLista(NULL);
                    }
                    else{
                        if(aux->getIzquierda()!=NULL){aux->getIzquierda()->setDerecha(aux->getDerecha());}
                        else{nodo->setLista(aux->getDerecha());}
                        if(aux->getDerecha()!=NULL){aux->getDerecha()->setIzquierda(aux->getIzquierda());}
                    }
                    cout<<"Nota eliminada con exito"<<endl;
                    cout<<""<<endl;
                }
            }
        } while (!valida);
    }
    else{
        cout<<"El alumno no tiene notas"<<endl;
        cout<<""<<endl;
    }
};
void Sistema::menuNotas(Nodo* nodo){
    string dato;
    do
    {
        cout<<"===Menu notas==="<<endl;
        cout<<"[A] Agregar notas"<<endl;
        cout<<"[B] Modificar nota"<<endl;
        cout<<"[C] Eliminar nota"<<endl;
        cout<<"[VOLVER] Para regresar al menu principal"<<endl;
        cout<<"Ingrese una opcion"<<endl;
        getline(cin,dato);
        dato = toLower(dato);
        if(dato=="a"){
            ingresarNotas(nodo);
        }else if(dato=="b"){
            cambiarNota(nodo);
        }else if (dato=="c"){
            eliminarNota(nodo);
        }else if (dato=="volver"||dato=="v"){
            cout<<""<<endl;
        }else{
            cout<<"Ingrese una opcion válida"<<endl;
            cout<<""<<endl;
        }
    } while (dato!="volver"&&dato!="v");
};
void Sistema::modificarNotas(){
    string alumno;
    cout<<"Ingrese el nombre del alumno"<<endl;
    getline(cin,alumno);
    alumno = toLower(alumno);
    int posAlumno = matriz->getPosFila(alumno);
    string ramo;
    cout<<"Ingrese el nombre del ramo"<<endl;
    getline(cin,ramo);
    ramo = toLower(ramo);
    int posRamo = matriz->getPosColumna(ramo);
    bool ingresados = true;
    if(posAlumno==0){
        ingresados = errorAlumno(alumno);
    }
    if(posRamo==0&&ingresados){
        ingresados = errorRamo(ramo);
    }
    if(ingresados){
        Nodo* nodo;
        bool inscribir = false;
        if(posRamo==0){posRamo = matriz->getPosColumna(ramo);inscribir = true;}
        if(posAlumno==0){posAlumno = matriz->getPosFila(alumno);inscribir = true;}
        if(inscribir){nodo = matriz->ingresarNodo(posAlumno,posRamo);}
        else{
            nodo = matriz->getNodo(posAlumno,posRamo);
            if(nodo == NULL){
                nodo = errorInscripcion(nodo,posAlumno,posRamo);
            }
        }
        if(nodo!=NULL){
            menuNotas(nodo);
        }   
    }
};
void Sistema::calcularPromedio(){
    Nodo* nodo;
    string alumno;
    cout<<"Ingrese el nombre del alumno"<<endl;
    getline(cin,alumno);
    alumno = toLower(alumno);
    int posAlumno = matriz->getPosFila(alumno);
    string ramo;
    cout<<"Ingrese el nombre del ramo"<<endl;
    getline(cin,ramo);
    ramo = toLower(ramo);
    int posRamo = matriz->getPosColumna(ramo);
    bool ingresados = true;
    bool notas = true;
    if(posAlumno==0){
        ingresados = errorAlumno(alumno);
    }
    if(posRamo==0&&ingresados){
        ingresados = errorRamo(ramo);
    }
    if(ingresados){
        bool inscribir = false;
        if(posRamo==0){posRamo = matriz->getPosColumna(ramo);inscribir = true;}
        if(posAlumno==0){posAlumno = matriz->getPosFila(alumno);inscribir = true;}
        if(inscribir){nodo = matriz->ingresarNodo(posAlumno,posRamo);notas=false;}
        else{
            nodo = matriz->getNodo(posAlumno,posRamo);
            if(nodo == NULL){
                nodo = errorInscripcion(nodo,posAlumno,posRamo);
                notas=false;
            }
        }
        if(!notas){
            if(nodo!=NULL){
                menuNotas(nodo);
            }
            else{
                cout<<"No se ingresaron notas"<<endl;
                cout<<""<<endl;
                notas = false;
            }
        }
    }
    else{
        cout<<"No se pudo ingresar notas"<<endl;
        cout<<""<<endl;
        notas = false;
    }
    if(notas){
        double promedio = nodo->getPromedio();
        cout<<"El promedio de "<<toCap(alumno)<<" en "<<toCap(ramo)<<" es: "<<promedio<<endl;
        cout<<""<<endl;
        cout<<""<<endl;
    }
}