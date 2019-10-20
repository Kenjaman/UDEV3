package fr.epsi.udev.ex19;

public class Prodeur extends Employe {

	private int nbPieceprod;
	public Prodeur() {
		// TODO Auto-generated constructor stub
	}

	public Prodeur(String prenom, String nom, int age, String dateEntree, int nbPieceprod) {
		super(prenom, nom, age, dateEntree);
		this.nbPieceprod = nbPieceprod;
	}

	public String toString() {
		return " Le producteur "+this.getPrenom()+" "+this.getNom()+" gagne "+this.calculerSalaire()+" pour ces "+this.getNbPieceprod()+" pièces";
	}
	
	public int getNbPieceprod() {
		return nbPieceprod;
	}

	public void setNbPieceprod(int nbPieceprod) {
		this.nbPieceprod = nbPieceprod;
	}

	@Override
	public double calculerSalaire() {
		return this.getNbPieceprod()*5;
	}

}
