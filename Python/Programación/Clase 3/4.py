#Giacomo Baldessari

num = int(input('Ingrese un número aqui: '))

noPrimo = False
num2 = 0

for i in range (2, num):
    num2 = num % int(i)
    if num2 == 0:
        noPrimo = True

if noPrimo == True:
    print('El numero ingresado no es primo')
else:
    print('El numero ingresado es primo')