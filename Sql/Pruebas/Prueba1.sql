drop table if exists Persona cascade;
drop table if exists Unidad cascade;
drop table if exists Carrera cascade;
drop table if exists Profesor cascade;
drop table if exists Funcionario cascade;
drop table if exists Estudiante cascade;

create table Persona(
	rut text primary key,
	nombre text not null
);
create table Unidad(
	id text primary key,
	nombre text not null
);
create table Carrera(
	id text primary key,
	nombre text not null
);
create table Profesor(
	id text primary key,
	id_unidad text references Unidad(id) not null,
	rut_persona text references Persona(rut) not null,
	fecha_inicio date not null,
	fecha_termino date
);
create table Funcionario(
	id text primary key,
	id_unidad text references Unidad(id) not null,
	rut_persona text references Persona(rut) not null,
	fecha_inicio date not null,
	fecha_termino date
);
create table Estudiante(
	id text primary key,
	id_carrera text references Carrera(id) not null,
	rut_persona text references Persona(rut) not null,
	fecha_inicio date not null,
	fecha_termino date
);
-- Insertar personas
INSERT INTO Persona (rut, nombre) VALUES
  ('111111111', 'Ana Sánchez'),
  ('222222222', 'Pedro Rodríguez'),
  ('333333333', 'Luisa Martínez'),
  ('444444444', 'Carlos González'),
  ('555555555', 'Sofía Pérez'),
  ('666666666', 'Eduardo López'),
  ('777777777', 'María Fernández'),
  ('888888888', 'Javier Ramírez'),
  ('999999999', 'Isabel Torres'),
  ('101010101', 'Andrés Díaz'),
  ('121212121', 'Laura Herrera'),
  ('131313131', 'José Castro'),
  ('141414141', 'Valentina Paredes'),
  ('151515151', 'Ricardo Silva'),
  ('161616161', 'Carmen Flores'),
  ('171717171', 'Miguel Ortega'),
  ('181818181', 'Daniela Vargas'),
  ('191919191', 'Raúl Navarro'),
  ('202020202', 'Paula Reyes'),
  ('212121212', 'Fernando Guzmán'),
  ('222222223', 'Gloria Rojas'),
  ('232323232', 'Felipe Álvarez'),
  ('242424242', 'Valeria Espinoza'),
  ('252525252', 'Hernán Castro'),
  ('262626262', 'Camila Araya'),
  ('272727272', 'Eduardo Moroso'),
  ('282828282', 'Claudia Morales'),
  ('292929292', 'Nicolás González'),
  ('123456789', 'César Araya'),
  ('987654321', 'David Silva');

-- Insertar unidades
INSERT INTO Unidad (id, nombre) VALUES
  ('U1', 'Escuela de ingeniería'),
  ('U2', 'Biología marina'),
  ('U3', 'Escuela de ciencias empresariales'),
  ('U4', 'Ciencias Basicas'),
  ('U5', 'Biblioteca');

-- Insertar carreras
INSERT INTO Carrera (id, nombre) VALUES
  ('C1', 'ITI'),
  ('C2', 'ICCI'),
  ('C3', 'ICI'),
  ('C4', 'INGECO'),
  ('C5', 'Medicina');

-- Insertar profesores
INSERT INTO Profesor (id, id_unidad, rut_persona, fecha_inicio, fecha_termino) VALUES
  ('P1', 'U1', '123456789', '2010-01-10', '2020-12-31'),
  ('P2', 'U2', '987654321', '2012-03-15', '2021-09-30'),
  ('P3', 'U3', '555555555', '2014-08-15', null),
  ('P4', 'U4', '666666666', '2011-02-25', '2019-07-10'),
  ('P5', 'U5', '777777777', '2012-05-10', '2023-09-20'),
  ('P6', 'U1', '141414141', '2010-04-15', '2019-12-31'),
  ('P7', 'U2', '151515151', '2012-08-20', '2021-11-30'),
  ('P8', 'U3', '161616161', '2011-03-05', '2019-10-15'),
  ('P9', 'U4', '171717171', '2010-07-10', '2019-05-30'),
  ('P10', 'U5', '181818181', '2012-05-01', null),
  ('P11', 'U1', '987654321', '2011-09-01', '2020-12-31'),
  ('P12', 'U2', '202020202', '2010-06-15', '2019-11-30'),
  ('P13', 'U3', '212121212', '2012-02-25', '2022-10-10'),
  ('P14', 'U4', '222222222', '2011-05-10', '2019-08-15'),
  ('P15', 'U5', '232323232', '2010-04-20', null);

-- Insertar funcionarios
INSERT INTO Funcionario (id, id_unidad, rut_persona, fecha_inicio, fecha_termino) VALUES
  ('F1', 'U1', '123456789', '2011-05-20', null),
  ('F2', 'U2', '987654321', '2015-07-01', '2022-11-15'),
  ('F3', 'U3', '888888888', '2013-03-01', '2021-12-15'),
  ('F4', 'U4', '999999999', '2010-06-10', '2018-11-05'),
  ('F5', 'U5', '101010101', '2012-09-20', '2023-06-30'),
  ('F6', 'U1', '242424242', '2013-03-10', '2021-11-05'),
  ('F7', 'U2', '252525252', '2015-06-20', '2022-09-15'),
  ('F8', 'U3', '262626262', '2014-07-05', null),
  ('F9', 'U4', '272727272', '2012-09-10', '2021-12-31'),
  ('F10', 'U5', '282828282', '2013-02-15', '2022-08-30');

