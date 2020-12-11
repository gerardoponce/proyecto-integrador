package com.pe.project.food.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pe.project.food.entity.Platillo;
import com.pe.project.food.repository.PlatilloRepository;
import com.pe.project.food.service.PlatilloService;

@Service
@Primary
public class PlatilloServiceJpa implements PlatilloService {

	@Autowired
	private PlatilloRepository platilloRepo;
	
	@Override
	public Platillo crearPlatillo(Platillo platillo) {
		return platilloRepo.save(platillo);
	}

	@Override
	public List<Platillo> buscarTodosPlatillos() {
		return platilloRepo.findAll();
	}

	@Override
	public Platillo buscarPorNombre(String nombrePlatillo) {
		return platilloRepo.findByNombre(nombrePlatillo);
	}

	@Override
	public Platillo actualizarPlatillo(Platillo platillo) {
		return platilloRepo.save(platillo);
	}

	@Override
	public void eliminarPlatillo(String nombrePlatillo) {
		Platillo platillo = buscarPorNombre(nombrePlatillo);
		platilloRepo.delete(platillo);
	}

}
