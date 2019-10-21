package exo3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gestion_Agenda monRepertoire = new Gestion_Agenda();
		Scanner scn = new Scanner(System.in);
		int choix = 0;
		boolean quitter;
		//		scn.reset();
		//		scn.remove();
		do{
			System.out.println("Entrez votre choix ( 1 : Ajouter , 2: Afficher le repertoire,."
					+ " 3: Rechercher par nom), 0 : Exit");
			choix =scn.nextInt();
			switch(choix) {
			case 1:
				System.out.println("Entrez les informations de la personne :");
				System.out.println("Entrez le nom :");
				String nom = scn.next();
				System.out.println("Entrez l'adresse :");
				String adresse = scn.next();
				System.out.println("Entrez le numero :");
				String numero = scn.next();
				monRepertoire.ajouterPersonne(new Personne(nom, adresse, numero));
				quitter = false;
				break;
			case 2: 
				System.out.println(monRepertoire);
				quitter = false;
				break;
			case 3:
				System.out.println("Entrez le nom :");
				String nomRechercher = scn.next();
				System.out.println(monRepertoire.recherchePersonne(nomRechercher));
				quitter = false;
				break;
			case 0:
				quitter=true;
			default:
				System.out.println("Entrez une valeur valable (1,2 ou 3)");
				quitter = false;
				break;
			}
		}while(!quitter);
		System.out.println("Bye");

	}
}
