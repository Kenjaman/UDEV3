package com.permApp.controleur;


import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.permApp.modele.Association;
import com.permApp.modele.Plante;

public class PlanteDto {
	
	private Long id;
	@NotBlank(message = "Veuillez entrer un nom")
	private String nom;
	private List<AssociationDto> compagnons;
//	private List<Plante> mauvaisesAssoc;
//	private List<Plante> bonnesAssoc;
//	private List<Plante> neutreAssoc;
//	
//	public List<Plante> getNeutreAssoc() {
//		return neutreAssoc;
//	}
//	public void setNeutreAssoc(List<Plante> neutreAssoc) {
//		this.neutreAssoc = neutreAssoc;
//	}
//	public void setMauvaisesAssoc(List<Plante> mauvaisesAssoc) {
//		this.mauvaisesAssoc = mauvaisesAssoc;
//	}
//	public void setBonnesAssoc(List<Plante> bonnesAssoc) {
//		this.bonnesAssoc = bonnesAssoc;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<AssociationDto> getCompagnons() {
		return compagnons;
	}
	public void setCompagnons(List<AssociationDto> compagnons) {
		this.compagnons = compagnons;
	}
	
}
