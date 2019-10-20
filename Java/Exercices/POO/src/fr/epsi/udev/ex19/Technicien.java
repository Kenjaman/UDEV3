package fr.epsi.udev.ex19;

public class Technicien extends Prodeur implements ARisque {

	public Technicien() {
		// TODO Auto-generated constructor stub
	}

	public Technicien(String prenom, String nom, int age, String dateEntree, int nbPieceprod) {
		super(prenom, nom, age, dateEntree, nbPieceprod);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" et ca prime de risque de "+PRIME+" €";
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return super.calculerSalaire()+PRIME;
	}

}
