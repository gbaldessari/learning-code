#Giacomo Baldessari

velocidad = float(input('Ingrese la velocidad: '))
tiempo = int(input('Ingrese el tiempo: '))

def distancia(velocidad,tiempo):
    distancia = 0
    for i in range(tiempo+1):
        print('Tiempo:',(i),'Velocidad:',velocidad,'Distancia recorrida:',distancia)
        distancia += velocidad
distancia(velocidad,tiempo)