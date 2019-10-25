package exo4;

import java.util.Arrays;

public class Pizza {
	private int id_pizza;
	private static int id=0;
	{id++;}
	private String nom;
	private double prix_pizza;
	private Ingredient[] ingredients = new Ingredient[6];


	public Pizza(String nom,Ingredient[] ingredients) {
		this.id_pizza = id;
		this.nom=nom;
		this.ingredients=ingredients;
	}


	public Pizza() {
		this.id_pizza=id;
		// TODO Auto-generated constructor stub
	}


	public String getNom() {
		return nom;
	}

	public boolean ajouteIngredient(Ingredient newIngredient) {
		if(this.getIngredients().length<6) {
			for(int i=0; i<this.getIngredients().length;i++) {
				if(this.getIngredients()[i]==null) {
					this.ingredients[i]=newIngredient;
					return true;
				}
			}
		}
		return false;
	}


	public double getPrix_pizza() {
		for(Ingredient ingredient : ingredients)
			this.prix_pizza += ingredient.getPrix()+3;
		return prix_pizza;
	}


	public Ingredient[] getIngredients() {
		return ingredients;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrix_pizza(double prix_pizza) {
		this.prix_pizza = prix_pizza;
	}


	public void setIngredients(Ingredient[] ingredients) {
		if(ingredients.length>=3 && ingredients.length<=6)
			this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		builder.append("\n Ingredients :");
		builder.append(this.ingredients);
		builder.append("Prix : ");
		builder.append(prix_pizza);
		return builder.toString();
	}

	

}
