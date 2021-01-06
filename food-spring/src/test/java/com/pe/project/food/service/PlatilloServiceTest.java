package com.pe.project.food.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.entity.Platillo;
import com.pe.project.food.entity.TipoPlatillo;

@SpringBootTest
public class PlatilloServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PlatilloServiceTest.class);
	
	@Autowired
	private PlatilloService platilloService;

	@Test
	public void testCrear() {
		String nombre = "otro";
		String descripcion = "una descripción breve";
		double precio = 10.90;
		String fotoPlatillo = "desconocido.jpg";
		
		TipoPlatillo tipos_platillos_id = new TipoPlatillo(1, "desayuno");
		
		List<Ingrediente> ingredientesPlatillos = new ArrayList<Ingrediente>();
		
		Ingrediente ingrediente1 = new Ingrediente(1, "ingrediente 1");
		Ingrediente ingrediente2 = new Ingrediente(2, "ingrediente 2");
		
		ingredientesPlatillos.add(ingrediente1);
		ingredientesPlatillos.add(ingrediente2);
		
		Platillo platillo = new Platillo(nombre, descripcion, precio, fotoPlatillo, tipos_platillos_id, ingredientesPlatillos);
		platillo = platilloService.crearPlatillo(platillo);
		
		logger.info("" + platillo);
		
		assertThat(platillo.getId()).isNotNull();
		assertEquals(nombre, platillo.getNombre());
		assertEquals(precio, platillo.getPrecio(), 0.1);
		assertEquals(tipos_platillos_id.getNombre(), platillo.getTipoPlatillo().getNombre());
		
		// Eliminacion
		platilloService.eliminarPlatillo(platillo.getNombre());
	}
	
	@Test
	public void testBuscarTodos() {
        int SIZE_EXPECTED = 3;
        List<Platillo> platillos = platilloService.buscarTodosPlatillos();
        assertEquals(SIZE_EXPECTED, platillos.size());
	}
	
	@Test
	public void testFindByNombre() {

		String FIND_NAME = "platillo 1";
		String NOMBRE_ESPERADO="platillo 1";

		Platillo platillo = platilloService.buscarPorNombre(FIND_NAME);
		assertEquals(NOMBRE_ESPERADO, platillo.getNombre());
	}
	
	@Test
	public void testActualizarPlatillo() {

		String nombre = "otro_v2";
		String descripcion = "una descripción breve";
		double precio = 10.90;
		String fotoPlatillo = "desconocido.jpg";

		TipoPlatillo tipos_platillos_id = new TipoPlatillo(3, "postre");
		List<Ingrediente> ingredientesPlatillos = new ArrayList<Ingrediente>();
		Ingrediente ingrediente1 = new Ingrediente(1, "ingrediente 1");
		Ingrediente ingrediente2 = new Ingrediente(2, "ingrediente 2");
		
		ingredientesPlatillos.add(ingrediente1);
		ingredientesPlatillos.add(ingrediente2);
		
		String up_nombre = "otor_v2.1";
		String up_descripcion ="platillo de prueba";
		double up_precio = 0.00;

		Platillo platillo = new Platillo(nombre, descripcion, precio, fotoPlatillo, tipos_platillos_id, ingredientesPlatillos);

		// Crear platillo
		logger.info(">" + platillo);
		Platillo readPlatillo = platilloService.crearPlatillo(platillo);
		logger.info(">>" + readPlatillo);

		Integer create_id = readPlatillo.getId();

		// Preparar para actualizar
		readPlatillo.setNombre(up_nombre);
		readPlatillo.setDescripcion(up_descripcion);
		readPlatillo.setPrecio(up_precio);

		// Actualizacion
		Platillo upgradePlatillo = platilloService.actualizarPlatillo(readPlatillo);
		logger.info(">>>>" + upgradePlatillo );

		assertThat(create_id).isNotNull();
		assertEquals(create_id, upgradePlatillo.getId());
		assertEquals(up_nombre, upgradePlatillo.getNombre());
		assertEquals(up_descripcion, upgradePlatillo.getDescripcion());
		assertEquals(up_precio, upgradePlatillo.getPrecio());
		
		// Eliminacion
		platilloService.eliminarPlatillo(upgradePlatillo.getNombre());
	}
	
	@Test
	public void testEliminarPlatillo() {

		String nombre = "otro_v1";
		String descripcion = "una descripción breve";
		double precio = 10.90;
		String fotoPlatillo = "desconocido.jpg";
		
		TipoPlatillo tipos_platillos_id = new TipoPlatillo(2, "almuerzo");

		
		List<Ingrediente> ingredientesPlatillos = new ArrayList<Ingrediente>();
		Ingrediente ingrediente1 = new Ingrediente(1, "ingrediente 1");
		Ingrediente ingrediente2 = new Ingrediente(2, "ingrediente 2");
		
		ingredientesPlatillos.add(ingrediente1);
		ingredientesPlatillos.add(ingrediente2);
		
		Platillo platillo = new Platillo(nombre, descripcion, precio, fotoPlatillo, tipos_platillos_id, ingredientesPlatillos);
		
		platillo = platilloService.crearPlatillo(platillo);
		logger.info("" + platillo);

		platilloService.eliminarPlatillo(platillo.getNombre());
		
		Platillo readPlatillo = platilloService.buscarPorNombre(platillo.getNombre());
		Assertions.assertThrows(NullPointerException.class, () -> {
		    readPlatillo.getId();
		  });

	}
}
