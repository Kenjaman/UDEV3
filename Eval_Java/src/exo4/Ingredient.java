package exo4;

public class Ingredient {

	private static int id=0;
	{id++;}
	private int id_ing;
	private double prix;
	private String nom_ing;
	
	public Ingredient(String label, double prix) {
		this.id_ing=id;
		this.prix=prix;
		this.nom_ing=label;
	}
	
	public int getId() {
		return id;
	}

	public double getPrix() {
		return prix;
	}

	public String getNomIng() {
		return nom_ing;
	}

	public void setNom_ing(String nom_ing) {
		this.nom_ing = nom_ing;
	}

	public void setPrix(double prix2) {
		// TODO Auto-generated method stub
		this.prix=prix2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id_ing);
		builder.append(" : ");
		builder.append(nom_ing);
		builder.append(" : ");
		builder.append(prix);
		builder.append(" €");
		return builder.toString();
	}
	
	
}
