package fr.epsi.udev.ex10;

import fr.epsi.udev.exo9.Voiture;

public class MainEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Voiture[] voitures = new Voiture[2];
		Moto [] motos = new Moto[4];
		Camion camion = new Camion();
		
		for(Voiture voiture:voitures) {
			voiture = new Voiture();
			System.out.println(voiture.afficher());
		}
		for(Moto moto:motos) {
			moto = new Moto();
			System.out.println(moto.afficher());
		}
		
	}

}
