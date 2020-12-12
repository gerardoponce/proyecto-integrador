USE food;

INSERT INTO membresias(nombre, descripcion, precio) VALUES ("básico", "es básico y gratuito", 0.00);
INSERT INTO membresias(nombre, descripcion, precio) VALUES ("intermedio", "es intermedio y no gratuito", 9.90);
INSERT INTO membresias(nombre, descripcion, precio) VALUES ("premium", "es premium y no gratuito", 15.90);

INSERT INTO tipos_platillos(nombre) VALUES ("desayuno");
INSERT INTO tipos_platillos(nombre) VALUES ("almuerzo");
INSERT INTO tipos_platillos(nombre) VALUES ("postre");

INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("platillo 1", 10.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("platillo 2", 8.90, 2);
INSERT INTO platillos(nombre, precio, tipo_platillo) VALUES("platillo 3", 6.90, 3);
