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

import com.pe.project.food.entity.Membresia;
import com.pe.project.food.service.MembresiaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class MembresiaRestController {

	@Autowired
	private MembresiaService membresiaService;

	@GetMapping(value="/membresias")
	public List<Membresia> buscarTodas() {
		return membresiaService.buscarTodasMembresias();
	}
	
	@PostMapping(value="/membresias/")
	@ResponseStatus(HttpStatus.CREATED)
	public void crearMembresia(@RequestBody Membresia membresia) {
		membresiaService.crearMembresia(membresia);
	}
	
	@GetMapping(value="/membresias/{nombre}")
	public Membresia buscarMembresia(@PathVariable("nombre") String nombre) {
		return membresiaService.buscarPorNombre(nombre);
	}
	
	@GetMapping(value="/membresias/id/{id}")
	public Membresia buscarMembresiaPorId(@PathVariable("id") Integer id) {
		return membresiaService.buscarPorId(id);
	}
	
	@PutMapping(value="/membresias/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarMembresia(@PathVariable("nombre") String nombre, @RequestBody Membresia membresia) {
		membresiaService.buscarPorNombre(membresia.getNombre());
		membresiaService.actualizarMembresia(membresia);
	}
	
	@DeleteMapping(value="/membresias/{nombre}")
	@ResponseStatus(HttpStatus.OK)
    public void eliminarMembresia(@PathVariable("nombre") String nombre) {
		membresiaService.eliminarMembresia(nombre);
    }
}
