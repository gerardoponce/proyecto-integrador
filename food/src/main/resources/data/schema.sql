CREATE DATABASE `food` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE food;

CREATE USER IF NOT EXISTS 'dev'@'localhost' IDENTIFIED BY '#123456#';

GRANT ALL PRIVILEGES ON food.* TO 'dev'@'localhost';

FLUSH PRIVILEGES;

-- food.membresias definition
CREATE TABLE `membresias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f2i1wkxqgfdbisdvpxpurjenk` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.tipos_platillos definition
CREATE TABLE `tipos_platillos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_v128j4setxgobsni2gybelel` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.platillos definition
CREATE TABLE `platillos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `foto_platillo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `tipo_platillo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_obc6r6wfcbsbdfag1vu6tmtt5` (`nombre`),
  UNIQUE KEY `UK_r68ivrsu3lvs6v1asx3eas2cy` (`foto_platillo`),
  KEY `FK3jeppy3d7ci1nl32i4xhpjk11` (`tipo_platillo`),
  CONSTRAINT `FK3jeppy3d7ci1nl32i4xhpjk11` FOREIGN KEY (`tipo_platillo`) REFERENCES `tipos_platillos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- food.usuarios definition
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
