package com.pe.project.food.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tipos_platillos")
public class TipoPlatillo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true, nullable = false)
	@NotNull
	private String nombre;
	
	@OneToMany(mappedBy="tipoPlatillo")
	private List<Platillo> platillos;

	public TipoPlatillo() {
		super();
	}

	public TipoPlatillo(Integer id, @NotNull String nombre, List<Platillo> platillos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.platillos = platillos;
	}

	public TipoPlatillo(Integer id, @NotNull String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public TipoPlatillo(@NotNull String nombre, List<Platillo> platillos) {
		super();
		this.nombre = nombre;
		this.platillos = platillos;
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

	public List<Platillo> getPlatillos() {
		return platillos;
	}

	public void setPlatillos(List<Platillo> platillos) {
		this.platillos = platillos;
	}
	
}
