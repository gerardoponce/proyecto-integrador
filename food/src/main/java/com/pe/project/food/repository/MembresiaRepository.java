package com.pe.project.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.project.food.model.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
	
	Membresia findByNombre(String nombreMembresia);
	
}
