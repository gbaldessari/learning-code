#Giacomo Baldessari

contadorTotal = 0
contadorMayor = 0
contadorMenor = 0

nombreMenor = ''
menor = 500

nombreMayor = ''
mayor = -1

nombre = str(input('Ingrese el nombre: ')).lower()

if nombre != 'fin':
    nota = float(input('Ingrese la nota: '))
    
else:
    nota = -1

while nota != -1:

    if nota >= 4:
        contadorMayor += 1
        contadorTotal += 1
        if nota < menor:
            menor = nota
            nombreMenor = nombre
    
    else:
        contadorMenor += 1
        contadorTotal += 1
        if nota > mayor:
            mayor = nota
            nombreMayor = nombre
        
    nombre = str(input('Ingrese el nombre: '))
    if nombre != 'fin':
        nota = float(input('Ingrese la nota: '))
    else:
        nota = -1

if contadorTotal != 0:
    porcentajeMayor = (100 * contadorMayor)/contadorTotal
    porcentajeMenor = (100 * contadorMenor)/contadorTotal

else:
    porcentajeMayor = 0
    porcentajeMenor = 0

print('Total de notas ingresadas:', contadorTotal)
print('Cantidad de notas mayores o iguales a 4.0:', contadorMayor,'(',porcentajeMayor,'% )')
if menor == 500:
    print('     No existe menor')
else:
    print('     La menor fue:', menor,'(',nombreMenor.capitalize(),' )')
print('Cantidad de notas menores a 4.0:', contadorMenor,'(',porcentajeMenor,'% )')
if mayor == -1:
    print('     No existe mayor')
else:
    print('     La mayor fue:', mayor,'(',nombreMayor.capitalize(),' )')