package com.animalFood.models;

public class Food implements IStockItem {
	private String nom;
	private int quantit�;
	
	
	public Food(String food) {
		if(food == null)
			throw new NullPointerException();
		this.nom = food;
		this.quantit� = 0;
	}


	public String getFood() {
		return nom;
	}


	public void setFood(String food) {
		this.nom = food;
	}


	public int getQuantit�() {
		return quantit�;
	}


	public void setQuantit�(int quantit�) {
		if(quantit�< 0)
			throw new IllegalArgumentException("Quantit� ne peux pas �tre inferieur a 0");
		this.quantit� = quantit�;
	}
	
	@Override
	public void replenish(int qt�) {
		if(qt�< 0)
			throw new IllegalArgumentException("Quantit� ajout�e ne peux pas �tre inferieur a 0");
		this.setQuantit�(quantit�+qt�);
	}

	@Override
	public void remove(int qt�) throws IllegalStateException {
		if(qt�<0)
			throw new IllegalArgumentException("Quantit� retir�e ne peux pas �tre inferieur a 0");
		this.setQuantit�(quantit�-qt�);;
	}
}
