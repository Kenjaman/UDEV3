package com.animalfood.dao;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.animalfood.models.Food;
import com.animalfood.models.IStockItem;
import com.animalfood.utils.CsvFile;

public class FoodCsv {
	private CsvFile csv;
	private FoodFactory factory;
	
	public FoodCsv(CsvFile csv, FoodFactory factory) {
		this.csv = csv;
		this.factory = factory;
	}
	public IStockItem[] load(String separator) throws IOException {
		List<Food> foodList = Collections.emptyList();
		
    	for(Map.Entry<String, String> entry : this.csv.load(";").entrySet()) {
    		Food createdFood = factory.newFood(entry.getKey());
    		int qty = Integer.parseInt(entry.getValue());
    		
    		createdFood.replenish(qty);
			foodList.add(createdFood);
		}
        return (IStockItem[])foodList.toArray(); 
	}
}
