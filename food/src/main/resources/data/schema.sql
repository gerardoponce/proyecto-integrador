CREATE DATABASE food /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE USER IF NOT EXISTS 'dev'@'localhost' IDENTIFIED BY '#123Dev456#';

GRANT ALL PRIVILEGES ON food.* TO 'dev'@'localhost';

USE food;

-- food.usuarios definition
CREATE TABLE usuarios (
	id int NOT NULL AUTO_INCREMENT,
	apellido varchar(255) DEFAULT NULL,
	clave varchar(255) DEFAULT NULL,
	correo varchar(255) DEFAULT NULL,
	direccion varchar(255) DEFAULT NULL,
	foto_perfil varchar(255) DEFAULT NULL,
	nombre varchar(255) DEFAULT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.membresias definition
CREATE TABLE membresias (
	id int NOT NULL AUTO_INCREMENT,
	descripcion varchar(255) NOT NULL,
	nombre varchar(255) NOT NULL,
	precio double NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.ingredientes definition
CREATE TABLE ingredientes (
	id int NOT NULL AUTO_INCREMENT,
	nombre varchar(255) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.tipos_platillos definition
CREATE TABLE tipos_platillos (
	id int NOT NULL AUTO_INCREMENT,
	nombre varchar(255) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.platillos definition
CREATE TABLE platillos (
	id int NOT NULL AUTO_INCREMENT,
	descripcion varchar(255) DEFAULT NULL,
	foto_platillo varchar(255) DEFAULT NULL,
	nombre varchar(255) NOT NULL,
	precio double NOT NULL,
	tipo_platillo int DEFAULT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (nombre),
	UNIQUE KEY (foto_platillo),
	FOREIGN KEY (tipo_platillo) REFERENCES tipos_platillos (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.platillos_ingredientes definition
CREATE TABLE platillos_ingredientes (
	platillo_id int NOT NULL,
	ingrediente_id int NOT NULL,
	KEY (ingrediente_id),
	KEY (platillo_id),
	FOREIGN KEY (ingrediente_id) REFERENCES ingredientes (id),
	FOREIGN KEY (platillo_id) REFERENCES platillos (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
