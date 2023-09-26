#Claudio Nieto

numero = input('Ingrese un numero:')
listaNumeros = []

while len(listaNumeros) != 20:
    if int(numero) > 0:
        listaNumeros.append(numero)
        numero = input()
    else:
        numero = input()
        
print(listaNumeros)