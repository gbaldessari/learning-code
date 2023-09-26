import numpy as np

matriz=np.zeros([4,4])

numero=0

for i in range(4):

    numero+=1

    for j in range(4):

        matriz[i,j]=numero

print(matriz)