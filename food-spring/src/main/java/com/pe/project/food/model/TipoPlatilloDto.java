package com.pe.project.food.model;

import java.util.List;

public class TipoPlatilloDto {

	private Integer id;
	
	private String nombre;
	
	private List<PlatilloDto> platillos;
	
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

	public List<PlatilloDto> getPlatillos() {
		return platillos;
	}

	public void setPlatillos(List<PlatilloDto> platillos) {
		this.platillos = platillos;
	}
	
}
