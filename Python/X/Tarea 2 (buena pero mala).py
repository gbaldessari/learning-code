#Giacomo Baldessari

arch = open('dados.txt', encoding='UTF-8')
datos = arch.readline().strip()

obtenerPuntosJ1 = 0
obtenerPuntosJ2 = 0

calcularPuntajeJ1 = 0
calcularPuntajeJ2 = 0

while datos != '':

    lista = datos.split(',')

    if lista[0] == 'Jugador 1':

        obtenerPuntosJ1 = (int(lista[1]) + int(lista[2]))

        if obtenerPuntosJ1 == 7 or obtenerPuntosJ1 ==11:
            calcularPuntajeJ1 += 3

        elif obtenerPuntosJ1 == 2 or obtenerPuntosJ1 == 3 or obtenerPuntosJ1 == 12:
            calcularPuntajeJ1 -= 2

        else:
            calcularPuntajeJ1 += 1
    
    if lista[0] == 'Jugador 2':
        
        obtenerPuntosJ2 = (int(lista[1]) + int(lista[2]))

        if obtenerPuntosJ2 == 7 or obtenerPuntosJ2 ==11:
            calcularPuntajeJ2 += 3

        elif obtenerPuntosJ2 == 2 or obtenerPuntosJ2 == 3 or obtenerPuntosJ2 == 12:
            calcularPuntajeJ2 -= 2

        else:
            calcularPuntajeJ2 += 1

    datos = arch.readline().strip()

print('Puntaje Final del Jugador 1:', calcularPuntajeJ1)
print('Puntaje Final del Jugador 2:', calcularPuntajeJ2)

if calcularPuntajeJ1 > calcularPuntajeJ2:
    print('El ganador es Jugador 1')
    
else:
    print('El ganador es Jugador 2')

arch.close()