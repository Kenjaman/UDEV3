package com.exemple.spring;

public class Voiture {
	
	private String marque;
	private Moteur moteur;
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Moteur getMoteur() {
		return moteur;
	}

	// injection de dépendance
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	
	

}
