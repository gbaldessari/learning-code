drop table if exists Estudiante cascade;
drop table if exists Carrera cascade;
drop table if exists Asistencia cascade;
drop table if exists Asignatura cascade;
drop table if exists Semestre cascade;
drop table if exists InscripcionCarrera cascade;
drop table if exists EstudianteAsistencia cascade;
drop table if exists InscripcionAsignatura cascade;
drop table if exists AsistenciaAsignatura cascade;
drop table if exists auditoriaInscripcion cascade;

create table Estudiante (
    rut text primary key,
    nombre text not null
);
create table Carrera (
    codigo text primary key,
    nombre text not null
);
create table Asistencia (
    codigo text primary key,
    fecha date not null
);
create table Asignatura (
    codigo text primary key,
    nombre text not null
);
create table Semestre (
    codigo int primary key,
    fechaInicio date not null,
    fechaTermino date not null
);
create table InscripcionCarrera (
    codigo text primary key,
    codigoCarrera text references Carrera(codigo) not null,
    rutEstudiante text references Estudiante(rut) not null,
    semestreIngreso int references Semestre(codigo) not null
);
create table EstudianteAsistencia (
    codigo text primary key,
    rutEstudiante text references Estudiante(rut) not null,
    codigoAsistencia text references Asistencia(codigo) not null
);
create table InscripcionAsignatura (
    codigo text primary key,
    rutEstudiante text references Estudiante(rut) not null,
    codigoAsignatura text references Asignatura(codigo) not null,
    paralelo text not null,
    semestreInscripcion int references Semestre(codigo) not null
);
create table AsistenciaAsignatura (
    codigo text primary key,
    codigoAsignatura text references Asignatura(codigo) not null,
    codigoAsistencia text references Asistencia(codigo) not null,
    paralelo text not null
);

/*6.a Si su modelo no lo soporta de forma natural, escriba un trigger que impida que los estudiantes escriban asignaturas
en semestre anteriores a su semestre de ingreso a la carrera.*/
create or replace function validar_semestre_ingreso()
returns trigger as $$
begin
    if (
        new.semestreInscripcion < (
            select semestreIngreso
            from InscripcionCarrera
            where rutEstudiante = new.rutEstudiante
            order by semestreIngreso
            limit 1
        )
    ) then
        raise exception 'No puedes inscribir asignaturas en semestres anteriores a tu semestre de ingreso a la carrera';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger validar_semestre_ingreso_trigger
before insert on InscripcionAsignatura
for each row execute function validar_semestre_ingreso();

/*6.b Como seguramente su modelo solo guarda la información “actual” de lo que los estudiantes tienen, si su modelo no lo soporta de forma natural, escriba
triggers para poder almacenar en una tabla auxiliar (llamada “auditoria_inscripcion”) todos las inscripciones, modificaciones de inscripción y eliminaciones
de asignaturas que hacen las y los estudiantes. Dicha tabla debe tener solo una columna, llamada “texto”.*/
create table auditoriaInscripcion (
    texto text not null
);

create or replace function trigger_inscripcion()
returns trigger as $$
begin
    insert into auditoriaInscripcion (texto)
    values (
        'Estudiante ' || new.rutEstudiante || ' inscribió ' || new.codigoAsignatura ||
        ' en semestre ' || new.semestreInscripcion
    );
    return new;
end;
$$ language plpgsql;

create trigger trigger_inscripcion
after insert on InscripcionAsignatura
for each row execute function trigger_inscripcion();

create or replace function trigger_renuncia()
returns trigger as $$
begin
    insert into auditoriaInscripcion (texto)
    values (
        'Estudiante ' || old.rutEstudiante || ' renunció a ' || old.codigoAsignatura ||
        ' en semestre ' || old.semestreInscripcion
    );
    return old;
end;
$$ language plpgsql;

create trigger trigger_renuncia
before delete on InscripcionAsignatura
for each row execute function trigger_renuncia();

