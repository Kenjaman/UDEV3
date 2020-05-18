package com.animoz.controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller
public class PopulationControleur {
	
	@Autowired
	private AnimalService animalService;
	@Autowired
	private PopulationService populationService;
	@Autowired
	private EnclosService enclosService;

	@GetMapping("/populations")
	public String listePopulation(Model model) {
		model.addAttribute("populations", populationService.getPopulations());
		return "populations";
	}
	
	@GetMapping("/populations/rapport")
	public void getRapportEnclos(Model model) {
	FileInputStream in;
	try {
		in = new FileInputStream("personnes.jrxml");
		JasperReport report = JasperCompileManager.compileReport(in);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("AUTEUR", "David Gayerie");
		JRCsvDataSource dataSource = new JRCsvDataSource("personnes.csv");
		dataSource.setUseFirstRowAsHeader(true);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
		
		JRPdfExporter pdfExporter = new JRPdfExporter();
		pdfExporter.setExporterInput(new SimpleExporterInput(print));
		pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput("rapport.pdf"));
		pdfExporter.exportReport();
	} catch (FileNotFoundException | JRException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@GetMapping("/ajoutPopulation")
	public String ajouterPopulation(Model model, @ModelAttribute Population population) {
		model.addAttribute("animaux", animalService.getAnimaux());
		model.addAttribute("enclos",enclosService.getEnclos());
		return "ajoutPopulation";
	}
	
	@PostMapping("/ajoutPopulation")
	public String ajouterPopulation(Model model, @Valid @ModelAttribute Population population, BindingResult bindingResult) {
			try {
				if(bindingResult.hasErrors()) {
					return ajouterPopulation(model, population);
				}else {
					populationService.ajouter(population);
				}
			} catch (IllegalEnclosException e) {
				bindingResult.reject("Danger", e.getMessage());
				return ajouterPopulation(model, population);
			}
			return "redirect:/enclos";
	}

}
