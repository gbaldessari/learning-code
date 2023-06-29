#Giacomo Baldessari

arch = open('restoran.txt',encoding='UTF-8')
linea = arch.readline().strip()

if linea != '':

    totalPrecio = [0,0,0]

    platos = []
    valor = []

    ingredientes = []
    valIngredientes = []

    for i in range(int(linea)):
        linea = arch.readline().strip()
        partes = linea.split(',')
        ing = partes[0]
        valIng = int(partes[1])
        ingredientes.append(ing)
        valIngredientes.append(valIng)

    linea = arch.readline().strip()

    for i in range(int(linea)):
        valor1 = 0
        linea = arch.readline().strip()
        partes2 = linea.split(',')
        pIngredientes = partes2[0]
        Plato = partes2[1]
        cantidad = int(partes2[2])

        if pIngredientes in ingredientes:
            for x in range(len(ingredientes)):
                if ingredientes[x] == pIngredientes:
                    valor1 = valIngredientes[x]*cantidad

        if not Plato in platos:
            platos.append(Plato)
            valor.append(valor1)
        elif Plato in platos:
            x = platos.index(Plato)
            valor[x] += valor1
            
    linea = arch.readline().strip()

    edades = ['Menores','Adolescentes','Adultos']

    for i in range(int(linea)):
        valorT = 0
        linea = arch.readline().strip()
        partes3 = linea.split(',')
        edad = partes3[0]
        plato = partes3[1]
        cant = int(partes3[2])

        if plato in platos:  
            for i in range(len(platos)):
                if platos[i] == plato:
                    valorT = valor[i] * cant

        if edad not in edades:
            edades.append(edad)
            totalPrecio.append(valorT)
        elif edad in edades:
            y = edades.index(edad)
            totalPrecio[y] += valorT
    
    for i in range(len(edades)):
       print(edades[i],totalPrecio[i])
else:
    print()