import java.util.Scanner;
import java.util.Random;

class Main {
  static final int MIN_ALLUMETTES = 10;
  static final int MAX_ALLUMETTES = 25;

  public static void main(String[] args) {
    Scanner clavier = new Scanner(System.in);
    Random hazard = new Random();
    int nbAllumettes = hazard.nextInt(MAX_ALLUMETTES - MIN_ALLUMETTES) + MIN_ALLUMETTES;
    int joueur = 1;
    boolean optionSuggestion = true;
    int choix=0, choixMax=0;
    String suggestion="", question="";
    EtatJeu etat = EtatJeu.NombreInit;

    while(etat != EtatJeu.FinDeProgramme) {
      switch(etat) {
        case NombreInit:
          System.out.print("Combien d'allumettes (10-25) ?");
          choix = clavier.nextInt();
          etat = 10 <= choix && choix <= 25 
            ? EtatJeu.AffichageAllumettes
            : EtatJeu.NombreInitErr;
          break;

        case NombreInitErr:
          System.out.print("ERREUR : Combien d'allumettes (10-25) ?");
          choix = clavier.nextInt();
          if(10 <= choix && choix <= 25) {
            etat = EtatJeu.AffichageAllumettes;
          } 
          break;

        case AffichageAllumettes:
          for(int i=0; i<nbAllumettes; i++) {
            System.out.print('|');
          }
          System.out.println(nbAllumettes);
          etat = EtatJeu.SaisieChoix; 
          break;

        case SaisieChoix:
          suggestion = optionSuggestion ? "Conseil : "+((nbAllumettes+3)%4) : "";
          choixMax = Math.min(nbAllumettes, 3);
          question = "Joueur n°" + joueur + ", votre choix (1 à " + choixMax + ") : ";
          
          System.out.println(suggestion);
          System.out.print(question);
          choix = clavier.nextInt();
          etat = 1<= choix && choix <=choixMax 
            ? EtatJeu.ModifNbrAllumettes
            : EtatJeu.SaisieChoixErr;  
          break;

        case SaisieChoixErr:
          System.out.print("ERREUR : " + question);
          choix = clavier.nextInt(); 
          if(1<= choix && choix <=choixMax) {
            etat = EtatJeu.ModifNbrAllumettes;
          }
          break;

        case ModifNbrAllumettes:
          nbAllumettes = nbAllumettes - choix;
          joueur = autreJoueur(joueur);
          etat = nbAllumettes > 1 
            ? EtatJeu.AffichageAllumettes
            : EtatJeu.FinDePartieRejouer;
          break;

        case FinDePartieRejouer:
          if(nbAllumettes == 0) {
            System.out.println("Reste 0 : Joueur " + joueur + " gagne !!!");
          }
          else {
            System.out.println("Reste 1 : Joueur " + autreJoueur(joueur) + " gagne !!!");
          }
          System.out.print("Rejouer (1: Oui, 2: Non) ?");
          choix = clavier.nextInt();
          etat = choix == 1 
            ? EtatJeu.NombreInit
            : EtatJeu.FinDeProgramme;
          break;
        case EtatJeu.FinDeProgramme:
          System.out.println("Au revoir");
          break;
      }
    }
    clavier.close();
  }
  static int autreJoueur(int unJoueur) {
    return 3-unJoueur;
  }
}