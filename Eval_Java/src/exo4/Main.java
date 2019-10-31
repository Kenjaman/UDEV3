package exo4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Pizzeria maPizzeria=new Pizzeria();
		Ingredient[] ingredients_dispo= new Ingredient[] {
				new Ingredient("Tomate", 2),
				new Ingredient("Oeuf", 2),
				new Ingredient("Pate", 0.5),
				new Ingredient("Sauce tomate",0.2),
				new Ingredient("Champignon", 1),
				new Ingredient("Fromage de ch�vre", 2),
				new Ingredient("Poivron", 1),
				new Ingredient("Mozzarella", 1),
				new Ingredient("Emmental", 2),
				new Ingredient("Roquefort", 3),
				new Ingredient("Jambon", 1),
				new Ingredient("Olive", 1.5),
				new Ingredient("Lardons", 2),
				new Ingredient("Oignons", 1),
				new Ingredient("Reblochon", 3),
				new Ingredient("Magret", 5)
		};
		maPizzeria.setIngredients_dispo(ingredients_dispo);
		Scanner scnMenu = new Scanner(System.in);
		int choixMenu=0;
		System.out.println("Bienvienido en ma Pizzeria que puis-je faire pour vous aujourd'hui ?");
		do {
			System.out.println("\n=============== \t \t Menu : \t \t===============  \n"
					+ "1) Afficher la liste des ingredients par prix \n"
					+ "2) Afficher la liste des ingredients par nom \n"
					+ "3) Creer sa pizza (6 ingredients maximum 3 minimum) \n"
					+ "4) Afficher la liste des pizzas\n"
					+ "5) Supprimer une pizza \n"
					+ "0) Quitter l'application");
			try {
				choixMenu=scnMenu.nextInt();

				switch(choixMenu) {
				case 1:
					for(Ingredient ing :maPizzeria.getListeIncredientPrixAsc())
						System.out.println(ing);
					break;
				case 2:			
					System.out.println("Liste des ingredients par ordre alphabetique :\n");
					for(Ingredient ing :maPizzeria.getListeIncredientNomAsc())
						System.out.println(ing);
					break;
				case 3:
					Pizza laPizzaCree = maPizzeria.createPizza();
					if(laPizzaCree != null)
						System.out.println("Vous avez cr�er la pizza : \n"+laPizzaCree);
					else
						System.out.println("Vous avez quitt� que puis je faire pour vous ?");
					break;
				case 4:
					System.out.print(maPizzeria.afficherListPizzas());
					break;
				case 5:
					System.out.println(maPizzeria.afficherListPizzas());
					if(!maPizzeria.getPizzas().isEmpty()) {
						System.out.println("Entrez l'id de la pizza que vous voulez supprimer :");
						if(maPizzeria.supprimerPizza(scnMenu.nextInt())){
							System.out.println("Pizza supprim�e ");
						}else {
							System.out.println("Pizza pas supprim�e :( elle doit pas exist�e :/ ");
						}
					}
					break;
				case 0:
					System.out.println("Ciao !");
					break;
				default:
					System.out.println("Hmmm c'est embarassant... Vous ne semblez pas savoir lire les choix possible ...");
				}
			}catch(InputMismatchException e) {
				System.err.println("Votre doigt a riper ? Aller on la retente");
				scnMenu.nextLine();
			}
		}while(choixMenu!=0);
		scnMenu.close();
	}

}
