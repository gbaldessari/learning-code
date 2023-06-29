#Giacomo Baldessari

arch = open('tres.txt',encoding='UTF-8')
empleados = arch.readline().strip()

cont2530 = 0

sucursal = ''

empleado33 = ''
suscursal33 = ''

ciudadMayor = ''
mayor = -1

empleadoMayor = ''
edad = -1

sucursalMenor = ''
menor = 1000

while empleados != '':
    lista = empleados.split(',')

    if int(lista[1]) > mayor:
            mayor = int(lista[1])
            ciudadMayor = lista[0]

    if lista[0] == 'Antofagasta':
        repA =  int(lista[1])
        sumaA = 0
        sucursal = lista[0]
        for i in range(repA):
            empleados = arch.readline().strip()
            lista = empleados.split(',')
            sumaA += int(lista[1])
            if int(lista[1]) >= 25 and int(lista[1]) <= 30:
                cont2530 += 1
            
            if int(lista[1]) == 33:
                empleado33 = lista[0]
                suscursal33 = sucursal

            if int(lista[1]) > edad:
                edad = int(lista[1])
                empleadoMayor = lista[0]
        
        ponderacionA = (repA * 10)+(sumaA + 0.5)
        if ponderacionA < menor:
            menor = ponderacionA
            sucursalMenor = sucursal
        
    elif lista[0] == 'Calama':
        repC =  int(lista[1])
        sumaC = 0
        sucursal = lista[0]
        for i in range(repC):
            empleados = arch.readline().strip()
            lista = empleados.split(',')
            sumaC += int(lista[1])
            if int(lista[1]) >= 25 and int(lista[1]) <= 30:
                cont2530 += 1
            
            if int(lista[1]) == 33:
                empleado33 = lista[0]
                suscursal33 = sucursal

            if int(lista[1]) > edad:
                edad = int(lista[1])
                empleadoMayor = lista[0]

        ponderacionC = (repC * 10)+(sumaC + 0.5)
        if ponderacionC < menor:
            menor = ponderacionC
            sucursalMenor = sucursal
        
    elif lista[0] == 'La Serena':
        repLS =  int(lista[1])
        sumaLS = 0
        sucursal = lista[0]
        for i in range(repLS):
            empleados = arch.readline().strip()
            lista = empleados.split(',')
            sumaLS += int(lista[1])
            if int(lista[1]) >= 25 and int(lista[1]) <= 30:
                cont2530 += 1

            if int(lista[1]) == 33:
                empleado33 = lista[0]
                suscursal33 = sucursal

            if int(lista[1]) > edad:
                edad = int(lista[1])
                empleadoMayor = lista[0]

        ponderacionLS = (repLS * 10)+(sumaLS + 0.5)
        if ponderacionLS < menor:
            menor = ponderacionLS
            sucursalMenor = sucursal
    
    empleados = arch.readline().strip()

promedioA = sumaA/repA
promedioC = sumaC/repC
promedioLS = sumaLS/repLS

porcentaje2530 = (cont2530 * 100) / (repA + repC + repLS)

print()
print('Sucursal que tiene la mayor cantidad de empleados:',ciudadMayor)
print()
print('Promedio de edad de trabajadores de Antofagasta:',promedioA)
print('Promedio de edad de trabajadores de Calama:',promedioC)
print('Promedio de edad de trabajadores de La Serena:',promedioLS)
print()
print('Empleado con la edad mayor entre todas las sucursales:', empleadoMayor)
print('Porcentaje de empleados cuya edad se encuentra entre 25 y 30 años:', porcentaje2530,'%')
print('Nombre y sucursal del empleado que tiene 33 años,',empleado33,'(',suscursal33,')')
print('Sucursal con la menor ponderación:',sucursalMenor)

arch.close()