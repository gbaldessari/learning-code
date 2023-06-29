#Giacomo Baldessari

num1 = float(input('Ingrese el primer número:'))
num2 = float(input('Ingrese el segundo número:'))

if (num2 == 0 ):
    print('Error: No puedes dividir por "0"')
else:
    div = num1 / num2
    mod = num1 % num2
    mod2 = num2 % num1

    if (mod == 0):
        print('Es entero')
    else:
        print('No es entero, el resto es:', mod)

    if (num1 > num2):
        print('El primer número es mayor que el segundo')
    elif (num1 < num2):
        print('El segundo número es mayor que el primero')
    else:
        print('Los números son iguales')
    if (mod == 0):
        print('Los números son multiplos')
    elif (mod2 == 0):
        print('Los números son multiplos')
    else:
        print('Los números no son multiplos')


    





