package com.animoz.controleur;

import org.hibernate.validator.constraints.NotBlank;

public class EspeceDto {

	@NotBlank(message = "Vous devez fournir un nom pour l''espèce !")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
