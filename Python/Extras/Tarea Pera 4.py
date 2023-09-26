import random
    
intentos = int(input("Ingrese el número de intentos que desea tener: "))
numero = random.randint(1, 100)
intentosPrevios = []
encontrado = False
for i in range(intentos):
    intento = int(input("Intento #"+str(i+1)+": Ingrese un número entre 1 y 100: "))
    intentosPrevios.append(intento)
    if intento < numero:
        print("El número es mayor.")
    elif intento > numero:
        print("El número es menor.")
    else:
        print("¡Felicitaciones! Adivinaste el número.")
        encontrado = True
        break
    intentosRestantes = intentos - (i+1)
    print("Te quedan",intentosRestantes,"intentos.")
    print("Intentos realizados:", intentosPrevios  )
if encontrado == False:
    print("Agotaste tus intentos. El número era", numero)