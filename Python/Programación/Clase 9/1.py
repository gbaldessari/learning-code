#Giacomo Baldessari

def leerNumeros():
    lista = []

    arch = open('ejercicio4.1.txt',encoding='UTF-8')
    numero = arch.readline().strip()
    while numero != '':
        lista.append(numero)
        numero = arch.readline().strip()
    return lista

listaNumeros = leerNumeros()

def encontrarElMaximo(lista):
    listaMaximos = []
    maximo1 = int(lista[0]) 
    maximo2 = int(lista[0]) 
    maximo3 = int(lista[0]) 

    for i in lista:
        if int(i) > maximo1:
            maximo3 = maximo2
            maximo2 = maximo1
            maximo1 = int(i)
        elif int(i)<= maximo1 and int(i) > maximo2:
            maximo3 = maximo2
            maximo2 = int(i)
        elif int(i)<= maximo2 and int(i) > maximo3:
            maximo3 = int(i)

    listaMaximos.append(maximo1)
    listaMaximos.append(maximo2)
    listaMaximos.append(maximo3)
    return listaMaximos

print(encontrarElMaximo(listaNumeros))