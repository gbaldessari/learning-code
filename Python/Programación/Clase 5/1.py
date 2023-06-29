#Giacomo Baldessari

arch = open('uno.txt',encoding='UTF-8')
linea = arch.readline().strip()

contador = 0
suma = 0
menor = 500
mayor = -1

while linea != '':
    contador += 1
    suma += float(linea)

    if float(linea) > mayor:
        mayor = float(linea)

    if float(linea) < menor:
        menor = float(linea)

    print(linea)
    linea = arch.readline().strip()

if contador != 0:
    promedio = suma/contador
else:
    promedio = 0

print()
print('Total de datos:', contador)
print('Promedio:', promedio)
print('Valor máximo:', mayor)
print('Valor mínimo',menor)

arch.close()