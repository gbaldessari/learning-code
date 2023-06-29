#Giacomo Baldessari

import numpy

arch = open('chat.txt',encoding='UTF-8')
linea = arch.readline().strip()
partes = linea.split(';')

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

def promedioLista(lista):
    contador = 0
    for i in lista:
        contador += i
    return contador/len(lista)

def encontrarElMinimo(lista):
    minimo = lista[0]
    for i in lista:
        if i < minimo:
            minimo = i
    return minimo

contador = 0
multimedia = 0

meses = []
nombres = []

matriz = numpy.zeros([12,8])

while linea != '':
    contador += 1
    if partes[3] == '<Sticker>' or partes[3] == '<GIF>' or partes[3] == '<Imagen>' or partes[3] == '<Audio>' or partes[3] == '<Video>':
        multimedia += 1
    
    nombre = partes[2].lower()

    columna = buscarAgregar(nombres,nombre)

    div = partes[0].lower()
    div2 = partes[0].split('/')
    mes = div2[1]
    fila = buscarAgregar(meses, mes)

    matriz[fila][columna] += 1

    linea = arch.readline().strip()
    partes = linea.split(';')

print('1) La cantidad de mensajes enviados es de',contador)
print('El porcentaje de contenido multimedia es de',str((multimedia*100)/contador)+'%')

totalNombres = []
mayorMes = []

for fila in range(len(nombres)):
    cont = 0
    for col in range(len(meses)):
        cont += matriz[col][fila] 
    totalNombres.append(cont)

maximo = encontrarElMaximo(totalNombres)
indexMaximo = encontrarIndex(totalNombres,maximo)

for col in range(len(meses)):
    mayorMes.append(matriz[col][indexMaximo])

mesMayor = encontrarElMaximo(mayorMes)
indexMesMayor = encontrarIndex(mayorMes,mesMayor) + 1

print('3) La(s) persona(s) con más mensajes enviados,con',maximo,'es/son:')
print('    -',str(nombres[indexMaximo]).capitalize())
print('    Su mes con más mensajes fue',indexMesMayor,'con',mesMayor)

cantMensajes = []

for col in range(len(meses)):
    cont = 0
    for fil in range(len(nombres)):
        cont += matriz[col][fil] 
    cantMensajes.append(cont)

promedioMSG = promedioLista(cantMensajes)
mesMaximo = encontrarIndex(cantMensajes,encontrarElMaximo(cantMensajes)) + 1

print('4) El promedio mensual de mensajes es',promedioMSG,'y el(los) mes(es) con más mensajes fue(ron):')
print('    -',mesMaximo)

cantMinimo = []
for fil in range(len(nombres)):
    cont = 0
    for col in range(len(meses)):
        cont += matriz[col][fil] 
    cantMinimo.append(cont)

minimo1 = encontrarElMinimo(cantMinimo)
indexMinimo1 = encontrarIndex(cantMinimo,minimo1)
nombre1 = nombres[indexMinimo1]
cantMinimo.pop(indexMinimo1)
minimo2 = encontrarElMinimo(cantMinimo)
indexMinimo2 = encontrarIndex(cantMinimo,minimo2)
nombre2 = nombres[indexMinimo2]


print('5) Las dos personas que menos hablan son:',str(nombre1).capitalize(),'con',minimo1,'mensajes y',str(nombre2).capitalize(),'con',minimo2,'mensajes')
