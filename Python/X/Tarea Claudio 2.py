#Claudio Nieto

numero = input('Ingrese un número:')

listaNumeros = []

listaNumerosP = []
listaNumerosN = []
listaNumeros0 = []


while len(listaNumeros) != 20:
    listaNumeros.append(numero)
    if int(numero) > 0:
        listaNumerosP.append(numero)
        numero = input()
    elif int(numero) < 0:
        listaNumerosN.append(numero)
        numero = input()
    else:
        listaNumeros0.append(numero)
        numero = input()
        
print('Numeros positivos:',len(listaNumerosP))
print('Numeros negativos:',len(listaNumerosN))
print('Numeros neutros:',len(listaNumeros0))