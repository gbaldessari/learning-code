import psycopg2

def iniciar():
    parametros = {
        "host": "localhost",
        "port": "5432",
        "user": "postgres",
        "password": "postgres",
        "database": "postgres"
    }
    global coneccion
    coneccion = psycopg2.connect(**parametros)
    
def querySelect(coneccion,queryy):
    cur = coneccion.cursor()
    cur.execute(queryy)
    resultados = cur.fetchall()
    cur.close()
    return resultados

def queryInsert(coneccion,queryy):
    cur = coneccion.cursor()
    cur.execute(queryy)
    coneccion.commit()
    cur.close()

def login(resultados):
    usuario = input("Ingrese usuario: ")
    contrasena = input("Ingrese contraseña: ")
    for i in resultados:
        if usuario == i[0] and contrasena == i[1]:
            return i
    agregar = input("Desea registrar un nuevo cliente (Y/N): ")
    if(agregar == "Y"):
        nombre = input("Ingrese el nombre del cliente: ")
        numero = input("Ingrese el numero de telefono del cliente: ")
        queryInsert(coneccion,"insert into cliente (correo,nombre,contrasena,numero_telefono) values ('" +usuario+"','"+nombre+"','"+contrasena+"','"+numero+"');")


iniciar()
resultados = querySelect(coneccion,"select correo,contrasena,'admin' from administrador union select correo,contrasena,'cliente' from cliente")
usuario = login(resultados)

if(usuario[2] == "admin"):
    # Menu admin
    print("admin")
elif(usuario[2]=="cliente"):
    #Menu cliente
    print("cliente")