package com.animalfood.dao;

import com.animalfood.models.Food;

public class FoodFactory {
	public Food newFood(String name) {
		return new Food(name);
	}
}
