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
drop table if exists IngresosDiarios cascade;

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
    cantidad int not null,
    primary key (idPedidoMesa,idItem)
);
create table ItemProducto(
    idItem int references Item(idItem) not null,
    idProducto int references Producto(idProducto) not null,
    cantidad int not null,
    primary key (idItem,idProducto)
);
create table IngresosDiarios (
    fecha date primary key,
    monto_vendido int
);
CREATE OR REPLACE FUNCTION actualizarIngresosDiarios()
RETURNS TRIGGER
AS $$
DECLARE
    monto_total_pedido INT;
BEGIN
    IF NEW.fechaHoraPedido > NEW.fechaHoraLLegadaPedido THEN
        RAISE EXCEPTION 'La fecha de llegada debe ser posterior a la fecha de pedido.';
    END IF;

    SELECT COALESCE(SUM(PPS.constoUnitario * PPS.cantidad), 0)
    INTO monto_total_pedido
    FROM PedidoProductoSuministro PPS
    WHERE PPS.idPedido = NEW.idPedido;

    BEGIN
        IF EXISTS (SELECT 1 FROM IngresosDiarios WHERE fecha = CURRENT_DATE) THEN
            UPDATE IngresosDiarios
            SET monto_vendido = monto_vendido + monto_total_pedido
            WHERE fecha = CURRENT_DATE;
        ELSE
            INSERT INTO IngresosDiarios (fecha, monto_vendido)
            VALUES (CURRENT_DATE, monto_total_pedido);
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            RAISE EXCEPTION 'Error al actualizar IngresosDiarios: %', SQLERRM;
    END;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER pedidoRealizado
AFTER INSERT
ON Pedido
FOR EACH ROW
EXECUTE FUNCTION actualizarIngresosDiarios();

CREATE OR REPLACE FUNCTION actualizarCostoPedido()
RETURNS TRIGGER
AS $$
DECLARE
    nuevo_costo float;
BEGIN
    nuevo_costo := NEW.constoUnitario * NEW.cantidad;

    UPDATE ProductoSuministro
    SET precioCostoPromedio = (precioCostoPromedio * cantidadStock + nuevo_costo) / (cantidadStock + NEW.cantidad),
        cantidadStock = cantidadStock + NEW.cantidad
    WHERE idProducto = NEW.idProducto AND idSuministro = NEW.idSuministro;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER actualizarCostoPedido
AFTER INSERT
ON PedidoProductoSuministro
FOR EACH ROW
EXECUTE FUNCTION actualizarCostoPedido();

CREATE OR REPLACE FUNCTION asignarMesa(
    IN p_numero_piso INT,
    IN p_numero_sector INT
)
RETURNS SETOF INT
AS $$
DECLARE
    mesa_disponible INT;
    numero_mesa_asignada INT;
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Piso WHERE numeroPiso = p_numero_piso) THEN
        RAISE EXCEPTION 'El piso especificado no existe.';
    END IF;

    IF NOT EXISTS (SELECT 1 FROM Sector WHERE numeroPiso = p_numero_piso AND numeroSector = p_numero_sector) THEN
        RAISE EXCEPTION 'El sector especificado no existe.';
    END IF;

    BEGIN
        SELECT COALESCE(MAX(numeroMesa), 0) + 1
        INTO mesa_disponible
        FROM Reservacion
        WHERE numeroPiso = p_numero_piso
            AND numeroSector = p_numero_sector
            AND numeroMesa <= 3;

        IF mesa_disponible = 0 THEN
            mesa_disponible := 1;
        END IF;

        SELECT numeroMesa
        INTO numero_mesa_asignada
        FROM Mesa
        WHERE numeroPiso = p_numero_piso
            AND numeroSector = p_numero_sector
            AND numeroMesa = mesa_disponible
            AND rutCamarero IS NULL;

        IF NOT FOUND THEN
            numero_mesa_asignada := 0;
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            RAISE EXCEPTION 'Error al asignar mesa: %', SQLERRM;
    END;

    IF numero_mesa_asignada IS NOT NULL THEN
        RETURN NEXT numero_mesa_asignada;
    ELSE
        RETURN NEXT 0;
    END IF;
