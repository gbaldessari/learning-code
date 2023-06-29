#Giacomo Baldessari

num = float(input('Ingrese un número aqui: '))

while num != int(num):
    print('Error el número debe ser un entero')
    num = (input('Ingrese un número aqui: '))

print('Tu número es', num)

num2 = float(input('Ingrese otro número aqui: '))

while num2 != int(num2):
    print('Error el número debe ser un entero')
    num2 = (input('Ingrese otro número aqui: '))

while num2 <= num:
    print('Error el numero debe ser menor al anterior')
    num2 = (input('Ingrese otro número aqui: '))

print('Tu número es', num2)

num3 = float(input('Ingrese el intervalo aqui: '))

while num3 != int(num3):
    print('Error el número debe ser un entero')
    num3 = (input('Ingrese el intervalo aqui: '))

for i in range(int(num), int(num2), int(num3)):
    print(i)