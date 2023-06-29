#Giacomo Baldessari

tamaño = int(input('Ingrese El tamaño del mundo: '))
posicion = int(input('Ingrese la posicion inicial: '))
longitud = int(input('Ingrese la longitud de salto: '))
cantidad = int(input('Ingrese la cantidad de saltos: '))

salto = longitud * cantidad

for i in range(posicion, tamaño, salto):
    if int(i) > tamaño-1:
        i = 0
print ('Juanito aterrizo en la casilla', i)