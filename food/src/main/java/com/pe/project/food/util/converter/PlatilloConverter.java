package com.pe.project.food.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pe.project.food.entity.Platillo;
import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.model.PlatilloDto;

@Component
public class PlatilloConverter {

	public PlatilloDto entityToDto(Platillo platillo) {
		PlatilloDto dto = new PlatilloDto();
		
		TipoPlatillo tipoPlatillo = new TipoPlatillo(platillo.getTipoPlatillo().getId(), platillo.getTipoPlatillo().getNombre());
		
		dto.setId(platillo.getId());
		dto.setNombre(platillo.getNombre());
		dto.setDescripcion(platillo.getDescripcion());
		dto.setPrecio(platillo.getPrecio());
		dto.setTipoPlatillo(tipoPlatillo);
		
		return dto;
	}
	
	public List<PlatilloDto> entityToDto(List<Platillo> platillos) {
		return platillos.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
}
