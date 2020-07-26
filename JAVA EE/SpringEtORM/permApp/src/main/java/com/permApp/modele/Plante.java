package com.permApp.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date_creation;
	@ManyToMany
	private List<Association> compagnons;
//	@OneToMany
//	private List<Association> bonnesAssoc;
	

//	public List<Association> getMauvaisesAssoc() {
//		return mauvaisesAssoc;
//	}
//
//	public void setMauvaisesAssoc(List<Association> mauvaisesAssoc) {
//		this.mauvaisesAssoc = mauvaisesAssoc;
//	}
//
//	public List<Association> getBonnesAssoc() {
//		return bonnesAssoc;
//	}
//
//	public void setBonnesAssoc(List<Association> bonnesAssoc) {
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

	public Date getDate_creation() {
		return date_creation;
	}
	
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public List<Association> getCompagnons() {
		return compagnons;
	}

	public void setCompagnons(List<Association> compagnons) {
		this.compagnons = compagnons;
	}


}
