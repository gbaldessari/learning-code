from unidecode import unidecode
import pandas as pd
import psycopg2
import re

def queryGet(query):
    cur = conexion.cursor()
    cur.execute(query)
    resultados = cur.fetchall()
    cur.close()
    return resultados

def querySet(query):
    try:
        cur = conexion.cursor()
        cur.execute(query)
        conexion.commit()
    except Exception as e:
        print(f"Error en la transacción: {e}")
        conexion.rollback()
    finally:
        if cur:
            cur.close()


def iniciarConexion():
    parametros = {
        "host": "localhost",
        "port": "5432",
        "user": "postgres",
        "password": "postgres",
        "database": "postgres2",
        "client_encoding": "utf-8"
    }
    global conexion
    conexion = psycopg2.connect(**parametros)


iniciarConexion()

patron = re.compile(r'([A-Z\s]+)\s\(([0-9]+)\)')
archivo_excel = 'datos_clases_202320.xlsx'
data = pd.read_excel(archivo_excel)

for indice, fila in data.iterrows():
    valores_fila = fila.tolist()

    querySet("insert into Asignatura(cod_asignatura,nombre_asignatura) values ('"+valores_fila[4]+"','"+unidecode(valores_fila[3])+"');")

    querySet("insert into Clase(cod_asignatura,paralelo,dia,bloque,sala) values ('"+valores_fila[4]+"','"+valores_fila[5]+"','"+valores_fila[1]+"','"+valores_fila[0]+"','"+valores_fila[2]+"');")

    querySet("insert into Clase(cod_asignatura,paralelo,dia,bloque,sala) values ('"+valores_fila[4]+"','"+valores_fila[5]+"','"+valores_fila[1]+"','"+valores_fila[0]+"','"+valores_fila[2]+"');")
    
    coincidencias = patron.findall(unidecode(valores_fila[6]))
    for nombre, rut in coincidencias:
        querySet("insert into Profesor(rut_profesor,nombre_profesor) values ('"+rut+"','"+nombre.strip()+"');")
        querySet("insert into ProfesorClase(rut_profesor,cod_asignatura,paralelo) values ('"+rut+"','"+valores_fila[4]+"','"+valores_fila[5]+"');")

    
print("XD")