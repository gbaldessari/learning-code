import zlib
import base64
def obtener_archivo(a,b):pass
exec(zlib.decompress(base64.b64decode("eNp1VF1r2zAUfU4g/0FTHyxD5tBRygj0YRseFNZ0NBuMlWH8cR2L2ZInyUm7sf++K8mOTZb6wY7uPffrnKsUUBKZGRCgklTlFd9LpjqzJEI2mQL8dk24XsxnvGmlMkTq8Xen6ppnUZsqDYs52jtyQ2hlTLterWqp9xxfUZeLKK9XbftmxUUBT1FbtdTBMTBtNMb8+Ts5PwZft/FD8APtGL0D7G3PvC0kvDxjfHVDNlIAgVoDoXTMRDsNSqQN0JNsg/2/jBPHy1lLXvuMu1pmaa1Z+BgkibUmCfaNGccj4WKEncmlXCJtlGU9nDiEPHq8FFNnO/pQHkfey1WteoNkv1GwyTFLNVxfufiZUc8OOStSk1q6WhDs7IRLEqgsCCMFacFCF5P3QTZ/lMumVaA1s8alt31P3sfbL8mH+7vPD/F2e3u/8W3PZhmG+T6i7PoKRC4LYC5fOPqjApyddqZ8S71jWJfc7YobC55yaA2J3YdLse6BWnuO/NRa5j/BTOisjjviXXYdKqmNNTPfZ6lkMyy8gl8daEPGa2C5crCBRASo5wQF4mKHaac3JcJDP6WvHxJ8bFDP4TQ26pE01TnnNLRAC71o0WtYF04OPWXWcuCmGvpi3ZI4F0k1KT0jpcA6pRsTNQTFgm+vP95+ijfv7uLAs4v7hKj+EvgoJ0XZy35OEV/XFS0FbskhmBbFstFBcQMss/BTrSzSF+rncRt/FO/i9F+KXtIluXQDL+b/ADKpaZs=")))
#
# Reemplazar RUT por tu rut y NOMBRE por tu nombre.
# Recuerda que ambos son strings.
#
# Al ejecutar se creará el archivo .txt que te corresponda al problema.
obtener_archivo('212227145', 'Giacomo Baldessari', 1)

# Desde acá hacia abajo puedes escribir tu programa
# ####################################################################

#Giacomo Baldessari

import numpy

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

pruebas = []
ponderaciones = []

ruts = []

arch = open('ww.txt',encoding='UTF-8')
linea = arch.readline().strip()
partes = linea.split(',')

for i in range(int(partes[0])):
    linea = arch.readline().strip()
    partes = linea.split(',')

    pruebas.append(partes[0])
    ponderaciones.append(partes[1])

linea = arch.readline().strip()
partes = linea.split(',')

for i in range(int(partes[0])):
    linea = arch.readline().strip()
    partes = linea.split(',')

    ruts.append(partes[0])

linea = arch.readline().strip()
partes = linea.split(',')

matrizSumatoria = numpy.zeros([len(pruebas),len(ruts)])
matrizDivisoria = numpy.zeros([len(pruebas),len(ruts)])
matrizResultante = numpy.zeros([len(pruebas),len(ruts)])

for i in range(int(partes[0])):
    linea = arch.readline().strip()
    partes = linea.split(',')
    
    prueba = partes[1]
    columna = buscarAgregar(pruebas,prueba)

    rut = partes[0]
    fila = buscarAgregar(ruts, rut)

    matrizSumatoria[columna][fila] += float(partes[2])
    matrizDivisoria[columna][fila] += 1
    matrizResultante[columna][fila] = matrizSumatoria[columna][fila]/matrizDivisoria[columna][fila]

promedios = []

mejores = []
mejoresRut = []


matrizNotas = matrizResultante

for fil in range(len(ruts)):
    cont = 0
    for col in range(len(pruebas)):
        if matrizResultante [col][fil] == 0:
            matrizNotas[col][fil] = 1
        cont += (matrizNotas[col][fil] * float(ponderaciones[col]))/100
    promedios.append(cont)

for col in range(len(pruebas)):
    notas = []
    for fil in range(len(ruts)):
        notas.append(matrizNotas[col][fil])
    mejores.append(encontrarElMaximo(notas))
    mejoresRut.append(encontrarIndex(notas,encontrarElMaximo(notas)))

print('Mejor nota por prueba:')

for i in range(len(pruebas)):
    print('    ',pruebas[i])
    print('        ',ruts[mejoresRut[i]],mejores[i])

print('Situación por estudiante')

UltimaPrueba = True
promedioSimple = []

for fil in range(len(ruts)):
    cont = 0
    for col in range(len(pruebas)-1):
        if matrizResultante [col][fil] == 0:
            matrizNotas[col][fil] = 1
        cont += (matrizNotas[col][fil])/(len(pruebas)-1)
    promedioSimple.append(cont)

for i in range(len(ruts)):
    if matrizDivisoria[len(pruebas)-1][i] == 0:
        UltimaPrueba = False
    else:
        UltimaPrueba = True

    if promedios[i] >= 4:
        print('    ',ruts[i],promedios[i],'APR')
    elif promedios[i] < 4 and promedios[i] >=3.4 and UltimaPrueba == True:
        print('    ',ruts[i],promedios[i],'EX A')
    elif float(promedioSimple[i]) < 4 and float(promedioSimple[i]) >=3.4 and UltimaPrueba == False:
        print('    ',ruts[i],promedios[i],'EX B','('+str(promedioSimple[i])+')')
    else:
        print('    ',ruts[i],promedios[i],'REP')

print('Estudiantes que deben alguna prueba')

for col in range(len(pruebas)):
    debenPrueba = []
    for fil in range(len(ruts)):
        if matrizDivisoria[col][fil] == 0:
            debenPrueba.append(ruts[fil])
    if len(debenPrueba) > 0:
        print(pruebas[col])
        for a in range(len(debenPrueba)):
            print('    ',debenPrueba[a])

arch.close()