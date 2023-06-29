#Giacomo Baldessari

mayor = -1
nombreMayor = ''

nombre = str(input('Ingrese el nombre: '))
edad = float(input('Ingrese la edad: '))

while edad != -1:
    
    if edad > mayor:
        mayor = edad
        nombreMayor = nombre
        
        nombre = str(input('Ingrese el nombre: '))
        edad = float(input('Ingrese la edad: '))
    else:
        nombre = str(input('Ingrese el nombre: '))
        edad = float(input('Ingrese la edad: '))

if mayor != -1:
    print(nombreMayor)
else:
    print('No se puede calcular el número mayor')