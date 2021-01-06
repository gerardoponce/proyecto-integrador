package com.pe.project.food.service;

import java.util.List;

import com.pe.project.food.entity.Platillo;

public interface PlatilloService {

	Platillo crearPlatillo(Platillo platillo);

	List<Platillo> buscarTodosPlatillos();

	/**
	 * 
	 * @param String
	 * @return unique platillo
	 */
	Platillo buscarPorNombre(String nombrePlatillo);

	Platillo actualizarPlatillo(Platillo platillo);

	void eliminarPlatillo(String nombrePlatillo);
	
}
