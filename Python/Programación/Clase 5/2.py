#Giacomo Baldessari

arch = open('dos.txt', encoding='UTF-8')
vuelos = arch.readline().strip()

contadorT = 0

contadorTD = 0
contadorTO = 0
cont100 = 0

ciudadMayor = ''
mayor = -1

ciudadMenor = ''
menor = 1000

contadorDS = 0
contadorDCq = 0
contadorDCn = 0
contadorDCa = 0
contadorDA = 0
contadorDI = 0
contadorDPa = 0
contadorDPm = 0

contadorOS = 0
contadorOA = 0
contadorOCn = 0
contadorOCp = 0
contadorOLs = 0

antoSanti = 0

while vuelos != '':

    print(vuelos)

    contadorT +=1

    lista = vuelos.split(',')
    
    if lista[0] == 'Antofagasta':
        contadorOA += 1
        contadorTO += 1

        antoSanti += int(lista[2])

        if int(lista[2]) < menor:
            menor = int(lista[2])
            ciudadMenor = lista[0]
        if int(lista[2]) < 100:
            cont100 += 1
    
    if lista[0] == 'Santiago':
        contadorOS += 1
        contadorTO += 1

        antoSanti += int(lista[2])

        if int(lista[2]) < menor:
            menor = int(lista[2])
            ciudadMenor = lista[0]
        if int(lista[2]) < 100:
            cont100 += 1

    if lista[0] == 'Concepción':
        contadorOCn += 1
        contadorTO += 1
        if int(lista[2]) < menor:
            menor = int(lista[2])
            ciudadMenor = lista[0]
        if int(lista[2]) < 100:
            cont100 += 1
    
    if lista[0] == 'Copiapo':
        contadorOCp += 1
        contadorTO += 1
        if int(lista[2]) < menor:
            menor = int(lista[2])
            ciudadMenor = lista[0]
        if int(lista[2]) < 100:
            cont100 += 1

    if lista[0] == 'La Serena':
        contadorOLs += 1
        contadorTO += 1
        if int(lista[2]) < menor:
            menor = int(lista[2])
            ciudadMenor = lista[0]
        if int(lista[2]) < 100:
            cont100 += 1

    if lista[1] == 'Santiago':
        contadorDS += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]
    
    if lista[1] == 'Coquimbo':
        contadorDCq += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]
    
    if lista[1] == 'Calama':
        contadorDCa += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]

    if lista[1] == 'Iquique':
        contadorDI += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]

    if lista[1] == 'Concepción':
        contadorDCn += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]
        
    if lista[1] == 'Punta Arena':
        contadorDPa += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]

    if lista[1] == 'Puerto Montt':
        contadorDPm += 1
        contadorTD += 1
        if int(lista[2]) > mayor:
            mayor = int(lista[2])
            ciudadMayor = lista[1]

    vuelos = arch.readline().strip()

promedio = antoSanti/(contadorOS + contadorOA)

porcentaje = (cont100*100)/contadorT

print('Vuelos realizados:', contadorT)
print('Vuelos realizados con destino Santiago:', contadorDS)
print('Promedio de pasajeros transportados en los vuelos cuyo origen fue Antofagasta o Santiago:', promedio)
print('Ciudad de destino del viaje con más pasajeros:', ciudadMayor)
print('Ciudad de origen del viaje con menos pasajeros:', ciudadMenor)
print('Porcentaje de vuelos que transportaron menos de 100 personas:', porcentaje,'%')

arch.close()