import numpy as np

arch = open('archivo.txt',encoding='UTF-8')
linea = arch.readline().strip()

def buscarAgregar(lista,elemento):
    if elemento not in lista:
        lista.append(elemento)
    return lista.index(elemento)

paises = []
nombres = []
matriz = np.zeros([10,10])

while linea != '':
    partes = linea.split(',')
    pais = partes[1]
    nombre = partes[0]

    columna = buscarAgregar(paises,pais)
    fila = buscarAgregar(nombres, nombre)
    matriz[fila][columna] += 1

    linea = arch.readline().strip()
    
print(matriz)
print(paises)
print(nombres)

