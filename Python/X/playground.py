def ordenarLista1(lista): # Para ordernar una lista numérica de menor a mayor
    for a in range(len(lista) -1):
        for b in range(a+1, len(lista)):
            if lista[a] > lista[b]:
                aux = lista[a]
                lista[a] = lista[b]
                lista[b] = aux

                """
                aquí puedes copiar y pegar
                otras listas si necesitas también
                ordenarlas, por ejemplo:
                si quieres también ordenar una lista de nombres x

                aux = nombre[a]
                nombre[a] = nombre[b]
                nombre[b] = aux

                y así se ordenará, en caso de que uses listas en paralelo
                """
    return lista

def ordenarLista2(lista): # Para ordernar una lista numérica de mayor a menor
    for a in range(len(lista) -1):
        for b in range(a+1, len(lista)):
            if lista[a] < lista[b]:
                aux = lista[a]
                lista[a] = lista[b]
                lista[b] = aux

                """
                aquí puedes copiar y pegar
                otras listas si necesitas también
                ordenarlas, por ejemplo:
                si quieres también ordenar una lista de nombres x

                aux = nombre[a]
                nombre[a] = nombre[b]
                nombre[b] = aux

                y así se ordenará, en caso de que uses listas en paralelo
                """
    return lista

def sumadorLista(lista): # Sumar todos los elementos de una lista
    contador = 0
    for i in lista:
        contador += i
    return contador

def promedioLista(lista): # Obtener el promedio de los elementos de una lista
    contador = 0
    for i in lista:
        contador += i
    return contador/len(lista)

def encontrarElMaximo(lista):
    maximo = lista[0] # No es necesario poner un -99999999999999999999999999
    for i in lista:
        if i > maximo:
            maximo = i
    return maximo

def encontrarElMinimo(lista):
    minimo = lista[0] # No es necesario poner un 9999999999999999999999999999999
    for i in lista:
        if i < minimo:
            minimo = i
    return minimo

"""
def existe(lista, valor):
    for i in lista:
        if i == valor:
            return True
    return False

Toda la función anterior se puede intercambiar por:

> valor in lista

así te ahorras código
"""

"""
def obtenerPosicion(lista, valor):
    for i in range(len(lista)):
        if valor == lista[i]:
            return i
    return -1

Toda la función anterior se puede intercambiar por:

> lista.index(valor)

así te ahorras código
"""


# == EJEMPLO DE USO ==

lista = [4, 1, 2, 7, 8, 4, 6, 4] # LISTA DE EJEMPLO

# PRINTS
print("El orden de menor a mayor es:", ordenarLista1(lista))
print("El orden de mayor a menor es:", ordenarLista2(lista))
print("La suma de los números es:", sumadorLista(lista))
print("El promedio de los números es:", promedioLista(lista))
print("El máximo número en la lista es:", encontrarElMaximo(lista))
print("El mínimo número en la lista es:", encontrarElMinimo(lista))
print("¿El número 5 existe en la lista?", 5 in lista)
print("¿Cuál es la posición del 6 en la lista?", lista.index(6))