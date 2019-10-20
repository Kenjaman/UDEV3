package fr.epsi.udev.ex12;

import java.util.Scanner;

public class Livre {
	private int id;
	private String titre;
	private String nomAuteur;
	private double prix;
	private static int idClasse;
	{idClasse++;}

	Scanner scn = new Scanner(System.in);

	public Livre() {
		this.id=idClasse;
		System.out.println("D�but de l'entr�e du livre "+this.getId()+" :");
		System.out.println("Entrez l'auteur :");
		//		this.nomAuteur=scn.nextLine();
		this.nomAuteur="Ren�";
		System.out.println("Entrez le titre :");
		//		this.titre=scn.nextLine();
		this.titre="lataupe";
		System.out.println("Entrez le prix :");
		//		this.prix=scn.nextInt();
		this.prix=9999;
	}



	@Override
	public String toString() {
		StringBuilder sl=new StringBuilder();
		sl.append(this.getId());
		sl.append("\t Titre : ");
		sl.append(this.getTitre());
		sl.append("\t Auteur : ");
		sl.append(this.getNomAuteur());
		sl.append("\t Prix : ");
		sl.append(this.getPrix());
		sl.append("�\n");
		return sl.toString();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