END;
$$ LANGUAGE plpgsql;


-- Pisos
INSERT INTO Piso(numeroPiso) VALUES (1), (2), (3);

-- Sectores
INSERT INTO Sector(numeroPiso, numeroSector, vipS_N, terrazaS_N) VALUES
(1, 1, 'S', 'N'),
(1, 2, 'N', 'S'),
(2, 1, 'S', 'N'),
(2, 2, 'N', 'N');

-- Camareros
INSERT INTO Camarero(rutCamarero, nombreCompleto, telefono, fechaComienzoContrato, rutJefe) VALUES
('123456789', 'Juan Perez', '987654321', '2022-01-01', ''),
('987654321', 'Maria Rodriguez', '123456789', '2022-02-01', '123456789');

-- Mesas
INSERT INTO Mesa(numeroPiso, numeroSector, numeroMesa, rutCamarero) VALUES
(1, 1, 1, '123456789'),
(1, 1, 2, '123456789'),
(1, 2, 1, '987654321'),
(2, 1, 1, '987654321');

-- Pedidos
INSERT INTO Pedido(idPedido, fechaHoraPedido, fechaHoraLLegadaPedido, consolidadoS_N) VALUES
(1, '2023-01-15 12:00:00', '2023-01-15 12:30:00', 'S'),
(2, '2023-01-16 18:00:00', '2023-01-16 18:45:00', 'N');

-- IngresosDiarios
INSERT INTO IngresosDiarios(fecha, monto_vendido) VALUES
('2023-01-15', 150),
('2023-01-16', 200);

-- Solicitantes
INSERT INTO Solicitante(idSolicitante, nombreCompleto, telefono) VALUES
('CL123', 'Cliente 1', '555-1234'),
('CL456', 'Cliente 2', '555-5678');

-- Reservaciones
INSERT INTO Reservacion(idReservacion, fechaHora, idSolicitante, numeroPiso, numeroSector, numeroMesa) VALUES
(1, '2023-01-17 19:00:00', 'CL123', 1, 1, 1),
(2, '2023-01-18 20:00:00', 'CL456', 1, 2, 1);

-- Productos
INSERT INTO Producto(idProducto) VALUES (1), (2), (3);

-- Suministros
INSERT INTO Suministro(idSuministro) VALUES (1), (2), (3);

-- ProductoSuministro
INSERT INTO ProductoSuministro(idProducto, idSuministro, nombre, precioCostoPromedio, cantidadStock) VALUES
(1, 1, 'Producto 1', 10.5, 100),
(2, 2, 'Producto 2', 8.75, 50),
(3, 3, 'Producto 3', 15.2, 75);

-- Menú Categoría
INSERT INTO MenuCategoria(idMenuCategoria, nombre) VALUES
(1, 'Entrada'),
(2, 'Plato Principal'),
(3, 'Postre');

-- Items
INSERT INTO Item(idItem, nombre, precioVenta, idMenuCategoria) VALUES
(1, 'Entrada 1', 8, 1),
(2, 'Plato Principal 1', 15, 2),
(3, 'Postre 1', 6, 3);

-- Menú Día
INSERT INTO MenuDia(idMenuDia, fecha) VALUES
(1, '2023-01-15'),
(2, '2023-01-16');

-- MenuDiaItem
INSERT INTO MenuDiaItem(idMenuDia, idItem) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3);

-- PedidoMesa
INSERT INTO PedidoMesa(idPedidoMesa, fechaHora, numeroPiso, numeroSector, numeroMesa) VALUES
(1, '2023-01-15 12:15:00', 1, 1, 1),
(2, '2023-01-16 18:30:00', 2, 1, 1);

