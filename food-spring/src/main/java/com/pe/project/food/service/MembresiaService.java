package com.pe.project.food.service;

import java.util.List;

import com.pe.project.food.entity.Membresia;

public interface MembresiaService {

	Membresia crearMembresia(Membresia membresia);

	List<Membresia> buscarTodasMembresias();

	/**
	 * 
	 * @param String
	 * @return membresia
	 */
	Membresia buscarPorNombre(String nombreMembresia);

	Membresia buscarPorId(Integer idMembresia);
	
	Membresia actualizarMembresia(Membresia membresia);

	Void eliminarMembresia(String nombreMembresia);
}
