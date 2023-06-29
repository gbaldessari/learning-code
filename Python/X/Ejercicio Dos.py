import numpy as np # Importamos Numpy como np

archivoLluvias = open("lluvias.txt", encoding="UTF-8") # Leemos el archivo
linea = archivoLluvias.readline().strip() # Leemos la primera linea de cantidad de comunas
comunas = [] # Declaramos una lista vacía de comunas
meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septimebre", "Octubre", "Noviembre", "Diciembre"] # Declaramos una lista con los meses del año (bastante útil)

for comuna in range(int(linea)): # Por cada comuna
    linea = archivoLluvias.readline().strip() # Leemos una línea de comuna
    comunas.append(linea) # Guardamos la comuna en la lista
    
matrizLluvias = np.zeros([len(comunas), 12]) # Declaramos una matriz de comunas y meses
acumuladorPrecipitaciones = 0 # Declaramos un acumulador de precipitaciones totales

for indiceComuna in range(len(comunas)): # Por cada comuna-precipitacion
    linea = archivoLluvias.readline().strip() # Leemos un archivo de precipitación
    partes = linea.split(",") # Declaramos las partes

    for indicePrecipitacion in range(12): # Por cada precipitación mensual
        acumuladorPrecipitaciones += float(partes[indicePrecipitacion]) # Acumulamos la precipitación
        matrizLluvias[indiceComuna][indicePrecipitacion] = float(partes[indicePrecipitacion]) # Guardamos en la matriz la precipitación

archivoLluvias.close() # Cerramos el archivo dado que no se ocupará más

# == PARTE 1 (PRECIPITACIONES TOTALES) ==
print("1. La cantidad total del mm en la región de Coquimbo es:", round(acumuladorPrecipitaciones,2)) # Imprimimos el enunciado 1

# == PARTE 2 (REPORTE MENSUAL) ==
print() # Imprimimos una línea vacía, para separación
print("2. Reporte Mensual de Precipitaciones") # Imprimimos el enunciado

mesesSinPrecipitaciones = [] # Declaramos una lista vacía para añadir los meses sin precipitación (Parte 5)
for indiceMensual in range(matrizLluvias.shape[1]): # Por cada mes
    acumuladorMensual = 0 # Declaramos un acumulador mensual
    for indiceComuna in range(matrizLluvias.shape[0]): # Por cada comuna
        acumuladorMensual += matrizLluvias[indiceComuna][indiceMensual] # Acumulamos los mm de precipitación
    print(meses[indiceMensual], round(acumuladorMensual, 2)) # Imprimirmos el informe mensual
    if acumuladorMensual == 0: # Si ese mes no hubo precipitaciones (Parte 5)
        mesesSinPrecipitaciones.append(meses[indiceMensual]) # Guardamos el mes sin precipitación en la lista (Parte 5)

# == PARTE 3 (REPORTE COMUNAL) ==
print() # Imprimimos una línea vacía, para separación
print("3. Reporte Mensual por comunas") # Imprimimos el enunciado

precipitacionesPorComuna = [] # Declaramos una lista para las precipitaciones por comuna (Parte 4)
for indiceComuna in range(matrizLluvias.shape[0]): # Por cada comuna
    acumuladorComunal = 0 # Declaramos un acumulador comunal
    for indiceMensual in range(matrizLluvias.shape[1]): # Por cada mes
        acumuladorComunal += matrizLluvias[indiceComuna][indiceMensual] # Acumulamos los mm de precipitación
    print(comunas[indiceComuna], round(acumuladorComunal, 2)) # Imprimirmos el informe comunal
    precipitacionesPorComuna.append(acumuladorComunal) # Guardamos la precipitación comunal en la lista (Parte 4)

# == PARTE 4 (COMUNA CON MENOS PRECIPITACIÓN) ==
print() # Imprimimos una línea vacía, para separación
print("4. La comuna con menor precipitación es:") # Imprimirmos el enunciado

indiceElMenor = 0 # Declaramos el índice (por default) del menor mes
for indice in range(len(precipitacionesPorComuna)): # Recorremos la lista de precipitaciones comunales por índice
    if precipitacionesPorComuna[indice] < precipitacionesPorComuna[indiceElMenor]: # Si la precipitación es menor al actual record
        indiceElMenor = indice # Ese nuevo índice pasa a ser el nuevo menor

for indice in range(len(precipitacionesPorComuna)): # Recorremos la lista de precipitaciones comunales por índice
    if precipitacionesPorComuna[indiceElMenor] == precipitacionesPorComuna[indice]: # Si el mes califica como uno de los menores
        print(comunas[indice]) # Imprimimos el menor mes

# == PARTE 5 (MESES SIN PRECIPITACIÓN) ==
print() # Imprimimos una línea vacía, para separación
print("5. Los meses sin precitaciones fueron:") # Imprimimos el enunciado

for mes in mesesSinPrecipitaciones: # Por cada mes sin precipitación
    print(mes) # Imprimir mes