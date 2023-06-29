#Giacomo Baldessari

puerta = True

def anillos(num):
    anillos = 0
    num = list(num)
    for i in range(len(num)):
        if num[i] == '0' or num[i] == '6' or num[i] == '9':
            anillos += 1
        elif num[i] == '8':
            anillos += 2
        else:
            anillos += 0
    return anillos

while puerta == True:
    num = str(input('Ingrese el numero a evaluar: '))
    print('Los anillos presentes en el numero son:',anillos(num))
    otroNum = str(input('¿Desea evaluar otro numero? '))
    if otroNum == 'NO':
        puerta = False
    elif otroNum == 'SI':
        puerta = True
    else:
        while otroNum != 'SI' and otroNum != 'NO':
            otroNum = str(input('¿Desea evaluar otro numero? '))
            if otroNum == 'NO':
                puerta = False
            elif otroNum == 'SI':
                puerta = True