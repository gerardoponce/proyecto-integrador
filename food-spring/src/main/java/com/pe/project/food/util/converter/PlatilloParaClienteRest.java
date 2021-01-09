package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pe.project.food.entity.Platillo;
import com.pe.project.food.model.PlatilloDto;

@Component
public class PlatilloParaClienteRest {

	ModelMapper modelMapper = null;
	
	public PlatilloDto entityToDto(Platillo platillo) {
		
		PlatilloDto platilloDto = new PlatilloDto();
		
		modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(Platillo.class, PlatilloDto.class)
	    	.addMappings(mapper -> {
	    		mapper.skip(PlatilloDto::setTipoPlatillo);
	    		mapper.skip(PlatilloDto ::setIngredientes);
	    	});
		
		platilloDto = modelMapper.map(platillo, PlatilloDto.class);
		
		platilloDto.setTipoPlatillo(null);
	    platilloDto.setIngredientes(null);
		
		return platilloDto;
	}
	
	public List<PlatilloDto> entityToDto(List<Platillo> platillos) {
		return platillos.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
}
