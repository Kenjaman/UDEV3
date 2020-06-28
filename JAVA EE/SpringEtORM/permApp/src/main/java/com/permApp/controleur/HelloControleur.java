package com.permApp.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.permApp.modele.Plante;

@Controller
public class HelloControleur {
	
	@GetMapping(path = "/hello")
	public String hello(@ModelAttribute Plante animal, @RequestParam String nomAnimal) {
		// Faire un truc avec le modèle
		animal.setNom(nomAnimal);
		// Demander à la vue une mise à jour
		return "hello";
	}

}
