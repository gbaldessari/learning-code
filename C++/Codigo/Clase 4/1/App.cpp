#include "Lista.cpp"

int main(){
    Lista lista = Lista();
    lista.add(2);
    lista.add(4);
    lista.add(7);
    cout<<lista.getPromedio()<<endl;
    return 0;
}