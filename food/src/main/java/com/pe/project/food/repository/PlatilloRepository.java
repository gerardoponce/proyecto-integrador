package com.pe.project.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.project.food.entity.Platillo;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo, Integer> {

	public Platillo findByNombre(String nombrePlatillo);
	
}
