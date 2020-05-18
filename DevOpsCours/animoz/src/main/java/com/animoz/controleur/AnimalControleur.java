package com.animoz.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.animoz.service.AnimalService;

@Controller
public class AnimalControleur {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/animal")
	public String getListeAnimaux(Model model) {
		model.addAttribute("animaux", animalService.getAnimaux());
		return "animaux";
	}

	@GetMapping("/animal/{animalId}")
	public String getAnimal(Model model, @PathVariable long animalId) {
		model.addAttribute("animal", animalService.getAnimal(animalId));
		return "animal";
	}
}
