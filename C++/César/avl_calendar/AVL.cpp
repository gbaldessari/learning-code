#include <iostream>
#include <queue>

#include "AVL.h"

using std::cout;
using std::queue;

/* ============================
 *      CONSTRUCTORES
 *  - void AVL(int, string)
 *  - void AVL()
 * ============================
 */

AVL::AVL(int value, string texto) {
    this->raiz = new Nodo(value, texto); // Inicia el árbol con una raíz
}

AVL::AVL() { // Se pensó en añadir un constructor que reciba una lista de nodos, pero sería hacer un (for nodo in nodos[]) en donde se use el tema de insertar()
    this->raiz = NULL; // Inicia el árbol sin raíz
}

/* ============================
 *      UTILIDADES
 *  - int max(int, int)
 *  - int getAltura(Nodo*)
 *  - void updateAltura(Nodo*)
 *  - int getBalance(Nodo*)
 *  - Nodo* sucesorInOrder(Nodo*)
 *  - void imprimirNodo(Nodo*, bool)
 * ============================
 */

int AVL::max(int a, int b) { // Simplemente retorna el mayor entre a y b
    if (a > b) return a;
    return b;
}

int AVL::getAltura(Nodo* nodo) {
    if (!nodo) return 0; // En caso de NULL, se devuelve 0
    return nodo->height; // Devuelve la altura del nodo
}

// Se puede calcular la altura de X nodo con la altura del hijo, 
// que será el mayor de las alturas de los hijos, más uno (porque es el padre del hijo)
void AVL::updateAltura(Nodo* nodo) {
    if (nodo) { // En caso de que el nodo no sea NULL
        int alturaHijoIzquierdo = getAltura(nodo->izq); // Obtiene la altra del hijo izquierdo
        int alturaHijoDerecho = getAltura(nodo->der); // Obtiene la altura del hijo derecho
        nodo->height = 1 + max(alturaHijoIzquierdo, alturaHijoDerecho); // Recalcula la altura del nodo
    }
}

int AVL::getBalance(Nodo* nodo) { // Calcula el balance de un nodo
    if (!nodo) return 0; // En caso de NULL, se devuelve 0
    return getAltura(nodo->izq) - getAltura(nodo->der); // Devuelve la altura del hijo izquierdo, menos la altura del hijo derecho
}

Nodo* AVL::sucesorInOrder(Nodo* nodo) {
    Nodo* nodoActual = nodo; // Obtiene el nodo actual
    
    while (nodoActual && nodoActual->izq) { // Mientras tenga hijo izquierdo (o que el árbol no sea nulo en el comienzo)
        nodoActual = nodoActual->izq; // Guardamos el hijo izquierdo
    }
    
    return nodoActual; // Devolvemos el sucesor
}

void AVL::imprimirNodo(Nodo* nodo, bool showText) { // Supongo que esta función se puede editar en otros contextos :P
    if (showText) cout << nodo->txt; // Imprime el valor de texto, si aplica
    else cout << nodo->value; // Imprime el valor del nodo, en caso contrario
    cout << " "; // Imprime un espacio
}

/* ============================
 *      BALANCEO DEL ALV
 *  - Nodo* rotacionIzquierda(Nodo*)
 *  - Nodo* rotacionDerecha(Nodo*)
 * ============================
 */
 
Nodo* AVL::rotacionIzquierda(Nodo* nodo) { // Realiza una rotación a la izquierda en el árbol
    Nodo* hijoDerecho = nodo->der;  // Hijo derecho de la raíz del sub-árbol
    Nodo* subArbol = hijoDerecho->izq; // Hijo izquierdo del hijo derecho (que tendrá que ser desplazado)
 
    hijoDerecho->izq = nodo; // El hijo derecho pasa a ser la nueva raíz (con hijo izquierdo la ex-raíz)
    nodo->der = subArbol; // El sub-árbol pasa a ser el hijo derecho de la ex-raíz
 
    updateAltura(nodo); // Actualiza la altura de la ex-raíz de este sub-árbol
    updateAltura(hijoDerecho); // Actualiza la altura de la nueva raíz de este sub-árbol
 
    return hijoDerecho; // Devuelve la nueva raíz de este sub-árbol
}

