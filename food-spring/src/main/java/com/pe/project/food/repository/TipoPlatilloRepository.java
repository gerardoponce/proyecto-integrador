package com.pe.project.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.project.food.entity.TipoPlatillo;

public interface TipoPlatilloRepository extends JpaRepository<TipoPlatillo, Integer> {

	public TipoPlatillo findByNombre(String nombrePlatillo);
}
