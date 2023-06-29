#Giacomo Baldessari

n = 0
s = 0

num = float(input('Ingrese un número: '))

while num != -1:
    n += 1
    s += num
    num = float(input('Ingrese un número: '))

if n != 0:
    promedio = s / n
    print(promedio)
else:
    print('No se puede calcular el promedio')