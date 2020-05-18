package com.animoz.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

@Entity
public class Population {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(value=1, message = "Entrez au moins un individu")
	private int nombreIndividus=1;
	@ManyToOne
	private Animal animal;
	
	@ManyToOne
	private Enclos enclos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNombreIndividus() {
		return nombreIndividus;
	}

	public void setNombreIndividus(int nombreIndividus) {
		this.nombreIndividus = nombreIndividus;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Enclos getEnclos() {
		return enclos;
	}

	public void setEnclos(Enclos enclos) {
		this.enclos = enclos;
	}
}