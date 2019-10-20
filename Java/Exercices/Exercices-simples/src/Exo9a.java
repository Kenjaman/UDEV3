import java.util.Scanner;

public class Exo9a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tabNote[]= new int [5];
		int tabMoyenne=0;
		Scanner scn = new Scanner(System.in);
		for (int i=0;i<tabNote.length;i++) {
			System.out.println("Entrez note n°"+i);
			tabNote[i]=scn.nextInt();
			tabMoyenne+=tabNote[i];
		}
		tabMoyenne/=tabNote.length;
		System.out.println("Moyenne : "+tabMoyenne);
		
	}
}
