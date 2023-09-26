#Eduardo Miranda 21.141.817-6 & Giacomo Baldessari 21.222.714-5
import pandas as pd
import matplotlib.pyplot as plt
from numpy import nan
df = pd.read_excel("Sindicato Prestadora de Servicios.xlsx") #dataframe
#Primer Punto (Priorización)

# Funciones para ordenar las listas de priorizacion
def intercambiar(lista,a,b):
    aux = lista[a] ; lista[a] = lista[b] ; lista[b] = aux
def ordenarListas(l1,l2):
    for i in range(0,len(l1)-1):
        for j in range(i+1,len(l1)):
            if l1[i] < l1[j]:
                intercambiar(l1,i,j)
                intercambiar(l2,i,j)
# Listas paralelas
nombres = [] # almacena los nombres de las columnas 
valores = [] # almacena los promedios de cada columna
"""
# Solo las valoraciones iguales a 5
for i in range(3,15): # Desde la columna D a l O del archivo excel
    columna = df.iloc[:,i]
    nombreCol = df.columns[i]
    nombres.append(nombreCol)
    valor = (columna == 5).sum()
    valores.append(valor)
"""
"""
# Suma total de las valoraciones
for i in range(3,15):
    columna = df.iloc[:,i]
    nombreCol = df.columns[i]
    nombres.append(nombreCol)
    valor = columna.sum()
    valores.append(valor)
"""
# Promedio de las valoraciones
for i in range(3,15):
    columna = df.iloc[:,i] # devuelve la columna en el indice i
    nombreCol = df.columns[i] # Nombre de la columna
    nombres.append(nombreCol) # agrega el nombre a nombres
    valor = columna.sum() 
    valores.append(valor/df.shape[0]) # agrega el promedio de la columna a valores
ordenarListas(valores,nombres)
df.info() # Nos damos cuenta que hay una columna que no tiene datos
#eliminamos la columna vacía (indice 12)
df = df.drop(columns=["10. Permiso Administrativo"])
indice = nombres.index("10. Permiso Administrativo")
nombres.pop(indice)
valores.pop(indice)
df.info() # Confirmamos que la fila se eliminó del dataframe
#Creamos un gráfico de apoyo
dataGrafico = {'Columnas':nombres, 'Valores de prioridad':valores}
dfGraf = pd.DataFrame(dataGrafico)

plt.figure(figsize=(20, 10))
plt.bar(dfGraf['Columnas'], dfGraf['Valores de prioridad'])
plt.xlabel('Columnas')
plt.ylabel('Valores por prioridad')
plt.title('Gráfico de prioridades')
plt.xticks(rotation=90)

plt.tight_layout()
plt.show()
#-------------------------------------------------------------------------------------------------

# Limpieza columna 14 (aunmento de movilización)
df.iloc[:,14] = pd.to_numeric(df.iloc[:,14], errors='coerce') # Los datso no numéricos se cambian por NaN
sumaMov = df.iloc[:,14].sum() # suma los datos de la columna
promMov = sumaMov/df.shape[0] # promedio de la columna
df.iloc[:,14] = df.iloc[:,14].fillna(promMov) # cambia los valores NaN por el promedio calculado
promConsideracionMov = (df.iloc[:,14].sum())/(df.shape[0]) # Calcula el promedio con la columna limpia
print("")
print(df.columns[14])
print("Para el aumento de movilización las personas consideran en promedio: $",round(promConsideracionMov))
print("")

# Limpieza para la columna 15 (aumento de sueldo base)
df.iloc[:,15] = pd.to_numeric(df.iloc[:,15], errors='coerce') # Los datso no numéricos se cambian por NaN
df.loc[df[df.columns[15]] > 1, df.columns[15]] = nan
sumasueldo = df.iloc[:,15].sum() # suma los datos de la columna
promSueldo = sumasueldo/df.shape[0] # promedio de la columna
df.iloc[:,15] = df.iloc[:,15].fillna(promSueldo) # cambia los valores NaN por el promedio calculado
promConsideracionSueldo = (df.iloc[:,15].sum())/(df.shape[0]) # Calcula el promedio con la columna limpia
print("")
print(df.columns[15])
print("Para el aumento del sueldo base las personas consideran en promedio:",round(promConsideracionSueldo*100,2),"%")
print("")

# Preferencia de pago de gratificación (columna 16)
modaPago = df[df.columns[16]].mode() # Retorna una lista con los datos de la moda de la columna
print("")
print("Las personas prefieren el pago de la gratificación de forma",modaPago[0])
print("")

#-------------------------------------------------------------------------------------------------

