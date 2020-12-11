package com.pe.project.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.project.food.entity.Platillo;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo, Integer> {

	public Platillo findByNombre(String nombrePlatillo);
	
	//@Query(value="SELECT NEW com.pe.project.food.entity.PlatilloTipoPlatilloDto(p.id, p.nombre, p.descripcion, p.precio, tp.id as tpId, tp.nombre as tpNombre) FROM Platillo p, TipoPlatillo tp WHERE p.tipoPlatillo.id = tp.id ")
	//@Query(value="SELECT p.id, p.nombre, p.descripcion, p.precio, tp.id as tpId, tp.nombre as tpNombre FROM Platillo p, TipoPlatillo tp WHERE p.tipoPlatillo.id = tp.id")
	//public List<Object[]> findAllPlatillos();
	
	//@Query(value = "SELECT NEW com.pe.project.food.entity.PlatilloTipoPlatilloDto(p.id, p.nombre, p.descripcion, p.precio, tp.id as tpId, tp.nombre as tpNombre) FROM Platillo p, TipoPlatillo tp "
	//		+ "WHERE p.tipoPlatillo.id = tp.id AND p.nombre = :nombrePlatillo")
	//public Platillo findByNombre(@Param("nombrePlatillo") String nombrePlatillo);
}
