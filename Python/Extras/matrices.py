import numpy as np

matriz = np.zeros([3,4])
cont = 1
for col in range(0,3):
    for fil in range(0,4):
        matriz[col][fil] = cont
        cont += 1

print(matriz)

matriz = np.zeros([3,4])
cont = 1
for fil in range(0,4):
    for col in range(0,3):
        matriz[col][fil] = cont
        cont += 1

#print(matriz)