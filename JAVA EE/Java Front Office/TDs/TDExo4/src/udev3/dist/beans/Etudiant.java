package udev3.dist.beans;

public class Etudiant {

	private int id;
	private String nom;
	private String prenom;
	private double numSec;
	private int anneeEtude;
	private float fraisInscription;
	
	public Etudiant() {
		super();
		this.id = 0;
		this.nom = "Richard";
		this.prenom = "Jean-Louis";
		this.numSec = 1111111111;
		this.anneeEtude = 1;
		this.fraisInscription = this.anneeEtude*150;
		
	}
	public Etudiant(int id, String nom, String prenom, double numSec, int anneeEtude) {
		this();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numSec = numSec;
		this.anneeEtude = anneeEtude;
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
	public int getAnneeEtude() {
		return anneeEtude;
	}
	public void setAnneeEtude(int anneeEtude) {
		this.anneeEtude = anneeEtude;
	}
	
}
