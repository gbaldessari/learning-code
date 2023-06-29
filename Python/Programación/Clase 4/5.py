#Giacomo Baldessari

mayor = -1
nombreMayor = ''

edad = float(input('Ingrese la edad: '))

while edad != -1:
    nombre = str(input('Ingrese el nombre: '))

    if edad > mayor:
        mayor = edad
        nombreMayor = nombre
        edad = float(input('Ingrese la edad: '))
    else:
        edad = float(input('Ingrese la edad: '))

if mayor != -1:
    print(nombreMayor)
else:
    print('No se puede calcular el número mayor')