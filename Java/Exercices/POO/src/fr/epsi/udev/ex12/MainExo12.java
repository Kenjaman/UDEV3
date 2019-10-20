package fr.epsi.udev.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExo12 {

	public static void main(String[] args) {
		List<Livre> livres = new ArrayList<Livre>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Nombre de livre a saisir ?");
		int nbLivre = scn.nextInt();
		for(int i=0;i<nbLivre;i++)
			livres.add(new Livre());
		
		for(Livre l : livres)
			System.out.println(l);
	}
}
