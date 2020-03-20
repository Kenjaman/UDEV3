package udev3.dist.beans;

public class Professeur {
	private int id;
	private String nom;
	private String prenom;
	private double numSec;
	private int anneeAnciennete;
	private float salaire;

	public Professeur() {
		super();
		this.id = 0;
		this.nom = "Poulu";
		this.prenom = "Jean-Louis";
		this.numSec = 1111111111;
		this.anneeAnciennete = 1;
		this.salaire = this.anneeAnciennete*50+1600;

	}
	public Professeur(int id, String nom, String prenom, double numSec, int anneeAnciennete) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numSec = numSec;
		this.anneeAnciennete = anneeAnciennete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getNumSec() {
		return numSec;
	}
	public void setNumSec(double numSec) {
		this.numSec = numSec;
	}
	public int getAnneeAnciennete() {
		return anneeAnciennete;
	}
	public void setAnneeAnciennete(int anneeAnciennete) {
		this.anneeAnciennete = anneeAnciennete;
	}
	
	public int getSalaire() {
		return this.anneeAnciennete*50+1600;
	}
}
