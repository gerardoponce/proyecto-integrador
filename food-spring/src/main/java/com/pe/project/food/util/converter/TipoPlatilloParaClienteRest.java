package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.model.TipoPlatilloDto;

@Component
public class TipoPlatilloParaClienteRest {

	private ModelMapper modelMapper = null;
	PlatilloParaClienteRest platilloConverter;
	
	public TipoPlatilloDto entityToDto(TipoPlatillo tipoPlatillo) {
		
		TipoPlatilloDto tipoPlatilloDto = new TipoPlatilloDto();
		
		modelMapper = new ModelMapper();
		platilloConverter = new PlatilloParaClienteRest();
		
		modelMapper.createTypeMap(TipoPlatillo.class, TipoPlatilloDto.class)
	       .addMappings(mapper -> {
	           mapper.skip(TipoPlatilloDto::setPlatillos);
	    });
		
		tipoPlatilloDto = modelMapper.map(tipoPlatillo, TipoPlatilloDto.class);
		
		tipoPlatilloDto.setPlatillos(platilloConverter.entityToDto(tipoPlatillo.getPlatillos()));
		
		return tipoPlatilloDto;
		
	}
	
	public List<TipoPlatilloDto> entityToDto(List<TipoPlatillo> tipoPlatillo) {
		return tipoPlatillo.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
}
