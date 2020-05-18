package com.animoz.controleur;

import org.hibernate.validator.constraints.NotBlank;

import com.animoz.modele.Espece;
import com.animoz.modele.Regime;

public class AnimalDto {
	
	@NotBlank(message = "Le nom ne doit pas etre vide")
	private String nom;
	
	private String origine;
	private String description;
	private Espece espece;
	private Regime regime;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) {
		this.espece = espece;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}

}
