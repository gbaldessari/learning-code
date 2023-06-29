#Giacomo Baldessari
import numpy

listaMascotas = []
listaDiagnosticos = []
listaClinicas = []
listaAtenciones = []

arch = open('datos.txt',encoding='UTF-8')
linea = arch.readline().strip()

while linea != '':
    partes = linea.split(',')

    mascotaEnLista = False
    diagnosticoEnLista = False
    clinicaEnLista = False

    for i in range(len(listaMascotas)):
        if(partes[0]==listaMascotas[i]):
            mascotaEnLista = True
    
    for i in range(len(listaDiagnosticos)):
        if(partes[3]==listaDiagnosticos[i]):
            diagnosticoEnLista = True

    for i in range(len(listaClinicas)):
        if(partes[2]==listaClinicas[i]):
            clinicaEnLista = True
    
    if mascotaEnLista==False:
        listaMascotas.append(partes[0])
    
    if diagnosticoEnLista==False:
        listaDiagnosticos.append(partes[3])

    if clinicaEnLista==False:
        listaClinicas.append(partes[2])
        listaAtenciones.append(0)

    linea = arch.readline().strip()

matrizMascotaDiagnostico = numpy.zeros([len(listaMascotas),len(listaDiagnosticos)])
matrizMascotaClinica = numpy.zeros([len(listaMascotas),len(listaClinicas)])

arch = open('datos.txt',encoding='UTF-8')
linea = arch.readline().strip()

while linea != '':
    partes = linea.split(',')
    for i in range(len(listaMascotas)):
        for a in range(len(listaDiagnosticos)):
            if listaMascotas[i] == partes[0] and listaDiagnosticos[a] == partes[3]:
                matrizMascotaDiagnostico[i][a]+=1

    linea = arch.readline().strip()

print("por cada mascota, diagnósticos más repetidos")

for i in range(len(listaMascotas)):
    mayor = 0
    for a in range(len(listaDiagnosticos)):
        if matrizMascotaDiagnostico[i][a] > mayor:
            mayor = matrizMascotaDiagnostico[i][a]
    print(listaMascotas[i])
    for e in range(len(listaDiagnosticos)):
        if matrizMascotaDiagnostico[i][e] == mayor:
            print("         "+listaDiagnosticos[e])

arch = open('datos.txt',encoding='UTF-8')
linea = arch.readline().strip()

while linea != '':
    partes = linea.split(',')
    for i in range(len(listaClinicas)):
        if partes[2] == listaClinicas[i]:
            listaAtenciones[i]+=1

    linea = arch.readline().strip()

suma = 0
for i in range(len(listaAtenciones)):
    suma += int(listaAtenciones[i])
promedio = suma/len(listaAtenciones)

print()
print("promedio atenciones "+str(promedio))

for i in range(len(listaAtenciones)):
    if int(listaAtenciones[i])<promedio:
        print("eliminando "+listaClinicas[i]+" "+str(listaAtenciones[i]))

print()
print("por cada mascota, clínicas donde se atendió")

arch = open('datos.txt',encoding='UTF-8')
linea = arch.readline().strip()

while linea != '':
    partes = linea.split(',')

    for i in range(len(listaMascotas)):
        for a in range(len(listaClinicas)):
            if listaMascotas[i] == partes[0] and listaClinicas[a] == partes[2]:
                matrizMascotaClinica[i][a]+=1

    linea = arch.readline().strip()

for i in range(len(listaMascotas)):
    print(listaMascotas[i])
    for e in range(len(listaClinicas)):
        print("         "+str(listaClinicas[e])+" "+str(matrizMascotaClinica[i][e]))

arch.close