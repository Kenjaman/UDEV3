package fr.epsi.udev.ex4;


public class Chaine2 {
	private String machaine;
	
	public Chaine2() {
		super();
	}

	public Chaine2(String chaine) {
		super();
		machaine= chaine;
	}
	
	public int compte(String listeAtrouver) {
		int compteur=0;
		for(char lettre : this.machaine.toLowerCase().toCharArray()) {
			if(listeAtrouver.lastIndexOf(lettre) != -1)
				compteur++;
		}
		return compteur;
	}
	
	public int compterMots() {
		int etat=1, compteur=0;
		for(char lettre : this.machaine.toLowerCase().toCharArray()) {
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
	private static boolean estSeparateur(char lettre) {
		return " \t\n.,;:/?!@'()\\\"=-_+".indexOf(lettre)!=-1;
	}

}