-- PedidoMesaItem
INSERT INTO PedidoMesaItem(idPedidoMesa, idItem, cantidad) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 2, 1),
(2, 3, 3);

-- Merma
INSERT INTO Merma(idMerma, fechaMerma, cantidad, idItem, rutCamarero) VALUES
(1, '2023-01-15', 2, 1, '123456789'),
(2, '2023-01-16', 1, 2, '987654321');

-- ItemProducto
INSERT INTO ItemProducto(idItem, idProducto, cantidad) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- PedidoProductoSuministro
INSERT INTO PedidoProductoSuministro(idPedido, idProducto, idSuministro, cantidad, constoUnitario) VALUES
(1, 1, 1, 2, 21),
(1, 2, 2, 1, 15),
(2, 2, 2, 1, 15),
(2, 3, 3, 3, 45);

-- Escriba un bloque que despliegue el nombre del ítem y precio de venta, para aquel ítem que más
-- ha sido solicitado por los clientes.
select
    i.nombre as nombreitem,
    i.precioventa as precioventa,
    count(pmi.iditem) as cantidadsolicitada
from 
    item as i
join 
    pedidomesaitem as pmi on i.iditem = pmi.iditem
group by 
    i.nombre, i.precioventa
order by 
    cantidadsolicitada desc
limit 1;

-- Los ingresos totales obtenidos en el ultimo mes -- 
select 
    coalesce(sum(i.precioventa * pmi.cantidad), 0) as ingresostotales
from 
    pedidomesa as pm
join
    pedidomesaitem as pmi on pm.idpedidomesa = pmi.idpedidomesa
join
    item as i on pmi.iditem = i.iditem
where
    pm.fechahora >= current_date - interval '1' month;
   

-- Los ingresos obtenidos para los sectores VIP que se encuentran en terraza --
select
    coalesce(sum(i.precioventa * pmi.cantidad), 0) as ingresosterrazavip
from
    pedidomesa as pm
join
    pedidomesaitem as pmi on pm.idpedidomesa = pmi.idpedidomesa
join
    item as i on pmi.iditem = i.iditem
join
    mesa as m on pm.numeropiso = m.numeropiso
            and pm.numerosector = m.numerosector
            and pm.numeromesa = m.numeromesa
join
    sector as s on m.numeropiso = s.numeropiso
            and m.numerosector = s.numerosector
where
    s.vips_n = 's' and s.terrazas_n = 's'
    and pm.fechahora >= current_date - interval '1' month;
   
-- Los ingresos obtenidos para los sectores VIP que no se encuentran en terraza --   
select
    coalesce(sum(i.precioventa * pmi.cantidad), 0) as ingresosvipnoterraza
from
    pedidomesa as pm
join
    pedidomesaitem as pmi on pm.idpedidomesa = pmi.idpedidomesa
join
    item as i on pmi.iditem = i.iditem
join
    mesa as m on pm.numeropiso = m.numeropiso
            and pm.numerosector = m.numerosector
            and pm.numeromesa = m.numeromesa
join
    sector as s on m.numeropiso = s.numeropiso
            and m.numerosector = s.numerosector
where
    s.vips_n = 's' and s.terrazas_n = 'n'
    and pm.fechahora >= current_date - interval '1' month;

-- Los ingresos obtenidos de los sectores que no son VIP --
select
    coalesce(sum(i.precioventa * pmi.cantidad), 0) as ingresosnovip
from
    pedidomesa as pm
join
    pedidomesaitem as pmi on pm.idpedidomesa = pmi.idpedidomesa
join
    item as i on pmi.iditem = i.iditem
join
    mesa as m on pm.numeropiso = m.numeropiso
            and pm.numerosector = m.numerosector
            and pm.numeromesa = m.numeromesa
join
    sector as s on m.numeropiso = s.numeropiso
            and m.numerosector = s.numerosector
where
    s.vips_n = 'n'
    and pm.fechahora >= current_date - interval '1' month;
