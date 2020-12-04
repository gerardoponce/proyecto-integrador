package com.pe.project.food.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pe.project.food.model.Membresia;

@SpringBootTest
public class MembresiaServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MembresiaServiceTest.class);
	
	@Autowired
	private MembresiaService membresiaService;

	@Test
	public void testCrear() {
		String nombre = "otro";
		String descripcion ="te ofrece beneficios semanales";
		double precio = 10.90;
		
		Membresia membresia = new Membresia(nombre, descripcion, precio);
		membresia = membresiaService.crearMembresia(membresia);
		
		logger.info("" + membresia);
		
		assertThat(membresia.getId()).isNotNull();
		assertEquals(nombre, membresia.getNombre());
		assertEquals(descripcion, membresia.getDescripcion());
		assertEquals(precio, membresia.getPrecio(), 0.1);
		
		// Eliminacion
		membresiaService.eliminarMembresia(membresia.getNombre());
	}
	
	@Test
	public void testBuscarTodas() {
        int SIZE_EXPECTED = 3;
        List<Membresia> membresias = membresiaService.buscarTodasMembresias();
        
        assertEquals(SIZE_EXPECTED, membresias.size());
	}
	
	@Test
	public void testFindByNombre() {

		String FIND_NAME = "básico";
		String NOMBRE_ESPERADO="básico";

		Membresia membresia = membresiaService.buscarPorNombre(FIND_NAME);

		assertEquals(NOMBRE_ESPERADO, membresia.getNombre());
	}
	
	@Test
	public void testActualizarMembresia() {

		String nombre = "gratuito_v2";
		String descripcion ="es gratuito";
		double precio = 0.00;

		String up_nombre = "premium_v2";
		String up_descripcion ="es gratuito por dos meses";
		double up_precio = 0.00;

		Membresia membresia = new Membresia(nombre, descripcion, precio);

		// Crear membresia
		logger.info(">" + membresia);
		Membresia readMembresia = membresiaService.crearMembresia(membresia);
		logger.info(">>" + readMembresia);

		Integer create_id = readMembresia.getId();

		// Prepar para actualizar
		readMembresia.setNombre(up_nombre);
		readMembresia.setDescripcion(up_descripcion);
		readMembresia.setPrecio(up_precio);

		// Actualizacion
		Membresia upgradePet = membresiaService.actualizarMembresia(readMembresia);
		logger.info(">>>>" + upgradePet);

		assertThat(create_id).isNotNull();
		assertEquals(create_id, upgradePet.getId());
		assertEquals(up_nombre, upgradePet.getNombre());
		assertEquals(up_descripcion, upgradePet.getDescripcion());
		assertEquals(up_precio, upgradePet.getPrecio());
		
		// Eliminacion
		membresiaService.eliminarMembresia(upgradePet.getNombre());
	}
	
	@Test
	public void testEliminarMembresia() {

		String nombre = "básico_v1";
		String descripcion ="es gratuito";
		double precio = 0.00;

		Membresia membresia = new Membresia(nombre, descripcion, precio);
		membresia = membresiaService.crearMembresia(membresia);
		logger.info("" + membresia);

		membresiaService.eliminarMembresia(membresia.getNombre());
		
		Membresia readMembresia = membresiaService.buscarPorNombre(membresia.getNombre());
		Assertions.assertThrows(NullPointerException.class, () -> {
		    readMembresia.getId();
		  });

	}
}
