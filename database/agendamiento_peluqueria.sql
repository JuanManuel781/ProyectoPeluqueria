/* CREACIÓN DE LA BASE DE DATOS */
CREATE DATABASE administrador_Peluquerias;
USE administrador_Peluquerias;

CREATE TABLE roles(
	id int primary key auto_increment,
    descripcion varchar(100) not null
);

CREATE TABLE tipos_pagos(
	id int primary key auto_increment,
    descripcion varchar(100) not null
);

CREATE TABLE servicios(
	id int primary key auto_increment,
    descripcion varchar(100) not null
);

CREATE TABLE usuarios(
	id int primary key auto_increment,
    tipo_documento enum('ninguno','Tarjeta Identidad','Cedula') not null,
    numero_documento int not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(50) not null,
    celular int not null,
    usuario varchar(50) not null,
    contraseña varchar(50)not null,
    id_rol_usuario int,
    constraint fk_roles_usuarios_id_rol_usuario  FOREIGN KEY (id_rol_usuario ) REFERENCES roles(id)
);

CREATE TABLE agendamientos(
	id int primary key auto_increment,
    fecha date,
    hora  time,
    usuario_id int,
    constraint fk_usuarios_agendamientos_usuario_id foreign key(usuario_id) references usuarios(id),
    tipo_pago_id int,
    constraint fk_tipos_pagos_agendamientos_tipo_pago_id foreign key(tipo_pago_id) references tipos_pagos(id),
    servicios_id int,
    constraint fk_servicios_agendamientos_servicios_id foreign key(servicios_id) references servicios(id)
);
