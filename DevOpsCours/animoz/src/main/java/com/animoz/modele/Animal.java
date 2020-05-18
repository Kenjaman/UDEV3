package com.animoz.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String origine;
	private String description;
	@Enumerated(EnumType.STRING)
	private Regime regime;
	@ManyToOne
	private Espece espece;
	@OneToMany(mappedBy = "animal")
	private List<Population> populations;

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
	
	public int getPopulationTotale() {
		int populationTotale = 0;
		for (Population population : populations) {
			populationTotale += population.getNombreIndividus();
		}
		return populationTotale;
	}

	public List<Population> getPopulations() {
		return populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}
}
