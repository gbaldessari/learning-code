#Giacomo Baldessari

def leerNombres():
    lista = []

    arch = open('nombres.txt',encoding='UTF-8')
    nombre = arch.readline().strip()
    while nombre != '':
        lista.append(nombre)
        nombre = arch.readline().strip()
    return lista

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

nombresUnicos = obtenerNombresUnicos(leerNombres())
printNombres(nombresUnicos)