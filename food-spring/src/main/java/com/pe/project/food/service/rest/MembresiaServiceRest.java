package com.pe.project.food.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.project.food.entity.Membresia;
import com.pe.project.food.service.MembresiaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
public class MembresiaServiceRest implements MembresiaService{

	ObjectMapper objectMapper = new ObjectMapper();
	private static final String MEMBRESIAS_URL = "membresias/";
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Override
	public Membresia crearMembresia(Membresia membresia) {
		
		Mono<Membresia> membresiaMono = webClientBuilder.build()
											.post().uri(MEMBRESIAS_URL+"crear")
											.body(Mono.just(membresia), Membresia.class)
											.retrieve()
											.bodyToMono(Membresia.class);
		
		Membresia membresiaJson = membresiaMono.block();
		
		return membresiaJson;
	}

	@Override
	public List<Membresia> buscarTodasMembresias() {

		Flux<Membresia> flux = webClientBuilder
								.build()
								.get().uri(MEMBRESIAS_URL)
								.retrieve()
								.bodyToFlux(Membresia.class);
		
		List<Membresia> membresias = flux.collectList().block();
		
		return membresias;
	}

	@Override
	public Membresia buscarPorNombre(String nombreMembresia) {
		
		Mono<Membresia> membresiaMono = webClientBuilder
											.build()
											.get().uri(MEMBRESIAS_URL+"{nombre}", nombreMembresia)
											.retrieve()
											.bodyToMono(Membresia.class);
		
		Membresia membresia = membresiaMono.block();
		
		return membresia;
	}

	@Override
	public Membresia actualizarMembresia(Membresia membresia) {
		Mono<Membresia> membresiaMono = webClientBuilder
											.build()
											.put().uri(MEMBRESIAS_URL+"{nombre}/actualizar", membresia.getNombre())
											.body(Mono.just(membresia), Membresia.class)
											.retrieve()
											.bodyToMono(Membresia.class);
		
		Membresia membresiaJson = membresiaMono.block();
		
		return membresiaJson;
	}

	@Override
	public void eliminarMembresia(String nombreMembresia) {
		Mono<Void> membresiaMono = webClientBuilder
										.build()
										.delete().uri(MEMBRESIAS_URL+"{nombre}/eliminar", nombreMembresia)
										.retrieve()
										.bodyToMono(Void.class);
		
		Void membresiaJson = membresiaMono.block();
		
	}

}
