#Giacomo Baldessari

num = float(input('Ingrese un numero: '))

def parImpar(num):
    iteraciones = 0
    while num != 1:
        if num%2 == 0:
            iteraciones += 1
            num = num/2
        else:
            num = 3*num+1
            iteraciones += 1
    return iteraciones
        
print(parImpar(num))