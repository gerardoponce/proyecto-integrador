package com.pe.project.food.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class InicioController {

	@GetMapping(value="/")
	public String mostarIndex(Model model) {
		return "index";
	}
}
