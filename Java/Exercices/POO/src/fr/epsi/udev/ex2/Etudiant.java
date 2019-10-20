package fr.epsi.udev.ex2;

public class Etudiant {
	private String nom;
	private double[] notes = new double[4];
	

    public Etudiant() {
    this.nom = "John";
    this.notes = new double[]{18,10,14,3,8};
    }

	public Etudiant(String nom, double[] notes, double moyenne, boolean resultat) {
		super();
		this.nom = nom;
		this.notes = new double[notes.length];
	}
	
	public double calculMoyenne() {
		double total=0;
		for(double note:this.notes) {
			total+=note;
		}
		return total/this.notes.length;
	}

	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double[] getNotes() {
		return notes;
	}


	public void setNotes(double[] notes) {
		this.notes = notes;
	}


	public String getResultat(boolean resultat) {
		if(this.calculMoyenne()>=10)
			return "admis";
		else 
			return "non-admis";
	}


	public static void main(String[] args) {
		Etudiant lucas = new Etudiant();
		System.out.println(lucas.getNotes()[6]);
	}
}
