import psycopg2

def queryGet(query):
    cur = conexion.cursor()
    cur.execute(query)
    resultados = cur.fetchall()
    cur.close()
    return resultados

def querySet(query):
    cur = conexion.cursor()
    cur.execute(query)
    conexion.commit()
    cur.close()

def iniciarConexion():
    parametros = {
        "host": "localhost",
        "port": "5432",
        "user": "postgres",
        "password": "postgres",
        "database": "postgres"
    }
    global conexion
    conexion = psycopg2.connect(**parametros)

def login(resultados):
    while True:
        usuario = input("Ingrese usuario: ")
        contrasena = input("Ingrese contraseña: ")
        for i in resultados:
            if usuario == i[1] and contrasena == i[2]:
                return i
        valorRegistro = registro(usuario,contrasena)
        if valorRegistro != False:
            return valorRegistro
        
def registro(usuario,contrasena):
    while True:
        agregar = input("Desea registrar un nuevo cliente (Y/N): ").lower()
        if agregar == "y":
            nombre = input("Ingrese el nombre del cliente: ")
            numero = input("Ingrese el numero de telefono del cliente: ")
            querySet("insert into cliente (correo,nombre,contrasena,numero_telefono) values ('" +usuario+"','"+nombre+"','"+contrasena+"','"+numero+"');")
            return queryGet("select nombre,correo,contrasena,numero_telefono,'cliente' from cliente where correo = '"+usuario+"'")[0]
        elif agregar == "n":
            return False
        else:
            print("Ingrese un valor valido")

def registrarProducto():
    id = input("Ingrese el id del producto: ")
    nombre = input("Ingrese el nombre del producto: ")
    precio = input("Ingrese el precio del producto: ")
    descripcion = input("Ingrese la descripcion del producto: ")
    stock = input("Ingrese el stock del producto: ")
    querySet("insert into producto(id_producto,nombre,precio,descripcion,stock) values ('"+id+"','"+nombre+"','"+precio+"','"+descripcion+"','"+stock+"');")

def menuAdmin():
    while True:
        print("==Menu Administrador==")
        print("1) Registrar nuevo producto")
        print("2) Informacion de producto")
        print("3) Actualizar inventario")
        print("4) Productos bajos de stock")
        print("5) Registrar venta")
        print("6) Historial de ventas")
        print("7) Salir")
        opcion = input()
        if opcion == "1":
            registrarProducto()
        elif opcion == "2":
            print()
        elif opcion == "3":
            print()
        elif opcion == "4":
            print()
        elif opcion == "5":
            print()
        elif opcion == "6":
            print()
        elif opcion == "7":
            break
        else:
            print("Ingrese una opcion valida")
        

def menuCliente(usuarioIniciado):
    print("Menu Cliente")

iniciarConexion()
resultados = queryGet("select nombre,correo,contrasena,' ','admin' from administrador union select nombre,correo,contrasena,numero_telefono,'cliente' from cliente")
usuarioIniciado = login(resultados)

if(usuarioIniciado[4] == "admin"):
    menuAdmin()
elif(usuarioIniciado[4]=="cliente"):
    menuCliente(usuarioIniciado)