-- Insertar estudiantes
INSERT INTO Estudiante (id, id_carrera, rut_persona, fecha_inicio, fecha_termino) VALUES
  ('E1', 'C1', '123456789', '2010-09-05', null),
  ('E2', 'C2', '987654321', '2013-02-10', '2018-09-30'),
  ('E3', 'C3', '111111111', '2011-02-01', '2016-11-30'),
  ('E4', 'C4', '121212121', '2013-04-10', null),
  ('E5', 'C5', '131313131', '2010-07-15', '2023-03-25'),
  ('E6', 'C1', '292929292', '2010-03-01', '2014-12-31'),
  ('E7', 'C2', '252525252', '2013-01-10', '2018-09-30'),
  ('E8', 'C3', '777777777', '2011-04-15', '2016-07-25'),
  ('E9', 'C4', '202020202', '2010-05-20', '2015-03-15'),
  ('E10', 'C5', '141414141', '2013-06-10', null),
  ('E11', 'C1', '252525252', '2012-02-01', '2016-12-31'),
  ('E12', 'C2', '171717171', '2010-07-10', '2015-08-30'),
  ('E13', 'C3', '232323232', '2011-09-15', '2016-09-20'),
  ('E14', 'C4', '222222222', '2013-03-25', '2017-12-31'),
  ('E15', 'C5', '151515151', '2012-04-20', '2016-11-15');

-- a. Obtenga el/la estudiante mas antigua de la universidad.
select P.nombre, P.rut, E.fecha_inicio, E.fecha_termino
from Estudiante E
inner join Persona P on E.rut_persona = P.rut
where E.fecha_inicio = (
  select min(fecha_inicio) from Estudiante);

-- b. Obtenga la persona que más tiempo lleva en la UCN
select tabla.nombre, tabla.rut, tabla.duracion
from(
select P.rut, P.nombre, 
    greatest(
        max(coalesce(E.fecha_termino, NOW()) - E.fecha_inicio),
        max(coalesce(F.fecha_termino, NOW()) - F.fecha_inicio),
        max(coalesce(Pr.fecha_termino, NOW()) - Pr.fecha_inicio)
    ) as duracion
FROM Persona P
left join Estudiante as E on P.rut = E.rut_persona
left join Funcionario as F on P.rut = F.rut_persona
left join Profesor as Pr on P.rut = Pr.rut_persona
group by P.rut, P.nombre
order by 3 desc, 1 asc
) as tabla
where duracion is not null
limit 1

-- c. Obtenga la persona que más veces ha sido estudiante en la UCN
select P.nombre, P.rut, count(rut) as veces_estudiante
from Persona as P
inner join Estudiante as E on P.rut = E.rut_persona
group by P.rut, P.nombre
order by 3 desc
limit 1

-- d. Liste a todas las personas de la UCN, indicando la cantidad de roles que han desempeñado
select P.nombre, P.rut, count(distinct E.rut_persona) + count(distinct F.rut_persona)+ count(distinct Pr.rut_persona) as roles
from Persona as P
left join Estudiante as E on P.rut = E.rut_persona
left join Funcionario as F on P.rut = F.rut_persona
left join Profesor as Pr on P.rut = Pr.rut_persona
group by nombre, rut 
order by 3 desc, 1 asc;

-- e. Dada una fecha (por ejemplo, “2023-10-01”) indique la cantidad de personas relacionadas con cada una de las unidades de la UCN
select U.nombre, U.id, count(P.rut) as personas
from Unidad as U
left join (Persona as P
    left join Funcionario as F on P.rut = F.rut_persona and '2022-10-01' between F.fecha_inicio and F.fecha_termino
    left join Profesor as Pr on P.rut = Pr.rut_persona and '2022-10-01' between Pr.fecha_inicio and Pr.fecha_termino
) on  U.id = F.id_unidad or U.id = Pr.id_unidad
group by U.id, U.nombre
order by 3 desc

-- f. Liste todas las unidades, indicando la cantidad de personas totales que han relacionadas con dicha unidad.
select U.id, U.nombre, count(P.rut) as personas
from Unidad as U
left join (Persona as P
    left join Funcionario as F on P.rut = F.rut_persona
    left join Profesor as Pr on P.rut = Pr.rut_persona
) on U.id = F.id_unidad or U.id = Pr.id_unidad
group by U.id, U.nombre
union
select C.id, C.nombre, count(P.rut) as personas
from Carrera as C
left join (Persona as P 
	left join Estudiante as E on P.rut = E.rut_persona) on C.id = E.id_carrera
group by C.id, C.nombre