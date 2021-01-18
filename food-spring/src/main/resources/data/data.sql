USE food;

/* INSERT INTO membresias(nombre, descripcion, precio) VALUES ("Básico", "es básico y gratuito", 0.00);
INSERT INTO membresias(nombre, descripcion, precio) VALUES ("Intermedio", "es intermedio y no gratuito", 9.90);
INSERT INTO membresias(nombre, descripcion, precio) VALUES ("Premium", "es premium y no gratuito", 15.90); */

INSERT INTO tipos_platillos(nombre) VALUES ("Desayuno");
INSERT INTO tipos_platillos(nombre) VALUES ("Almuerzo");
INSERT INTO tipos_platillos(nombre) VALUES ("Postre");

INSERT INTO ingredientes(nombre) VALUES ("ingrediente 1");
INSERT INTO ingredientes(nombre) VALUES ("ingrediente 2");
INSERT INTO ingredientes(nombre) VALUES ("ingrediente 3");
INSERT INTO ingredientes(nombre) VALUES ("ingrediente 4");

INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 1", 10.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 2", 8.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 3", 6.90, 3);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 4", 10.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 5", 8.90, 1);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 6", 6.90, 1);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 7", 10.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 8", 8.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 9", 6.90, 3);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 10", 10.90, 1);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 11", 8.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("Platillo 13", 6.90, 3);

INSERT INTO platillos_ingredientes VALUES (1, 1);
INSERT INTO platillos_ingredientes VALUES (1, 2);
INSERT INTO platillos_ingredientes VALUES (2, 3);
INSERT INTO platillos_ingredientes VALUES (2, 4);
