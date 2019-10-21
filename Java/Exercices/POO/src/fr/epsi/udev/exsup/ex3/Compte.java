package fr.epsi.udev.exsup.ex3;

public class Compte {
	private String numero;
	private String nom_titulaire;
	private double solde;
	
	public void depot(double montant) {
		this.setSolde(solde+montant);
	}
	
	public double consulter() {
		return this.getSolde();
	}
	
	public void retire(double montant) throws IllegalArgumentException {
		if(this.solde-montant<0) {
			this.solde = montant;
		}else
			throw new IllegalArgumentException("Le solde est insuffisant");
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNom_titulaire() {
		return nom_titulaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
