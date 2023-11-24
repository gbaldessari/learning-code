drop table if exists Cliente cascade;
drop table if exists Administrador cascade;
drop table if exists Compra cascade;
drop table if exists Producto cascade;
drop table if exists Detalle_compra cascade;

create table Cliente (
    correo text primary key,
    nombre text not null,
    contrasena text not null,
    numero_telefono text not null
);
create table Administrador (
    correo text primary key,
    nombre text not null,
    contrasena text not null
);
create table Compra (
    id_compra text primary key,
    id_administrador text references Administrador(correo) not null,
    id_cliente text references Cliente(correo) not null,
    fecha date not null
);
create table Producto (
    id_producto text primary key,
    nombre text not null,
    precio int not null,
    descripcion text not null,
    stock int not null
);
create table Detalle_compra (
    id_compra text references Compra(id_compra),
    id_producto text references Producto(id_producto),
    primary key (id_compra, id_producto),
    cantidad int not null
);

insert into Administrador(correo,nombre,contrasena) values 
    ('laura@tienda.com','laura','LauR1234');

INSERT INTO Cliente (correo, nombre, contrasena, numero_telefono)
VALUES 
    ('argentina@gmail.com', 'David Hilbe', 'vivaMilei', '123456789'),
    ('matisos@hotmail.com', 'Matias Di Steffano', 'sosrerRar', '987654321');

INSERT INTO Producto (id_producto, nombre, precio, descripcion, stock)
VALUES 
    ('P1', 'Lámpara de Mesa', 25000, 'Lámpara decorativa para el hogar', 50),
    ('P2', 'Juego de Toallas', 30000, 'Juego de toallas de alta calidad', 40),
    ('P3', 'Cojín Decorativo', 10000, 'Cojín suave y decorativo para el sofá', 60);

INSERT INTO Compra (id_compra, id_administrador, id_cliente, fecha)
VALUES 
    ('C1', 'laura@tienda.com', 'argentina@gmail.com', '2023-01-01'),
    ('C2', 'laura@tienda.com', 'matisos@hotmail.com', '2023-02-01');

INSERT INTO Detalle_compra (id_compra, id_producto, cantidad)
VALUES 
    ('C1', 'P1', 2),
    ('C1', 'P2', 1),
    ('C2', 'P3', 3);