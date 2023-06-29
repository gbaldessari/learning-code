#Giacomo Baldessari

import math

angulo = float(input('Ingrese el angulo: '))
velocidad = float(input('Ingrese la velocidad: '))

def sen(angulo):
    return math.sin(math.radians(angulo))

def cos(angulo):
    return math.cos(math.radians(angulo))

def lanzamiento(angulo,velocidad):
    tiempo = 0
    posicion = [0,0]
    puerta = False
    while puerta == False:

        posicion = [(velocidad*cos(angulo)*tiempo),((-0.5*9.8)*(tiempo**2)+(velocidad*sen(angulo)*tiempo))]
        if posicion[1] < 0:
            tiempo = (2*velocidad*sen(angulo))/9.8
            posicion = [(velocidad*cos(angulo)*tiempo),((-0.5*9.8)*(tiempo**2)+(velocidad*sen(angulo)*tiempo))]
            print(posicion)
            puerta = True
        else:
            print(posicion)
            tiempo += 1

lanzamiento(angulo,velocidad)