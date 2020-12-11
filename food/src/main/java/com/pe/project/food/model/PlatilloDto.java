package com.pe.project.food.model;

public class PlatilloDto {

	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;

	private TipoPlatilloDto tipoPlatillo;

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

	public TipoPlatilloDto getTipoPlatillo() {
		return tipoPlatillo;
	}

	public void setTipoPlatillo(TipoPlatilloDto tipoPlatillo) {
		this.tipoPlatillo = tipoPlatillo;
	}
	
}
