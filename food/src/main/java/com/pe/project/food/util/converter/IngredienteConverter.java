package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.model.IngredienteDto;

public class IngredienteConverter {

	public IngredienteDto entityToDto(Ingrediente ingrediente) {
		IngredienteDto ingredienteDto = new IngredienteDto();
		
		ingredienteDto.setId(ingrediente.getId());
		ingredienteDto.setNombre(ingrediente.getNombre());
		
		return ingredienteDto;
		
	}
	
	public List<IngredienteDto> entityToDto(List<Ingrediente> ingredientes) {
		return ingredientes.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public List<Ingrediente> dtoToEntity(List<IngredienteDto> ingredientes) {
		return ingredientes.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public Ingrediente dtoToEntity(IngredienteDto ingredienteDto) {
		
		Ingrediente ingrediente = new Ingrediente(ingredienteDto.getId(), ingredienteDto.getNombre());
		
		return ingrediente;
		
	}
	
}
