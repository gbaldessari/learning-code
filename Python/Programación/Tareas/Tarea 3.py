#Giacomo Baldessari

arch = open('historial.txt', encoding='UTF-8')
datos = arch.readline().strip()

jugadores = []

maderaApro = []
maderaAprv = 0

promedio = 0

piel = 0
madera = 0
fibra = 0 

cuero = 0
tablones = 0
tela = 0

nivel = 0
xpNivel = 50
experiencia = 0

def comprobadorNombres(listaJugadores, nombreJugador):
    for i in range(len(listaJugadores)):
        if listaJugadores[i] == nombreJugador:
            return True
    
    return False

def recoleccionPiel(lista):
    piel = 0
    if lista[1] == 'Jabalí':
        piel += 20
    elif lista[1] == 'Lobo':
        piel += 10
    elif lista[1] == 'Pavo':
        piel += 5
    else:
        piel += 0
    return piel

def recoleccionMadera(lista):
    madera = 0
    if lista[1] == 'Madera dura':
        madera += 30
    elif lista[1] == 'Madera de sino':
        madera += 60
    elif lista[1] == 'Pimpollo':
        madera += 45
    else:
        madera += 0
    return madera

def recoleccionFibra(lista):
    fibra = 0
    if lista[1] == 'Cáñamo':
        fibra += 20
    elif lista[1] == 'Hierbasedosa':
        fibra += 15
    elif lista[1] == 'Especias':
        fibra += 10
    else:
        fibra += 0
    return fibra

def fabricacionCuero(piel):
    cuero = 0
    if piel >= 4:
        cuero = piel // 4
    return cuero

def fabricacionTablones(madera):
    tablones = 0
    if madera >= 5:
        tablones = madera // 5
    return tablones

def fabricacionTela(fibra):
    tela = 0
    if fibra >= 10:
        tela = fibra // 10
    return tela

def pielSobrante(piel):
    pielS = piel % 4
    piel = pielS
    return piel

def maderaSobrante(madera):
    maderaS = madera % 5
    madera = maderaS
    return madera

def fibraSobrante(fibra):
    fibraS = fibra % 10
    fibra = fibraS
    return fibra

def experienciaRecoleccion(nivel):
    experienciaObtenida = 0
    experienciaObtenida += (25 + (nivel* 10))
    return experienciaObtenida

def experienciaFabricacion(pFabricado):
    experienciaObtenida = 0
    experienciaObtenida += 10 * pFabricado
    return experienciaObtenida

def aprovecharMadera(lista):
    minimo = 10000000000000000000000000000000000000000
    for i in range(len(lista)):
        if int(lista[i]) < minimo:
            aproMadera = i
    return aproMadera

while datos != '':
    lista = datos.split(',')
    jugador = lista[0]
    comprobadorNombres(jugadores, jugador)

    if comprobadorNombres(jugadores, jugador) == False:
        jugadores.append(jugador)
    else:
        jugadores.remove(jugador)
    
    datos = arch.readline().strip()

arch.close()

for i in range(len(jugadores)):

    arch = open('historial.txt', encoding='UTF-8')
    datos = arch.readline().strip()

    player = jugadores[i]

    while datos != '':
        lista = datos.split(',')
        if lista[0] == player:
            recoleccionPiel(lista)
            piel += recoleccionPiel(lista)

            recoleccionMadera(lista)
            madera += recoleccionMadera(lista)

            recoleccionFibra(lista)
            fibra += recoleccionFibra(lista)

            if lista[1] == 'Cuero':
                fabricacionCuero(piel)
                cuero += fabricacionCuero(piel)

                if fabricacionCuero(piel) > 0:
                    print(player,'ha fabricado',fabricacionCuero(piel),'unidades de Cuero')

                pielSobrante(piel)
                piel = pielSobrante(piel)
                
            
            if lista[1] == 'Tablones':
                fabricacionTablones(madera)
                tablones += fabricacionTablones(madera)

                if fabricacionTablones(madera) > 0:
                    print(player,'ha fabricado',fabricacionTablones(madera),'unidades de Tablones')

                maderaSobrante(madera)
                madera = maderaSobrante(madera)
            
            if lista[1] == 'Tela':
                fabricacionTela(fibra)
                tela += fabricacionTela(fibra)

                if fabricacionTela(fibra) > 0:
                    print(player,'ha fabricado',fabricacionTela(fibra),'unidades de Tela')

                fibraSobrante(fibra)
                fibra = fibraSobrante(fibra)

        datos = arch.readline().strip()

    fibra = 0
    madera = 0
    piel = 0
    
    arch.close()

print('------------------------------')
print('2) Experiencia obtenida:')

