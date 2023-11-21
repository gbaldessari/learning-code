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

insert into Cliente(correo,nombre,contrasena,numero_telefono) values
    ('giacomo@baldessari.it','giacomo','odioItalia','666');
