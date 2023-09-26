#Giacomo Baldessari

def funs(lista,listaVieja,listaNueva):
    largox = len(lista)
    largoy = largox
    pos = 0
    listaFinal = []
    
    while pos < largoy:
        pos2 = listaVieja.index(listaNueva[pos])
        listaFinal.append(lista[pos2])
        pos += 1
    return listaFinal

def funt(lista):
    largox = len(lista)
    largoy = largox
    nuevaLista = []
    primPal = lista[0]
    
    while len(nuevaLista) != largox:
        pos = 0
        primPal = lista[0]
        while pos < largoy:
            ver = lista[pos]
            if primPal > ver and pos < largoy:
                primPal = ver
            pos += 1
        nuevaLista.append(primPal)
        lista.remove(primPal)
        largoy -= 1
    return nuevaLista

def maxPeso(lista):
    pos = 0
    max = 0
    largo = len(lista)
    for i in range(0,largo):
        if max < lista[pos]:
            max = lista[pos]
        pos += 1
    return max

def formato(origen,destino):
    mayor = origen
    menor = destino
    
    if mayor > menor:
        mayor = destino
        menor = origen
    viajeFinal = (str(mayor) +' -> '+ str(menor))
    return viajeFinal

arch = open('viaje.txt',encoding='UTF-8')
linea = arch.readline().strip()

xViaje = []
listaPeso = []

listaViaje = []
listaViajeF = []

listaMayor = []
listaMenor = []

while linea != '':
    viaje = linea.split(',')
    x = formato(viaje[0], viaje[1])
    
    if x not in listaViaje:
        listaViaje.append(x)
        listaViajeF.append(x)
        listaPeso.append(0)
        listaMayor.append(0)
        listaMenor.append(0)
        xViaje.append(False)

    indice = int(listaViaje.index(x))

    if int(viaje[2]) >= 18:
        listaPeso[indice] += 70
        listaMayor[indice] += 1
    elif int(viaje[2]) < 18:
        listaPeso[indice] += 40
        listaMenor[indice] += 1
    linea = arch.readline().strip()

arch.close()
nuevaListaViaje = funt(listaViaje)

nuevaListaPeso = funs(listaPeso, listaViajeF, nuevaListaViaje)
pesoMax = maxPeso(nuevaListaPeso)

nuevaListaMayor = funs(listaMayor, listaViajeF, nuevaListaViaje)
nuevaListaMenor = funs(listaMenor, listaViajeF, nuevaListaViaje)

pos = 0
largo = len(nuevaListaViaje)

while largo > 0:
    if nuevaListaMayor[pos] >= nuevaListaMenor[pos]:
        xViaje[pos] = True
    largo -= 1
    pos += 1

pos = 0
largo = len(nuevaListaViaje)
viajeRealizable = False

while largo > 0:
    if nuevaListaMayor[pos] >= nuevaListaMenor[pos] and nuevaListaPeso[pos] == pesoMax:
        viajeRealizable = True
    largo -= 1
    pos += 1

if viajeRealizable == False:
    print('SINVIAJES')
elif viajeRealizable == True:
    largo = len(nuevaListaViaje)
    pos = 0
    print(pesoMax)

    while largo > 0:
        if nuevaListaPeso[pos] == pesoMax:
            print(nuevaListaViaje[pos])
        largo -= 1
        pos += 1