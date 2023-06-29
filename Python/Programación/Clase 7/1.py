#Giacomo Baldessari

def factorial(num):
    numero = int(num)

    if int(num) == 0:
        return 1
    elif int(num) < 0:
        return 'Error: Ingrese un número valido'
    else:
        for i in range(int(num)-1):
            numero *= (int(num)-1-i)
        return numero
        
num = input('Ingrese un número: ')
print(factorial(num))