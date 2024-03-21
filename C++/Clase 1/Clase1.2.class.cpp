#include <iostream>
using namespace std;
class A{
    public:
        virtual void x(){
            cout<<"fun A(x)"<<endl;
        }
        void y(){
            cout<<"fun A(y)"<<endl;
        }
    
};
class B{
    public:
        void x(){
            cout<<"fun B(x)"<<endl;
        }
        virtual void y(){
            cout<<"fun B(y)"<<endl;
        }
    
};
class C:public A,public B{
    public:
        void x(){
            cout<<"fun C(x)"<<endl;
        }
        void y(){
            cout<<"fun C(y)"<<endl;
        }
    
};