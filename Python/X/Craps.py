# César Antonio Muñoz Francke - ICCI - Tarea N°2
# Versión Modificada para Revisión Pública

def obtenerPuntosJ1(linea: str = "") -> int: # Función que calcula el puntaje del jugador 1, que obtiene un str y devuelve un int
    if linea == "": # Si se ejecuta el valor default de linea
        raise ValueError("No se ha obtenido una línea con el cual trabajar.") # Se genera un error de tipo

    partes = linea.split(",") # Dividir linea
    jugador = partes[0].lower() # Obtener jugador
    puntajeDadoUno = int(partes[1]) # Obtener primer dado
    puntajeDadoDos = int(partes[2]) # Obtener segundo dado

    if jugador == "jugador 1": # Si es jugador 1
        return calcularPuntaje1(puntajeDadoDos + puntajeDadoUno) # Dar puntaje según la suma de sus dados
    else: # En caso contrario
        return 0 # Retornar 0

def obtenerPuntosJ2(linea: str = "") -> int: # Función que calcula el puntaje del jugador 1, que obtiene un str y devuelve un int
    if linea == "": # Si se ejecuta el valor default de linea
        raise ValueError("No se ha obtenido una línea con el cual trabajar.") # Se genera un error de tipo

    partes = linea.split(",") # Dividir linea
    jugador = partes[0].lower() # Obtener jugador
    puntajeDadoUno = int(partes[1]) # Obtener primer dado
    puntajeDadoDos = int(partes[2]) # Obtener segundo dado

    if jugador == "jugador 2": # Si es jugador 2
        return calcularPuntaje1(puntajeDadoDos + puntajeDadoUno) # Dar puntaje según la suma de sus dados
    else: # En caso contrario
        return 0 # Retornar 0

def calcularPuntaje1(sumaDeDados: int = -1) -> int: # Función para calcular puntaje, que obtiene un int y devuelve un int
    if sumaDeDados == -1: # Si se ejecuta el valor default de sumaDeDados
        raise TypeError("No se ha obtenido una suma de dados.")  # Se genera un error de tipo

    if sumaDeDados == 7 or sumaDeDados == 11: # Si la suma de los dados es igual a 7 o 11
        return 3 # sumar 3 puntos
    elif sumaDeDados == 2 or sumaDeDados == 3 or sumaDeDados == 12: # Si la suma de los dados es igual a 2, 3 o 12
        return -2 # restar 2 puntos
    else: # en caso contrario
        return 1 # sumar 1 punto

def calcularPuntaje2(sumaDeDados: int = -1) -> int: # Función para calcular puntaje, que obtiene un int y devuelve un int
    if sumaDeDados == -1:  # Si se ejecuta el valor default de sumaDeDados
        raise TypeError("No se ha obtenido una suma de dados.")  # Se genera un error de tipo

    if sumaDeDados == 7 or sumaDeDados == 11: # Si la suma de los dados es igual a 7 o 11
        return 3 # sumar 3 puntos
    elif sumaDeDados == 2 or sumaDeDados == 3 or sumaDeDados == 12: # Si la suma de los dados es igual a 2, 3 o 12
        return -2 # restar 2 puntos
    else: # en caso contrario
        return 1 # sumar 1 punto

def imprimirPuntajesFinales(puntajeFinalJugadorUno: int, puntajeFinalJugadorDos: int) -> None: # Procedimiento para imprimir puntajes finales
    print("Puntaje Final del Jugador 1:", puntajeFinalJugadorUno) # Imprimir puntaje del jugador 1
    print("Puntaje Final del Jugador 2:", puntajeFinalJugadorDos) # Imprimir puntaje del jugador 2

    if puntajeFinalJugadorUno > puntajeFinalJugadorDos: # Si el jugador 1 tiene más puntos que el jugador 2
        print("El ganador es Jugador 1") # Decir que el jugador 1 ganó
    elif puntajeFinalJugadorUno < puntajeFinalJugadorDos:  # Si el jugador 2 tiene más puntos que el jugador 1
        print("El ganador es Jugador 2") # Decir que el jugador 2 ganó
    else: # En caso contrario
        print("¡Es un empate!") # Decir que el juego fue un empate

puntosPrimerJugador = 0 # Inicializar puntos del jugador uno en cero
puntosSegundoJugador = 0 # Inicializar puntos del jugador dos en cero

with open("./dados.txt", encoding="UTF-8") as archivo: # Con la función open() de dados.txt dentro del mismo directirio, como archivo. El archivo se cerrará el archivo automáticamente una vez terminado la declaración "with"
    for linea in archivo: # Por cada línea en el archivo
        puntosPrimerJugador += obtenerPuntosJ1(linea) # Sumar puntaje correspondiente al jugador uno
        puntosSegundoJugador += obtenerPuntosJ2(linea) # Sumar puntaje correspondiente al jugador dos

imprimirPuntajesFinales(puntosPrimerJugador, puntosSegundoJugador) # Imprimir resultados finales del juego
input("== Programa Terminado ==") # Input arbitrario para evitar que la consola se cierre