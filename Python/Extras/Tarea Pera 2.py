respuesta = str(input("¿Quiere ayuda para calcular areas y perimetros de figuras geométricas? "))
if respuesta == "Si":
    opcion = int(input("¿Desea calcular area[1] o perimetro[2]? "))
    if opcion == 1:
        print('¿El área de que figura geométrica quisiera saber?')
        print('[1] Cuadrado')
        print('[2] Círculo')
        print('[3] Rectángulo')
        figura = int(input())
        if figura == 1:
            lado = float(input('Ingrese el valor del lado:'))
            areaCuadrado = lado**2
            print('El área del cuadrado es:', areaCuadrado)
        elif figura == 2:
            radio = float(input('Ingrese el valor del radio:'))
            areaCirculo = 3.14159265359*radio**2
            print('El área del círculo es:', areaCirculo)
        elif figura == 3:
            largo = float(input('Ingrese el valor del largo: '))
            ancho = float(input('Ingrese el valor del ancho: '))
            areaRectangulo = largo*ancho
            print('El área del rectángulo es:', areaRectangulo)
        else:
            print('Opción inválida')
    elif(opcion == 2):
        print('¿El perímetro de que figura geométrica quisiera saber?')
        print('[1] Cuadrado')
        print('[2] Círculo')
        print('[3] Rectángulo')
        figura = int(input())
        if figura == 1:
            lado = float(input('Ingrese el valor del lado:'))
            perimetroCuadrado = lado*4
            print('El perímetro del cuadrado es:', perimetroCuadrado)
        elif figura == 2:
            radio = float(input('Ingrese el valor del radio:'))
            perimetroCirculo = 3.14159265359*radio*2
            print('El perímetro del círculo es:', perimetroCirculo)
        elif figura == 3:
            largo = float(input('Ingrese el valor del largo: '))
            ancho = float(input('Ingrese el valor del ancho: '))
            perimetroRectangulo = (largo+ancho)*2
            print('El perímetro del rectángulo es:', perimetroRectangulo)
        else:
            print('Opción inválida')
    else:
        print('Opción inválida')
elif respuesta == "No":
    print('Programa terminado')
else:
    print('Opción inválida')