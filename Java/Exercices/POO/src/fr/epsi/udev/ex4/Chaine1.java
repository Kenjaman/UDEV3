package fr.epsi.udev.ex4;


public class Chaine1 {
	
	
	private String machaine;
	
	public Chaine1() {
		super();
	}

	public Chaine1(String chaine) {
		super();
		machaine= chaine;
	}
	
	public String extrait(String aExtraire) {
		return comptageListe(this.machaine, aExtraire);
	}
	

	private static String comptageListe(String texte, String listeAtrouver) {
		StringBuffer chaineRetour= new StringBuffer();
		for(char lettre : texte.toLowerCase().toCharArray()) {
			if(listeAtrouver.lastIndexOf(lettre) != -1)
				chaineRetour.append(lettre);
		}
		return chaineRetour.toString();
	}
}
