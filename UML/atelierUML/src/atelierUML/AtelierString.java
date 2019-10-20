package atelierUML;

public class AtelierString {

	static int compterLesE(String texte) {
		String lettreAtrouver= "eEéèêë";
		return comptageListe(texte, lettreAtrouver);
	}

	static int compterConsonnes(String texte) {
		String listeDeConsonne="zrtpqsdfghjklmwxçcvbn";
		return comptageListe(texte, listeDeConsonne);
	}

	private static int comptageListe(String texte, String listeAtrouver) {
		int compteur=0;
		for(char lettre : texte.toLowerCase().toCharArray()) {
			System.out.print(lettre);
			if(listeAtrouver.lastIndexOf(lettre) != -1)
				compteur++;
		}
		return compteur;
	}
	private static boolean estSeparateur(char lettre) {
		return " \t\n.,;:/?!@'()\\\"=-_+".indexOf(lettre)!=-1;
	}

	static int compterMots(String text) {
		int etat=1, compteur=0;
		for(char lettre : text.toLowerCase().toCharArray()) {
			switch(etat) {									// Machine à état
			case 1:
				if(!estSeparateur(lettre)) {
					compteur++;
					etat = 2;
				}				
				break;
			case 2:
				if(estSeparateur(lettre))
					etat=1;
				break;
			}
		}
		return compteur;
	}

	static void assertEquals(int attendu,int constate) {
		if(attendu==constate)
			System.out.println(" : Test OK");
		else 
			System.err.println(" : Test KO - Attendu : "+attendu+" - Constaté : "+constate);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message ="Hello world!";

		int resultat =compterLesE(message);
		assertEquals(1,resultat); //1
		assertEquals(3,compterLesE("Phrase avec 3 E")); //3
		assertEquals(2,compterLesE("Répétition")); //2
		assertEquals(0,compterLesE("La Disparition")); //0

		assertEquals(0,compterConsonnes("ouïe")); //0
		assertEquals(7,compterConsonnes(message)); //0

		assertEquals(4,compterMots("Bonjour tout le monde")); //0
		assertEquals(0,compterMots("    .")); //0
		assertEquals(6,compterMots("  L'exercice  est un casse-tête ! ")); //0
	}

}
