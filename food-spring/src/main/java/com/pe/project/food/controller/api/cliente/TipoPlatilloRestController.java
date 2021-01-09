package com.pe.project.food.controller.api.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.model.TipoPlatilloDto;
import com.pe.project.food.service.TipoPlatilloService;
import com.pe.project.food.util.converter.TipoPlatilloParaClienteRest;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class TipoPlatilloRestController {

	@Autowired
	private TipoPlatilloService tipoPlatilloService;
	
	@Autowired
	private TipoPlatilloParaClienteRest converter;
	
	@GetMapping(value="/tipos-platillo")
	public List<TipoPlatilloDto> buscarTodos() {
		List<TipoPlatillo> tiposPlatillo = tipoPlatilloService.buscarTodosTiposPlatillo();
		
		return converter.entityToDto(tiposPlatillo);
	}
}