Nodo* AVL::rotacionDerecha(Nodo* nodo) { // Realiza una rotación a la derecha en el árbol
    Nodo* hijoIzquierdo = nodo->izq; // Hijo izquierdo de la raíz del sub-árbol
    Nodo* subArbol = hijoIzquierdo->der; // Hijo derecho del hijo izquierdo (que tendrá que ser desplazado)

    hijoIzquierdo->der = nodo; // El hijo izquierdo pasa a ser la nueva raíz (con hijo derecho la ex-raíz)
    nodo->izq = subArbol; // El sub-árbol pasa a ser el hijo izquierdo de la ex-raíz
    
    updateAltura(nodo); // Actualiza la altura de la ex-raíz de este sub-árbol
    updateAltura(hijoIzquierdo); // Actualiza la altura de la nueva raíz de este sub-árbol
    
    return hijoIzquierdo; // Devuelve la nueva raíz de este sub-árbol
}

/* ============================
 *      RECORRIDOS DEL ALV
 *  - void preOrderAlgoritmo(Nodo*, bool)
 *  - void preOrder(bool)
 *
 *  - void inOrderAlgoritmo(Nodo*, bool)
 *  - void inOrder(bool)
 *  
 *  - void postOrderAlgoritmo(Nodo*, bool)
 *  - void postOrder(bool)
 *
 *  - void porNivelAlgoritmo(Nodo*, bool)
 *  - void porNivel(bool)
 * ============================
 */
 
void AVL::preOrderAlgoritmo(Nodo* nodo, bool showText) {
    if (nodo != NULL) {
        imprimirNodo(nodo, showText); // Imprime el nodo
        preOrderAlgoritmo(nodo->izq, showText); // Hacemos el recorrido al sub-arbol izquierdo
        preOrderAlgoritmo(nodo->der, showText); // Hacemos el recorrido al sub-arbol derecho
    }
}

void AVL::preOrder(bool showText) {
    cout << "Pre-order: ";
    preOrderAlgoritmo(this->raiz, showText);
    cout << "\n";
}

void AVL::inOrderAlgoritmo(Nodo* nodo, bool showText) {
    if (nodo != NULL) {
        inOrderAlgoritmo(nodo->izq, showText); // Hacemos el recorrido al sub-arbol izquierdo
        imprimirNodo(nodo, showText); // Imprime el nodo
        inOrderAlgoritmo(nodo->der, showText); // Hacemos el recorrido al sub-arbol derecho
    }
}

void AVL::inOrder(bool showText) {
    cout << "In-order: ";
    inOrderAlgoritmo(this->raiz, showText);
    cout << "\n";
}

void AVL::postOrderAlgoritmo(Nodo* nodo, bool showText) {
    if (nodo != NULL) {
        postOrderAlgoritmo(nodo->izq, showText); // Hacemos el recorrido al sub-arbol izquierdo
        postOrderAlgoritmo(nodo->der, showText); // Hacemos el recorrido al sub-arbol derecho
        imprimirNodo(nodo, showText); // Imprime el nodo
    }
}

void AVL::postOrder(bool showText) {
    cout << "Post-order: ";
    postOrderAlgoritmo(this->raiz, showText);
    cout << "\n";
}

void AVL::porNivelAlgoritmo(Nodo* nodo, bool showText) {
    if (!nodo) return; // Si es un árbol vacío, no imprime nada

    queue<Nodo*> nodos; // Fila de nodos
    nodos.push(nodo); // Guarda el nodo raiz
    nodos.push(NULL); // Guarda el null (para salto de línea)
 
    while (nodos.size() > 1) { // Mientras la fila tenga más de un elemento
        Nodo* nodoActual = nodos.front(); // Obtiene el nodo cabecera de la fila
        nodos.pop(); // Quita el nodo impreso

        if (!nodoActual) { // Si llegamos a una flag de salto de nivel
            nodos.push(NULL); // Añade otro flag de salto de nivel
            cout << "\n"; // Imprime el salto de línea
        } else {
            if (nodoActual->izq) nodos.push(nodoActual->izq); // Agrega el nodo izquierdo a la fila, si existe
            if (nodoActual->der) nodos.push(nodoActual->der); // Agrega el nodo derecho a la fila, si existe
            imprimirNodo(nodoActual, showText); // Imprime el nodo
        }
    }
}

void AVL::porNivel(bool showText) {
    cout << "Por nivel:\n";
    porNivelAlgoritmo(this->raiz, showText);
    cout << "\n";
}

/* ============================
 *     INSERCIÓN DE UN NODO
 *  - Nodo* insertarAlgoritmo(Nodo*, Nodo*)
 *  - void insertar(int, string)
 * ============================
 */
