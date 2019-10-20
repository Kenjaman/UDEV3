package fr.epsi.udev.ex19;

public class Salaire {

	public static void main(String[] args) {
		Personnel p = new Personnel();
		p.ajouterEmploye(new Vendeur("Alex", "Terrieur", 45, "1995", 30000));
		p.ajouterEmploye(new Representant("Alain", "Terrieur", 25, "2001", 20000));
		p.ajouterEmploye(new Prodeur("Yves", "Bosseur", 28, "1998", 1000));
		p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
		p.ajouterEmploye(new Technicien("Jean", "Flippe", 28, "2000", 1000));
		p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));
		p.afficherSalaires();
		System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + "euros.");
	}

}
