package com.pe.project.food.controller.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.project.food.model.IngredienteDto;
import com.pe.project.food.model.PlatilloDto;
import com.pe.project.food.model.TipoPlatilloDto;

@SpringBootTest
@AutoConfigureMockMvc
public class PlatilloRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static final ObjectMapper om = new ObjectMapper();

	@Test
	public void testObtenerPlatillos() throws Exception {

		int ID_PRIMER_REGISTRO = 1;

		this.mockMvc
			.perform(get("/api/v1/platillos"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].id", is(ID_PRIMER_REGISTRO)));
	}

	@Test
	public void testBuscarPlatillo() throws Exception {

		String NOMBRE = "platillo 1";
	    String DESCRIPCION = null;
	    double PRECIO = 10.9;
	    String fotoPLATILLO = null;
	    Integer tipoPLATILLO = 2;
	    Integer ingrediente1 = 1;
	    Integer ingrediente2 = 2;

		mockMvc.perform(get("/api/v1/platillos/platillo 1"))  // Object must be BASIL 
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				//.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.nombre", is(NOMBRE)))
			.andExpect(jsonPath("$.descripcion", is(DESCRIPCION)))
			.andExpect(jsonPath("$.precio", is(PRECIO)))
			.andExpect(jsonPath("$.fotoPlatillo", is(fotoPLATILLO)))
			.andExpect(jsonPath("$.tipoPlatillo.id", is(tipoPLATILLO)))
			.andExpect(jsonPath("$.ingredientes[0].id", is(ingrediente1)))
			.andExpect(jsonPath("$.ingredientes[1].id", is(ingrediente2)));

	}
	
	@Test
	public void testCrearPlatillo() throws Exception {

	    String NOMBRE = "platillo 1_v1";
	    String DESCRIPCION = "Un platillo delicioso";
	    double PRECIO = 10.9;
	    String fotoPLATILLO = null;
	    
	    TipoPlatilloDto tipoPlatilloDto = new TipoPlatilloDto();
	    tipoPlatilloDto.setId(2);
	    tipoPlatilloDto.setNombre("almuerzo");
	    
	    IngredienteDto ingredienteDto1 = new IngredienteDto();
	    ingredienteDto1.setId(1);
	    ingredienteDto1.setNombre("ingrediente 1");
	    
	    IngredienteDto ingredienteDto2 = new IngredienteDto();
	    ingredienteDto2.setId(2);
	    ingredienteDto2.setNombre("ingrediente 2");
	    
	    List<IngredienteDto> ingredientesDto = new ArrayList<IngredienteDto>();
	    
	    ingredientesDto.add(ingredienteDto1);
	    ingredientesDto.add(ingredienteDto2);
	    
	    PlatilloDto platilloDto = new PlatilloDto();
	    platilloDto.setNombre(NOMBRE);
	    platilloDto.setDescripcion(DESCRIPCION);
	    platilloDto.setPrecio(PRECIO);
	    platilloDto.setFotoPlatillo(fotoPLATILLO);
	    platilloDto.setTipoPlatillo(tipoPlatilloDto);
	    platilloDto.setIngredientes(ingredientesDto);
	    
		/*
		 * { 
		 * 	"nombre": "platillo 1_v1", 
		 * 	"descripcion": "Un platillo delicioso", 
		 * 	"precio": 10.9,
		 *  "fotoPlatillo": null,
		 * 	"tipoPlatillo": { 
		 * 		"id": 2, 
		 * 		"nombre": "almuerzo" 
		 * 	}, 
		 * "ingredientesPlatillos": 
		 * 	[ 
		 * 		{ 
		 * 			"id": 1, 
		 * 				"nombre": "ingrediente 1" 
	 	 * 			
	 	 * 		}, 
	 	 * 		{ 
		 * 			"id": 2, 
		 *			"nombre": "ingrediente 2" 
	 	 * 			
	 	 * 		} 
	 	 * 	] 
	 	 * }
		*/
	    
		mockMvc.perform(post("/api/v1/platillos/")
			.content(om.writeValueAsString(platilloDto))
			.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
			.andDo(print())
            .andExpect(status().isCreated())
			.andExpect(jsonPath("$.nombre", is(NOMBRE)))
			.andExpect(jsonPath("$.descripcion", is(DESCRIPCION)))
			.andExpect(jsonPath("$.precio", is(PRECIO)))
			.andExpect(jsonPath("$.tipoPlatillo.id", is(2)))
			.andExpect(jsonPath("$.ingredientesPlatillos[0].id", is(1)))
			.andExpect(jsonPath("$.ingredientesPlatillos[1].id", is(2)));

	}
	
	@Test
    public void testEliminarPlatillo() throws Exception {
		
        mockMvc.perform(delete("/api/v1/platillos/platillo 1_v1"))
                /*.andDo(print())*/
                .andExpect(status().isOk());
    }
	
}
