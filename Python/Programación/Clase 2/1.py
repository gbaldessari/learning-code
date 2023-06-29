#Giacomo Baldessari

num1 = float(input('Ingrese el primer número:'))
num2 = float(input('Ingrese el segundo número:'))

sum = num1 + num2
res = num1 - num2
mult = num1 * num2
exp = num1 ** num2
div = num1 / num2
divE = num1 // num2
mod = num1 % num2
print(sum, res, mult, exp, div, divE, mod)
print((sum + res + mult + exp + div + divE + mod)/7)