package com.animalFood.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	

	@Test
	void testFoodNominal() {
		String nom = "foo";
		
		Food foo = new Food(nom);	
		
		assertEquals(0,foo.getQuantité());
	}
	
	@Test
	void testFoodErreur() {
		assertThrows(NullPointerException.class, ()->new Food(null));
	}

	@Test
	void testReplenishExtrem() {
		int qté = 0;

		Food food = new Food("foo");
		
		food.replenish(qté);
		assertEquals(0,food.getQuantité());
	}

	@Test
	void testReplenishNominal() {
		int qté = 10;

		Food food = new Food("foo");
		
		food.replenish(qté);
		assertEquals(10,food.getQuantité());
	}
	
	@Test
	void testReplenishNominal2ajout() {
		Food food = new Food("foo");
		
		food.replenish(2);
		food.replenish(8);
		
		assertEquals(10,food.getQuantité());
	}

	@Test
	void testReplenishErreurNegative() {
		int qté = -10;

		Food food = new Food("foo");
		food.setQuantité(20);
		
		assertThrows(IllegalArgumentException.class, ()->food.replenish(qté));
	}
	
	
	
	@Test
	void testRemoveNominal() {
		Food food = new Food("foo");
		food.setQuantité(30);
		
		food.remove(20);
		
		assertEquals(10,food.getQuantité());
	}

	void testRemoveNominalDouble() {
		Food food = new Food("foo");
		food.setQuantité(30);
		
		food.remove(20);
		food.remove(5);
		
		assertEquals(5,food.getQuantité());
	}
	
	
	@Test
	void testRemoveExtremeTake0() {
		Food food = new Food("foo");
		food.setQuantité(10);
		
		food.remove(0);
		
		assertEquals(10,food.getQuantité());
	}
	
	@Test
	void testRemoveExtremeTo0() {
		Food food = new Food("foo");
		food.setQuantité(10);
		
		food.remove(0);
		
		assertEquals(10,food.getQuantité());
	}
	
	
	
	@Test
	void testRemoveErreurTakeFrom0() {
		int qté = 10;
		
		IStockItem food = new Food("foo");
		
		assertThrows(IllegalArgumentException.class, ()->food.remove(qté));
	}
	
	@Test
	void testRemoveErreurTakeNegative() {
		Food food = new Food("foo");
		food.setQuantité(10);
		
		assertThrows(IllegalArgumentException.class, ()->food.remove(-5));
	}
}

