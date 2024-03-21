//Giacomo Baldessari
#include <iostream>
using namespace std;
int main(int argc,char** argv){
    int vect[10];
    for(int i =0;i<10;i++){
        vect[i] = 0;
    }
    int* a = &vect[7];
    *(a-2) = 9;
    int *b = a-3;
    vect[2] = *(b+1)-(b-a);
    *a = vect[a-b+2]*2;
    for(int i =0;i<10;i++){
        cout<<vect[i]<<endl;
    }
    return 0;
}