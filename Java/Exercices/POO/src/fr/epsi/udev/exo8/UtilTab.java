package fr.epsi.udev.exo8;

public class UtilTab {

	public static double somme(double [] tableau) {
		int somme=0;
		for(double tab : tableau)
			somme+=tab;
		return somme;
	}
	
	public static void incre (double[]tableau, int increment) {
		for(int i=0; i<tableau.length;i++)
			tableau[i]+=increment;
	}
	
	public static void afficheTab(double []tableau) {
		System.out.print("[");
		for(double tab : tableau)
			System.out.print(tab+", ");
		System.out.println("]");
	}
}
