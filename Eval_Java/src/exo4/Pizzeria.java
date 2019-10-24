package exo4;

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
					double temp = inOrdreCrois[j - 1].getPrix();
					inOrdreCrois[j - 1].setPrix(inOrdreCrois[j].getPrix());
					inOrdreCrois[j].setPrix(temp);
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
					String temp = inOrdreCrois[j - 1].getNomIng();
					inOrdreCrois[j - 1].setNom_ing(inOrdreCrois[j].getNomIng());
					inOrdreCrois[j].setNom_ing(temp);
				}
			}
		}
		return inOrdreCrois;
	}
	
}
