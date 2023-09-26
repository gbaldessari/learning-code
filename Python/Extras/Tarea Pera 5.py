def calcular_promedio(lista):
    suma = 0
    cantidad = len(lista)
    for i in range(cantidad):
        suma = suma+float(lista[i])
    if(cantidad!=0):
        promedio = suma/cantidad
        return promedio
    return suma

def encontrar_palabras(cadena, lista):
    encontradas = []
    for i in lista:
        if i in cadena:
            encontradas.append(i)
    return encontradas

def contar_vocales(cadena):
    diccionario = {"a": 0, "e": 0, "i": 0, "o": 0, "u": 0}
    for i in cadena:
        if i.lower() in diccionario:
            diccionario[i.lower()] = diccionario[i.lower()]+1
    return diccionario

def sumar_numeros_pares(numero):
    suma = 0
    contador = 0
    while(contador<=numero):
        if contador>=2 and contador%2==0:
            suma = suma + contador
        contador = contador + 1
    return suma

def imprimir_multiplos(numero, cantidad):
    for i in range(cantidad):
        multiplo = numero * (i+1)
        print(multiplo)