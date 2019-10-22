package monopoly.editions.legacy.console;

import monopoly.core.Dice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dice unDe = new Dice(6);
		Dice autreDe = new Dice(6);
		
		unDe.lancer();
		autreDe.lancer();
		unDe.afficher();

	}

}
