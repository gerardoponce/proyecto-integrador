package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pe.project.food.entity.Platillo;
import com.pe.project.food.model.PlatilloDto;

@Component
public class PlatilloConverter {

	ModelMapper modelMapper = null;
	TipoPlatilloConverter tipoPlatilloConverter;
	IngredienteConverter ingredienteConverter;

	public PlatilloDto entityToDto(Platillo platillo) {
		
		PlatilloDto platilloDto = new PlatilloDto();
		
		tipoPlatilloConverter = new TipoPlatilloConverter();
		ingredienteConverter = new IngredienteConverter();
		
		modelMapper = new ModelMapper();
		
	    modelMapper.createTypeMap(Platillo.class, PlatilloDto.class)
	    	.addMappings(mapper -> {
	    		mapper.skip(PlatilloDto::setTipoPlatillo);
	    		mapper.skip(PlatilloDto::setIngredientes);
	    	});
	    
	    platilloDto = modelMapper.map(platillo, PlatilloDto.class);
	    
	    platilloDto.setTipoPlatillo(tipoPlatilloConverter.entityToDto(platillo.getTipoPlatillo()));
	    platilloDto.setIngredientes(ingredienteConverter.entityToDto(platillo.getIngredientesPlatillos()));
		
		return platilloDto;
	}
	
	public List<PlatilloDto> entityToDto(List<Platillo> platillos) {
		return platillos.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Platillo dtoToEntity(PlatilloDto platilloDto) {
		
		Platillo platillo = new Platillo();
		
		tipoPlatilloConverter = new TipoPlatilloConverter();
		ingredienteConverter = new IngredienteConverter();
		
		modelMapper = new ModelMapper();

		modelMapper.createTypeMap(PlatilloDto.class, Platillo.class)
    	.addMappings(mapper -> {
    		mapper.skip(Platillo::setTipoPlatillo);
    		mapper.skip(Platillo::setIngredientesPlatillos);
    	});
		
		platillo = modelMapper.map(platilloDto, Platillo.class);
		
		platillo.setTipoPlatillo(tipoPlatilloConverter.dtoToEntity(platilloDto.getTipoPlatillo()));
		platillo.setIngredientesPlatillos(ingredienteConverter.dtoToEntity(platilloDto.getIngredientes()));
		
		return platillo;
		
	}
}
