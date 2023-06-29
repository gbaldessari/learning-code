//Giacomo Baldessari
#include <stdio.h>
int main(){
    int x;
    int N = 4;
    int *ptr1,*ptr2;
    ptr1 = &N;
    ptr2 = &N;
    ptr2 = ptr2+3;
    x = ptr2-ptr1;
    printf("La resta de ptr1 y ptr2 es %d\n",x);
    return 0;
}