#include <iostream>
using namespace std;

void minHeap(int* puntero, int largo){
    int primeraHoja = (largo/2)+1;
    int ultimaHoja = largo;
    int cont=0;
    bool desordenado = true;
    while(desordenado){
        cont = 0;
        for(int i=1;i<primeraHoja;i++){
            int hDer=(2*i)+1;
            int hIzq=2*i;
            if(*(puntero+hIzq)>*(puntero+hDer)||
              (i==primeraHoja-1 &&ultimaHoja%2==0)){
                if(*(puntero+hIzq)>*(puntero+i)){
                    swap(*(puntero+hIzq),*(puntero+i));
                }else{
                    cont++;
                }
            }else{
                if(*(puntero+hDer)>*(puntero+i)){
                    swap(*(puntero+hDer),*(puntero+i));
                }else{
                    cont++;
                }
            }
        }
        if(cont == primeraHoja-1){
            swap(*(puntero+1),*(puntero+ultimaHoja));
            ultimaHoja--;                        
            primeraHoja = (ultimaHoja/2)+1;
            if(ultimaHoja == 1){
                desordenado = false;
            }
        }
    }
};

void maxHeap(int* puntero, int largo){
    int primeraHoja = (largo/2)+1;
    int ultimaHoja = largo;
    int cont=0;
    bool desordenado = true;
    while(desordenado){
        cont = 0;
        for(int i=1;i<primeraHoja;i++){
            int hDer=(2*i)+1;
            int hIzq=2*i;
            bool existeHDer = true;
            if(i==primeraHoja-1 && ultimaHoja %2 ==0){
                existeHDer = false;
            }
            if(*(puntero+hIzq)<*(puntero+hDer)||
            (i==primeraHoja-1 &&ultimaHoja%2==0)){
                if(*(puntero+hIzq)<*(puntero+i)){
                    swap(*(puntero+hIzq),*(puntero+i));
                }else{
                    cont++;
                }
            }else{
                if(*(puntero+hDer)<*(puntero+i)){
                    swap(*(puntero+hDer),*(puntero+i));
                }else{
                    cont++;
                }
            }
        }
        if(cont == primeraHoja-1){
            swap(*(puntero+1),*(puntero+ultimaHoja));
            ultimaHoja--;
            primeraHoja = (ultimaHoja/2)+1;
            if(ultimaHoja == 1){
                desordenado = false;
            }
        }
    }
};

int main()
{
    int lista[11] = {0,6,86,62,71,34,78,77,14,84,70};
    int* puntero = &lista[0];
    int largo = (sizeof(lista)/4)-1;
    minHeap(puntero,largo);
    for(int i=0;i<=10;i++){
        cout<<lista[i]<<"|";
    }
    cout<<endl;
    maxHeap(puntero,largo);
    for(int i=0;i<=10;i++){
        cout<<lista[i]<<"|";
    }
    return 0;
}