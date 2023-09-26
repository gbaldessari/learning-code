#-----------------------------------------------------------------------------
#DAVID AUGUSTO HILBE
#RUT : 25.873.546-3
#ICCI - C1
#-----------------------------------------------------------------------------
Abrir = open("dados.txt","r") #ACA ABRE EL ARCHIVO DADOS.TXT.
Rechu = Abrir.readline().strip()
def obtenerPuntosJ2(Rechu):#DEFINO LA FUNCION CALCULARPUNTAJEJ2.
    total = 0
    while  Rechu != "":
        Novd = Rechu.split(",")
        Jugador = Novd[0]
        Dado1 = int(Novd[1])
        Dado2 = int(Novd[2])
        x = Dado1 + Dado2        
        if Jugador =="Jugador 2":#EN CUANTO EL JUGADOR SEA 2 LEA SI LA LINEA 1 Y 2 DAN CIERTAS SUMAS QUE LOS SUME A UN TOTAL DEL JUGADOR 2. 
            if x == 7 or x ==11:
                    total += 3
            elif x == 2 or x == 3 or x ==12:
                    total -= 2
            elif x == 4 or x == 5 or x == 6 or x == 8 or x == 9 or x == 10:
                    total += 1 
        Rechu = Abrir.readline().strip()        
    return total
    
TotalJ2 = obtenerPuntosJ2(Rechu)#CON ESTO VOY A LLAMAR AL TOTAL RECOLECTADO DEL JUGADOR 2.    

Abrir = open("dados.txt","r") #ACA NUEVAMENTE ABRO EL ARCHIVO DADOS.TXT YA QUE EL CICLO ANTERIOR LO DEJA EN LA ULTIMA LINEA E IMPIDE QUE SUME LOS DATOS EL JUGADOR 1.
def obtenerPuntosJ1(Rechu):#DEFINO LA FUNCION CALCULARPUNTAJEJ1.
    total = 0
    while  Rechu != "":
        Novd = Rechu.split(",")
        Jugador = Novd[0]
        Dado1 = int(Novd[1])
        Dado2 = int(Novd[2])
        x = Dado1 + Dado2        
        if Jugador =="Jugador 1":#EN CUANTO EL JUGADOR SEA 1 LEA SI LA LINEA 1 Y 2 DAN CIERTAS SUMAS QUE LOS SUME A UN TOTAL DEL JUGADOR 1. 
            if x == 7 or x ==11:
                    total += 3
            elif x == 2 or x == 3 or x ==12:
                    total -= 2
            elif x == 4 or x == 5 or x == 6 or x == 8 or x == 9 or x == 10:
                    total += 1 
        Rechu = Abrir.readline().strip()
    return total

TotalJ1 = obtenerPuntosJ1(Rechu)#CON ESTO OTRO VOY A LLAMAR AL TOTAL RECOLECTADO POR EL OTRO JUGADOR, OSEA EL JUGADOR 1. 
print("El puntaje del jugador 1:",TotalJ1)
print("El puntaje del jugador 2:",TotalJ2)

def calcularPuntajeJ1(Rechu):#ESTE DEF SIRVE PARA DEFINIR LOS PUNTOS Y EL GANADOR
    GanadorJ1 = "Ganador"
    if TotalJ1 > TotalJ2 :#SI EL JUGADOR 1 OBTIENE MAS PUNTOS QUE EL JUGADOR 2, EL GANADOR ES EL JUGADOR 1.
        GanadorJ1 = "El ganador es el Jugador 1"
        print(GanadorJ1)
    elif TotalJ1 == TotalJ2: #EN CASO DE QUE AMBOS JUGADORES TENGAN LOS MISMOS PUNTOS ESTOS QUEDARIAN EN UN EMPATE.
        print("Fue un empate")  
GanadorJugador1 = calcularPuntajeJ1(Rechu)

def calcularPuntajeJ2(Rechu):#ESTE DEF SIRVE PARA DEFINIR LOS PUNTOS Y EL GANADOR 
    GanadorJ2 = "Ganador"
    if TotalJ1 < TotalJ2 :#SI EL JUGADOR 2 OBTIENE MAS PUNTOS QUE EL JUGADOR 1, EL GANADOR ES EL JUGADOR 2.
        GanadorJ2 = "El ganador es el Jugador 2"
    elif TotalJ1 == TotalJ2 :#EN CASO DE QUE AMBOS JUGADORES TENGAN LOS MISMOS PUNTOS ESTOS QUEDARIAN EN UN EMPATE.
        print("Fue un empate")  
    print(GanadorJ2)
GanadorJugador1 = calcularPuntajeJ2(Rechu)

input("---FIN DEL PROGRAMA---")