print("Identeificación de valores (media de cada columna después de la limpieza): ")
# Limpieza de Aguinaldo de navidad (columna 17)
df.iloc[:,17] = pd.to_numeric(df.iloc[:,17], errors='coerce') # Los datso no numéricos se cambian por NaN
sumaAguinaldo = df.iloc[:,17].sum() # suma los datos de la columna
promAguinaldo = sumaAguinaldo/df.shape[0] # promedio de la columna
df.iloc[:,17] = df.iloc[:,17].fillna(promAguinaldo) # cambia los valores NaN por el promedio calculado
print("     - Aguinaldo Navidad:",df[df.columns[17]].mode()[0])
print("")

# Limpieza de Aumento Colación  (columna 18)
df.iloc[:,18] = pd.to_numeric(df.iloc[:,18], errors='coerce') # Los datso no numéricos se cambian por NaN
df.loc[df[df.columns[18]] < 1, df.columns[18]] = nan # los % se cambian por NaN
sumaColacion = df.iloc[:,18].sum() # suma los datos de la columna
promColacion = sumaColacion/df.shape[0] # promedio de la columna
df.iloc[:,18] = df.iloc[:,18].fillna(promColacion) # cambia los valores NaN por el promedio calculado
print("     - Aumento Colación:",df[df.columns[18]].mode()[0])
print("")

# Limpieza de Bono Vacaciones (columna 21)
df.iloc[:,21] = pd.to_numeric(df.iloc[:,21], errors='coerce') # Los datso no numéricos se cambian por NaN
sumaBono = df.iloc[:,21].sum() # suma los datos de la columna
promBono = sumaBono/df.shape[0] # promedio de la columna
df.iloc[:,21] = df.iloc[:,21].fillna(promBono) # cambia los valores NaN por el promedio calculado
print("     - Bono Vacaciones:",df[df.columns[21]].mode()[0])
print("")

# Limpieza de Regiones (columna 24)
df["REGIÓN"] = df["REGIÓN"].str.upper().str.strip() # Limpia los espacios y transforma a mayúsculas
# Diccionario de regiones
aberviaturas = {"METROPOLITANA":"RM","15":"XV","14":"XIV","13":"XIII","12":"XII","11":"XI","10":"X",
                "9":"IX","8":"VIII","7":"VII","6":"VI","5":"V","4":"IV","3":"III","2":"II","1":"I"}
# Lista con orden de regiones
regiones = ["XV","XIV","XIII","XII","XI","X","IX","VIII","VII","VI","RM","V","IV","III","II","I"]
df["REGIÓN"].replace(aberviaturas,inplace=True) # reemplaza los valores del diccionario
modaReg = df[df.columns[24]].mode()[0] # retorna la moda
df["REGIÓN"] = df["REGIÓN"].apply(lambda x:x if x in regiones else modaReg) # si el valor no es una region valida lo cambia por la moda

# Gráficos para comparar valores por regiones:
# Ordenamos los datos por región para que en el gráfico las regiones se vean ordenadas
df["REGIÓN"] = pd.Categorical(df["REGIÓN"], categories=regiones, ordered=True) #Ordena respecto el orden de la lista regiones
df = df.sort_values(by="REGIÓN") # ordena el data frame con el orden de la columna de regiones

# Gráfico promedio aumento sueldo base por región 
columnas = df[["REGIÓN",df.columns[15]]]
promedios = columnas.groupby("REGIÓN")[df.columns[15]].mean().reset_index()

plt.figure(figsize=(10,8))
plt.bar(promedios["REGIÓN"],promedios[df.columns[15]])
plt.xlabel("Región")
plt.ylabel("Aumento sueldo base")
plt.title("Gráfico aumentos por región")
plt.show()

# Gráfico promedio aguinaldo navidad por región
columnas = df[["REGIÓN",df.columns[17]]]
promedios = columnas.groupby("REGIÓN")[df.columns[17]].mean().reset_index()

plt.figure(figsize=(10,8))
plt.bar(promedios["REGIÓN"],promedios[df.columns[17]])
plt.xlabel("Región")
plt.ylabel("Aguinaldo de navidad")
plt.title("Gráfico aguinaldo por región")
plt.show()

# Gráfico promedio bono vacaciones por región
columnas = df[["REGIÓN",df.columns[21]]]
promedios = columnas.groupby("REGIÓN")[df.columns[21]].mean().reset_index()

plt.figure(figsize=(10,8))
plt.bar(promedios["REGIÓN"],promedios[df.columns[21]])
plt.xlabel("Región")
plt.ylabel("Bono Vacaciones")
plt.title("Gráfico bono vacaciones por región")
plt.show()


