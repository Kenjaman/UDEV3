package com.animoz.controleur;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.modele.IPopulation;
import com.animoz.service.AnimalService;
import com.animoz.service.EnclosService;
import com.animoz.service.IllegalEnclosException;
import com.animoz.service.PopulationService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
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
	@Autowired
	private DataSource dataSource;
	private JasperReport rapport;

	@PostConstruct
	public void compilerRapport() throws JRException {
		InputStream modeleInputStream = this.getClass().getResourceAsStream("/listPopulation.jrxml");
		rapport = JasperCompileManager.compileReport(modeleInputStream);
	}
	@GetMapping("/populations")
	public String listePopulation(Model model) {
		model.addAttribute("populations", populationService.getPopulations());
		return "populations";
	}

	@GetMapping(path="/populations/rapport.xlsx")
	public void getRapportPopulation(OutputStream out,Model model) {
		try(Connection connection = dataSource.getConnection()) {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("AUTEUR", "Kénan Roux");
			JasperPrint print = JasperFillManager.fillReport(rapport, parameters, connection);
			JRXlsxExporter xlsxExporter = new JRXlsxExporter();
			xlsxExporter.setExporterInput(new SimpleExporterInput(print));
			xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
			xlsxExporter.exportReport();
		} catch (JRException | SQLException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/ajoutPopulation")
	public String ajouterPopulation(Model model, @ModelAttribute IPopulation population) {
		model.addAttribute("animaux", animalService.getAnimaux());
		model.addAttribute("enclos",enclosService.getEnclos());
		return "ajoutPopulation";
	}

	@PostMapping("/ajoutPopulation")
	public String ajouterPopulation(Model model, @Valid @ModelAttribute IPopulation population, BindingResult bindingResult) {
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
