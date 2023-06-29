#Giacomo Baldessari

def esPrimo(num):
    if num <= 1:
        return False
    elif num == 2:
        return True
    else:
        for i in range(2, num):
            if num % i == 0:
                return False
        return True  

def IesPrimo(i):
    num = 0
    lista = []
    while len(lista) != i:
        
        num += 1
        if esPrimo(num) == True:
            lista.append(num)
    print(lista[i-1])

i = int(input('Ingrese un numero: '))
IesPrimo(i)