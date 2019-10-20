package fr.epsi.udev.ex14;

import java.util.Random;

public class Etudiant extends Personne {
	private String ecole;
	private double[] notes;
	private int nbNote=0;

	public Etudiant() {
		super();
		this.notes=new double[4];
		this.ecole="Poudlard";
	}

	public Etudiant(String nom, String prenom, String adresse, String ecole) {
		super(nom, prenom, adresse);
		this.notes=new double[4];
		this.ecole = ecole;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etudiant à ");
		builder.append(ecole+'\n');
		builder.append(super.toString());
		return builder.toString();
	}

	public void suivreCours(Professeur prof) {
		System.out.println(this.getNom()+" suit le cours de "+prof.getMatiere()+" de Mr/Mme "+prof.getNom());
	}
	
	public boolean passeExamen() {
		System.out.println(this.getNom()+" se présente a l'examen...");
//		System.out.println(this.getNom()+" se concentre ....");
//		Random rdn = new Random();
//		int chance = rdn.nextInt(100)+1;
//		if(chance>50) {
		if(this.calculMoyenne()>10) {
			System.out.println("Et ca paaaaaasse !! Examen reussi avec une moyenne de "+this.calculMoyenne());
			return true;
		}else {
			System.out.println("Echec !!!! une moyenne de "+this.calculMoyenne()+" ce n'est pas suffisant !");
			return false;
		}
	}

	public double calculMoyenne() {
		double total=0;
		for(double note:this.notes) {
			total+=note;
		}
		return total/this.nbNote;
	}

	public double[] getNotes() {
		return notes;
	}
	
	public void setNotes(double note) {
		this.notes[nbNote]=note;
		this.nbNote++;
	}


	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	
	
}
