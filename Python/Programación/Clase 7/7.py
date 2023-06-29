#Giacomo Baldessari

velocidad = float(input('Ingrese la velocidad: '))
aceleracion = float(input('Ingrese la aceleración: '))
tiempo = int(input('Ingrese el tiempo: '))

def distancia(velocidad,aceleracion,tiempo):
    dist = 0
    distancia = 0
    vel = velocidad
    for i in range(tiempo+1):
        
        print('Tiempo:',(i),'Velocidad:',vel,'Distancia recorrida:',distancia)
        distancia = dist + (velocidad*(i+1))+(0.5*aceleracion)*((i+1)**2)
        vel += aceleracion
        
distancia(velocidad,aceleracion,tiempo)