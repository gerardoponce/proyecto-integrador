package com.pe.project.food.model;

import com.pe.project.food.entity.TipoPlatillo;

public class PlatilloDto {

	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;

	private TipoPlatillo tipoPlatillo;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoPlatillo getTipoPlatillo() {
		return tipoPlatillo;
	}

	public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {
		this.tipoPlatillo = tipoPlatillo;
	}
	
}
