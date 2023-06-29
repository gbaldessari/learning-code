import numpy as np # Importamos Numpy como np

archivoNotas = open("ww.txt", encoding="UTF-8") # Abrimos el archivo de notas
linea = archivoNotas.readline().strip() # Leemos la primera linea de cantidad de pruebas

pruebas = [] # Lista que contendrá el nombre de las pruebas
ponderaciones = [] # Lista que contendrá las ponderaciones de las pruebas
fechasPruebas = [] # Lista que contendrá las fechas de las pruebas
alumnos = [] # Lista que contendrá los RUT's de los alumnos

for indiceAlumno in range(int(linea)): # Por cada línea de datos de prueba
    linea = archivoNotas.readline().strip() # Leermos una linea de prueba
    partes = linea.split(",") # Lo separamos en parte por coma

    nombrePrueba = partes[0] # Declaramos el nombre de prueba
    ponderacionPrueba = int(partes[1]) # Declaramos la ponderación de la prueba, como int
    fecha = partes[2] # Declaramos la fecha de la prueba

    pruebas.append(nombrePrueba) # Guardamos el nombre de la prueba
    ponderaciones.append(ponderacionPrueba / 100) # Guardamos la ponderación de la prueba, dividido entre cien (porcentaje simple)
    fechasPruebas.append(fecha) # Guardamos la fecha de la prueba

linea = archivoNotas.readline().strip() # Leemos la linea que contiene la cantidad de alumnos

for indiceAlumno in range(int(linea)): # Por cada línea de alumno
    linea = archivoNotas.readline().strip() # Leemos una línea de alumnos
    alumnos.append(int(linea)) # Guardamos el RUT del alumno, como int

matrizNotas = np.zeros([len(alumnos), len(pruebas)]) # Declaramos una matriz que contendrá la sumatoria de notas por prueba y alumno
matrizVeces = np.zeros([len(alumnos), len(pruebas)]) # Declaramos una matriz que contendrá la cantidad de veces que un alumno dio una cierta prueba

linea = archivoNotas.readline().strip() # Leemos la linea que contiene la pruebas rendidas

for indiceAlumno in range(int(linea)): # Por cada línea de prueba rendida
    linea = archivoNotas.readline().strip() # Leermos una linea de prueba rendida
    partes = linea.split(",") # Declaramos las partes

    alumnoRendidor = int(partes[0]) # Declaramos el RUT del alumno rendidor, como int
    pruebaRendida = partes[1] # Declaramos la prueba rendida por el alumno
    nota = float(partes[2]) # Declaramos la nota de la prueba rendida, como float

    indiceAlumno = alumnos.index(alumnoRendidor) # Obtenemos el índice del alumno
    indicePrueba = pruebas.index(pruebaRendida) # Obtenemos el índice de la prueba

    matrizNotas[indiceAlumno][indicePrueba] += nota # Guardamos su nota en la matriz
    matrizVeces[indiceAlumno][indicePrueba] += 1 # Guardamos el intento rendido en la matriz

archivoNotas.close() # Cerramos el archivo, dado que no se ocupará más

for indiceAlumno in range(matrizNotas.shape[0]): # Por cada alumno en la matriz de notas
    for indicePrueba in range(matrizNotas.shape[1]): # Por cada prueba en la matriz de notas
        if matrizVeces[indiceAlumno][indicePrueba] == 0: # Si el alumno no rindió esa prueba
            matrizNotas[indiceAlumno][indicePrueba] = 1 # Rellenamos con nota mínima
        else: # Si el alumno si rindió esa prueba
            nota = float(matrizNotas[indiceAlumno][indicePrueba]) / int(matrizVeces[indiceAlumno][indicePrueba]) # Calculamos el promedio de sus intentos en esa prueba
            matrizNotas[indiceAlumno][indicePrueba] = nota # Reemplazamos la sumatoria de notas con nota promediada final

# == PARTE 1 (MEJOR NOTA POR PRUEBA) ==
print("Mejor nota por prueba:") # Imprimir primer enunciado
indicesMejoresNotas = [] # Una lista que contiene el índice de mejor nota, por cada prueba
for indicePrueba in range(matrizNotas.shape[1]): # Por cada prueba rendida
    indiceAlumnoMayorNota = 0  # Se declara el mejor alumno (por default) como el primer alumno de la lista
    for indiceNotas in range(matrizNotas.shape[0]): # Por cada nota que tenga la prueba
        if matrizNotas[indiceNotas][indicePrueba] > matrizNotas[indiceAlumnoMayorNota][indicePrueba]: # Si la nota iterando es mayor al record actual
            indiceAlumnoMayorNota = indiceNotas # Sobreescribimos el alumno
    indicesMejoresNotas.append(indiceAlumnoMayorNota) # Guardamos el índice de mejor nota

