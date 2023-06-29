#Giacomo Baldessari

def obtenerDuplicados(lista1,lista2):
    duplicados = []
    
    for i in lista1:
        if comprobar(i,lista2):
            duplicados.append(i)
    return duplicados

def comprobar(nombre,lista):
    for i in lista:
        if i == nombre:
            return True
    return False

def obtenerNombresUnicos(lista):
    unicos = []
    for i in lista:
        if not comprobar(i,unicos):
            unicos.append(i)
    return unicos

def printNombres(lista):
    for i in lista:
        print(i)



lista1 = []
lista2 = []

arch = open('nombres.txt',encoding='UTF-8')
nombre = arch.readline().strip()

arch2 = open('nombres2.txt',encoding='UTF-8')
nombre2 = arch2.readline().strip()

while nombre != '':
    lista1.append(nombre)
    nombre = arch.readline().strip()

while nombre2 != '':
    lista2.append(nombre2)
    nombre2 = arch2.readline().strip()

nombresUnicos = obtenerNombresUnicos(lista1)
nombresUnicos2 = obtenerNombresUnicos(lista2)

print(obtenerDuplicados(nombresUnicos,nombresUnicos2))