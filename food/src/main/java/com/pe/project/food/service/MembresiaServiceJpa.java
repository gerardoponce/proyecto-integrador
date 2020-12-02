package com.pe.project.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pe.project.food.model.Membresia;
import com.pe.project.food.repository.MembresiaRepository;

@Service
@Primary
public class MembresiaServiceJpa implements MembresiaService {

	@Autowired
	private MembresiaRepository membresiaRepo;
	
	@Override
	public Membresia crear(Membresia membresia) {
		return membresiaRepo.save(membresia);

	}

	@Override
	public List<Membresia> buscarTodas() {
		return membresiaRepo.findAll();
	}

	@Override 
	public List<Membresia> findByNombre(String nombreMembresia) { 
		return membresiaRepo.findByNombre(nombreMembresia);
	}

	@Override
	public Membresia actualizar(Membresia membresia) {
		return membresiaRepo.save(membresia);
	}

	@Override
	public void eliminar(String nombreMembresia) {
		Membresia membresia= findByNombre(nombreMembresia).get(0);
		membresiaRepo.delete(membresia);
		
	}
	 

}
