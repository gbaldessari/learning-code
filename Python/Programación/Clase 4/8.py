#Giacomo Baldessari

salir = ''

contBP = 0
contN = 0
contPO = 0
contO = 0
contT = 0

while salir != 'si':
    nombre = str(input('Ingrese el nombre: ')).lower()
    edad = int(input('Ingrese la edad: '))
    estatura = float(input('Ingrese la estatura(m): '))
    masa = float(input('Ingrese el peso(Kg): '))
    
    imc = masa/(estatura**2)

    if imc < 18.5:
        print('El IMC es de', imc)
        print('Se encuentra en bajo peso')
        contBP += 1
        contT += 1

    if imc >= 18.5 and imc < 25:
        print('El IMC es de', imc)
        print('Se encuentra en peso normal')
        contN += 1
        contT += 1

    if imc >= 25 and imc < 30:
        print('El IMC es de', imc)
        print('Se encuentra en preobeso')
        contPO += 1
        contT += 1

    if imc >= 30:
        print('El IMC es de', imc)
        print('Se encuentra en obeso')
        contO += 1
        contT += 1
    
    while salir != 'si' and salir != 'no':
        salir = input('¿Quiere terminar el programa?(Si/No): ').lower()


if contT != 0:
    bajoPeso = (100 * contBP)/contT
    normal = (100 * contN)/contT
    preObeso = (100 * contPO)/contT
    obeso = (100 * contO)/contT
    
    print('Estudiantes con bajo peso:', contBP, '(',bajoPeso,'% )')
    print('Estudiantes con peso normal:', contN, '(',normal,'% )')
    print('Estudiantes con preobesidad:', contPO, '(',preObeso,'% )')
    print('Estudiantes con obesidad:', contO, '(',obeso,'% )')
else:
    print('No hay nada que mostrar...')