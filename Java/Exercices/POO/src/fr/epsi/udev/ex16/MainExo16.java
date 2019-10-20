package fr.epsi.udev.ex16;

import java.util.ArrayList;
import java.util.List;

public class MainExo16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Voiture> voitures = new ArrayList<Voiture>();
		List<Moto> motos = new ArrayList<Moto>();
		List<Camion> camions = new ArrayList<Camion>();
		List<Tracteur> tracteurs = new ArrayList<Tracteur>();
		for(int i=0; i<5;i++) {
			voitures.add(new Voiture("Peugot",1999,2000.2,"rouge"));
			motos.add(new Moto("GP2202",1999,2000.2,"rouge"));
			tracteurs.add(new Tracteur("Grevin",1800,32323233.1,"rouille"));
			camions.add(new Camion("SurlaRoute",1999,2000.2,"bleu"));
		}
		
		
		ParcVehicule monParc = new ParcVehicule(motos,camions,voitures,tracteurs);
		System.out.println(monParc);
		
	}

}
