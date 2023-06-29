#Giacomo Baldessari

menor = 500

num = float(input('Ingrese un número: '))

while num != -1:
    if num < menor:
        menor = num
        num = float(input('Ingrese un número: '))
    else:
        num = float(input('Ingrese un número: '))

if menor == 500:
    print('No se puede calcular el menor')
else:
    print(menor)