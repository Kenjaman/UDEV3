package com.permApp.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.permApp.service.PlanteService;

@Controller
public class PlanteControleur {
	
	@Autowired
	private PlanteService planteService;
	
	@GetMapping("/plantes")
	public String getListePlantes(Model model) {
		model.addAttribute("plantes", planteService.getPlantes());
		return "plantes";
	}

//	@GetMapping("/animal/{animalId}")
//	public String getAnimal(Model model, @PathVariable long animalId) {
//		model.addAttribute("animal", planteService.getAnimal(animalId));
//		return "animal";
//	}
}
