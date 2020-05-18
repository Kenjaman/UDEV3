package com.animoz.controleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.modele.Population;
import com.animoz.service.AnimalService;
import com.animoz.service.EnclosService;
import com.animoz.service.EspeceService;
import com.animoz.service.IllegalEnclosException;
import com.animoz.service.PopulationService;

@Controller
public class EnclosControleur {
	
	@Autowired
	private EnclosService enclosService;

	@GetMapping("/enclos")
	public String listeEnclos(Model model) {
		model.addAttribute("enclos", enclosService.getEnclos());
		return "enclos";
	}

}
