#Giacomo Baldessari

def entre(min,max,op):
    if op == 'multiplicacion':
        resultado = 1
        for i in range(min,(max+1)):
            resultado *= i
    elif op == 'suma':
        resultado = 0
        for i in range(min,(max+1)):
            resultado += i
    else:
        resultado = 0
    return resultado

ingresarDato = input('Ingrese datos:').lower()
datoIngresado = ingresarDato.split(',')

if len(datoIngresado) == 0:
    puerta = True
else:
    puerta = False

while puerta == False:
    min = int(datoIngresado[0])
    max = int(datoIngresado[1])
    op = datoIngresado[2]
    
    print(entre(min,max,op))

    ingresarDato = input('Ingrese datos:').lower()
    datoIngresado = ingresarDato.split(',')

    if len(datoIngresado) == 0:
        puerta = True
    else:
        puerta = False
