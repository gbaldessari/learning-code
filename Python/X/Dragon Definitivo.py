#Giacomo Baldessari

import random
import time

score = 0

puerta = True

while puerta != False:
    jugarDeNuevo = ''

    print('-------------------------------------------------------------------------------------')
    print()
    print('Estás en un lugar repleto de dragones...')
    print()
    time.sleep(2)
    print('Y en búsqueda de un tesoro decides explorar...')
    print()
    time.sleep(2)
    print('Después de una ardua búsqueda finalmente hayas dos cuevas...')
    print()
    time.sleep(2)
    print('En una cueva se encuentra un dragón amigable que está dispuesto a compartir su tesoro')
    print()
    time.sleep(2)
    print('Pero en la otra, hay otro dragón que no será tan amable y te devorará apenas te vea.')
    print()
    print('-------------------------------------------------------------------------------------')
    time.sleep(2)

    cueva = ''

    while cueva != 'derecha' and cueva != 'izquierda':
        cueva = str(input('¿A que cueva quieres entrar?(Derecha/Izquierda): ')).lower()

    cuevaDragon = random.randint(1,2)

    print('-------------------------------------------------------------------------------------')
    print()
    print('Te acercas a la cueva...')
    print()
    time.sleep(2)
    print('Es oscura y aterradora...')
    print()
    time.sleep(2)
    print('¡Un dragón enorme aparece repentinamente frente a ti!')
    print()
    time.sleep(2)
    print('Se acerca lentamente y...')
    print()
    time.sleep(2)

    if cuevaDragon == 1:
        print('¡Comparte su tesoro sin problemas!')
        print()
        time.sleep(1)
        print('¡Felicidades!')
        print()
        print('-------------------------------------------------------------------------------------')
        print()
        print()
        time.sleep(2)
        score += 100

    else:
        print('¡Te come de un bocado!')
        time.sleep(1)
        print()
        print('Eso pasa por meterte donde no debias...')
        print('-------------------------------------------------------------------------------------')
        print()
        print()
        time.sleep(2)
        score = 0

    print('Tu puntaje es', score,'puntos')
    time.sleep(1)

    while jugarDeNuevo != 'si' and jugarDeNuevo != 'no':
        jugarDeNuevo = str(input('¿Quieres jugar de nuevo?(Si/No): ')).lower()

    if jugarDeNuevo == 'si':
        puerta = True

    else:
        puerta = False
    
print('Tu puntaje final es', score,'puntos!!')