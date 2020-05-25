package com.animalFood.models;

public interface IStockItem {

	void replenish(int qté);

	void remove(int qté) throws IllegalStateException;

}