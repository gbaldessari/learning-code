#Giacomo Baldessari

ingresarDato = input()
datoIngresado = ingresarDato.split()

alto = int(datoIngresado[1])
primero = int(datoIngresado[0])

lista = ''

for i in range(alto):
    imprimir = lista + str(primero+i) + ' '
    lista = imprimir
    print(lista)