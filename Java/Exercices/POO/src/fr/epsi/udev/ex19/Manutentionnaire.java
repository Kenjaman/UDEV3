package fr.epsi.udev.ex19;

public class Manutentionnaire extends Employe {

	private double nbHeure;

	public Manutentionnaire() {
		// TODO Auto-generated constructor stub
	}

	public Manutentionnaire(String prenom, String nom, int age, String dateEntree, double nbHeure) {
		super(prenom, nom, age, dateEntree);
		this.nbHeure = nbHeure;
	}
	public String toString() {
		return "Le manutentionnaire "+this.getPrenom()+" "+this.getNom()+" gagne "+this.calculerSalaire()+" pour ces "+this.getNbHeure()+" heures";
	}

	@Override
	public double calculerSalaire() {
		return nbHeure*65;
	}

	public double getNbHeure() {
		return nbHeure;
	}
	
	public void setNbHeure(double nbHeure) {
		this.nbHeure = nbHeure;
	}

}
