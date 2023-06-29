import numpy as np

def Max(list):
  mayor = list[0]
  index = 0
  for i in list:
    if i > mayor:
      mayor = i
      index = list.index(i)
  return mayor , index

def Min(list):
  minor = list[0]
  index = 0
  for i in list:
    if i < minor:
      minor = i
      index = list.index(i)
  return minor , index

def factorial(number):
  if number == 0:
    return 1
  else:
    return number*factorial(number-1)

def Sort(list): #mayor to minor
  Go = True
  while Go: 
    Go = False
    for i in range(len(list)-1):
      if list[i] < list[i + 1]:
        list[i+1], list[i] = list[i], list[i+1]
        Go = True

def Sum(list):
  sum = 0
  for i in list:
    sum += i
  return sum

def Count(list,element):
  count = 0
  for i in list:
    if element == i:
      count += 1
  return count

def Average(list):
  sum = 0
  for i in list:
    sum +=i
  if len(list) == 0:
    return sum
  return sum/len(list)

def Percentage(n1,n2):
  return 100*(n1/n2)

def Reverse(list):
  newlist = []
  for i in range(len(list)-1,-1,-1):
    newlist.append(list[i])
  return newlist

def Changex_matrix(matrix,y1,y2):
  buffer1 = []
  buffer2 = []
  for i in range(np.shape(matrix)[1]):
    buffer1.append(matrix[y1,i])

  for i in range(np.shape(matrix)[1]):
    buffer2.append(matrix[y2,i])

  for i in range(np.shape(matrix)[1]):
    matrix[y1,i] = buffer2[i]

  for i in range(np.shape(matrix)[1]):
    matrix[y2,i] = buffer1[i]

def Changex_matrix_list(matrix,list,y1,y2):
  buffer1 = []
  buffer2 = []
  for i in range(np.shape(matrix)[1]):
    buffer1.append(matrix[y1,i])

  for i in range(np.shape(matrix)[1]):
    buffer2.append(matrix[y2,i])

  for i in range(np.shape(matrix)[1]):
    matrix[y1,i] = buffer2[i]

  for i in range(np.shape(matrix)[1]):
    matrix[y2,i] = buffer1[i]
  
  list[y1],list[y2] = list[y2],list[y1]

def Max_matrix(matrix):
  mayor = matrix[0,0]
  index = [0,0]
  for i in range(np.shape(matrix)[1]):
    for j in range(np.shape(matrix)[0]):
      if mayor < matrix[i,j]:
        mayor = matrix[i,j]
        index = [i,j]
      elif mayor == matrix[i,j]:
        index = [i,j]
  return mayor, index

def DeleteF(matrix,list1,y):
  count = 1
  for i in range(y,np.shape(matrix)[0]):
    list = []
    for k in range(np.shape(matrix)[1]):
      list.append(matrix[y+count,k])
    
    for k in range(np.shape(matrix)[1]):
      matrix[y+count-1,k] = list[k]

  for i in range(np.shape(matrix)[1]):
    matrix[len(list)-1,i] = 0

  list1.pop(y)

def DeleteC(matrix,list1,x):
  count = 1
  for i in range(x,np.shape(matrix)[1]):
    list = []
    for k in range(np.shape(matrix)[0]):
      list.append(matrix[k,x+count])
    
    for k in range(np.shape(matrix)[0]):
      matrix[k,x+count-1] = list[k]

  for i in range(np.shape(matrix)[1]):
    matrix[i,len(list)-1] = 0

  list1.pop(x)

def SumF(matrix):
  list = []
  for i in range(np.shape(matrix)[1]):
    sum = 0
    for j in range(np.shape(matrix)[0]):
      sum += matrix[i,j]
    list.append(sum)
  return list

def SumC(matrix):
  list = []
  for i in range(np.shape(matrix)[1]):
    sum = 0
    for j in range(np.shape(matrix)[0]):
      sum += matrix[j,i]
    list.append(sum)
  return list

def SortMatrix(list,matrix): #mayor to minor
  Go = True
  while Go: 
    Go = False
    for i in range(len(list)-1):
      if list[i] < list[i + 1]:
        list[i+1], list[i] = list[i], list[i+1]
        Changex_matrix(matrix,i,i+1)
        Go = True

def ordenarMatriz(matriz, list): #cambiaaa
  for i in range(0,len(list)) :
    for j in range(0,len(list[i])):
      if list[i] > list[j]:
        matriz[i][j] = int(matriz[i][j]) + int(matriz[j][i])
        matriz[j][i] = 0

