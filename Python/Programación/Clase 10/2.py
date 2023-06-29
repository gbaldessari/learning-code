#Giacomo Baldessari

import numpy

arch = open('taxis.txt',encoding='UTF-8')
linea = arch.readline().strip()

def buscarAgregar(lista,elemento):
    if elemento not in lista:
        lista.append(elemento)
    return lista.index(elemento)

def encontrarIndex(lista,elemento):
    if elemento in lista:
        
        return lista.index(elemento)
    else:
        return -1

def encontrarElMaximo(lista):
    maximo = lista[0]
    for i in lista:
        if i > maximo:
            maximo = i
    return maximo

taxis = []
nombres = []
matriz = numpy.zeros([10,10])

while linea != '':
    partes = linea.split(';')
    taxi = partes[1]
    nombre = partes[0]

    columna = buscarAgregar(taxis,taxi)
    fila = buscarAgregar(nombres, nombre)
    matriz[columna][fila] += int(partes[2])

    linea = arch.readline().strip()

mayorTaxi = []
mayorTaxista = []

for fila in range(len(nombres)):
    cont = 0
    for col in range(len(taxis)):
        cont += matriz[col][fila] 
    mayorTaxista.append(cont)

for col in range(len(taxis)):
    cont = 0
    for fila in range(len(nombres)):
        cont += matriz[col][fila]
    mayorTaxi.append(cont)

indexTaxista = encontrarIndex(mayorTaxista,encontrarElMaximo(mayorTaxista))
indexTaxi = encontrarIndex(mayorTaxi,encontrarElMaximo(mayorTaxi))

print(nombres[indexTaxista])
print(taxis[indexTaxi])