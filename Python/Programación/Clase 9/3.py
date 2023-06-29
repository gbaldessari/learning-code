#Giacomo Baldessari

def encontrarElMinimo():
    arch = open('ejercicio4.3.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(',')

    listaFinal = [0,0,0,0,0,0,0,0,0]
    nombre1 = ''
    nombre2 = ''
    nombre3 = ''

    minimo1 = 999999999999999999999999999999999999999993
    minimo2 = 999999999999999999999999999999999999999992
    minimo3 = 999999999999999999999999999999999999999991

    pena1 = 0
    pena2 = 0
    pena3 = 0

    while datos != '':
        suma = (int(lista[1]) + int(lista[2]) + int(lista[3]))/3 + int(lista[4]) + int(lista[5]) + int(lista[6])
        penalizacion = int(lista[4]) + int(lista[5]) + int(lista[6])

        if suma < minimo1:
            pena3 = pena2
            pena2 = pena1
            pena1 = penalizacion

            minimo3 = minimo2
            minimo2 = minimo1
            minimo1 = suma

            nombre3 = nombre2
            nombre2 = nombre1
            nombre1 = lista[0]
        elif suma>= minimo1 and suma < minimo2:
            pena3 = pena2
            pena2 = penalizacion

            minimo3 = minimo2
            minimo2 = suma

            nombre3 = nombre2
            nombre2 = lista[0]
        elif suma>= minimo2 and suma < minimo3:
            pena3 = penalizacion

            minimo3 = suma

            nombre3 = lista[0]
            
        datos = arch.readline().strip()
        lista = datos.split(',')
    
    listaFinal[0] = nombre1
    listaFinal[1] = minimo1
    listaFinal[2] = pena1
    listaFinal[3] = nombre2
    listaFinal[4] = minimo2
    listaFinal[5] = pena2
    listaFinal[6] = nombre3
    listaFinal[7] = minimo3
    listaFinal[8] = pena3
    
    return listaFinal

lista = encontrarElMinimo()

print('El lugar 1 fue para',lista[0],'con',lista[1],'('+str(lista[2]),'penalizaciones)')
print('El lugar 2 fue para',lista[3],'con',lista[4],'('+str(lista[5]),'penalizaciones)')
print('El lugar 3 fue para',lista[6],'con',lista[7],'('+str(lista[8]),'penalizaciones)')