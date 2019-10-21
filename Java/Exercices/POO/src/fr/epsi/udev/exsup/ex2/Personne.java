package fr.epsi.udev.exsup.ex2;

public class Personne {

	private String nom;
	private String prenom;
	private Appartement sonAppart;
	
	public Personne() {
		super();
	}
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	public Appartement getSonAppart() {
		return sonAppart;
	}

	public void setSonAppart(Appartement sonAppart) {
		this.sonAppart = sonAppart;
	}
	
	public void vendSonAppart(Personne p2) {
		p2.setSonAppart(this.getSonAppart());
		this.setSonAppart(null);
		
	}
	
	
}
