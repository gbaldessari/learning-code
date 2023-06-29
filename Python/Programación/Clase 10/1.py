#Giacomo Baldessari

import numpy

arch = open('ciudades.txt',encoding='UTF-8')
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

ciudades = []
matriz = numpy.zeros([100,100])

while linea != '':
    partes = linea.split(',')
    
    ciudad = partes[1].lower()
    columna = buscarAgregar(ciudades,ciudad)

    ciudad = partes[0].lower()
    fila = buscarAgregar(ciudades, ciudad)

    matriz[fila][columna] = partes[2]

    ciudad = partes[0].lower() 
    columna = buscarAgregar(ciudades,ciudad)

    ciudad = partes[1].lower()
    fila = buscarAgregar(ciudades, ciudad)

    matriz[fila][columna] = partes[2]

    linea = arch.readline().strip()

arch = open('consultas.txt',encoding='UTF-8')
linea = arch.readline().strip()
partes = linea.split(',')

origen = []
destino = []

while linea != '':
    origen.append(partes[0].lower())
    destino.append(partes[1].lower())

    linea = arch.readline().strip()
    partes = linea.split(',')

for i in range(len(origen)):
    indexOrigen = int(encontrarIndex(ciudades,origen[i]))

    indexDestino = int(encontrarIndex(ciudades,destino[i]))
    if indexOrigen == -1:
        print(str(origen[i]).upper(),'no existe')
    elif indexDestino == -1:
        print(str(destino[i]).upper(),'no existe')
    elif matriz[indexOrigen,indexDestino] == 0:
        print(str(origen[i]).upper(),'y',str(destino[i]).upper(),'no están conectadas')
    else:
        print(str(origen[i]).upper(),'y',str(destino[i]).upper(),'están a',str(matriz[indexOrigen,indexDestino])+'km de distancia')