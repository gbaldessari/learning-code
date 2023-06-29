#Giacomo Baldessari

arch = open('dados.txt', encoding='UTF-8')
datos = arch.readline().strip()
print(datos)
puntajeCJ1 = 0
puntajeCJ2 = 0

def obtenerPuntosJ1(datos):
    lista = datos.split(',')

    jugador = lista[0]
    puntajeJ1 = (int(lista[1]) + int(lista[2]))
    
    if jugador != 'Jugador 1':
        puntajeJ1 = 0
    
    return puntajeJ1
    
def obtenerPuntosJ2(datos):
    lista = datos.split(',')

    jugador = lista[0]
    puntajeJ2 = (int(lista[1]) + int(lista[2]))
    
    if jugador != 'Jugador 2':
        puntajeJ2 = 0
    
    return puntajeJ2

def calcularPuntajeJ1(puntajeJ1):
    puntajeFJ1 = 0
    
    if puntajeJ1 == 7 or puntajeJ1 == 11:
        puntajeFJ1 += 3

    elif puntajeJ1 == 2 or puntajeJ1 == 3 or puntajeJ1 == 12:
        puntajeFJ1 -= 2

    elif puntajeJ1 == 4 or puntajeJ1 == 5 or puntajeJ1 == 6 or puntajeJ1 == 8 or puntajeJ1 == 9 or puntajeJ1 == 10:
        puntajeFJ1 += 1

    return puntajeFJ1

def calcularPuntajeJ2(puntajeJ2):
    puntajeFJ2 = 0

    if puntajeJ2 == 7 or puntajeJ2 == 11:
        puntajeFJ2 += 3

    elif puntajeJ2 == 2 or puntajeJ2 == 3 or puntajeJ2 == 12:
        puntajeFJ2 -= 2

    elif puntajeJ2 == 4 or puntajeJ2 == 5 or puntajeJ2 == 6 or puntajeJ2 == 8 or puntajeJ2 == 9 or puntajeJ2 == 10:
        puntajeFJ2 += 1

    return puntajeFJ2

while datos != '':
    obtenerPuntosJ1(datos)
    puntosJ1 = int(obtenerPuntosJ1(datos))
    
    obtenerPuntosJ2(datos)
    puntosJ2 = int(obtenerPuntosJ2(datos))
    
    calcularPuntajeJ1(puntosJ1)
    puntajeCJ1 += int(calcularPuntajeJ1(puntosJ1))
    
    calcularPuntajeJ2(puntosJ2)
    puntajeCJ2 += int(calcularPuntajeJ2(puntosJ2))
    
    datos = arch.readline().strip()

print('Puntaje Final del Jugador 1:', puntajeCJ1)
print('Puntaje Final del Jugador 2:', puntajeCJ2)

if puntajeCJ1 > puntajeCJ2:
    print('El ganador es Jugador 1')

elif puntajeCJ1 == puntajeCJ2:
    print('Hubo un empate')  

else:
    print('El ganador es Jugador 2')

arch.close()