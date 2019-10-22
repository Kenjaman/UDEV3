package monopoly.editions.legacy.console;

import monopoly.core.Joueur;
import monopoly.core.PaireDeDes;
import monopoly.core.Plateau;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] version1936 = {
				"Go",
				"Mediterranean Ave",
				"Community",
				"Baltic Ave",
				"Income Tax",
				"Reading RR",
				"Oriental Ave",
				"Chance",
				"Vermont Ave",
				"Connecticut Ave",

				"Just visiting",
				"St. Charles Place",
				"Electric Company",
				"States Ave",
				"Virginia Ave",
				"Pennsylvania RR",
				"St. James Place",
				"Community",
				"Tennessee Ave", 
				"New York Ave",

				"Free parking",
				"Kentucky Ave",
				"Chance",
				"Indiana Ave",
				"Illinois Ave", 
				"B&O RR",
				"Atlantic Ave", 
				"Ventnor Ave", 
				"Water Works",
				"Marvin Gardens",

				"Go to jail",
				"Pacific Ave", 
				"North Carolina Ave",
				"Community",
				"Pennsylvania Ave",
				"Short Line",
				"Chance",
				"Park Place",
				"Luxury Tax", 
				"Boardwalk" 
		};
		PaireDeDes lesDes = new PaireDeDes(6);
		Plateau lePlateau = new Plateau(version1936);
		Joueur joueurSolo = new Joueur(2000,lePlateau.getNbEmplacement());
		
		for(int i =0 ; i<100; i++) {
			lesDes.lancer();
			System.out.printf("Vous avez fait %d, vous avancez sur la case %d : '%s' . Vous avez %d $ en poche\n", lesDes.getTotal(),joueurSolo.getPosition(), lePlateau.getEmplacement(joueurSolo.avancer(lesDes)), joueurSolo.getCapital());
			
		}

	}

}
