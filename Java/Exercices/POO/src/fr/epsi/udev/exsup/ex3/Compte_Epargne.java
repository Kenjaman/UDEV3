package fr.epsi.udev.exsup.ex3;

public class Compte_Epargne extends Compte {
	private double taux;

	public Compte_Epargne(double taux) {
		super();
		this.taux = taux;
	}
	
	public void ajoutInteret() {
		double interet = this.getSolde()*(1+this.getTaux());
		this.depot(interet);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
