#Giacomo Baldessari

n = 0
c = 0

num = float(input('Ingrese un número: '))

while num != -1:
    if num >= 4:
        c += 1
        n += 1
        num = float(input('Ingrese un número: '))
    else:
        n += 1
        num = float(input('Ingrese un número: '))
if n != 0:
    porcentaje = (100 * c)/n
    print(porcentaje)
else:
    print('No se puede realizar el cálculo')