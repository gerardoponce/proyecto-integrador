package com.pe.project.food.model;

import java.util.List;

import com.pe.project.food.entity.Platillo;

public class IngredienteDto {

	private Integer id;
	
	private String nombre;
	
	private List<Platillo> platillosIngredientes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Platillo> getPlatillosIngredientes() {
		return platillosIngredientes;
	}

	public void setPlatillosIngredientes(List<Platillo> platillosIngredientes) {
		this.platillosIngredientes = platillosIngredientes;
	}
	
}
