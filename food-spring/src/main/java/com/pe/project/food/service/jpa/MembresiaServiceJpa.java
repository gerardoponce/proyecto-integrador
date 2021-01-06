package com.pe.project.food.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.project.food.entity.Membresia;
import com.pe.project.food.repository.MembresiaRepository;
import com.pe.project.food.service.MembresiaService;

@Service
public class MembresiaServiceJpa implements MembresiaService {

	@Autowired
	private MembresiaRepository membresiaRepo;
	
	@Override
	public Membresia crearMembresia(Membresia membresia) {
		return membresiaRepo.save(membresia);
	}

	@Override
	public List<Membresia> buscarTodasMembresias() {
		return membresiaRepo.findAll();
	}

	@Override 
	public Membresia buscarPorNombre(String nombreMembresia) { 
		return membresiaRepo.findByNombre(nombreMembresia);
	}

	@Override
	public Membresia actualizarMembresia(Membresia membresia) {
		return membresiaRepo.save(membresia);
	}

	@Override
	public void eliminarMembresia(String nombreMembresia) {
		Membresia membresia = buscarPorNombre(nombreMembresia);
		membresiaRepo.delete(membresia);
	}
	
}
