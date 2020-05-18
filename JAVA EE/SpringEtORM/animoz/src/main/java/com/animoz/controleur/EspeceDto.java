package com.animoz.controleur;

import org.hibernate.validator.constraints.NotBlank;

public class EspeceDto {
	 @NotBlank(message = "Le nom ne doit pas etre vide")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
