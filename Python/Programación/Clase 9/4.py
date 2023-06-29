#Giacomo Baldessari

def altoRiesgo():
    riesgoAlto = []
    
    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) > 75:
            riesgoAlto.append(lista[0])
            
        datos = arch.readline().strip()
        lista = datos.split(';')
    return riesgoAlto

def altoPeso():
    pesoAlto = []

    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) > 75:
            pesoAlto.append(lista[2])

        datos = arch.readline().strip()
        lista = datos.split(';')
    return pesoAlto

def medioRiesgo():
    riesgoMedio = []
    
    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) <= 75 and int(lista[1]) > 50:
            riesgoMedio.append(lista[0])
            
        datos = arch.readline().strip()
        lista = datos.split(';')
    return riesgoMedio

def medioPeso():
    pesoMedio = []

    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) <= 75 and int(lista[1]) > 50:
            pesoMedio.append(lista[2])
            
        datos = arch.readline().strip()
        lista = datos.split(';')
    return pesoMedio

def bajoRiesgo():
    riesgoBajo = []
    
    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) <= 50:
            riesgoBajo.append(lista[0])
            
        datos = arch.readline().strip()
        lista = datos.split(';')
    return riesgoBajo

def bajoPeso():
    pesoBajo = []

    arch = open('ejercicio4.4.txt',encoding='UTF-8')
    datos = arch.readline().strip()
    lista = datos.split(';')

    while datos != '':
        if int(lista[1]) <= 50:
            pesoBajo.append(lista[2])
            
        datos = arch.readline().strip()
        lista = datos.split(';')
    return pesoBajo

riesgoAlto = altoRiesgo()
pesoAlto = altoPeso()
riesgoMedio = medioRiesgo()
pesoMedio = medioPeso()
riesgoBajo = bajoRiesgo()
pesoBajo = bajoPeso()


for a in range(len(riesgoAlto)-1):
    for b in range(a+1,len(riesgoAlto)):
        if pesoAlto[a] < pesoAlto[b]:
            auxP = pesoAlto[a]
            pesoAlto[a] = pesoAlto[b]
            pesoAlto[b] = auxP

            auxN = riesgoAlto[a]
            riesgoAlto[a] = riesgoAlto[b]
            riesgoAlto[b] = auxN

for a in range(len(riesgoMedio)-1):
    for b in range(a+1,len(riesgoMedio)):
        if pesoMedio[a] < pesoMedio[b]:
            auxP = pesoMedio[a]
            pesoMedio[a] = pesoMedio[b]
            pesoMedio[b] = auxP

            auxN = riesgoMedio[a]
            riesgoMedio[a] = riesgoMedio[b]
            riesgoMedio[b] = auxN

for a in range(len(riesgoBajo)-1):
    for b in range(a+1,len(riesgoBajo)):
        if pesoBajo[a] < pesoBajo[b]:
            auxP = pesoBajo[a]
            pesoBajo[a] = pesoBajo[b]
            pesoBajo[b] = auxP

            auxN = riesgoBajo[a]
            riesgoBajo[a] = riesgoBajo[b]
            riesgoBajo[b] = auxN

print('Riesgo alto')
print('----------------------------------------')
for i in range(len(riesgoAlto)):
    print(riesgoAlto[i],'('+str(pesoAlto[i]),'Riesgo ajustado)')
print('----------------------------------------')
print('Riesgo medio')
print('----------------------------------------')
for i in range(len(riesgoMedio)):
    print(riesgoMedio[i],'('+str(pesoMedio[i]),'Riesgo ajustado)')
print('----------------------------------------')
print('Riesgo bajo')
print('----------------------------------------')
for i in range(len(riesgoBajo)):
    print(riesgoBajo[i],'('+str(pesoBajo[i]),'Riesgo ajustado)')

