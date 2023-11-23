import psycopg2
import re
import datetime

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
    if not 6 <= len(contrasena) <= 8:
        print("La longitud de la contraseña debe estar entre 6 y 8 caracteres.")
        return False
    if not re.search(r"[A-Z]", contrasena):
        print("La contraseña debe contener al menos una letra mayúscula.")
        return False
    if not re.search(r"\d", contrasena):
        print("La contraseña debe contener al menos un número.")
        return False
    if not re.search(r"[!@#$%^&*()-_=+{};:'\",.<>?/\\|`~]", contrasena):
        print("La contraseña debe contener al menos un carácter especial.")
        return False
    return True

def registrarProducto():
    id = input("Ingrese el id del producto: ")
    nombre = input("Ingrese el nombre del producto: ")
    
    while True:
        try:
            precio = int(input("Ingrese el precio del producto: "))
            break
        except ValueError:
            print("Por favor, ingrese un valor válido para el precio.")
    
    descripcion = input("Ingrese la descripcion del producto: ")
    
    while True:
        try:
            stock = int(input("Ingrese el stock del producto: "))
            break
        except ValueError:
            print("Por favor, ingrese un número válido para el stock.")
    
    querySet("insert into producto(id_producto,nombre,precio,descripcion,stock) values ('"+id+"','"+nombre+"','"+str(precio)+"','"+descripcion+"','"+str(stock)+"');")

def verProducto():
    id = input("Ingrese el id del producto que desea ver: ")
    producto = queryGet("select * from producto where id_producto = '" + id + "'")

    if producto:
        print("Detalles del producto:")
        print("ID: ", producto[0][0])
        print("Nombre: ", producto[0][1])
        print("Precio: ", producto[0][2])
        print("Descripción: ", producto[0][3])
        print("Stock: ", producto[0][4])
    else:
        print("No se encontró un producto con el ID proporcionado.")

def actualizarInventario():
    id = input("Ingrese el id del producto que desea actualizar: ")
    producto = queryGet("select * from producto where id_producto = '" + id + "'")

    if producto:
        print("Detalles actuales del producto:")
        print("ID: ", producto[0][0])
        print("Nombre: ", producto[0][1])
        print("Precio: ", producto[0][2])
        print("Descripción: ", producto[0][3])
        print("Stock: ", producto[0][4])
        
        while True:
            try:
                nuevo_precio = int(input("Ingrese el nuevo precio del producto: "))
                break
            except ValueError:
                print("Por favor, ingrese un valor válido para el precio.")
        
        while True:
            try:
                nuevo_stock = int(input("Ingrese la nueva cantidad en stock del producto: "))
                break
            except ValueError:
                print("Por favor, ingrese un número válido para el stock.")
        
        querySet("update producto set precio = '"+str(nuevo_precio)+"', stock = '"+str(nuevo_stock)+"' where id_producto = '"+id+"'")
        print("Inventario actualizado correctamente.")
    else:
        print("No se encontró un producto con el ID proporcionado.")

def verProductosBajosStock():
    umbral = int(input("Ingrese el umbral de stock: "))
    productos = queryGet("select * from producto where stock <= " + str(umbral))

    if productos:
        print("Productos con stock bajo el umbral:")
        for producto in productos:
            print("ID: ", producto[0])
            print("Nombre: ", producto[1])
            print("Precio: ", producto[2])
            print("Descripción: ", producto[3])
            print("Stock: ", producto[4])
            print("-----------------------------")
    else:
        print("No hay productos con stock por debajo del umbral proporcionado.")



def registrarVenta(id_administrador):
    ventas = queryGet("select count(*) from compra")
    id_compra = str(ventas[0][0])
    id_cliente = input("Ingrese el id del cliente: ")
    fecha = datetime.date.today().strftime("%Y-%m-%d")
    querySet("insert into compra(id_compra, id_administrador, id_cliente, fecha) values ('"+id_compra+"','"+id_administrador+"','"+id_cliente+"','"+fecha+"');")
    
    while True:
        id_producto = input("Ingrese el id del producto vendido: ")
            
        while True:
            try:
                cantidad = int(input("Ingrese la cantidad vendida de este producto: "))
                break
            except ValueError:
                print("Por favor, ingrese un número válido para la cantidad.")
            
        querySet("insert into detalle_compra(id_compra, id_producto, cantidad) values ('"+id_compra+"','"+id_producto+"','"+str(cantidad)+"');")
        print("Producto agregado a la venta.")

        while True:
            agregar_producto = input("¿Desea agregar un nuevo producto a la venta? (Si/No): ")
            if agregar_producto.lower() == 'si' or agregar_producto.lower() == 's':
                break
            elif agregar_producto.lower() == 'no' or agregar_producto.lower() == 'n':
                print("Venta registrada correctamente.")
                return

