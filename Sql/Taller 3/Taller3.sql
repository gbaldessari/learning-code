create table cliente (
    correo text primary key,
    nombre text not null,
    contrasena text not null,
    numero_telefono text not null
);
create table administrador (
    correo text primary key,
    nombre text not null,
    contrasena text not null
);
create table compra (
    id_compra text primary key,
    id_administrador text references administrador(correo) not null,
    id_cliente text references cliente(correo) not null,
    fecha date not null
);
create table producto (
    id_producto text primary key,
    nombre text not null,
    precio int not null,
    descripcion text not null,
    stock int not null
);
create table detalle_compra (
    id_compra text REFERENCES compra(id_compra),
    id_producto text REFERENCES producto(id_producto),
    primary key (id_compra, id_producto),
    cantidad int not null
);

insert into administrador(correo,nombre,contrasena) values 
    ('laura@tienda.com','laura','LauR1234');

insert into cliente(correo,nombre,contrasena,numero_telefono) values
    ('giacomo@baldessari.it','giacomo','odioItalia','666');

select correo,contrasena,'admin' from administrador
union
select correo,contrasena,'cliente' from cliente