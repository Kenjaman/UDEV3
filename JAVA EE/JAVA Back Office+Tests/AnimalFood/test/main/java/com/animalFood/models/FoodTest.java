package com.animalFood.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	

	@Test
	void testFoodNominal() {
		String nom = "foo";
		
		Food foo = new Food(nom);	
		
		assertEquals(0,foo.getQuantit�());
	}
	
	@Test
	void testFoodErreur() {
		assertThrows(NullPointerException.class, ()->new Food(null));
	}

	@Test
	void testReplenishExtrem() {
		int qt� = 0;

		Food food = new Food("foo");
		
		food.replenish(qt�);
		assertEquals(0,food.getQuantit�());
	}

	@Test
	void testReplenishNominal() {
		int qt� = 10;

		Food food = new Food("foo");
		
		food.replenish(qt�);
		assertEquals(10,food.getQuantit�());
	}
	
	@Test
	void testReplenishNominal2ajout() {
		Food food = new Food("foo");
		
		food.replenish(2);
		food.replenish(8);
		
		assertEquals(10,food.getQuantit�());
	}

	@Test
	void testReplenishErreurNegative() {
		int qt� = -10;

		Food food = new Food("foo");
		food.setQuantit�(20);
		
		assertThrows(IllegalArgumentException.class, ()->food.replenish(qt�));
	}
	
	
	
	@Test
	void testRemoveNominal() {
		Food food = new Food("foo");
		food.setQuantit�(30);
		
		food.remove(20);
		
		assertEquals(10,food.getQuantit�());
	}

	void testRemoveNominalDouble() {
		Food food = new Food("foo");
		food.setQuantit�(30);
		
		food.remove(20);
		food.remove(5);
		
		assertEquals(5,food.getQuantit�());
	}
	
	
	@Test
	void testRemoveExtremeTake0() {
		Food food = new Food("foo");
		food.setQuantit�(10);
		
		food.remove(0);
		
		assertEquals(10,food.getQuantit�());
	}
	
	@Test
	void testRemoveExtremeTo0() {
		Food food = new Food("foo");
		food.setQuantit�(10);
		
		food.remove(0);
		
		assertEquals(10,food.getQuantit�());
	}
	
	
	
	@Test
	void testRemoveErreurTakeFrom0() {
		int qt� = 10;
		
		IStockItem food = new Food("foo");
		
		assertThrows(IllegalArgumentException.class, ()->food.remove(qt�));
	}
	
	@Test
	void testRemoveErreurTakeNegative() {
		Food food = new Food("foo");
		food.setQuantit�(10);
		
		assertThrows(IllegalArgumentException.class, ()->food.remove(-5));
	}
}

