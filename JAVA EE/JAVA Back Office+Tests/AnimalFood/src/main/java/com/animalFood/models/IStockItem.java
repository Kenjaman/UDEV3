package com.animalFood.models;

public interface IStockItem {

	void replenish(int qt�);

	void remove(int qt�) throws IllegalStateException;

}