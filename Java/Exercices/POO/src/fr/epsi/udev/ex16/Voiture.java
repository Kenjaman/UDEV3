package fr.epsi.udev.ex16;

import java.util.Scanner;

public class Voiture extends Vehicule{
	private static int refMatricule=0;
	{refMatricule++;}
	private int matricule;
	private String modele;
	private int anneeMod;
	private double prix;
	private String couleur;
	protected boolean demarrer;
	
	Scanner scn= new Scanner(System.in);
	
	
	
	public Voiture() {
		super();
		System.out.println("Entrez le mod�le :");
		this.modele=scn.nextLine();
		System.out.println("Entrez la couleur :");
		this.couleur=scn.nextLine();
		System.out.println("Entrez le l'ann�e :");
		this.anneeMod=scn.nextInt();
		System.out.println("Entrez le prix :");
		this.prix=scn.nextInt();
		this.matricule=refMatricule;
	}

	public Voiture(String modele, int anneeMod, double prix, String couleur) {
		super(modele,anneeMod,prix,couleur);

		
	}
	
	public void afficherCouleur() {
		System.out.println("Couleur :"+this.couleur);
	}
	public void demarreVehicule() {
		System.out.println("La voiture d�marre....");
		this.demarrer=true;
	}
	public void arreterVehicule() {
		this.demarrer=false;
		System.out.println("La voiture s'arr�te....");
	}
	
	public String afficher() {
		return "Matricule :" +this.getMatricule()+ "\nMod�le :"+this.getModele()+
				"\nAnn�e mod�le: "+this.getAnneeMod()+
				"\nCouleur :"+this.couleur+
				"\n Prix :"+this.getPrix()+" �";
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnneeMod() {
		return anneeMod;
	}

	public void setAnneeMod(int anneeMod) {
		this.anneeMod = anneeMod;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	
}
