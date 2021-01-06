package com.pe.project.food.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true, nullable = false)
	@NotNull
	private String nombre;

	@ManyToMany(mappedBy = "ingredientesPlatillos")
	private List<Platillo> platillosIngredientes;

	public Ingrediente() {
		super();
	}

	public Ingrediente(Integer id, @NotNull String nombre, List<Platillo> platillosIngredientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.platillosIngredientes = platillosIngredientes;
	}

	public Ingrediente(@NotNull String nombre) {
		super();
		this.nombre = nombre;
	}

	public Ingrediente(Integer id, @NotNull String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public List<Platillo> getPlatillosIngredientes() {
		return platillosIngredientes;
	}

	public void setPlatillosIngredientes(List<Platillo> platillosIngredientes) {
		this.platillosIngredientes = platillosIngredientes;
	}
	
}
