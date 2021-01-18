package com.pe.project.food.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.repository.IngredienteRepository;
import com.pe.project.food.service.IngredienteService;

@Service
@Primary
public class IngredienteServiceJpa implements IngredienteService{

	@Autowired
	private IngredienteRepository ingredienteRepo;
	
	@Override
	public Ingrediente crearIngrediente(Ingrediente ingrediente) {
		return ingredienteRepo.save(ingrediente);
	}

	@Override
	public List<Ingrediente> buscarTodosIngredientes() {
		return ingredienteRepo.findAll();
	}

	@Override
	public Ingrediente buscarPorNombre(String nombreIngrediente) {
		return ingredienteRepo.findByNombre(nombreIngrediente);
	}

	@Override
	public Ingrediente actualizarIngrediente(Ingrediente ingrediente) {
		return ingredienteRepo.save(ingrediente);
	}

	@Override
	public void eliminarIngrediente(String nombreIngrediente) {
		Ingrediente ingrediente = buscarPorNombre(nombreIngrediente);
		ingredienteRepo.delete(ingrediente);
	}

	@Override
	public Ingrediente buscarPorId(Integer idIngrediente) {
		return ingredienteRepo.findById(idIngrediente).get();
	}

}
