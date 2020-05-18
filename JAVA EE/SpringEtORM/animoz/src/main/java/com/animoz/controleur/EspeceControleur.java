package com.animoz.controleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.service.AnimalExisteEncoreException;
import com.animoz.service.EspeceService;

@Controller
public class EspeceControleur {
	
	@Autowired
	private EspeceService especeService;
	
	@GetMapping("/espece")
	public String getEspeces(Model model,@ModelAttribute EspeceDto especeDto) {
		model.addAttribute("especes", especeService.getEspeces());
		return "especes";
	}
	
	@PostMapping("/espece")
	public String ajouterEspeces(Model model, @Valid @ModelAttribute EspeceDto especeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return getEspeces(model, especeDto);
		else {
			especeService.ajouter(especeDto.getNom());
			return "redirect:/espece";
		}
	}
	
	@PostMapping("/espece/disparition")
	public String supprimerEspeces(Model model,@ModelAttribute EspeceDto especeDto) {
		try {
			especeService.supprimer(especeDto.getNom());
			return "redirect:/espece";
		} catch (AnimalExisteEncoreException e) {
			// TODO Auto-generated catch block
			model.addAttribute("messageErreur",e.getMessage());
			return getEspeces(model, especeDto);
		}
	
	}
	
}
