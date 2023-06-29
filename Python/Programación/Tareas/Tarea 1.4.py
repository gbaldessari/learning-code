#Giacomo Baldessari

saveAño = 0
saveMes = 0
contDia = 0

nAcumuladoM = 0
mAcumuladoM = 0
pAcumuladoM = 0
kAcumuladoM = 0

nAcumuladoA = 0
mAcumuladoA = 0
pAcumuladoA = 0
kAcumuladoA = 0

nAcumuladoT = 0
mAcumuladoT = 0
pAcumuladoT = 0
kAcumuladoT = 0

ingresarDato = input('Ingrese datos: ').lower()
datoIngresado = ingresarDato.split()

puerta = False
if len(ingresarDato) == 0:
    puerta = True

else:
    puerta = False

    año = datoIngresado[0]
    mes = datoIngresado[1]
    dia = datoIngresado[2]
    fruta = datoIngresado[3]
    cantidad = datoIngresado[4]

    saveAño = int(año)
    saveMes = int(mes)

while puerta == False:
    if fruta == 'naranja':
        nAcumuladoM += int(cantidad)
        nAcumuladoA += int(cantidad)
        nAcumuladoT += int(cantidad)

    if fruta == 'manzana':
        mAcumuladoM += int(cantidad)
        mAcumuladoA += int(cantidad)
        mAcumuladoT += int(cantidad)

    if fruta == 'pera':
        pAcumuladoM += int(cantidad)
        pAcumuladoA += int(cantidad)
        pAcumuladoT += int(cantidad)

    if fruta == 'kiwi':
        kAcumuladoM += int(cantidad)
        kAcumuladoA += int(cantidad)
        kAcumuladoT += int(cantidad)

    if int(dia) > 0:
        contDia += int(dia)
            
    ingresarDato = input('Ingrese datos: ').lower()

    if len(ingresarDato) == 0:
        puerta = True
        datoIngresado = [0,0,0,0,0]

    else:
        puerta = False
        datoIngresado = ingresarDato.split()
            
    año = datoIngresado[0]
    mes = datoIngresado[1]
    dia = datoIngresado[2]
    fruta = datoIngresado[3]
    cantidad = datoIngresado[4]

    if saveMes != int(mes):
        print('Total Mes',saveMes,'/',saveAño,':','N:', nAcumuladoM,'M:', mAcumuladoM,'P:', pAcumuladoM,'K:', kAcumuladoM)
        saveMes = int(mes)
        nAcumuladoM = 0
        mAcumuladoM = 0
        pAcumuladoM = 0
        kAcumuladoM = 0

    if saveAño != int(año):
        print('Total Año',saveAño,':','N:', nAcumuladoA,'M:', mAcumuladoA,'P:', pAcumuladoA,'K:', kAcumuladoA)
        saveAño = int(año)
        nAcumuladoA = 0
        mAcumuladoA = 0
        pAcumuladoA = 0
        kAcumuladoA = 0
            
total = nAcumuladoT + mAcumuladoT + pAcumuladoT + kAcumuladoT

if contDia > 0:
    print('Total Vendido:', total)

    if total == 0:
        total += 1
    
    porcentajeN = (nAcumuladoT * 100) / total
    porcentajeM = (mAcumuladoT * 100) / total
    porcentajeP = (pAcumuladoT * 100) / total
    porcentajeK = (kAcumuladoT * 100) / total

    print('Total Naranjas:', nAcumuladoT, porcentajeN,'%')
    print('Total Manzanas:', mAcumuladoT, porcentajeM,'%')
    print('Total Peras:', pAcumuladoT, porcentajeP,'%')
    print('Total Kiwis:', kAcumuladoT, porcentajeK,'%')
    
else:
    print('No hay nada que mostrar...')