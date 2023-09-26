import numpy as np
import matplotlib.pyplot as plt


def get_A(n):
    matrix = np.zeros((n, n))
    for i in range(n):
        for j in range(n):
            matrix[i, j] = 20 - 5 * np.cos(3 * i) + 3 * np.sin(2 * j)
    return matrix


def check_inv(matrix):
    return np.linalg.det(matrix) != 0


def get_b(n, A):
    b = np.zeros(n)
    for i in range(n):
        for j in range(n):
            b[i] += A[i, j]
    return b


def solve(A, b):
    return np.linalg.inv(A).dot(b)


def generate_N(n):
    N = np.zeros(n)
    for i in range(n):
        N[i] = i + 1
    return N


n = int(input("Ingrese un valor de n: "))
matrix = get_A(n)
while not check_inv(matrix):
    print("Ups... la matriz creada no es invertible")
    n = int(input("Ingrese otro valor de n: "))
    matrix = get_A(n)
b = get_b(n, matrix)
x = solve(matrix, b)
N = generate_N(n)

# Codigo para graficar

plt.title('Gráfico de soluciones al sistema de ecuaciones')
plt.xlabel('Vector N')
plt.ylabel('Soluciones')
plt.plot(N, x)
plt.scatter(N, x)
plt.show()