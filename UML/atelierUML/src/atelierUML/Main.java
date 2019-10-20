package atelierUML;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int joueur=1;
		boolean optionSuggestion=true;
		Scanner scn =new Scanner(System.in);
		EtatJeu etat = EtatJeu.NombreInit;
		int nbPris=0;
		int choixMax=0;
		int nbObjets=0;
		cadre("Bonjour Kénan",'#');
		while(etat != EtatJeu.FinDeProgramme) {
			switch (etat) {
			case NombreInit:
				System.out.println("Choisir le nombre d'allumette (min 5 / max 25)");
				joueur=1;
				nbObjets=scn.nextInt();
				etat = nbObjets>=5 && nbObjets<= 25 ? EtatJeu.AffichageAllumettes : EtatJeu.NombreInitErr;
				break;
			case NombreInitErr:
				System.out.println("Erreur ! Choisir le nombre d'allumette (min 5 / max 25)");
				nbObjets=scn.nextInt();
				if(nbObjets>=5 && nbObjets<= 25)
					etat= EtatJeu.AffichageAllumettes;
				break;
			case AffichageAllumettes:
				System.out.println("Allumettes restantes :");
				for(int i=0;i<nbObjets;i++)
					System.out.print("|");
				System.out.println(nbObjets);
				System.out.println("\n************************");
				
				etat= EtatJeu.SaisieChoix;
				break;
			case SaisieChoix:
				choixMax=Math.min(nbObjets, 3);
				System.out.println("Joueur "+joueur+ " choisis entre 1 et "+choixMax+" objets");
				System.out.println("Suggestion : "+( optionSuggestion ? ((nbObjets+3)%4) == 0 ? "-":((nbObjets+3)%4) : ""));
				nbPris = scn.nextInt();
				etat = nbPris>=1 && nbPris<=choixMax ? EtatJeu.ModifierNbAllumettes : EtatJeu.SaisieChoixErr;
				break;
			case SaisieChoixErr:
				System.out.println("Attention ! Vous devez choisr un nombre en 1 et "+choixMax);
				break;
			case ModifierNbAllumettes:
				nbObjets=nbObjets-nbPris;
				etat = nbObjets> 1 ? EtatJeu.AffichageAllumettes : EtatJeu.FinDePartie;
				if(etat!=EtatJeu.FinDePartie) {
					if(joueur==1)
						joueur=2;
					else
						joueur=1;
				}
				break;
			case FinDePartie:
				if(nbObjets==1) {
					System.out.println("*************************Joueur "+joueur+" a gagné !!!*******************");
				}else
					System.out.println("Joueur "+ joueur+" a perdu !!!!");
				System.out.println("Rejouer ?  (1 : Oui, 2 : Non)");
				int choix = scn.nextInt();
				etat = choix == 1 ? EtatJeu.NombreInit : EtatJeu.FinDeProgramme;
				break;
			case FinDeProgramme:
				cadre("Au revoir !",'#');
			default:
				break;
			}
		}
		scn.close();
	}

	public static void cadre(String chaine, char car) {
		int largeur= 4+chaine.length();
		dessinerLigne(largeur,car);
		System.out.println(car+" "+chaine+' '+car);
		dessinerLigne(largeur,car);
	}

	private static void dessinerLigne(int longueur, char car) {
		for(int i=0;i<longueur;i++) {
			System.out.print(car);
		}
		System.out.println();
	}
}