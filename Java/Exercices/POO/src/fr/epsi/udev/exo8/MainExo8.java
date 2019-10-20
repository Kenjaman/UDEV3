package fr.epsi.udev.exo8;

import java.util.Scanner;

public class MainExo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Entrez le chiffre :");
		int n = scn.nextInt();
		double tableau[] = new double[n];
		int nbCarre = 0;
		int i = 0, j = 1;
		do {
			if (j % 2 != 0) {
				nbCarre++;
				tableau[i] = j * j;
				i++;
			}
			j++;

		} while (nbCarre < n);
		for (double carre : tableau) {
			System.out.println((int) Math.sqrt(carre) + " a pour carré " + (int)carre);
		}
		UtilTab.afficheTab(tableau);
		System.out.println(UtilTab.somme(tableau));
		UtilTab.afficheTab(tableau);
		UtilTab.incre(tableau,2);
		UtilTab.afficheTab(tableau);
		scn.close();
	}

}
