package fr.epsi.udev.exsup.ex2;

public class Main {

	public static void main(String[] args) {
		//1)
		Personne p1 = new Personne("Roux","Kénan");
		Personne p2 = new Personne("Proust","Madeleine");
		
		Appartement apt = new Appartement(2000);
		
		//2)
		p1.setSonAppart(apt);
		p1.getSonAppart().augmentePrixApp(0.10);
		p1.vendSonAppart(p2);
	}

}