def verHistorialVentas():
    ventas = queryGet("select * from compra")

    if ventas:
        print("Historial de ventas:")

        for venta in ventas:
            print("ID de la venta: ", venta[0])
            print("ID del administrador: ", venta[1])
            print("ID del cliente: ", venta[2])
            print("Fecha: ", venta[3])
            detalles = queryGet("select * from detalle_compra where id_compra = '" + venta[0] + "'")
            monto_total = 0

            for detalle in detalles:
                producto = queryGet("select * from producto where id_producto = '" + detalle[1] + "'")[0]
                print("Producto: ", producto[1])
                print("Cantidad: ", detalle[2])
                monto_total += producto[2] * detalle[2]

            print("Monto total: ", monto_total)
            print("-----------------------------")
    else:
        print("No hay ventas registradas.")

def verInformacionPersonal(usuarioIniciado):
    print("Informacion Personal:")
    print("Nombre: " + usuarioIniciado[0])
    print("Contraseña :" + usuarioIniciado[2])
    print("Correo: " + usuarioIniciado[1])
    print("Numero de telefono: " + usuarioIniciado[3])
    print("-----------------------------")
    
def verCatalogoProductos():
    productos = queryGet("select * from producto")
    if productos:
        print("Catálogo de productos:")
        for producto in productos:
            print("ID: ", producto[0])
            print("Nombre: ", producto[1])
            print("Precio: ", producto[2])
            print("Descripción: ", producto[3])
            print("-----------------------------")
    else:
        print("No hay productos disponibles en la tienda.")

def realizarCompra(usuarioIniciado):
    id_compra = str(queryGet("select count(*) from compra")[0][0])
    fecha = datetime.date.today().strftime("%Y-%m-%d")
    querySet("insert into compra(id_compra, id_administrador, id_cliente, fecha) values ('"+id_compra+"','N.A','"+usuarioIniciado[1]+"','"+fecha+"');")
    
    while True:
        id_producto = input("Ingrese el id del producto que desea comprar: ")
        
        while True:
            try:
                cantidad = int(input("Ingrese la cantidad que desea comprar de este producto: "))
                break
            except ValueError:
                print("Por favor, ingrese un número válido para la cantidad.")
        
        querySet("insert into detalle_compra(id_compra, id_producto, cantidad) values ('"+id_compra+"','"+id_producto+"','"+str(cantidad)+"');")
        print("Producto agregado a la compra.")

        while True:
            agregar_producto = input("¿Desea agregar un nuevo producto a la compra? (Si/No): ")
            if agregar_producto.lower() == 'si' or agregar_producto.lower() == 's':
                break
            elif agregar_producto.lower() == 'no' or agregar_producto.lower() == 'n':
                print("Compra realizada correctamente.")
                return
    
    


def menuAdmin(id):
    while True:
        print("== Menu Administrador ==")
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
            verProducto()
        elif opcion == "3":
            actualizarInventario()
        elif opcion == "4":
            verProductosBajosStock()
        elif opcion == "5":
            registrarVenta(id)
        elif opcion == "6":
            verHistorialVentas()
        elif opcion == "7":
            break
        else:
            print("Ingrese una opcion valida")
        

def menuCliente(usuarioIniciado):
    while True:
        print("== Menu Cliente ==")
        print("1) Ver informacion personal")
        print("2) Ver catalogo de productos")
        print("3) Realizar una compra")
        print("4) Salir")
        opcion = input()

        if opcion == "1":
            verInformacionPersonal(usuarioIniciado)
        elif opcion == "2":
            verCatalogoProductos()
        elif opcion == "3":
            print(1)
        elif opcion == "4":
            break



iniciarConexion()
usuarios = queryGet("select nombre,correo,contrasena,' ','admin' from administrador union select nombre,correo,contrasena,numero_telefono,'cliente' from cliente")
usuarioIniciado = iniciarSesion()

if(usuarioIniciado[4] == "admin"):
    menuAdmin(id)
elif(usuarioIniciado[4]=="cliente"):
    menuCliente(usuarioIniciado)