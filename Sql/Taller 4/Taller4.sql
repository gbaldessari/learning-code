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
    numeroPiso int references Piso(numeroPiso) not null,
    numeroSector int not null,
    primary key (numeroPiso, numeroSector),
    vipS_N text not null,
    terrazaS_N text not null
);
create table Mesa (
    numeroPiso int references Piso(numeroPiso) not null,
    numeroSector int not null,
    numeroMesa int not null,
    primary key (numeroPiso,numeroSector,numeroMesa),
    rutCamarero text references Camarero(rutCamarero) not null
);
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
    numeroSector int not null,
    numeroMesa int not null
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
    numeroSector int not null,
    numeroMesa int not null
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

-- Insert sample data into Piso table
INSERT INTO Piso (numeroPiso) VALUES
(1),
(2),
(3);

-- Insert sample data into Sector table
INSERT INTO Sector (numeroPiso, numeroSector, vipS_N, terrazaS_N) VALUES
(1, 1, 'S', 'N'),
(1, 2, 'N', 'Y'),
(2, 1, 'N', 'N');

-- Insert sample data into Camarero table
INSERT INTO Camarero (rutCamarero, nombreCompleto, telefono, fechaComienzoContrato, rutJefe) VALUES
('123456789', 'John Doe', '555-1234', '2022-01-01', '987654321'),
('987654321', 'Jane Smith', '555-5678', '2022-02-01', '123456789');

-- Insert sample data into Mesa table
INSERT INTO Mesa (numeroPiso, numeroSector, numeroMesa, rutCamarero) VALUES
(1, 1, 101, '123456789'),
(1, 2, 201, '987654321'),
(2, 1, 301, '123456789');

-- Insert sample data into Pedido table
INSERT INTO Pedido (idPedido, fechaHoraPedido, fechaHoraLLegadaPedido, consolidadoS_N) VALUES
(1, '2023-01-15', '2023-01-15', 'S'),
(2, '2023-02-20', '2023-02-20', 'N');

-- Insert sample data into PedidoMesa table
INSERT INTO PedidoMesa (idPedidoMesa, fechaHora, numeroPiso, numeroSector, numeroMesa) VALUES
(1, '2023-01-15 12:30:00', 1, 1, 101),
(2, '2023-02-20 18:45:00', 1, 2, 201);

-- Insert sample data into Solicitante table
INSERT INTO Solicitante (idSolicitante, nombreCompleto, telefono) VALUES
('SOL001', 'Alice Johnson', '555-1111'),
('SOL002', 'Bob Williams', '555-2222');

-- Insert sample data into Reservacion table
INSERT INTO Reservacion (idReservacion, fechaHora, idSolicitante, numeroPiso, numeroSector, numeroMesa) VALUES
(1, '2023-03-01 19:00:00', 'SOL001', 2, 1, 301),
(2, '2023-03-10 20:30:00', 'SOL002', 1, 1, 101);

-- Insert sample data into Suministro table
INSERT INTO Suministro (idSuministro) VALUES
(1),
(2),
(3);

-- Insert sample data into Producto table
INSERT INTO Producto (idProducto) VALUES
(1),
(2),
(3);

-- Insert sample data into ProductoSuministro table
INSERT INTO ProductoSuministro (idProducto, idSuministro, nombre, precioCostoPromedio, cantidadStock) VALUES
(1, 1, 'Product A', 10.50, 100),
(2, 2, 'Product B', 8.75, 150),
(3, 3, 'Product C', 12.00, 120);

-- Insert sample data into PedidoProductoSuministro table
INSERT INTO PedidoProductoSuministro (idPedido, idProducto, idSuministro, cantidad, constoUnitario) VALUES
(1, 1, 1, 2, 21),
(1, 2, 2, 3, 26),
(2, 3, 3, 1, 12);

-- Insert sample data into MenuDia table
INSERT INTO MenuDia (idMenuDia, fecha) VALUES
(1, '2023-01-05'),
(2, '2023-02-10');

-- Insert sample data into MenuCategoria table
INSERT INTO MenuCategoria (idMenuCategoria, nombre) VALUES
(1, 'Appetizer'),
(2, 'Main Course'),
(3, 'Dessert');

-- Insert sample data into Item table
INSERT INTO Item (idItem, nombre, precioVenta, idMenuCategoria) VALUES
(1, 'Item 1', 15, 1),
(2, 'Item 2', 25, 2),
(3, 'Item 3', 10, 3);

-- Insert sample data into Merma table
INSERT INTO Merma (idMerma, fechaMerma, cantidad, idItem, rutCamarero) VALUES
(1, '2023-01-10', 5, 1, '123456789'),
(2, '2023-02-15', 3, 2, '987654321');

-- Insert sample data into MenuDiaItem table
INSERT INTO MenuDiaItem (idMenuDia, idItem) VALUES
(1, 1),
(2, 2);

-- Insert sample data into PedidoMesaItem table
INSERT INTO PedidoMesaItem (idPedidoMesa, idItem) VALUES
(1, 1),
(2, 2);

-- Insert sample data into ItemProducto table
INSERT INTO ItemProducto (idItem, idProducto, cantidad) VALUES
(1, 1, 2),
(2, 2, 3);
