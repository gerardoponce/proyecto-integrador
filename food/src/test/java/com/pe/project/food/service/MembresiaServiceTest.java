package com.pe.project.food.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
		String nombre = "básico";
		String descripcion ="es gratuito";
		double precio = 0.00;
		
		Membresia membresia = new Membresia(nombre, descripcion, precio);
		membresia = membresiaService.crear(membresia);
		
		logger.info("" + membresia);
		
		assertThat(membresia.getId()).isNotNull();
		assertEquals(nombre, membresia.getNombre());
		assertEquals(descripcion, membresia.getDescripcion());
		assertEquals(precio, membresia.getPrecio(), 0.1);
	}
	
	@Test
	public void testBuscarTodas() {
        int SIZE_EXPECTED = 3;
        List<Membresia> membresias = membresiaService.buscarTodas();
        
        assertEquals(SIZE_EXPECTED, membresias.size());
	}
	
	@Test
	public void testFindByNombre() {

		String FIND_NAME = "intermedio";
		int SIZE_EXPECTED = 1;

		List<Membresia> membresia = membresiaService.findByNombre(FIND_NAME);

		assertEquals(SIZE_EXPECTED, membresia.size());
	}
	
	@Test
	public void testActualizarMembresia() {

		String nombre = "gratuito";
		String descripcion ="es gratuito";
		double precio = 0.00;

		String up_nombre = "premium";
		String up_descripcion ="es gratuito por dos meses";
		double up_precio = 0.00;

		Membresia membresia = new Membresia(nombre, descripcion, precio);

		// Crear membresia
		logger.info(">" + membresia);
		Membresia readMembresia = membresiaService.crear(membresia);
		logger.info(">>" + readMembresia);

		Integer create_id = readMembresia.getId();

		// Prepar para actualizar
		readMembresia.setNombre(up_nombre);
		readMembresia.setDescripcion(up_descripcion);
		readMembresia.setPrecio(up_precio);

		// Actualizacion
		Membresia upgradePet = membresiaService.actualizar(readMembresia);
		logger.info(">>>>" + upgradePet);

		assertThat(create_id).isNotNull();
		assertEquals(create_id, upgradePet.getId());
		assertEquals(up_nombre, upgradePet.getNombre());
		assertEquals(up_descripcion, upgradePet.getDescripcion());
		assertEquals(up_precio, upgradePet.getPrecio());
	}
	
	@Test
	public void testEliminarMembresia() {

		String nombre = "gratuito_1";
		String descripcion ="es gratuito";
		double precio = 0.00;

		Membresia membresia = new Membresia(nombre, descripcion, precio);
		membresia = membresiaService.crear(membresia);
		logger.info("" + membresia);

		try {
			membresiaService.eliminar(membresia.getNombre());
		} catch (Exception e) {
			
		}
			
		try {
			membresiaService.findByNombre(membresia.getNombre()).get(0);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		} 				

	}
}
