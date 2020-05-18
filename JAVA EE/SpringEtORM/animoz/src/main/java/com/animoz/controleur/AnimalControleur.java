package com.animoz.controleur;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.modele.Animal;
import com.animoz.modele.Regime;
import com.animoz.service.AnimalService;
import com.animoz.service.EspeceService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller
public class AnimalControleur {
	
	@Autowired
	private AnimalService animalService;
	@Autowired
	private EspeceService especeService;
	@Autowired
	private DataSource dataSource;
	
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
	
	@GetMapping("/ajoutAnimal")
	public String ajouterAnimal(Model model, @ModelAttribute AnimalDto animalDto) {
		model.addAttribute("especes", especeService.getEspeces());
		model.addAttribute("regimes", Regime.values());
		
		return "ajoutAnimal";
	}
	
	@PostMapping("/ajoutAnimal")
	public String ajouterAnimal(Model model, @Valid @ModelAttribute AnimalDto animalDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return ajouterAnimal(model, animalDto);
		}else {
			animalService.ajouter(animalDto);
			return "redirect:/animal";
		}
	}
	
	@GetMapping("/animal/{animalId}/modif")
	public String modifAnimal(Model model,@PathVariable long animalId) {
		model.addAttribute("animal", animalService.getAnimal(animalId));
		model.addAttribute("especes", especeService.getEspeces());
		model.addAttribute("regimes", Regime.values());
		return "modifAnimal";
	}
	
	@PostMapping("/animal/{animalId}/modif")
	public String modifAnimal(Model model,@PathVariable long animalId, @Valid @ModelAttribute Animal animal,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			model.addAttribute("especes", especeService.getEspeces());
			model.addAttribute("regimes", Regime.values());
			return "modifAnimal";
		}else {
			animalService.modifier(animal);
			return "redirect:/animal/"+animalId;
		}
	}

	  @GetMapping(path="animaux/liste.pdf", produces = "application/pdf")
	  public void produireRapport(OutputStream out) throws Exception {
	    InputStream modeleInputStream = this.getClass().getResourceAsStream("/listAnimaux.jrxml");
	    JasperReport rapport = JasperCompileManager.compileReport(modeleInputStream);
	    try(Connection connection = dataSource.getConnection()) {
	      Map<String, Object> parameters = new HashMap<>();
	      parameters.put("AUTEUR", "Kénan Roux");
	      JasperPrint print = JasperFillManager.fillReport(rapport, parameters, connection);

	      JRPdfExporter pdfExporter = new JRPdfExporter();
	      pdfExporter.setExporterInput(new SimpleExporterInput(print));
	      pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
	      pdfExporter.exportReport();
	    }
	    
	}
}
