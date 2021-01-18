package com.pe.project.food.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pe.project.food.entity.TipoPlatillo;
import com.pe.project.food.repository.TipoPlatilloRepository;
import com.pe.project.food.service.TipoPlatilloService;

@Service
@Primary
public class TipoPlatilloJpa implements TipoPlatilloService {

	@Autowired
	private TipoPlatilloRepository tipoPlatilloRepo;
	
	@Override
	public List<TipoPlatillo> buscarTodosTiposPlatillo() {
		
		return tipoPlatilloRepo.findAll();
	}

	@Override
	public TipoPlatillo buscarPorId(Integer idPlatillo) {
		return tipoPlatilloRepo.findById(idPlatillo).get();
	}

}
