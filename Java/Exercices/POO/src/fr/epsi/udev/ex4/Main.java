package fr.epsi.udev.ex4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String voyelles="aeiouy��������";
		final String consonnes="zrtpqsdfghjklmwx�cvbn";
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Entrez une chaine 1:");
		
		Chaine1 chaine=new Chaine1(scn.nextLine());
		
		System.out.println("Entrez une seconde chaine :");
		Chaine2 chaine2=new Chaine2(scn.nextLine());
		
		
		System.out.println(chaine.extrait(voyelles));
		System.out.println(chaine.extrait(consonnes));
		System.out.println(chaine2.compterMots());
		System.out.println(chaine2.compte(voyelles));
		scn.close();
	}

}
