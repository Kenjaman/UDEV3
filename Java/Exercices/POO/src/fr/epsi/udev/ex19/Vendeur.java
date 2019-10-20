package fr.epsi.udev.ex19;

public class Vendeur extends Employe {
	private double ca;

	public Vendeur() {
		// TODO Auto-generated constructor stub
	}

	public Vendeur(String prenom, String nom, int age, String dateEntree, double ca) {
		super(prenom, nom, age, dateEntree);
		this.setCa(ca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculerSalaire() {
		double salaire;
		salaire = this.getCa()*0.2 +400;
		// TODO Auto-generated method stub
		return salaire;
	}
	public String toString() {
		return "Le vendeur "+this.getPrenom()+" "+this.getNom()+" gagne "+this.calculerSalaire();
	}

	public double getCa() {
		return ca;
	}

	public void setCa(double ca) {
		this.ca = ca;
	}

}