for indicePrueba in range(matrizNotas.shape[1]): # Por cada prueba rendida
    indiceMejorNota = indicesMejoresNotas[indicePrueba] # Obtenemos el índice de mejor nota
    print("   ", pruebas[indicePrueba]) # Imprimimos el nombre de la prueba
    for indiceNotas in range(matrizNotas.shape[0]): # Por cada nota que tenga la prueba
        if matrizNotas[indiceMejorNota][indicePrueba] == matrizNotas[indiceNotas][indicePrueba]: # Si el alumno es uno de los que tuvo máxima nota
            print("       ", alumnos[indiceNotas], matrizNotas[indiceNotas][indicePrueba]) # Imprimimos los datos del alumno

# == PARTE 2 (SITUACIÓN POR ALUMNO) ==
print("Situación por estudiante") # Imprimimos enunciados
for indiceAlumno in range(matrizNotas.shape[0]): # Por cada alumno en la matriz de notas
    notaFinalPonderadaAlumno = 0 # Declaramos la nota final ponderada del alumno
    acumuladorNotasRendidasAlumno = 0 # Declaramos un acumulador de notas del alumno
    contadorNotasRendidasAlumno = 0 # Declaramos un contador de notas del alumno
    pruebasNoRendidasAlumno = [] # Declaramos una lista que tendrá las pruebas no rendidas por el alumno
    ultimaPruebaRendida = True # Declaramos un bool para saber si el alumno dio la última prueba

    for indicePrueba in range(matrizNotas.shape[1]): # Por cada prueba en la matriz de notas
        if matrizVeces[indiceAlumno][indicePrueba] == 0: # Si el alumno no rindió la prueba
            pruebasNoRendidasAlumno.append(indicePrueba) # Añadimos la prueba no rendida a la lista

            if indicePrueba == (len(pruebas)-1): # Si la prueba no rendida coincide con la última prueba
                ultimaPruebaRendida = False # Declaramos que el alumno no dio la última prueba
        else: # En caso contrario (el alumno si rindió la prueba)
            acumuladorNotasRendidasAlumno += matrizNotas[indiceAlumno][indicePrueba] # Acumulamos la nota rendida por el alumno
            contadorNotasRendidasAlumno += 1 # Sumamos uno al contador de pruebas rendidas
        notaFinalPonderadaAlumno += matrizNotas[indiceAlumno][indicePrueba] * ponderaciones[indicePrueba] # Hacemos sumatoria de la ponderación

    if len(pruebasNoRendidasAlumno) == 0 and notaFinalPonderadaAlumno >= 4.0: # Si el alumno está en caso de aprobación
        print("   ", alumnos[indiceAlumno], notaFinalPonderadaAlumno, "APR") # Imprimir informe
    elif len(pruebasNoRendidasAlumno) == 0 and notaFinalPonderadaAlumno < 4.0 and notaFinalPonderadaAlumno >= 3.4: # Si el alumno está en caso de examen A
        print("   ", alumnos[indiceAlumno], notaFinalPonderadaAlumno, "EX A") # Imprimir informe
    elif ultimaPruebaRendida == False and (acumuladorNotasRendidasAlumno/contadorNotasRendidasAlumno) >= 3.4: # Si el alumno está en caso de examen B
        print("   ", alumnos[indiceAlumno], notaFinalPonderadaAlumno, "EX B", "("+str(acumuladorNotasRendidasAlumno/contadorNotasRendidasAlumno)+")") # Imprimir informe
    else: # En caso de reprobación
        print("   ", alumnos[indiceAlumno], notaFinalPonderadaAlumno, "REP") # Imprimir informe

# == PARTE 3 (PRUEBAS NO RENDIDAS) ==
print("Estudiantes que deben alguna prueba") # Imprimir enunciado
for indicePrueba in range(matrizVeces.shape[1]): # Por cada prueba rendida en la matriz de intentos
    flagIntentos = False # Declaramos (por default) que todos los alumnos dieron la prueba
    for indiceIntentos in range(matrizVeces.shape[0]): # Por cada intento en la prueba
        if matrizVeces[indiceIntentos][indicePrueba] == 0: # Si un alumno no rindió esa prueba
            flagIntentos = True # Declaramos que hubo al menos un alumno que no rindió
            break # Terminamos el ciclo por eficiencia

    if flagIntentos == True: # Si al menos un alumno no rindió una prueba
        print(pruebas[indicePrueba]) # Imprimirmos el nombre de la prueba
        for indiceIntentos in range(matrizVeces.shape[0]): # Por cada intento en la prueba
            if matrizVeces[indiceIntentos][indicePrueba] == 0: # Si un alumno no la rindió
                print("   ", alumnos[indiceIntentos]) # Imprimir RUT alumno