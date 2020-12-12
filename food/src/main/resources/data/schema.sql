CREATE DATABASE food;

use food;

CREATE TABLE membresias (
  id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descripcion varchar(250) NOT NULL,
  nombre varchar(250) NOT NULL,
  precio double(6,2) NOT NULL,
  UNIQUE KEY (nombre)
);
CREATE TABLE tipos_platillos (
  id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(250) NOT NULL,
  UNIQUE KEY (nombre)
);
CREATE TABLE platillos (
  id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descripcion varchar(250) DEFAULT NULL,
  foto_platillo varchar(250) DEFAULT NULL,
  nombre varchar(250) NOT NULL,
  precio double(6,2) NOT NULL,
  tipo_platillo int DEFAULT NULL,
  UNIQUE KEY (nombre),
  UNIQUE KEY (foto_platillo),
  FOREIGN KEY (tipo_platillo) REFERENCES tipos_platillos (id)
);
CREATE TABLE usuarios (
  id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  apellido varchar(250) NOT NULL,
  clave varchar(250) NOT NULL,
  correo varchar(250) NOT NULL,
  direccion varchar(250) not NULL,
  foto_perfil varchar(250) DEFAULT NULL,
  nombre varchar(250) NOT NULL
);
