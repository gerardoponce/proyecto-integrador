package com.pe.project.food.service;

import java.util.List;

import com.pe.project.food.entity.Membresia;

public interface MembresiaService {

	Membresia crearMembresia(Membresia membresia);

	List<Membresia> buscarTodasMembresias();

	/**
	 * 
	 * @param String
	 * @return unique pet
	 */
	Membresia buscarPorNombre(String nombreMembresia);

	Membresia actualizarMembresia(Membresia membresia);

	void eliminarMembresia(String nombreMembresia);
}
