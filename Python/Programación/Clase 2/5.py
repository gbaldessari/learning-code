#Giacomo Baldessari

num = float(input('Ingrese un número:'))

if num > 0:
    num2 = num + (3 * num)
else:
    num2 = num - 2*(num / 2)
mod = num2 % 2
num3 = 0
if mod != 0:
    if num2 > 25 or num2 < -10:
        num3 = num2 * 4
        print('Impar')
    else:
        num3 = num3
else:
    num3 = num2 / 3
    print('Quizá es Par')
if num > num3:
    num4 = num
    num = num3
    num3 = num4
    print(num)
    print(num3)

if num3 == 0:
    print('Fin')