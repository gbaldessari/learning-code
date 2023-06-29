//Giacomo Baldessari
#include <stdio.h>
int main(void){
    int a,b,c,*p1,*p2;
    p1 = &a;
    *p1 = 1;
    p2 = &b;
    *p2 = 2;
    p1 = p2;
    *p1 = 0;
    p2 = &c;
    *p2 = 3;
    printf("%d %d %d\n",a,b,c);
    return 0;
}
