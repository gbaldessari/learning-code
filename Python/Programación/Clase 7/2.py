#Giacomo Baldessari

def sumaRangos():
    suma = 0
    arch = open('rangos.txt', encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(',')

    while datos != '':
        suma += (int(lista[1])-int(lista[0]))-1
        datos = arch.readline().strip()
        lista = datos.split(',')

    return suma

print(sumaRangos())