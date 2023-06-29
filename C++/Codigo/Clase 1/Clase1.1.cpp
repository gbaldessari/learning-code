//Giacomo Baldessari
#include <iostream>
using namespace std;
int main(){
    int arr[] = {4,2,4,3,2,1,2,3,0};
    int arr2[] = {2,3,4,1,2,4,2,3,0};
    int *ptr1= &arr[0];
    int ctr = 0;
    int *ptr2 = &arr2[ctr];
    int cont = 0;
    while (*ptr1!=0)
    {
        cont++;
        cout<<"inicio "<<cont<<": "<<*ptr1<<" "<<*ptr2<<endl;
        int *ptr2 = &arr2[0];
        int ctr2 = 0;
        if(arr[ctr]%2){
            while (*ptr2!=*ptr1)
            {
                ptr2++;
                ctr2++;
            }
            *ptr1 = arr2[ctr2]*2;
            arr2[ctr2] = *ptr2 + *ptr1;
        }
        ptr1++;
        ctr++;
    }
    return 0;
}