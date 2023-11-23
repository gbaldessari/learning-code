drop table if exists Asignatura cascade;
drop table if exists Profesor cascade;
drop table if exists Clase cascade;
drop table if exists ProfesorClase cascade;

create table Asignatura(
    cod_asignatura text primary key,
    nombre_asignatura text not null
);

create table Profesor(
    rut_profesor text primary key,
    nombre_profesor text not null
);

create table Clase (
    cod_asignatura text references Asignatura(cod_asignatura),
    paralelo text not null,
    primary key (cod_asignatura, paralelo),
    dia text not null,
    bloque text not null,
    sala text not null
);

create table ProfesorClase(
    rut_profesor text references Profesor(rut_profesor),
    cod_asignatura text,
    paralelo text,
    primary key (rut_profesor, cod_asignatura, paralelo),
    foreign key (cod_asignatura, paralelo) references Clase(cod_asignatura, paralelo)
);