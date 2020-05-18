package com.animoz.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilControleur {

	@GetMapping(path = {"/", "/accueil"})
	public String accueillir() {
		return "accueil";
	}
}
