package fr.epsi.udev.ex16;

import fr.epsi.udev.ex10.Camion;

public class Tracteur extends Vehicule {
	private String specialite;

	public Tracteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tracteur(String modele, int anneeMod, double prix, String couleur) {
		super(modele, anneeMod, prix, couleur);
		System.out.println("Entre la spécialité :");
		this.specialite=scn.nextLine();
		// TODO Auto-generated constructor stub
	}


}
