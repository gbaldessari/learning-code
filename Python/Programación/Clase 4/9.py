#Giacomo Baldessari

jugador1 = str(input('Ingresa el nombre del jugador 1: '))
jugador2 = str(input('Ingresa el nombre del jugador 2: '))

score1 = 0
score2 = 0

respuesta1 = ''
respuesta2 = ''

while score1 < 300 and score2 < 300:
    print()
    respuesta1 = input('Respuesta 1: ')
    respuesta2 = input('Respuesta 2: ')

    if respuesta2 == 'x' and respuesta1 == 'x':
        respuesta2 += 0
        respuesta1 += 0
    else:
        if respuesta1 != 'x':
            score1 += 100
        if respuesta2 != 'x':
            score2 += 100
        if respuesta1 != 'x' and respuesta2 == 'x':
            score1 += 50
        if respuesta2 != 'x' and respuesta1 == 'x':
            score2 += 50
    
    print('Puntuacion del jugador 1:',score1)
    print('Puntuacion del jugador 2:',score2)

if score1 == score2:
    print()
    print('Empate')
else:
    if score1 >= score2:
        print('Gana',jugador1,'!')
    if score2 >= score1:
        print('Gana',jugador2,'!')
