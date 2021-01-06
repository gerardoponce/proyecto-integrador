package com.pe.project.food.service;

import java.util.List;

import com.pe.project.food.entity.Ingrediente;

public interface IngredienteService {

	Ingrediente crearIngrediente(Ingrediente ingrediente);

	List<Ingrediente> buscarTodosIngredientes();

	/**
	 * 
	 * @param String
	 * @return unique ingrediente
	 */
	Ingrediente buscarPorNombre(String nombreIngrediente);

	Ingrediente actualizarIngrediente(Ingrediente ingrediente);

	void eliminarIngrediente (String nombreIngrediente);
	
}
