#Giacomo Baldessari

def ventas(cantidad,tipo):
    pago = 0
    if tipo == 'cancha':
        pago = 20000 * cantidad
    elif tipo == 'platea':
        pago = 30000 * cantidad
    elif tipo == 'vip':
        pago = 40000 * cantidad
    else:
        pago = 0
    return pago


puerta = False
ingresarDato = input('Ingrese datos:').lower()
datoIngresado = ingresarDato.split(',')

if len(datoIngresado) == 0:
    puerta = True
else:
    puerta = False

while puerta == False:
    ventas(int(datoIngresado[0]),datoIngresado[1])
    
    if ventas(int(datoIngresado[0]),datoIngresado[1]) == 0:
        print('Error: Ingrese datos validos')
    else:
        print('Monto a cancelar:',ventas(int(datoIngresado[0]),datoIngresado[1]))
    ingresarDato = input('Ingrese datos: ').lower()
    datoIngresado = ingresarDato.split()

    if len(datoIngresado) == 0:
        puerta = True
    else:
        puerta = False
