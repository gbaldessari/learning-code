#Giacomo Baldessari

def leerNombres():
    lista = []

    arch = open('ejercicio4.2.txt',encoding='UTF-8')
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

def indice(nombre,lista):
    for i in range(0,len(lista)):
        if nombre == lista[i]:
            return i
    return -1

def imprimir(nombre,frecuencia):
    for i in range(len(nombre)):
        print(nombre[i],frecuencia[i])

nombres = leerNombres()

nombresUnicos = obtenerNombresUnicos(leerNombres())
frecuencias = []
for i in nombresUnicos:
    frecuencias.append(0)

for n in nombres:
    if comprobar(n,nombresUnicos):
        x = indice(n,nombresUnicos)
        frecuencias[x] = frecuencias[x]+1
    else:
        nombresUnicos.append(n)
        frecuencias.append(1)

for a in range(len(frecuencias) - 1):
    for b in range(a+1,len(frecuencias)):
        if frecuencias[a] < frecuencias[b]:
            auxFr = frecuencias[a]
            frecuencias[a] = frecuencias[b]
            frecuencias[b] = auxFr

            auxNm = nombresUnicos[a]
            nombresUnicos[a] = nombresUnicos[b]
            nombresUnicos[b] = auxNm

imprimir(nombresUnicos,frecuencias)