package com.pe.project.food.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pe.project.food.entity.Platillo;
import com.pe.project.food.model.PlatilloDto;
import com.pe.project.food.service.PlatilloService;
import com.pe.project.food.util.converter.PlatilloConverter;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class PlatilloRestController {

	@Autowired
	private PlatilloService platilloService;
	
	@Autowired
	private PlatilloConverter converter;
	
	@GetMapping(value="/platillos")
	public List<PlatilloDto> buscarTodos() {
		List<Platillo> platillos = platilloService.buscarTodosPlatillos();
		
		return converter.entityToDto(platillos);
	}
	
	@PostMapping(value="/platillos/")
	@ResponseStatus(HttpStatus.CREATED)
	public Platillo crearPlatillo(@RequestBody Platillo platillo) {
		return platilloService.crearPlatillo(platillo);
	}
	
	@GetMapping(value="/platillos/{nombre}")
	public Platillo buscarPlatillo(@PathVariable("nombre") String nombre) {
		return platilloService.buscarPorNombre(nombre);
	}
	
	@PutMapping(value="/platillos/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarMembresia(@PathVariable("nombre") String nombre, @RequestBody Platillo platillo) {
		platilloService.buscarPorNombre(platillo.getNombre());
		platilloService.actualizarPlatillo(platillo);
	}
	
	@DeleteMapping(value="/platillos/{nombre}")
	@ResponseStatus(HttpStatus.OK)
    public void eliminarPlatillo(@PathVariable("nombre") String nombre) {
		platilloService.eliminarPlatillo(nombre);
    }
}
