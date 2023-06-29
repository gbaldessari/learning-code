import numpy as np

matrizConNumerosAletorios = np.random.rand(5, 5)
"""
La línea anterior genera una matriz de 5x5
rellena de números aleatorios en el intervalo real [0, 1)

Nota: No. No lo puedes ocupar en las pruebas ni nada.
"""

def cambiarValoresMatriz(matriz): # Permite cambiar los valores de una matriz, como multiplicar todos por 10 o aproximarlos todos
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            valorSobrescribir = round(matriz[linea][columna]*100, 0) # Este valor lo puedes cambiar por lo que haga falta
            matriz[linea][columna] = valorSobrescribir

def lineaPorColuma(matriz): # Recorrerá una matriz, primero por líneas y luego por columnas
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            """
            Aquí podrías hacer lo que haga falta, por ejemplo:
            1. Hallar los totales por linea
            2. Hallar el mayor por linea
            3. Hallar el menor por linea
            """
            print(linea, columna)

def columnaPorLinea(matriz): # Recorrerá una matriz, primero por columna y luego por líneas
    for columna in range(matriz.shape[1]):
        for linea in range(matriz.shape[0]):
            """
            Aquí podrías hacer lo que haga falta, por ejemplo:
            1. Hallar los totales por columna
            2. Hallar el mayor por columna
            3. Hallar el menor por columna
            """
            print(linea, columna)

def hallarElMayor(matriz): # Encontrar el mayor en una matriz
    elMayor = matriz[0][0]

    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            if matriz[linea][columna] > elMayor:
                elMayor = matriz[linea][columna]

    return elMayor

def hallarElMenor(matriz): # Encontrar el menor en una matriz
    elMenor = matriz[0][0]

    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            if matriz[linea][columna] < elMenor:
                elMenor = matriz[linea][columna]

    return elMenor

def obtenerIndices(matriz, elemento): #Hallar un cierto elemento en la matriz, y devolver sus coordenadas, si no existe se devuelve [-1, -1]
    """
    Nótese que primero hacemos un loop por linea
    luego por columna

    Dependiendo del contexto, te será más útil que primero
    lea las columnas, luego las filas

    Deberías de ser capaz de identificar el contexto e intercambiar
    esas líneas a tu conveniencia
    """
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            if matriz[linea][columna] == elemento:
                return [linea, columna]
    return [-1, -1]

def existeMatriz(matriz, elemento): #Verificar si un elemento existe en la matriz
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            if matriz[linea][columna] == elemento:
                return True
    return False

def sumaMatriz(matriz): #Suma todos los elementos de una matriz
    acumuladorSumatoria = 0
    for linea in range(matriz.shape[0]):
        for columna in range(matriz.shape[1]):
            acumuladorSumatoria += matriz[linea][columna]
    return acumuladorSumatoria

# === Ejemplos de muestra ===
print(matrizConNumerosAletorios) # Matriz original
cambiarValoresMatriz(matrizConNumerosAletorios) # Hacemos un arreglo
print(matrizConNumerosAletorios) # Matriz corregida
print("El mayor es:", hallarElMayor(matrizConNumerosAletorios))
print("El menor es:", hallarElMenor(matrizConNumerosAletorios))
print("La suma de los números es:", sumaMatriz(matrizConNumerosAletorios))
print("El número 7 existe en la matriz:", existeMatriz(matrizConNumerosAletorios, 7))

if existeMatriz(matrizConNumerosAletorios, 7):
    print("El número 7 está en las coodenadas:", obtenerIndices(matrizConNumerosAletorios, 7))