--6.c Construya triggers para asegurar que siempre que se va a almacenar un RUT, éste se almacene sin espacios, ni puntos, ni guiones, y con la letra K en mayúscula.
create or replace function normalizar_rut()
returns trigger as $$
begin
    new.rut = UPPER(REGEXP_REPLACE(new.rut, '[^0-9kK]', '', 'g'));
    return new;
end;
$$ language plpgsql;

create trigger normalizar_rut_trigger
before insert or update on Estudiante
for each row execute function normalizar_rut();

-- Insercion de datos
INSERT INTO Estudiante (rut, nombre) VALUES
    ('123456789', 'Juan Pérez'),
    ('987654321', 'María Gómez'),
    ('555555555', 'Carlos Rodríguez');
INSERT INTO Carrera (codigo, nombre) VALUES
    ('C001', 'Ingeniería Informática'),
    ('C002', 'Psicología'),
    ('C003', 'Administración de Empresas');
INSERT INTO Asistencia (codigo, fecha) VALUES
    ('A001', '2023-01-15'),
    ('A002', '2023-02-10'),
    ('A003', '2023-03-20');
INSERT INTO Asignatura (codigo, nombre) VALUES
    ('AS001', 'Programación I'),
    ('AS002', 'Psicología General'),
    ('AS003', 'Contabilidad');
INSERT INTO Semestre (codigo, fechaInicio, fechaTermino) VALUES
    (20221, '2022-01-01', '2022-06-30'),
    (20222, '2022-07-01', '2022-12-31'),
    (20231, '2023-01-01', '2023-06-30');
INSERT INTO InscripcionCarrera (codigo, codigoCarrera, rutEstudiante, semestreIngreso) VALUES
    ('IC001', 'C001', '123456789', 20221),
    ('IC002', 'C002', '987654321', 20222),
    ('IC003', 'C003', '555555555', 20231);
INSERT INTO EstudianteAsistencia (codigo, rutEstudiante, codigoAsistencia) VALUES
    ('EA001', '123456789', 'A001'),
    ('EA002', '987654321', 'A002'),
    ('EA003', '555555555', 'A003');
INSERT INTO InscripcionAsignatura (codigo, rutEstudiante, codigoAsignatura, paralelo, semestreInscripcion) VALUES
    ('IA001', '123456789', 'AS001', 'C1', 20221),
    ('IA002', '987654321', 'AS002', 'C2', 20222),
    ('IA003', '555555555', 'AS003', 'C1', 20231);
INSERT INTO AsistenciaAsignatura (codigo, codigoAsignatura, codigoAsistencia, paralelo) VALUES
    ('AA001', 'AS001', 'A001', 'C1'),
    ('AA002', 'AS002', 'A002', 'C2'),
    ('AA003', 'AS003', 'A003', 'C1');

/*5.a  Dado el código de una asignatura, el identificador del paralelo y un número de semestre, muestre el listado de personas inscritas
y, para cada persona, la cantidad de clases a las que asistió.*/
select
    E.rut,
    E.nombre,
    count(distinct EA.codigoAsistencia) as clases_asistidas
from
    Estudiante E
join
    InscripcionAsignatura as IA on E.rut = IA.rutEstudiante
join
    EstudianteAsistencia as EA on E.rut = EA.rutEstudiante
where
    IA.codigoAsignatura = 'AS001'
    and IA.paralelo = 'C1'
    and IA.semestreInscripcion = 20221
group by
    E.rut, E.nombre;

--5.b Dado un número de semestre y un código de asignatura, liste los paralelos que se dictaron ese semestre, mostrando la cantidad de personas inscritas en cada paralelo.
select
    IA.paralelo,
    count(IC.rutEstudiante) as cantidadInscritos
from
    InscripcionAsignatura as IA
join
    InscripcionCarrera as IC on IA.rutEstudiante = IC.rutEstudiante
