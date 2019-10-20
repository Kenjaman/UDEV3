package fr.epsi.udev.ex19;

public class ManutARisque extends Manutentionnaire implements ARisque {

	public ManutARisque() {
		// TODO Auto-generated constructor stub
	}

	public ManutARisque(String prenom, String nom, int age, String dateEntree, double nbHeure) {
		super(prenom, nom, age, dateEntree, nbHeure);
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
