package com.permApp.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.permApp.modele.Association;
import com.permApp.modele.Relation;
import com.permApp.service.AssociationService;
import com.permApp.service.PlanteService;

@Controller
public class PlanteControleur {
	
	@Autowired
	private PlanteService planteService;
	@Autowired
	private AssociationService associationService;
	
	@GetMapping("/plantes")
	public String getListePlantes(Model model) {
		model.addAttribute("plantes", planteService.getPlantes());
		for (Association assoc : associationService.getAssociations()) {
			System.out.println(assoc.getId_plante1()+ " + "+assoc.getId_plante2()+" = "+assoc.getRelation());
		}
		return "plantes";
	}
	
	@GetMapping("/ajoutPlante")
	public String ajouterPlante(Model model, @ModelAttribute PlanteDto planteDto) {
		model.addAttribute("plantes", planteService.getPlantes());
		model.addAttribute("compagnons",associationService.getAssociations());
		model.addAttribute("relations", Relation.values());
		return "ajoutPlante";
	}

//	@GetMapping("/animal/{animalId}")
//	public String getAnimal(Model model, @PathVariable long animalId) {
//		model.addAttribute("animal", planteService.getAnimal(animalId));
//		return "animal";
//	}
}
