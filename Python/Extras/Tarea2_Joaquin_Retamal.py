#Joaquín Retamal ICCI

arch = open("dados.txt","r")
linea = arch.readline().strip()
def puntos_P1(linea):     #P1 = jugador 1
    PT1 = 0
    while linea != "":
        linea = linea.split(",")
        sd = int(linea[1]) + int(linea[2]) # [1] es dado 1, [2] dado 2, sd es suma dados
        if linea[0] == "Jugador 1":
            if sd == 7 or sd == 11: # validación 1
                PT1 += 3
            elif sd == 2 or sd == 3 or sd == 12: # validación 2
                PT1 -= 2
            elif sd == 4 or sd == 5 or sd == 6 or sd == 8 or sd == 9 or sd == 10: # validación 3
                PT1 += 1
        linea = arch.readline().strip()
    return(PT1)

puntos1 = puntos_P1(linea)
print("Los puntos del jugador 1:",puntos1)

arch = open("dados.txt","r")
linea = arch.readline().strip()
def puntos_P2(linea):     #P2 = jugador 2
    PT2 = 0
    while linea != "":
        linea = linea.split(",")
        sd = int(linea[1]) + int(linea[2]) # [1] es dado 1, [2] dado 2, sd es suma dados
        if linea[0] == "Jugador 2":
            if sd == 7 or sd == 11: # validación 1
                PT2 += 3
            elif sd == 2 or sd == 3 or sd == 12: # validación 2
                PT2 -= 2
            elif sd == 4 or sd == 5 or sd == 6 or sd == 8 or sd == 9 or sd == 10: # validación 3
                PT2 += 1
        linea = arch.readline().strip()
    return(PT2)

puntos2 = puntos_P2(linea)
print("Los puntos del jugador 2:",puntos2)

if puntos1 > puntos2:
    print("Jugador 1 gana")
if puntos1 < puntos2:
    print("jugador 2 gana")
if puntos1 == puntos2:
    print("empate")