#Giacomo Baldessari

def esPrimo(num):
    if num < 1:
        return False
    elif num == 2:
        return True
    else:
        for i in range(2, num):
            if num % i == 0:
                return False
        return True  

for i in range(3,101):
    if esPrimo(i) == True:
        print(i)