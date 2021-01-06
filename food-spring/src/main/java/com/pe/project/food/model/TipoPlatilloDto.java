package com.pe.project.food.model;

import java.util.Set;

import com.pe.project.food.entity.Platillo;

public class TipoPlatilloDto {

	private Integer id;
	
	private String nombre;
	
	private Set<Platillo> platillos;

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

	public Set<Platillo> getPlatillos() {
		return platillos;
	}

	public void setPlatillos(Set<Platillo> platillos) {
		this.platillos = platillos;
	}
	
}
