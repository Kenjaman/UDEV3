package exo4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {
	private List <Pizza> pizzas = new ArrayList <Pizza>();
	private Ingredient[] ingredients_dispo;

	//Cronstructeurs 

	public Pizzeria() {
		super();
	}

	public Pizzeria(List<Pizza> pizzas, Ingredient[] ingredients_dispo) {
		super();
		this.pizzas = pizzas;
		this.ingredients_dispo = ingredients_dispo;
	}

	//Liste des ingredients triées

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

	// Recupération d'un ingredient par son id
	public Ingredient getIngredientById(int id) {
		Ingredient the_ingredient = null;
		for(Ingredient ingredient : this.ingredients_dispo) {
			if(ingredient.getId()==id) {
				the_ingredient=ingredient;
			}
		}
		return the_ingredient;	
	}
	
	// Recupération d'une pizza par son id

	public Pizza getPizzaById(int id) {
		Pizza la_pizza = null;
		for(Pizza pizza : this.getPizzas()) {
			if(pizza.getId_pizza()==id) {
				la_pizza=pizza;
			}
		}
		return la_pizza;	
	}

	//Création d'une pizza
	public Pizza createPizza() {
		Scanner scn = new Scanner(System.in);
		int choix =0;
		boolean quitter=false;
		boolean ok;
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

		//		Pizza pizzaCree=new Pizza();
		System.out.println("Creation de la pizza n° "+(this.getPizzas().size()+1));
		System.out.println("Choisir au moins 3 ingredients dans la liste (6 maximum) : \nEntrez 99 pour terminer votre oeuvre \n100 Pour annuler\n0 pour afficher la liste des ingredients");
		//		afficherListIngredient();
		do {
			try {
				System.out.println("Entrez l'id de l'ingredient n°"+(1+ingredients.size()));
				choix = scn.nextInt();
				if(choix>0 && choix <=this.getIngredients_dispo().length) {

					//				ok = pizzaCree.ajouteIngredient(this.getIngredientById(choix));
					ok = ingredients.add(this.getIngredientById(choix));
				}else if(choix ==0){
					System.out.println(this.getListIngredient());
					ok=false;
				}else if(choix == 99 && ingredients.size()>=3) {
					ok=true;
					quitter=true;
				}
				else if(choix == 99 && ingredients.size()<3){ 
					System.out.println("Il manque des ingredients "+ingredients.size()+" actuellements");
					ok=false;
				}else if(choix ==100) {
					ok=false;
					quitter = true;
				}else {
					System.out.println("Erreur l'ingredient n'existe pas ! Recommencez");
					ok=true;
				}
			}catch(InputMismatchException e) {
				System.err.println("Veuillez entrer des chiffres ");
				ok=false;
			}finally {
				scn.nextLine();
			}
		}while(!quitter && ingredients.size()<6);
		if(!ok) {
			return null;
		}
		System.out.println("Entrez le nom de votre pizza :");
		String nom_pizza =scn.nextLine();
		Pizza pizzaCree = new Pizza(nom_pizza,ingredients);
		this.pizzas.add(pizzaCree);
		return pizzaCree;
	
	}

	//Suppression de pizza
	public boolean supprimerPizza(int id) {
		return this.getPizzas().remove(this.getPizzaById(id));
	}

	//Getters and Setters 
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public Ingredient[] getIngredients_dispo() {
		return ingredients_dispo;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void setIngredients_dispo(Ingredient[] ingredients_dispo) {
		this.ingredients_dispo = ingredients_dispo;
	}



	//Affichages
	public String getListIngredient() {
		StringBuilder str = new StringBuilder();
		for(Ingredient ing :this.getIngredients_dispo())
			str.append(ing);
		return str.toString();
	}

	public String afficherListPizzas() {
		StringBuilder str = new StringBuilder();
		if(this.getPizzas().isEmpty())
			str.append("Il n'y a pas de pizza...");
		else {
			str.append("\n====================== Les Pizzas ======================\n");
			for(Pizza pizz :this.getPizzas()) {
				str.append(pizz);
				str.append("\n");
			}
			str.append("\n=========================================================\n");
		}
		return str.toString();
	}
}


