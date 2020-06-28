package com.permApp.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Date date_creation;
	@OneToMany
	private List<Plante> mauvaisesAssoc;
	@OneToMany
	private List<Plante> bonnesAssoc;

	public List<Plante> getMauvaisesAssoc() {
		return mauvaisesAssoc;
	}

	public void setMauvaisesAssoc(List<Plante> mauvaisesAssoc) {
		this.mauvaisesAssoc = mauvaisesAssoc;
	}

	public List<Plante> getBonnesAssoc() {
		return bonnesAssoc;
	}

	public void setBonnesAssoc(List<Plante> bonnesAssoc) {
		this.bonnesAssoc = bonnesAssoc;
	}

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

	public Date getDate_creation() {
		return date_creation;
	}
	
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}


}
