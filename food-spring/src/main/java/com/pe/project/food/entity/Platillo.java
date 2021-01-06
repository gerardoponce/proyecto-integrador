package com.pe.project.food.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="platillos")
public class Platillo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true, nullable = false)
	@NotNull
	private String nombre;
	
	private String descripcion;
	
	@Column(nullable = false)
	@NotNull
	private double precio;
	
	@Column(unique=true)
	private String fotoPlatillo;
	
	@ManyToOne()
	@JoinColumn(name = "tipo_platillo")
	private TipoPlatillo tipoPlatillo;

	@ManyToMany
	@JoinTable(
			  name = "platillos_ingredientes", 
			  joinColumns = @JoinColumn(name = "platillo_id"), 
			  inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private List<Ingrediente> ingredientesPlatillos;
	
	public Platillo() {
		super();
	}
	
	public Platillo(Integer id, @NotNull String nombre, String descripcion, @NotNull double precio, String fotoPlatillo,
			TipoPlatillo tipoPlatillo, List<Ingrediente> ingredientesPlatillos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fotoPlatillo = fotoPlatillo;
		this.tipoPlatillo = tipoPlatillo;
		this.ingredientesPlatillos = ingredientesPlatillos;
	}

	public Platillo(@NotNull String nombre, String descripcion, @NotNull double precio, String fotoPlatillo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fotoPlatillo = fotoPlatillo;
	}
	
	public Platillo(@NotNull String nombre, String descripcion, @NotNull double precio, String fotoPlatillo,
			TipoPlatillo tipoPlatillo, List<Ingrediente> ingredientesPlatillos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fotoPlatillo = fotoPlatillo;
		this.tipoPlatillo = tipoPlatillo;
		this.ingredientesPlatillos = ingredientesPlatillos;
	}
	
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
	
	public String getFotoPlatillo() {
		return fotoPlatillo;
	}
	
	public void setFotoPlatillo(String fotoPlatillo) {
		this.fotoPlatillo = fotoPlatillo;
	}
	
	public TipoPlatillo getTipoPlatillo() {
		return tipoPlatillo;
	}
	
	public void setTipoPlatillo(TipoPlatillo tipoPlatillo) {
		this.tipoPlatillo = tipoPlatillo;
	}
	
	public List<Ingrediente> getIngredientesPlatillos() {
		return ingredientesPlatillos;
	}
	
	public void setIngredientesPlatillos(List<Ingrediente> ingredientesPlatillos) {
		this.ingredientesPlatillos = ingredientesPlatillos;
	}
	
}
