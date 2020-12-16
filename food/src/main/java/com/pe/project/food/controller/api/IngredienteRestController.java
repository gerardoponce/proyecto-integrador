package com.pe.project.food.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pe.project.food.entity.Ingrediente;
import com.pe.project.food.model.IngredienteDto;
import com.pe.project.food.service.IngredienteService;
import com.pe.project.food.util.converter.IngredienteConverter;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class IngredienteRestController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private IngredienteConverter converter;
	
	@GetMapping(value="/ingredientes")
	public List<IngredienteDto> buscarTodos() {
		
		return converter.entityToDto(ingredienteService.buscarTodosIngredientes());
	}
	
	@PostMapping(value="/ingredientes/")
	@ResponseStatus(HttpStatus.CREATED)
	public Ingrediente crearIngrediente(@RequestBody IngredienteDto ingredienteDto) {
		
		Ingrediente ingrediente = converter.dtoToEntity(ingredienteDto);
		
		return ingredienteService.crearIngrediente(ingrediente);
	}
	
	@GetMapping(value="/ingredientes/{nombre}")
	public IngredienteDto buscarIngrediente(@PathVariable("nombre") String nombre) {
		
		Ingrediente ingrediente = ingredienteService.buscarPorNombre(nombre);
		
		return converter.entityToDto(ingrediente);
	}
	
}
