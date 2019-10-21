package exo1;

public class Main {
	public static void main(String[] args) {
		int nombreDePossibilite=0;

		for(int nbPiece10=0;nbPiece10<=10;nbPiece10++) {
			for(int nbPiece5=0;nbPiece5<=20;nbPiece5++) {
				for(int nbPiece2=0;nbPiece2<=50;nbPiece2++){
					if (2*nbPiece2 +5*nbPiece5+ 10*nbPiece10 ==100) {
						System.out.print( "\n1 euro = ");
						if (nbPiece2!=0)
							System.out.printf(" %d X 2 centimes + ",nbPiece2);
						if (nbPiece5!=0)
							System.out.printf(" %d X 5 centimes + " ,nbPiece5);
						if (nbPiece10!=0)
							System.out.printf(" %d X 10 centimes ", nbPiece10);

						nombreDePossibilite += 1;
					}
				}
			}
		}

		System.out.printf( "\nIl y a %d possibilites", nombreDePossibilite);
	}
}
