valor = float(input('Ingrese valor de su compra: '))
print('Usted puede pagar sus productos con 3 diferentes metodos:')
print()
print('Escriba "1" para pagar al contado con un descuento del 15% del total de su compra.')
print('Escriba "2" para pagar en 3 cuotas sin interes.')
print('Escriba "3" para pagar en las cuotas que usted quiera, más un 2% del valor por cada cuota.')
print()
metodo = float(input('Ingrese el metodo de pago: '))
valorF = 0
cuotas = 0

if metodo == 1:
    valorF = valor - (valor/100 * 15)
    print('El total a pagar es', valorF, 'pesos.')

if metodo == 2:
    valorF = valor/3
    print('el valor de cada cuota es de', valorF, 'pesos.')
    
if metodo == 3:
    cuotas = float(input('Ingrese el numero de cuotas: '))
    valorF = ((valor + ((valor/50)*cuotas))/cuotas)
    print('el valor de cada cuota es de', valorF, 'pesos, sumando asi', (valorF*cuotas), 'pesos.')
