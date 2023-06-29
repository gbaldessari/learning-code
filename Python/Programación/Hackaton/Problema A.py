#Giacomo Baldessari

import numpy

arch = open('viaje.txt',encoding='UTF-8')
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

def edadPeso(elemento):
    if int(elemento) >= 18:
        return 70
    else:
        return 40

def hallarElMayor(matriz): 
    elMayor = matriz[0][0]

    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            if matriz[linea][columna] > elMayor:
                elMayor = matriz[linea][columna]

    return elMayor

ciudades = []
matrizPeso = numpy.zeros([50,50])
matrizMayores = numpy.zeros([50,50])
matrizMenores = numpy.zeros([50,50])

while linea != '':
    partes = linea.split(',')
    
    ciudad = partes[1].lower()
    columna = buscarAgregar(ciudades,ciudad)

    ciudad = partes[0].lower()
    fila = buscarAgregar(ciudades, ciudad)

    peso = edadPeso(partes[2])
    matrizPeso[fila][columna] += peso
    if int(partes[2]) >= 18:
        matrizMayores[fila][columna] += 1
    else:
        matrizMenores[fila][columna] += 1

    ciudad = partes[0].lower() 
    columna = buscarAgregar(ciudades,ciudad)

    ciudad = partes[1].lower()
    fila = buscarAgregar(ciudades, ciudad)

    matrizPeso[fila][columna] += peso
    if int(partes[2]) >= 18:
        matrizMayores[fila][columna] += 1
    else:
        matrizMenores[fila][columna] += 1

    linea = arch.readline().strip()

