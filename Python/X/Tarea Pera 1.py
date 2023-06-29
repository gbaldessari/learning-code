numero = int(input("Ingrese un número entero: "))
if(numero<0):
    print("Error: Número negativo")
else:
    factorial = 1;
    if(numero>0):
        for i in range(numero):
            factorial = factorial*(i+1)
    print("El factorial de",numero,"es",factorial)