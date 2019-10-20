package fr.epsi.udev.ex17;

import java.util.ArrayList;
import java.util.List;

public class TestBatiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Batiment bat = new Batiment("25 Avenue de Picot");
		Maison maison = new Maison("74 Impasse du Taillandier", 13);
		Immeuble imbl = new Immeuble("8 Bis Rue Pasteur",200);
		List <Batiment> liste = new ArrayList<Batiment>(); 
		liste.add(bat);
		liste.add(maison);
		liste.add(imbl);
		for(Batiment ligne: liste)
			System.out.println(ligne);
	}

}
