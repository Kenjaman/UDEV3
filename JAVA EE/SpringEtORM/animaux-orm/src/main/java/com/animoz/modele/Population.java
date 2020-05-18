package com.animoz.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Population {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nombreIndividus;
	
	@ManyToOne
	private Animal animal;
	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNombreIndividus() {
		return nombreIndividus;
	}

	public void setNombreIndividus(Integer nombreIndividus) {
		this.nombreIndividus = nombreIndividus;
	}

	

}
