import psycopg2
import re

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

def iniciarSesion():
    while True:
        opcion = input("¿Desea ingresar (I) o registrarse (R)? ").lower()

        if opcion == "i":
            return ingresar()
        elif opcion == "r":
            return registrar()
        else:
            print("Ingrese una opción válida (I para ingresar, R para registrarse)")

def ingresar():
    while True:
        usuario = input("Ingrese usuario: ")
        contrasena = input("Ingrese contraseña: ")
        for i in usuarios:
            if usuario == i[1] and contrasena == i[2]:
                return i
        print("Credenciales incorrectas. Inténtelo nuevamente.")

def registrar():
    usuario = input("Ingrese usuario: ")
    while True:
        contrasena = input("Ingrese contraseña: ")
        if validarContrasena(contrasena):
            nombre = input("Ingrese el nombre del cliente: ")
            numero = input("Ingrese el número de teléfono del cliente: ")
            querySet("insert into cliente (correo, nombre, contrasena, numero_telefono) values ('" + usuario + "','" + nombre + "','" + contrasena + "','" + numero + "');")
            return queryGet("select nombre, correo, contrasena, numero_telefono, 'cliente' from cliente where correo = '" + usuario + "'")[0]
        else:
            print("La contraseña no cumple con los requisitos. Inténtelo nuevamente.")

def validarContrasena(contrasena):
    if 6 <= len(contrasena) <= 8:
        if re.search(r"[A-Z]", contrasena):
            if re.search(r"\d", contrasena):
                if re.search(r"[!@#$%^&*()-_=+{};:'\",.<>?/\\|`~]", contrasena):
                    return True
                else:
                    print("La contraseña debe contener al menos un carácter especial.")
            else:
                print("La contraseña debe contener al menos un número.")
        else:
            print("La contraseña debe contener al menos una letra mayúscula.")
    else:
        print("La longitud de la contraseña debe estar entre 6 y 8 caracteres.")
    return False

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
usuarios = queryGet("select nombre,correo,contrasena,' ','admin' from administrador union select nombre,correo,contrasena,numero_telefono,'cliente' from cliente")
usuarioIniciado = iniciarSesion()

if(usuarioIniciado[4] == "admin"):
    menuAdmin()
elif(usuarioIniciado[4]=="cliente"):
    menuCliente(usuarioIniciado)