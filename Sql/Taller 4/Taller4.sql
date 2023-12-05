drop table if exists ItemProducto cascade;
drop table if exists PedidoMesaItem cascade;
drop table if exists MenuDiaItem cascade;
drop table if exists Merma cascade;
drop table if exists Item cascade;
drop table if exists MenuCategoria cascade;
drop table if exists MenuDia cascade;
drop table if exists PedidoProductoSuministro cascade;
drop table if exists ProductoSuministro cascade;
drop table if exists Producto cascade;
drop table if exists Suministro cascade;
drop table if exists Reservacion cascade;
drop table if exists Solicitante cascade;
drop table if exists PedidoMesa cascade;
drop table if exists Pedido cascade;
drop table if exists Mesa cascade;
drop table if exists Camarero cascade;
drop table if exists Sector cascade;
drop table if exists Piso cascade;

create table Camarero (
    rutCamarero text primary key,
    nombreCompleto text not null,
    telefono text not null,
    fechaComienzoContrato date not null,
    rutJefe text not null
);
create table Piso (
    numeroPiso int primary key
);
create table Sector (
    numeroPiso int,
    numeroSector int,
    primary key (numeroPiso, numeroSector),
    vipS_N text not null,
    terrazaS_N text not null
);
create table Mesa (
    numeroPiso int,
    numeroSector int,
    numeroMesa int,
    rutCamarero text references Camarero(rutCamarero) not null,
    primary key (numeroPiso, numeroSector, numeroMesa)
);
alter table Sector
add foreign key (numeroPiso) references Piso(numeroPiso);
alter table Mesa
add foreign key (numeroPiso, numeroSector) references Sector(numeroPiso, numeroSector);
create table Pedido (
    idPedido int primary key,
    fechaHoraPedido date not null,
    fechaHoraLLegadaPedido date not null,
    consolidadoS_N text not null
);
create table PedidoMesa (
    idPedidoMesa int primary key,
    fechaHora date not null,
    numeroPiso int references Piso(numeroPiso) not null,
    numeroSector int references Sector(numeroSector) not null,
    numeroMesa int references Mesa(numeroMesa) not null
);
create table Solicitante (
    idSolicitante text primary key,
    nombreCompleto text not null,
    telefono text not null
);
create table Reservacion (
    idReservacion int primary key,
    fechaHora date not null,
    idSolicitante text references Solicitante(idSolicitante) not null,
    numeroPiso int references Piso(numeroPiso) not null,
    numeroSector int references Sector(numeroSector) not null,
    numeroMesa int references Mesa(numeroMesa) not null
);
create table Suministro (
    idSuministro int primary key
);
create table Producto (
    idProducto int primary key
);
create table ProductoSuministro (
    idProducto int references Producto(idProducto) not null,
    idSuministro int references Suministro(idSuministro) not null,
    nombre text not null,
    precioCostoPromedio float not null,
    cantidadStock int not null,
    primary key (idProducto,idSuministro)
);
create table PedidoProductoSuministro (
    idPedido int references Pedido(idPedido) not null,
    idProducto int references Producto(idProducto) not null,
    idSuministro int references Suministro(idSuministro) not null,
    primary key (idPedido,idProducto,idSuministro),
    cantidad int not null,
    constoUnitario int not null
);
create table MenuDia (
    idMenuDia int primary key,
    fecha date
);
create table MenuCategoria (
    idMenuCategoria int primary key,
    nombre text not null
);
create table Item (
    idItem int primary key,
    nombre text not null,
    precioVenta int not null,
    idMenuCategoria int references MenuCategoria(idMenuCategoria) not null
);
create table Merma (
    idMerma int primary key,
    fechaMerma date not null,
    cantidad int not null,
    idItem int references Item(idItem) not null,
    rutCamarero text references Camarero(rutCamarero) not null
);
create table MenuDiaItem (
    idMenuDia int references MenuDia(idMenuDia) not null,
    idItem int references Item(idItem) not null,
    primary key (idMenuDia,idItem)
);
create table PedidoMesaItem (
    idPedidoMesa int references PedidoMesa(idPedidoMesa) not null,
    idItem int references Item(idItem) not null,
    primary key (idPedidoMesa,idItem)
);
create table ItemProducto(
    idItem int references Item(idItem) not null,
    idProducto int references Producto(idProducto) not null,
    cantidad int not null,
    primary key (idItem,idProducto)
);