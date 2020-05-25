package com.animalFood.models;

public class Food implements IStockItem {
	private String nom;
	private int quantité;
	
	
	public Food(String food) {
		if(food == null)
			throw new NullPointerException();
		this.nom = food;
		this.quantité = 0;
	}


	public String getFood() {
		return nom;
	}


	public void setFood(String food) {
		this.nom = food;
	}


	public int getQuantité() {
		return quantité;
	}


	public void setQuantité(int quantité) {
		if(quantité< 0)
			throw new IllegalArgumentException("Quantité ne peux pas être inferieur a 0");
		this.quantité = quantité;
	}
	
	@Override
	public void replenish(int qté) {
		if(qté< 0)
			throw new IllegalArgumentException("Quantité ajoutée ne peux pas être inferieur a 0");
		this.setQuantité(quantité+qté);
	}

	@Override
	public void remove(int qté) throws IllegalStateException {
		if(qté<0)
			throw new IllegalArgumentException("Quantité retirée ne peux pas être inferieur a 0");
		this.setQuantité(quantité-qté);;
	}
}
