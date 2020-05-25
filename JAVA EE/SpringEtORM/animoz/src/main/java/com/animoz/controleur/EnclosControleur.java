package com.animoz.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.animoz.service.EnclosService;


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
