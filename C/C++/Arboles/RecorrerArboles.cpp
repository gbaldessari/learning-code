#include <iostream>
#include <stack>
using namespace std;

struct Nodo {
    int val;
    Nodo* izq;
    Nodo* der;
    Nodo(int value) : val(value), izq(NULL), der(NULL) {}
};

void preOrder(Nodo* raiz) {
    stack<Nodo*> stack;
    Nodo* actual = raiz;
    while (actual != NULL || !stack.empty()) {
        while (actual != NULL) {
            cout<<actual->val<<" ";
            stack.push(actual);
            actual = actual->izq;
        }
        actual = stack.top();
        stack.pop();
        actual = actual->der;
    }
    cout<<endl;
}

void inOrder(Nodo* raiz) {
    stack<Nodo*> stack;
    Nodo* actual = raiz;
    while (actual != NULL || !stack.empty()) {
        while (actual != NULL) {
            stack.push(actual);
            actual = actual->izq;
        }
        actual = stack.top();
        stack.pop();
        cout<<actual->val<<" ";
        actual = actual->der;
    }
    cout<<endl;
}

void postOrder(Nodo* raiz) {
    stack<Nodo*> stack;
    Nodo* actual = raiz;
    Nodo* anterior = NULL;
    while (actual != NULL || !stack.empty()) {
        if (actual != NULL) {
            stack.push(actual);
            actual = actual->izq;
        } 
        else{
            Nodo* ultimo = stack.top();
            if (ultimo->der != NULL && ultimo->der != anterior) {
                actual = ultimo->der;
            } 
            else{
                stack.pop();
                cout<<ultimo->val<<" ";
                anterior = ultimo;
            }
        }
    }
    cout<<endl;
}

Nodo* armarArbol(){
    Nodo* raiz = new Nodo(4);
    raiz->izq = new Nodo(2);
    raiz->der = new Nodo(6);
    raiz->izq->izq = new Nodo(1);
    raiz->izq->der = new Nodo(3);
    raiz->der->izq = new Nodo(5);
    raiz->der->der = new Nodo(7);
    return raiz;
}

int main() {
    Nodo* raiz=armarArbol();
    inOrder(raiz);
    preOrder(raiz);
    postOrder(raiz);
    return 0;
}