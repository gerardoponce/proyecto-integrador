package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.entity.Platillo;
import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.model.IngredienteDto;
import com.pe.project.food.model.PlatilloDto;
import com.pe.project.food.model.TipoPlatilloDto;

@Component
public class PlatilloConverter {

	public PlatilloDto entityToDto(Platillo platillo) {
		PlatilloDto platilloDto = new PlatilloDto();
		
		TipoPlatilloDto tipoPlatilloDto = new TipoPlatilloDto();
		
		tipoPlatilloDto.setId(platillo.getTipoPlatillo().getId());
		tipoPlatilloDto.setNombre(platillo.getTipoPlatillo().getNombre()); 
		
		platilloDto.setId(platillo.getId());
		platilloDto.setNombre(platillo.getNombre());
		platilloDto.setDescripcion(platillo.getDescripcion());
		platilloDto.setPrecio(platillo.getPrecio());
		platilloDto.setTipoPlatillo(tipoPlatilloDto);
		
		IngredienteConverter ingredienteConverter = new IngredienteConverter();
		
		List<IngredienteDto> ingredientesDto = ingredienteConverter.entityToDto(platillo.getIngredientesPlatillos());
		
		platilloDto.setIngredientes(ingredientesDto);
		
		return platilloDto;
	}
	
	public List<PlatilloDto> entityToDto(List<Platillo> platillos) {
		return platillos.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Platillo dtoToEntity(PlatilloDto platilloDto) {
		
		Platillo platillo = new Platillo();
		
		TipoPlatillo tipoPlatillo = new TipoPlatillo();
		
		tipoPlatillo.setId(platilloDto.getTipoPlatillo().getId());
		tipoPlatillo.setNombre(platilloDto.getTipoPlatillo().getNombre());
		
		platillo.setId(platilloDto.getId());
		platillo.setNombre(platilloDto.getNombre());
		platillo.setDescripcion(platilloDto.getDescripcion());
		platillo.setPrecio(platilloDto.getPrecio());
		platillo.setTipoPlatillo(tipoPlatillo);
		
		IngredienteConverter ingredienteConverter = new IngredienteConverter();
		
		List<Ingrediente> ingredientes = ingredienteConverter.dtoToEntity(platilloDto.getIngredientes());
		
		platillo.setIngredientesPlatillos(ingredientes);
		
		return platillo;
		
	}
}
