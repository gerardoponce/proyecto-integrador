package com.pe.project.food.service;

import java.util.List;

import com.pe.project.food.model.Membresia;

public interface MembresiaService {

	Membresia crear(Membresia membresia);
	List<Membresia> buscarTodas();
	List<Membresia> findByNombre(String nombreMembresia);
	Membresia actualizar(Membresia membresia);
	void eliminar(String nombreMembresia);
}
