#Giacomo Baldessari

print('---------------------------------------------------')
print('¿El área de que figura geométrica quisiera saber?')
print()
print('"1" para el triángulo')
print()
print('"2" para el cuadrado')
print()
print('"3" para el círculo')
print('---------------------------------------------------')
fig = int(input('Ingrese el número aqui: '))
print()

if fig == 1:
    lad1 = float(input('Ingrese el valor del primer lado: '))
    print()
    lad2 = float(input('Ingrese el valor del segundo lado: '))
    print()
    lad3 = float(input('Ingrese el valor del tercer lado: '))
    print()
    sp = (lad1 + lad2 + lad3) / 2
    areaT = (sp*(sp - lad1)*(sp - lad2)*(sp - lad3))**(1/2)
    print('El área del triangulo es:', areaT)

elif fig == 2:
    lad4 = float(input('Ingrese el valor del lado:'))
    print()
    areaC = lad4**2
    print('El área del cuadrado es:', areaC)
elif fig == 3:
    rad = float(input('Ingrese el valor del radio:'))
    print()
    areaC2 = 3.14159265359*(rad)**2
    print('El área del círculo es:', areaC2)
else:
    print('Error intente nuevamente')