package monopoly.core;

import java.util.Random;

public class Dice {
	private int value;
	private int nbFace;
	private Random rdn = new Random();

	public Dice(int nbFaces) {
		if(nbFaces<4) {
			throw new IllegalArgumentException("Un dé possède au moins 4 faces");
		}
		this.nbFace=nbFaces;
		this.lancer();
	}

	public void lancer() {
		this.value = rdn.nextInt(this.nbFace)+1;
	}

	public int getValue() {
		return value;
	}

	public void afficher() {
		switch (this.value) {
		case 1: {
			System.out.println(
					"┌───────┐\n"
							+"│       │\n"
							+"│   ●   │\n"
							+"│       │\n"
							+"└───────┘");
			break;
		}

		case 2: {
			System.out.println(
					"┌───────┐\n"
							+"│ ●     │\n"
							+"│       │\n"
							+"│     ● │\n"
							+"└───────┘");
			break;
		}

		case 3: {
			System.out.println(
					"┌───────┐\n"
							+"│     ● │\n"
							+"│   ●   │\n"
							+"│ ●     │\n"
							+"└───────┘");
			break;
		}

		case 4: {
			System.out.println(
					"┌───────┐\n"
							+"│ ●   ● │\n"
							+"│       │\n"
							+"│ ●   ● │\n"
							+"└───────┘");
			break;
		}

		case 5: {
			System.out.println(
					"┌───────┐\n"
							+"│ ●   ● │\n"
							+"│   ●   │\n"
							+"│ ●   ● │\n"
							+"└───────┘");
			break;
		}

		case 6: {
			System.out.println(
					"┌───────┐\n"
							+"│ ●   ● │\n"
							+"│ ●   ● │\n"
							+"│ ●   ● │\n"
							+"└───────┘");
			break;
		}


		}
	}
}