where
    IA.semestreInscripcion = 20221
    and IA.codigoAsignatura = 'AS001'
group by
    IA.paralelo;

/*5.c Liste a todos los y las estudiantes registrados en el sistema, indicando en una columna el nombre de su carrera más reciente, y en otra columna la cantidad de
ingresos a carrera que ha tenido (si ha ingresado más de una vez a la misma carrera, se consideran como ingresos separados).*/

select
    E.rut,
    E.nombre as nombre_estudiante,
    C.nombre as carrera,
    count(IC.codigo) as cantidad_ingresos
from
    Estudiante as E
join
    InscripcionCarrera as IC on E.rut = IC.rutEstudiante
join
    Carrera as C on IC.codigoCarrera = C.codigo
where
    IC.semestreIngreso = (
        select max(semestreIngreso)
        from InscripcionCarrera
        where rutEstudiante = E.rut
    )
group by
    E.rut, E.nombre, C.nombre
order by
    E.rut;

/*7 Elija una de las consultas del punto (5) y muestre (usando “explain”) cómo creando índices apropiados, el desempeño
de la consulta mejora. Muestre cómo se ejecuta la consulta antes y después de crear los índices.*/

--Antes
"GroupAggregate  (cost=615.98..616.04 rows=3 width=104)"
"  Group Key: e.rut, c.nombre"
"  ->  Sort  (cost=615.98..615.98 rows=3 width=128)"
"        Sort Key: e.rut, c.nombre"
"        ->  Nested Loop  (cost=32.15..615.95 rows=3 width=128)"
"              ->  Hash Join  (cost=32.00..615.22 rows=3 width=128)"
"                    Hash Cond: ((ic.rutestudiante = e.rut) AND (ic.semestreingreso = (SubPlan 1)))"
"                    ->  Seq Scan on inscripcioncarrera ic  (cost=0.00..16.30 rows=630 width=100)"
"                    ->  Hash  (cost=18.80..18.80 rows=880 width=64)"
"                          ->  Seq Scan on estudiante e  (cost=0.00..18.80 rows=880 width=64)"
"                          SubPlan 1"
"                            ->  Aggregate  (cost=17.88..17.89 rows=1 width=4)"
"                                  ->  Seq Scan on inscripcioncarrera  (cost=0.00..17.88 rows=3 width=4)"
"                                        Filter: (rutestudiante = e.rut)"
"              ->  Index Scan using carrera_pkey on carrera c  (cost=0.15..0.24 rows=1 width=64)"
"                    Index Cond: (codigo = ic.codigocarrera)"

--Despues
"GroupAggregate  (cost=9.16..9.19 rows=1 width=104)"
"  Group Key: e.rut, c.nombre"
"  ->  Sort  (cost=9.16..9.17 rows=1 width=128)"
"        Sort Key: e.rut, c.nombre"
"        ->  Nested Loop  (cost=1.25..9.15 rows=1 width=128)"
"              ->  Hash Join  (cost=1.10..2.30 rows=1 width=128)"
"                    Hash Cond: ((ic.rutestudiante = e.rut) AND (ic.semestreingreso = (SubPlan 1)))"
"                    ->  Seq Scan on inscripcioncarrera ic  (cost=0.00..1.03 rows=3 width=100)"
"                    ->  Hash  (cost=1.04..1.04 rows=4 width=64)"
"                          ->  Seq Scan on estudiante e  (cost=0.00..1.04 rows=4 width=64)"
"                          SubPlan 1"
"                            ->  Aggregate  (cost=1.04..1.05 rows=1 width=4)"
"                                  ->  Seq Scan on inscripcioncarrera  (cost=0.00..1.04 rows=1 width=4)"
"                                        Filter: (rutestudiante = e.rut)"
"              ->  Index Scan using carrera_pkey on carrera c  (cost=0.15..6.83 rows=1 width=64)"
"                    Index Cond: (codigo = ic.codigocarrera)"
