package fr.epsi.udev.ex14;

import java.util.Random;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String adresse;
	
	
	public Personne() {
		super();
		Random rdn= new Random();
		this.nom="Roux"+(char)(rdn.nextInt(230)+25);
		this.prenom="Kénan"+(char)(rdn.nextInt(230)+25);
		this.adresse="La mentebois joli";
	}
	public Personne(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNom :" + nom + "\n Prenom :" + prenom + "\n Adresse :" + adresse + "\n");
		return sb.toString();
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
