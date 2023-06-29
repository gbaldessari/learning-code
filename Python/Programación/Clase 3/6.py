#Giacomo Baldessari

contP = 0
contPA = 0

salir = False

while salir == False:
    print()
    print('Seleccione una asignatura:')
    print('(Programación / Programación Avanzada)')
    print('(Ingrese "Salir" para terminar el programa)')
    asignatura = input('-').lower()
    

    if asignatura == 'programacion' or asignatura == 'programación':
        print('Usted salecciono la asignatura', asignatura)
        print('¿Que informacion necesita?')
        print('Asistencia / Promedio Final')
        
        info = ''

        while info != 'asistencia' and info != 'promedio final':
            info = str(input('-')).lower()
        

        if info == 'asistencia':
            diasAsistidos = int(input('Introduzca los días de clase asistidos: '))
            diasNoAsistidos = int(input('Introduzca los días de clase no asistidos: '))
            diasTotales = diasAsistidos + diasNoAsistidos
            asistencia = (diasAsistidos * 100) / diasTotales
            print('Su porcentaje de asistencia es del',asistencia,'%')
            contP += 1
        
        if info == 'promedio final':
            nota1 = 0
            nota2 = 0
            nota3 = 0
            while nota1 < 1 or nota1 > 7:
                nota1 = float(input('Ingrese su primera nota: '))
            print('Su primera nota es', nota1)
            while nota2 < 1 or nota2 > 7:
                nota2 = float(input('Ingrese su segunda nota: '))
            print('Su segunda nota es', nota2)
            while nota3 < 1 or nota3 > 7:
                nota3 = float(input('Ingrese su tercera nota: '))
            print('Su tercera nota es', nota3)
            promedio = (nota1 + nota2 + nota3)/3
            print('Su promedio Final es',promedio)
            contP += 1
    
    if asignatura == 'programacion avanzada' or asignatura == 'programación avanzada':
        print('Usted salecciono la asignatura', asignatura)
        print('¿Que informacion necesita?')
        print('Asistencia / Promedio Final')

        info = ''

        while info != 'asistencia' and info != 'promedio final':
            info = str(input('-')).lower()

        if info == 'asistencia':
            diasAsistidos = int(input('Introduzca los días de clase asistidos: '))
            diasNoAsistidos = int(input('Introduzca los días de clase no asistidos: '))
            diasTotales = diasAsistidos + diasNoAsistidos
            asistencia = (diasAsistidos * 100) / diasTotales
            print('Su porcentaje de asistencia es del',asistencia,'%')
            contPA += 1
        
        if info == 'promedio final':
            nota1 = 0
            nota2 = 0
            nota3 = 0
            while nota1 < 1 or nota1 > 7:
                nota1 = float(input('Ingrese su primera nota: '))
            print('Su primera nota es', nota1)
            while nota2 < 1 or nota2 > 7:
                nota2 = float(input('Ingrese su segunda nota: '))
            print('Su segunda nota es', nota2)
            while nota3 < 1 or nota3 > 7:
                nota3 = float(input('Ingrese su tercera nota: '))
            print('Su tercera nota es', nota3)
            promedio = (nota1 + nota2 + nota3)/3
            print('Su promedio Final es',promedio)
            contPA += 1
    if asignatura == 'salir':
        salir = True

print('Alumnos de Programación consultados:', contP)
print('Alumnos de Programación Avanzada consultados:', contPA)