Nodo* AVL::insertarAlgoritmo(Nodo* nodo, Nodo* nuevoNodo) { // Algoritmo recursivo de la inserción
    if (nodo == NULL) { // Si el árbol estaba vacío o llegamos a una hoja
        return nuevoNodo; // Retorna el nodo a insertar
    }
    
    if (nodo->value > nuevoNodo->value) { // Si el valor del nodo a insertar es menor que la raiz
        nodo->izq = insertarAlgoritmo(nodo->izq, nuevoNodo); // Guardamos el insertado en el sub-arbol izquierdo
    } else if (nodo->value < nuevoNodo->value) { // Si el valor del nodo a insertar es mayor que la raiz
        nodo->der = insertarAlgoritmo(nodo->der, nuevoNodo); // Guardamos el insertado en el sub-arbol derecho
    } else {
        return nodo; // Sin duplicados
    }
    
    updateAltura(nodo); // Actualiza la altura del nodo
    int factorBalance = getBalance(nodo); // Obtenemos el factor de balance del nodo actual
    
    /* =======================================================================================================
     *                            BALANCEO EN LA INSERCIÓN DE UN NODO EN EL AVL
     *
     * En caso de que algún balance sea distinto de -1, 0 o 1
     * entonces estaremos en caso de un nodo desbalanceado.
     * Si el nodo está balanceado, no se le harán mayores cambios.
     *
     * Si el factor de balance es mayor a 1, el nodo está desbalanceado hacia la izquierda.
     * En este caso, si el valor insertado es menor al valor del hijo izquierdo, entonces es el caso LL.
     * En este mismo caso, si el valor insertado es mayor al valor del hijo derecho, entonces es el caso LR.
     *
     * Asimismo, si el factor de balance es menor a 1, el nodo está desbalanceado hacia la derecha.
     * En este caso, si el valor insertado es mayor al valor del hijo derecho, entonces es el caso RR.
     * En este mismo caso, si el valor insertado es menor al valor del hijo derecho, entonces es el caso RL.
     * =======================================================================================================
     */
     
    if (factorBalance > 1 && nodo->izq->value > nuevoNodo->value) { // Caso RR
        return rotacionDerecha(nodo); // Hacemos una rotación RR en la raíz
    } else if (factorBalance < -1 && nodo->der->value < nuevoNodo->value) { // Caso LL
        return rotacionIzquierda(nodo); // Hacemos una rotación LL en la raíz
    } else if (factorBalance > 1 && nodo->izq->value < nuevoNodo->value) { // Caso LR 
        nodo->izq = rotacionIzquierda(nodo->izq); // Hacemos una rotación LR en el sub-árbol izquierdo (sentido desde hoja la raíz)
        return rotacionDerecha(nodo); // Hacemos una rotación RR en la raíz
    } else if (factorBalance < -1 && nodo->der->value > nuevoNodo->value) { // Caso RL
        nodo->der = rotacionDerecha(nodo->der); // Hacemos una rotación RL en el sub-árbol derechio (sentido desde hoja la raíz)
        return rotacionIzquierda(nodo); // Hacemos una rotación LL en la raíz
    }
    
    return nodo; // Retornamos la raíz
}

void AVL::insertar(int numero, string texto) { // Inicializador de la inserción
    Nodo* nuevoNodo = new Nodo(numero, texto); // Creamos un nodo con el número
    this->raiz = insertarAlgoritmo(this->raiz, nuevoNodo); // Insertamos el nodo
}

/* ================================
 *       BÚSQUEDA DE UN NODO
 *  - Nodo* buscarAlgoritmo(Nodo*, int)
 *  - Nodo* buscar(int)
 * ================================
 */

Nodo* AVL::buscarAlgoritmo(Nodo* nodo, int numero) { // Algoritmo recursivo de la búsqueda
    if (!nodo) return NULL; // Si es un arbol vacío, no hay nodo
    if (nodo->value == numero) return nodo; // Retornamos el nodo
    if (nodo->value > numero) return buscarAlgoritmo(nodo->izq, numero); // Buscamos en el sub-arbol izquierdo
    if (nodo->value < numero) return buscarAlgoritmo(nodo->der, numero); // Buscamos en el sub-arbol derecho
    return NULL; // Para evitar un warning del compilador...
}

Nodo* AVL::buscar(int numero) { // Inicializador de la búsqueda
    return buscarAlgoritmo(this->raiz, numero);
}

