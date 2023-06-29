#Giacomo Baldessari

cantidad = int(input('Cantidad de figuras: '))

def figura(cantidad):
    mayor = -1
    figuraMayor = 'Error'
    area = 0
    for i in range(cantidad):
        figura = input('Ingrese la figura: ').lower()
        if figura == 'triangulo' or figura == 'triángulo':
            base = float(input('Ingrese la base: '))
            altura = float(input('Ingrese la altura: '))
            area = (base * altura)/2
            if area > mayor:
                mayor = area
                figuraMayor = 'Tríangulo'
        if figura == 'rectangulo' or figura == 'rectángulo':
            largo = float(input('Ingrese el largo: '))
            altura = float(input('Ingrese la altura: '))
            area = (largo * altura)
            if area > mayor:
                mayor = area
                figuraMayor = 'Rectángulo'
        if figura == 'circulo' or figura == 'círculo':
            radio = float(input('Ingrese el radio: '))
            area = (3.14 * (radio**2))
            if area > mayor:
                mayor = area
                figuraMayor = 'Círculo'
    
    return figuraMayor

print(figura(cantidad))