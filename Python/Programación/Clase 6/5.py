#Giacomo Baldessari

def total(desc):
    arti = open('artículos.txt',encoding='UTF-8')

    artLeido = arti.readline().strip()
    listaArt = artLeido.split(',')

    dineroFinal = 0

    while artLeido != '':
        precio = open('precios.txt',encoding='UTF-8')
        precioLeido = precio.readline().strip()
        listaPre = precioLeido.split(',')

        while precioLeido != '':
            if listaArt[0] == listaPre[0]:
                dineroFinal += int(listaArt[1])*int(listaPre[1])
            precioLeido = precio.readline().strip()
            listaPre = precioLeido.split(',')

        artLeido = arti.readline().strip()
        listaArt = artLeido.split(',')

    dineroFinal = dineroFinal - (dineroFinal*(int(desc)/100))
    return dineroFinal

def encontrarPrecioMax():
    arti = open('artículos.txt',encoding='UTF-8')

    maximo = -1

    artLeido = arti.readline().strip()
    listaArt = artLeido.split(',')

    dinero = 0

    while artLeido != '':
        precio = open('precios.txt',encoding='UTF-8')
        precioLeido = precio.readline().strip()
        listaPre = precioLeido.split(',')
        while precioLeido != '':
            if listaArt[0] == listaPre[0]:
                dinero = int(listaPre[1])
                if dinero > int(maximo):
                    maximo = dinero
            precioLeido = precio.readline().strip()
            listaPre = precioLeido.split(',')
        artLeido = arti.readline().strip()
        listaArt = artLeido.split(',')

    return maximo

def encontrarProductoMax():
    arti = open('artículos.txt',encoding='UTF-8')

    maximo = -1
    producto = ''

    artLeido = arti.readline().strip()
    listaArt = artLeido.split(',')

    dinero = 0

    while artLeido != '':
        precio = open('precios.txt',encoding='UTF-8')
        precioLeido = precio.readline().strip()
        listaPre = precioLeido.split(',')
        while precioLeido != '':
            if listaArt[0] == listaPre[0]:
                dinero = int(listaPre[1])
                if dinero > int(maximo):
                    maximo = dinero
                    producto = listaArt[0]
            precioLeido = precio.readline().strip()
            listaPre = precioLeido.split(',')
        artLeido = arti.readline().strip()
        listaArt = artLeido.split(',')

    return producto

desc = int(input('Ingrese el porcentaje de descuento: '))
print('Dinero total generado:',total(desc))
print('Producto con mayor precio:',encontrarProductoMax(),encontrarPrecioMax())