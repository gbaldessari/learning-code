numero = int(input("Ingrese un número entero: "))
primos = []
for i in range(2, numero+1):
    esPrimo = True
    for a in range(2, i):
        if (i % a) == 0:
            esPrimo = False
            break
    if esPrimo == True:
        primos.append(i)

print("Los números primos menores o iguales a",numero,"son:",primos)