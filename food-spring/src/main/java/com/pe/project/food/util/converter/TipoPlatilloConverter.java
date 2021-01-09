package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.model.TipoPlatilloDto;

@Component
public class TipoPlatilloConverter {

	ModelMapper modelMapper = null;

	public TipoPlatilloDto entityToDto(TipoPlatillo tipoPlatillo) {
		
		TipoPlatilloDto tipoPlatilloDto = new TipoPlatilloDto();
		
	    modelMapper = new ModelMapper();
	    
	    modelMapper.createTypeMap(TipoPlatillo.class, TipoPlatilloDto.class)
	       .addMappings(mapper -> {
	           mapper.skip(TipoPlatilloDto::setPlatillos);
	    });
	    
	    tipoPlatilloDto = modelMapper.map(tipoPlatillo, TipoPlatilloDto.class);
	    
		return tipoPlatilloDto;
		
	}
	
	public List<TipoPlatilloDto> entityToDto(List<TipoPlatillo> tiposPlatillos) {
		return tiposPlatillos.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public TipoPlatillo dtoToEntity(TipoPlatilloDto tipoPlatilloDto) {
		
		TipoPlatillo tipoPlatillo = new TipoPlatillo();
		
		modelMapper = new ModelMapper();
		
	    modelMapper.createTypeMap(TipoPlatilloDto.class, TipoPlatillo.class)
	       .addMappings(mapper -> {
	           mapper.skip(TipoPlatillo::setPlatillos);
	    });
		
	    tipoPlatillo = modelMapper.map(tipoPlatilloDto, TipoPlatillo.class);
	    
		return tipoPlatillo;
		
	}
}
