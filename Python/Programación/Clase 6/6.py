#Giacomo Baldessari

def calcularTiempo(distancia, velocidad):
    tiempo = (distancia/velocidad)
    return tiempo

def dividirDistancia(distancia):
    nuevaDistancia = (distancia/2)
    return nuevaDistancia

def aumentarVelocidad(velocidad):
    nuevaVelocidad = velocidad*1.5
    return nuevaVelocidad

def iterar(distancia,velocidad):
    tiempoFinal = 0
    tiempo = calcularTiempo(dividirDistancia(distancia), velocidad)

    while tiempo > 0.01:
        tiempoFinal += tiempo
        print('En recorrer',dividirDistancia(distancia),'me demoro',tiempo,'con velocidad',velocidad)
        distancia = dividirDistancia(distancia)
        velocidad = aumentarVelocidad(velocidad)
        tiempo = calcularTiempo(distancia/2, velocidad)

    return tiempoFinal

def main():
    distancia = 100
    velocidad = 2
    print('Vamos a comenzar con d=',dividirDistancia(distancia),'y v=',velocidad)
    tiempo = iterar(distancia,velocidad)
    print('Tiempo total', tiempo)

main()