for i in range(len(jugadores)):

    arch = open('historial.txt', encoding='UTF-8')
    datos = arch.readline().strip()

    player = jugadores[i]

    while datos != '':
        lista = datos.split(',')
        if lista[0] == player:

            if lista[1] == 'Jabalí' or lista[1] == 'Lobo' or lista[1] == 'Pavo':
                recoleccionPiel(lista)
                piel += recoleccionPiel(lista)

                experienciaRecoleccion(nivel)
                experiencia += experienciaRecoleccion(nivel)

                while experiencia >= xpNivel:
                    nivel += 1
                    round(xpNivel)
                    xpNivel += (xpNivel + (xpNivel*0.05))
                    

            if lista[1] == 'Madera dura' or lista[1] == 'Madera de sino' or lista[1] == 'Pimpollo':
                recoleccionMadera(lista)
                madera += recoleccionMadera(lista)

                experienciaRecoleccion(nivel)
                experiencia += experienciaRecoleccion(nivel)

                while experiencia >= xpNivel:
                    nivel += 1
                    round(xpNivel)
                    xpNivel += (xpNivel + (xpNivel*0.05))
                    

            if lista[1] == 'Cáñamo'or lista[1] == 'Hierbasedosa' or lista[1] == 'Especias':
                recoleccionFibra(lista)
                fibra += recoleccionFibra(lista)

                experienciaRecoleccion(nivel)
                experiencia += experienciaRecoleccion(nivel)

                while experiencia >= xpNivel:
                    nivel += 1
                    round(xpNivel)
                    xpNivel += (xpNivel + (xpNivel*0.05))
                    

            if lista[1] == 'Cuero':
                fabricacionCuero(piel)
                cuero += fabricacionCuero(piel)

                experienciaFabricacion(fabricacionCuero(piel))
                experiencia += experienciaFabricacion(fabricacionCuero(piel))
                if fabricacionCuero(piel) > 0:
                    while experiencia >= xpNivel:
                        nivel += 1
                        round(xpNivel)
                        xpNivel += (xpNivel + (xpNivel*0.05))
                    

                pielSobrante(piel)
                piel = pielSobrante(piel)
                
            
            if lista[1] == 'Tablones':
                fabricacionTablones(madera)
                tablones += fabricacionTablones(madera)

                experienciaFabricacion(fabricacionTablones(madera))
                experiencia += experienciaFabricacion(fabricacionTablones(madera))
                if fabricacionCuero(piel) > 0:
                    while experiencia >= xpNivel:
                        nivel += 1
                        round(xpNivel)
                        xpNivel += (xpNivel + (xpNivel*0.05))
                    

                maderaSobrante(madera)
                madera = maderaSobrante(madera)
            
            if lista[1] == 'Tela':
                fabricacionTela(fibra)
                tela += fabricacionTela(fibra)
                
                experienciaFabricacion(fabricacionTela(fibra))
                experiencia += experienciaFabricacion(fabricacionTela(fibra))
                if fabricacionCuero(piel) > 0:
                    while experiencia >= xpNivel:
                        nivel += 1
                        round(xpNivel)
                        xpNivel += (xpNivel + (xpNivel*0.05))

                fibraSobrante(fibra)
                fibra = fibraSobrante(fibra)

        datos = arch.readline().strip()

    print('-',player,'nivel',nivel,round(experiencia),'xp')
    
    experiencia = 0
    nivel = 0
    xpNivel = 50

    fibra = 0
    madera = 0
    piel = 0

    tablones = 0
    tela = 0
    cuero = 0 
            
    arch.close()

print('3) Recursos:')

for i in range(len(jugadores)):

    arch = open('historial.txt', encoding='UTF-8')
    datos = arch.readline().strip()

    player = jugadores[i]

    while datos != '':
        lista = datos.split(',')
        if lista[0] == player:
            recoleccionPiel(lista)
            piel += recoleccionPiel(lista)

            recoleccionMadera(lista)
            madera += recoleccionMadera(lista)

            recoleccionFibra(lista)
            fibra += recoleccionFibra(lista)

            if lista[1] == 'Cuero':
                fabricacionCuero(piel)
                cuero += fabricacionCuero(piel)

                pielSobrante(piel)
                piel = pielSobrante(piel) 
            
            if lista[1] == 'Tablones':
                fabricacionTablones(madera)
                tablones += fabricacionTablones(madera)

                maderaSobrante(madera)
                madera = maderaSobrante(madera)
            
            if lista[1] == 'Tela':
                fabricacionTela(fibra)
                tela += fabricacionTela(fibra)

                fibraSobrante(fibra)
                fibra = fibraSobrante(fibra)

        datos = arch.readline().strip()

    print('-',player,'Piel',piel,'Madera',madera,'Fibra',fibra)
    
    maderaApro.append(madera)
    
    promedio += tablones

    fibra = 0
    madera = 0
    piel = 0

    tablones = 0
    tela = 0
    cuero = 0 
    
    arch.close()

aprovecharMadera(maderaApro)
maderaAprv = aprovecharMadera(maderaApro)

print('4) El jugador que aprovechó mejor la madera fue:',jugadores[maderaAprv])

if len(jugadores) != 0:
    promedioTablones = promedio/len(jugadores)
else:
    promedioTablones = 0
print('5) El promedio de Tablones fabricados fue:',promedioTablones)