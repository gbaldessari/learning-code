#Giacomo Baldessari

mayor = -1

num = float(input('Ingrese un número: '))

while num != -1:
    if num > mayor:
        mayor = num
        num = float(input('Ingrese un número: '))
    else:
        num = float(input('Ingrese un número: '))

if mayor == -1:
    print('No se puede calcular el mayor')
else:
    print(mayor)