package exo4;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private int id_pizza;
	private static int id=0;
	{id++;}
	private String nom;
	private List <Ingredient> ingredients = new ArrayList<Ingredient>();


	public Pizza(String nom,List <Ingredient> ingredients) {
		this.id_pizza = id;
		this.nom=nom;
		this.ingredients=ingredients;
	}

	public Pizza() {
		this.id_pizza=id;
		this.nom="";
	}

//	public boolean ajouteIngredient(Ingredient newIngredient) {
//		if(this.getIngredients().size()<6) {
//			this.ingredients.add(newIngredient);
//			return true;
//		}
//		return false;
//	}


	public double getPrix_pizza() {
		double prix_pizza=0;
		for(Ingredient ingredient : this.ingredients)
			prix_pizza += ingredient.getPrix()+3;
		return prix_pizza;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		if(ingredients.size()>=3 && ingredients.size()<=6)
			this.ingredients = ingredients;
		else
			System.out.println("Erreur la pizza contient trop ou pas asser d'ingredients :"+this.getIngredients().size()
					+" actuellement");
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int getId_pizza() {
		return id_pizza;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(this.getId_pizza());
		builder.append(") ");
		builder.append(this.getNom());
		builder.append("  : ");
		builder.append(this.getPrix_pizza());
		builder.append(" €");
		builder.append("\nIngredients : \n\t");
		for(Ingredient ingredient : this.getIngredients()) {
			builder.append(ingredient.getNomIng());
			builder.append(" (");
			builder.append(ingredient.getPrix());
			builder.append(" €) ");
		}
		return builder.toString();
	}



}
