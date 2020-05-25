//package com.animoz.modele;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Enclos {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String numero;
//	private int capaciteMax = 0;
//	//	@OneToMany(mappedBy = "enclos")
//	private List<IPopulation> populations;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public List<IPopulation> getPopulations() {
//		return populations;
//	}
//
//	public void setPopulations(List<IPopulation> populations){
//		if(IPopulation.getTotalIndividus(populations)>this.getCapaciteMax())
//			throw new IllegalStateException("Il n'y a plus de place dans l'enclos");
//		this.populations = populations;
//	}
//
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//
//	public int getCapaciteRestante() {
//		return this.getCapaciteMax()-IPopulation.getTotalIndividus(this.populations);
//	}
//
//	public int getCapaciteMax() {
//		return this.capaciteMax;
//	}
//
//	public void setCapaciteMax(int capaciteMax) {
//		if(capaciteMax<0)
//			throw new IllegalArgumentException("La capacité Max ne peux etre inferieur a 0");
//		if(capaciteMax < IPopulation.getTotalIndividus(this.populations))
//			throw new IllegalStateException("La capacité MAx ne peux etre réduite tant que trop d'animaux sont présents");
//		this.capaciteMax= capaciteMax;
//	}
//
//
//
//}

package com.animoz.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enclos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	@OneToMany(mappedBy = "enclos")
	private List<Population> populations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Population> getPopulations() {
		return populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	
}

