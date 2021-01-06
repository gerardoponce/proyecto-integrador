package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.model.IngredienteDto;

@Component
public class IngredienteConverter {

	ModelMapper modelMapper = null;
	public IngredienteDto entityToDto(Ingrediente ingrediente) {
		
		IngredienteDto ingredienteDto = new IngredienteDto();
		
	    modelMapper = new ModelMapper();
	    
	    modelMapper.createTypeMap(Ingrediente.class, IngredienteDto.class)
	       .addMappings(mapper -> {
	           mapper.skip(IngredienteDto::setPlatillosIngredientes);
	    });
	    
	    ingredienteDto = modelMapper.map(ingrediente, IngredienteDto.class);
	    
		return ingredienteDto;
		
	}
	
	public List<IngredienteDto> entityToDto(List<Ingrediente> ingredientes) {
		return ingredientes.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public List<Ingrediente> dtoToEntity(List<IngredienteDto> ingredientes) {
		return ingredientes.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public Ingrediente dtoToEntity(IngredienteDto ingredienteDto) {
		
		Ingrediente ingrediente = new Ingrediente();
		
		modelMapper = new ModelMapper();
		
	    modelMapper.createTypeMap(IngredienteDto.class, Ingrediente.class)
	       .addMappings(mapper -> {
	           mapper.skip(Ingrediente::setPlatillosIngredientes);
	    });
		
	    ingrediente = modelMapper.map(ingredienteDto, Ingrediente.class);
	    
		return ingrediente;
		
	}
	
}
