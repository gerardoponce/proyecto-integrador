package com.pe.project.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.project.food.model.Membresia;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
	
	List<Membresia> findByNombre(String nombreMembresia);
	
}
