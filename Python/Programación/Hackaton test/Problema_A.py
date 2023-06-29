#Giacomo Baldessari

ingresarDato = input()
datoIngresado = ingresarDato.split()

largo = len(datoIngresado)

error = False

if largo/2 == largo//2:
    for i in range(largo-1):
        if int(datoIngresado[i]) != int(datoIngresado[largo-1-i]):
            error = True

else:
    for i in range(largo-1):
        if int(datoIngresado[largo//2]) != i:
            if int(datoIngresado[i]) != int(datoIngresado[largo-1-i]):
                error = True
        

if error == False:
    print('SI')
else:
    print('NO')  