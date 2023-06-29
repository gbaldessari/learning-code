#Giacomo Baldessari
import math

def ordenarLista(lista):
    n = len(lista)
    for i in range(n):
        for a in range(n-1):
            if(float(lista[a])>float(lista[a+1])):
                aux = lista[a+1]
                lista[a+1] = lista[a]
                lista[a] = aux

def mediaAritmetica(lista):
    suma = 0
    n = len(lista)
    for i in range(n):
        suma+=float(lista[i])
    promedio = suma/n
    return promedio

def mediana(lista):
    n = len(lista)
    ordenarLista(lista)
    mediana = 0
    if(n%2==0):
        mediana = str((lista[int(n/2)-1]+lista[int((n/2))])/2)
    else:
        mediana = str(lista[int((n/2))])
    return mediana

def moda(lista):
    n = len(lista)
    listaValores = []
    listaModa = []
    for i in range(n):
        valorNuevo = True
        for a in range(len(listaValores)):
            if(lista[i]==listaValores[a]):
                listaModa[a] +=1
                valorNuevo = False
        if(valorNuevo == True):
            listaValores.append(lista[i])
            listaModa.append(1)
    mayor = -1
    for i in range(len(listaModa)):
        if(listaModa[i]>mayor):
            mayor = listaModa[i]
    listaR = []
    for i in range(len(listaModa)):
        if(listaModa[i] == mayor):
            listaR.append(listaValores[i])
    return listaValores

def mediaGeometrica(lista):
    n = len(lista)
    x = 1
    for i in range(n):
        x = x *(1+float(lista[i]))
    mediaG = pow(x,1/n)-1
    return mediaG

def rango(lista):
    rango = max(lista)-min(lista)
    return rango

def rangoIntercuartilico(lista):
    n = len(lista)
    ordenarLista(lista)
    q1 = math.ceil(n/4)
    q3 = math.ceil((3*n)/4)
    rango = float(lista[q3-1])-float(lista[q1-1])
    return rango

def varianzaPoblacional(lista):
    n = len(lista)
    promedio = mediaAritmetica(lista)
    sumatoria = 0
    for i in range(n):
        sumatoria+=(float(lista[i])-promedio)**2
    varianza = sumatoria/n
    return varianza

def varianzaMuestral(lista):
    n = len(lista)
    promedio = mediaAritmetica(lista)
    sumatoria = 0
    for i in range(n):
        sumatoria+=(float(lista[i])-promedio)**2
    varianza = sumatoria/(n-1)
    return varianza

def desviacionEstandarPoblacional(lista):
    desviacion = math.sqrt(varianzaPoblacional(lista))
    return desviacion

def desviacionEstandarMuestral(lista):
    desviacion = math.sqrt(varianzaMuestral(lista))
    return desviacion

def coeficienteDeVariacionPoblacional(lista):
    coeficiente = desviacionEstandarPoblacional(lista)/abs(mediaAritmetica(lista))
    return coeficiente

def coeficienteDeVariacionMuestral(lista):
    coeficiente = desviacionEstandarMuestral(lista)/abs(mediaAritmetica(lista))
    return coeficiente
