package fr.epsi.udev.ex13;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.udev.ex12.Livre;

public class mainExo13 {

	public static void main(String[] args) {
		List <Livre> liste_livre=new ArrayList<Livre>();
		for(int i = 0;i<Bibliotheque.maxDeLivre;i++) {
			liste_livre.add(new Livre());
		}
		Bibliotheque biblio = new Bibliotheque(1, "La grande librairie", liste_livre, "2514bis Sunstreet a gauche de l'etoile du matin", "somewhere in space ...");
		System.out.println(biblio);
	}
}
	
