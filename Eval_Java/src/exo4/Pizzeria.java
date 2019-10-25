package exo4;

import java.util.Scanner;

public class Pizzeria {
	private Pizza[] pizzas;
	private Ingredient[] ingredients_dispo= new Ingredient[] {
			new Ingredient("Tomate", 2),
			new Ingredient("Oeuf", 2),
			new Ingredient("Pate", 0.5),
			new Ingredient("Sauce tomate",0.2),
			new Ingredient("Champignon", 1),
			new Ingredient("Fromage de chèvre", 2),
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
	
	public Pizzeria() {
		super();
	}

	public Pizzeria(Pizza[] pizzas, Ingredient[] ingredients_dispo) {
		super();
		this.pizzas = pizzas;
		this.ingredients_dispo = ingredients_dispo;
	}

	public Pizza[] getPizzas() {
		return pizzas;
	}

	public Ingredient[] getIngredients_dispo() {
		return ingredients_dispo;
	}

	public void setPizzas(Pizza[] pizzas) {
		this.pizzas = pizzas;
	}

	public void setIngredients_dispo(Ingredient[] ingredients_dispo) {
		this.ingredients_dispo = ingredients_dispo;
	}

	public Ingredient[] getListeIncredientPrixAsc() {
		Ingredient[] inOrdreCrois= this.ingredients_dispo.clone();
		int n = (inOrdreCrois.length) - 1;
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (inOrdreCrois[j - 1].getPrix() > inOrdreCrois[j].getPrix()) {
					Ingredient temp = inOrdreCrois[j - 1];
					inOrdreCrois[j - 1]=inOrdreCrois[j];
					inOrdreCrois[j]=temp;
				}
			}
		}
		return inOrdreCrois;
	}
	public Ingredient[] getListeIncredientNomAsc() {
		Ingredient[] inOrdreCrois= this.ingredients_dispo.clone();
		int n = (inOrdreCrois.length) - 1;
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (inOrdreCrois[j - 1].getNomIng().compareTo(inOrdreCrois[j].getNomIng())>0) {
					Ingredient temp = inOrdreCrois[j - 1];
					inOrdreCrois[j - 1]=inOrdreCrois[j];
					inOrdreCrois[j] =temp;
				}
			}
		}
		return inOrdreCrois;
	}
	
	public Ingredient getIngredientById(int id) {
		Ingredient the_ingredient = null;
		for(Ingredient ingredient : this.ingredients_dispo) {
			if(ingredient.getId()==id)
				the_ingredient=ingredient;
		}
		return the_ingredient;		
	}
	public void afficherListIngredient() {
		for(Ingredient ing :this.getIngredients_dispo())
			System.out.println(ing);
	}
	
	public Pizza createPizza() {
		Scanner scn = new Scanner(System.in);
		int choix =0;
		int i=0;
		boolean ok =false;
		Pizza pizzaCree=new Pizza();
		System.out.println("Choisir au moins 3 ingredients dans la liste (6 maximum) : \n Entrez 99 pour terminer");
		afficherListIngredient();
		do {
			System.out.println("Entrez l'id de l'ingredient n°"+i);
			choix = scn.nextInt();
			ok = pizzaCree.ajouteIngredient(this.getIngredientById(choix));
			if(choix==99)
				ok=false;
			i++;
		}while(i<3 && ok || i==6);
		System.out.println("Entrez le nom de votre pizza :");
		String nom_pizza = scn.nextLine();
		pizzaCree.setNom(nom_pizza);
		System.out.println("Vous avez créer la pizza "+pizzaCree);
		return pizzaCree;
		
		
	}
}
