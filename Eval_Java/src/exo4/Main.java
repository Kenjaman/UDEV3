package exo4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizzeria maPizzeria=new Pizzeria();
		
		for(Ingredient ing :maPizzeria.getIngredients_dispo())
			System.out.println(ing);
		
		for(Ingredient ing :maPizzeria.getListeIncredientPrixAsc())
			System.out.println(ing);
		
		maPizzeria.createPizza();
//		
//		for(Ingredient ing :maPizzeria.getListeIncredientNomAsc())
//			System.out.println(ing);
	}

}
