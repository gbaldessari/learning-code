import zlib
import base64
def obtener_archivo(a,b):pass
exec(zlib.decompress(base64.b64decode("eNp1VF1r2zAUfU4g/0FTHyxD5tBRygj0YRseFNZ0NBuMlWH8cR2L2ZInyUm7sf++K8mOTZb6wY7uPffrnKsUUBKZGRCgklTlFd9LpjqzJEI2mQL8dk24XsxnvGmlMkTq8Xen6ppnUZsqDYs52jtyQ2hlTLterWqp9xxfUZeLKK9XbftmxUUBT1FbtdTBMTBtNMb8+Ts5PwZft/FD8APtGL0D7G3PvC0kvDxjfHVDNlIAgVoDoXTMRDsNSqQN0JNsg/2/jBPHy1lLXvuMu1pmaa1Z+BgkibUmCfaNGccj4WKEncmlXCJtlGU9nDiEPHq8FFNnO/pQHkfey1WteoNkv1GwyTFLNVxfufiZUc8OOStSk1q6WhDs7IRLEqgsCCMFacFCF5P3QTZ/lMumVaA1s8alt31P3sfbL8mH+7vPD/F2e3u/8W3PZhmG+T6i7PoKRC4LYC5fOPqjApyddqZ8S71jWJfc7YobC55yaA2J3YdLse6BWnuO/NRa5j/BTOisjjviXXYdKqmNNTPfZ6lkMyy8gl8daEPGa2C5crCBRASo5wQF4mKHaac3JcJDP6WvHxJ8bFDP4TQ26pE01TnnNLRAC71o0WtYF04OPWXWcuCmGvpi3ZI4F0k1KT0jpcA6pRsTNQTFgm+vP95+ijfv7uLAs4v7hKj+EvgoJ0XZy35OEV/XFS0FbskhmBbFstFBcQMss/BTrSzSF+rncRt/FO/i9F+KXtIluXQDL+b/ADKpaZs=")))
#
# Reemplazar RUT por tu rut y NOMBRE por tu nombre.
# Recuerda que ambos son strings.
#
# Al ejecutar se creará el archivo .txt que te corresponda al problema.
obtener_archivo('212227145', 'Giacomo Baldessari', 2)

# Desde acá hacia abajo puedes escribir tu programa
# ####################################################################

#Giacomo Baldessari

import numpy

def encontrarIndex(lista,elemento):
    if elemento in lista:
        
        return lista.index(elemento)
    else:
        return -1

def encontrarElMinimo(lista):
    minimo = lista[0]
    for i in lista:
        if i < minimo:
            minimo = i
    return minimo

def sumaMatriz(matriz): 
    acumuladorSumatoria = 0
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            acumuladorSumatoria += matriz[linea][columna]
    return acumuladorSumatoria

meses = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre']
comunas = []

arch = open('lluvias.txt',encoding='UTF-8')
linea = arch.readline().strip()
partes = linea.split(',')

for i in range(int(partes[0])):
    linea = arch.readline().strip()
    partes = linea.split(',')

    comunas.append(partes[0])

matrizPrincipal = numpy.zeros([len(comunas),len(meses)])

for col in range(len(comunas)):
    linea = arch.readline().strip()
    partes = linea.split(',')
    for fil in range(len(meses)):
        matrizPrincipal[col][fil] = partes[fil]

sumaCoquimbo = sumaMatriz(matrizPrincipal)

print('1. La cantidad total del mm en la región de Coquimbo es:',sumaCoquimbo)

print('2. Reporte Mensual de Precipitaciones')
for fil in range(len(meses)):
    cont = 0
    for col in range(len(comunas)):
        cont += float(matrizPrincipal[col][fil])
    redondeo = round(cont,2)
    print(meses[fil],redondeo)

print()
print('3. Reporte Mensual por comunas')

mayorPrecipitacion = []

for col in range(len(comunas)):
    cont = 0
    for fil in range(len(meses)):
        cont += float(matrizPrincipal[col][fil])
    redondeo = round(cont,2)
    mayorPrecipitacion.append(redondeo)
    print(comunas[col],redondeo)

print()
print('4. La comuna con menor precipitación es:')

indexMinimo = encontrarIndex(mayorPrecipitacion,encontrarElMinimo(mayorPrecipitacion))
print(comunas[indexMinimo])

print()
print('5. Los meses sin precitaciones fueron:')
for fil in range(len(meses)):
    cont = 0
    for col in range(len(comunas)):
        cont += float(matrizPrincipal[col][fil])
    redondeo = round(cont,2)
    if redondeo == 0:
        print(meses[fil])