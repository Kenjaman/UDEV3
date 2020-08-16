package com.permApp.modele;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Plante database table.
 * 
 */
@Entity
@NamedQuery(name="Plante.findAll", query="SELECT p FROM Plante p")
public class Plante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	@Lob
	private byte[] image;

	private String nom;

	//bi-directional many-to-one association to Association
	@OneToMany(mappedBy="plante1")
	private List<Association> associations1;

	//bi-directional many-to-one association to Association
	@OneToMany(mappedBy="plante2")
	private List<Association> associations2;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Association> getAssociations1() {
		return this.associations1;
	}

	public void setAssociations1(List<Association> associations1) {
		this.associations1 = associations1;
	}

	public Association addAssociations1(Association associations1) {
		getAssociations1().add(associations1);
		associations1.setPlante1(this);

		return associations1;
	}

	public Association removeAssociations1(Association associations1) {
		getAssociations1().remove(associations1);
		associations1.setPlante1(null);

		return associations1;
	}

	public List<Association> getAssociations2() {
		return this.associations2;
	}

	public void setAssociations2(List<Association> associations2) {
		this.associations2 = associations2;
	}

	public Association addAssociations2(Association associations2) {
		getAssociations2().add(associations2);
		associations2.setPlante2(this);

		return associations2;
	}

	public Association removeAssociations2(Association associations2) {
		getAssociations2().remove(associations2);
		associations2.setPlante2(null);

		return associations2;
	}

	@Override
	public String toString() {
		return nom+" (Plante) [id=" + id + ", dateCreation=" + dateCreation + ", nom="
				+ nom + ", associations1=" + associations1 + ", associations2=" + associations2 + "]";
	}
	
	

}

//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//public class Plante {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String nom;
//	@Temporal(value=TemporalType.TIMESTAMP)
//	private Date date_creation;
//	@ManyToMany
//	private List<Association> compagnons;
////	@OneToMany
////	private List<Association> bonnesAssoc;
//	
//
////	public List<Association> getMauvaisesAssoc() {
////		return mauvaisesAssoc;
////	}
////
////	public void setMauvaisesAssoc(List<Association> mauvaisesAssoc) {
////		this.mauvaisesAssoc = mauvaisesAssoc;
////	}
////
////	public List<Association> getBonnesAssoc() {
////		return bonnesAssoc;
////	}
////
////	public void setBonnesAssoc(List<Association> bonnesAssoc) {
////		this.bonnesAssoc = bonnesAssoc;
////	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public Date getDate_creation() {
//		return date_creation;
//	}
//	
//	public void setDate_creation(Date date_creation) {
//		this.date_creation = date_creation;
//	}
//
//	public List<Association> getCompagnons() {
//		return compagnons;
//	}
//
//	public void setCompagnons(List<Association> compagnons) {
//		this.compagnons = compagnons;
//	}
//
//
//}
