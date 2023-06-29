#Giacomo Baldessari

def leerNumeros():
    lista = []

    arch = open('random.txt',encoding='UTF-8')
    numero = arch.readline().strip()
    while numero != '':
        lista.append(numero)
        numero = arch.readline().strip()
    return lista

def sumadorLista(lista): 
    contador = 0
    for i in lista:
        contador += int(i)
    return contador

def promedioLista(lista): 
    contador = 0
    for i in lista:
        contador += int(i)
    return contador/len(lista)

def encontrarElMaximo(lista):
    maximo = int(lista[0]) 
    for i in lista:
        if int(i) > maximo:
            maximo = int(i)
    return maximo

def encontrarElMinimo(lista):
    minimo = int(lista[0]) 
    for i in lista:
        if int(i) < minimo:
            minimo = int(i)
    return minimo

lista = leerNumeros()

print('Mínimo:',encontrarElMinimo(lista))
print('Máximo:',encontrarElMaximo(lista))
print('Promedio:',promedioLista(lista))
print('Suma',sumadorLista(lista))