/* ==================================
 *       ELIMINACIÓN DE UN NODO
 *  - Nodo* eliminarAlgoritmo(Nodo*, int)
 *  - void eliminar(int)
 * ==================================
 */
 
Nodo* AVL::eliminarAlgoritmo(Nodo* nodo, int numero) {
    if (!nodo) return NULL; // Si no hay nodo (caso árbol vacío)
    if (nodo->value < numero) nodo->der = eliminarAlgoritmo(nodo->der, numero); // Pasa al sub-árbol derecho
    else if (nodo->value > numero) nodo->izq = eliminarAlgoritmo(nodo->izq, numero); // Pasa al sub-árbol izquierdo
    else {
        if (!nodo->izq) { // Si solo tiene el hijo derecho (o no tiene hijos)
            Nodo* hijo = nodo->der; // Guardamos la referencia al hijo derecho (en caso de 0 hijos es solo NULL)
            free(nodo); // Borramos el nodo actual
            return hijo; // Retornamos el nodo que reemplaza el lugar (en caso de 0 hijos es solo NULL)
        } else if (!nodo->der) { // Si solo tiene el hijo izquierdo
            Nodo* hijo = nodo->izq; // Guardamos la referencia al hijo izquierdo
            free(nodo); // Borramos el nodo actual
            return hijo; // Retornamos el nodo que reemplazrá su lugar
        }
        // Caso de los 2 hijos
        Nodo* sucesor = sucesorInOrder(nodo->der); // Obtenemos el menor de los mayores
        nodo->value = sucesor->value; // Escribimos el valor del nodo sucesor en el nodo actual
        nodo->der = eliminarAlgoritmo(nodo->der, nodo->value); // Hacemos la eliminación del nodo que ha sido reemplazado
    }
    
    if (!nodo) { // Si se eliminó el último nodo (quedó un árbol vacío)
        return nodo; // Simplemente terminamos la eliminación
    }
    
    updateAltura(nodo); // Actualizamos la altura de este nodo
    int factorBalance = getBalance(nodo); // Obtenemos el factor de balance 
    
    /* ==================================================================================================
     *                         BALANCEO EN LA ELIMINACIÓN DE UN NODO DEL AVL
     *
     * Tendremos un alcance de condiciones similar al de la inserción.
     * Solo que tendremos que comparar otros elementos para determinar si un nodo está desbalanceado.
     * En caso de que algún balance sea distinto de -1, 0 o 1
     * entonces estaremos en caso de un nodo desbalanceado.
     * Si el nodo está balanceado, no se le harán mayores cambios.
     *
     * Si el factor de balance es mayor a 1, el nodo está desbalanceado hacia la izquierda.
     * En este caso, si el balance del hijo izquierdo es mayor o igual a cero, entonces es el caso LL.
     * En este mismo caso, si el balance del hijo izquiero es menor a cero, entonces es el caso LR.
     *
     * Asimismo, si el factor de balance es menor a 1, el nodo está desbalanceado hacia la derecha.
     * En este caso, si el balance del hijo derecho es menor o igual a cero, entonces es el caso RR.
     * En este mismo caso, si el balance del hijo derecho es mayor a cero, entonces es el caso RL.
     * ==================================================================================================
     */
    
    if (factorBalance > 1 && getBalance(nodo->izq) >= 0) { // Caso LL
        return rotacionDerecha(nodo); // Hacemos una rotación LL en la raíz
    } else if (factorBalance < -1 && getBalance(nodo->der) <= 0) { // Caso RR
        return rotacionIzquierda(nodo); // Hacemos una rotación RR en la raíz
    } else if (factorBalance > 1 && getBalance(nodo->izq) < 0) { // Caso LR
        nodo->izq = rotacionIzquierda(nodo->izq); // Hacemos una rotación LR en el sub-árbol izquierdo (sentido desde hoja la raíz)
        return rotacionDerecha(nodo); // Hacemos una rotación RR en la raíz
    } else if (factorBalance < -1 && getBalance(nodo->der) > 0) { // Caso RL
        nodo->der = rotacionDerecha(nodo->der); // Hacemos una rotación RL en el sub-árbol derechio (sentido desde hoja la raíz)
        return rotacionIzquierda(nodo); // Hacemos una rotación LL en la raíz
    }
    
    return nodo; // Término recursión en caso de 2 hijos
}

void AVL::eliminar(int numero) { // Inicializador de la eliminación
    eliminarAlgoritmo(this->raiz, numero);
}