#Claudio Nieto

asistentes = input('Asistentes:')

menores = 0
mayores = 0
general = 0

total = int(asistentes)
print('Ingrese los datos con el siguiente formato: "Nombre","Edad"')
for i in range(int(asistentes)):
    entradas = input('Ingrese datos:')
    entradaIngresada = entradas.split(',')
    if int(entradaIngresada[1]) < 10:
        menores += 1
    elif int(entradaIngresada[1]) > 65:
        mayores += 1
    else:
        general += 1
print('Menores de 10 años:',menores)
print('Monto menores:',menores*1000)

print('Mayores de 65 años:',mayores)
print('Monto mayores:',mayores*2000)

print('Publico general:',general)
print('Monto general:',general*3000)

print('Publico total:',total)
print('Monto general:',((general*3000)+(mayores*2000)+(menores*1000)))