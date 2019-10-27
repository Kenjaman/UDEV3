package exo4;

import java.util.ArrayList;
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
	
	//Création d'une pizza
	public Pizza createPizza() {
		Scanner scn = new Scanner(System.in);
		int choix =0;
		int i=1;
		boolean ok;
		Pizza pizzaCree=new Pizza();
		System.out.println("Choisir au moins 3 ingredients dans la liste (6 maximum) : \n Entrez 99 pour terminer et 0 pour afficher la liste des ingredients");
//		afficherListIngredient();
		do {
			System.out.println("Entrez l'id de l'ingredient n°"+i);
			choix = scn.nextInt();
			if(choix>0 && choix <=this.getIngredients_dispo().length) {
				ok = pizzaCree.ajouteIngredient(this.getIngredientById(choix));
				i++;
			}else if(choix ==0){
				this.afficherListIngredient();
				ok=true;
			}else if(choix == 99 && i>=4)
				ok=false;
			else if(choix == 99 && i<4){ 
				System.out.println("Erreur! Il manque des ingredients! Recommencez");
				ok=true;
			}else {
				System.out.println("Erreur l'ingredient n'existe pas ! Recommencez");
				ok=true;
			}
			 scn.nextLine();
		}while(ok);
		System.out.println("Entrez le nom de votre pizza :");
		String nom_pizza =scn.nextLine();
		pizzaCree.setNom(nom_pizza);
		this.pizzas.add(pizzaCree);
		return pizzaCree;
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
	public String afficherListIngredient() {
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
			for(Pizza pizz :this.getPizzas())
				str.append(pizz);
		}
		return str.toString();
	}
}


